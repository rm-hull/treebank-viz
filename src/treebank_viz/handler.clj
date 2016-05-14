(ns treebank-viz.handler
  (:require
    [compojure.core :refer :all]
    [compojure.handler :as handler]
    [hiccup.core :refer :all]
    [clojure.pprint :refer [pprint]]
    [ring.middleware.params :refer [wrap-params]]
    [ring.util.io :refer [piped-input-stream]]
    [ring.util.response :refer [response content-type status]]
    [treebank-viz.svg :refer :all]
    [treebank-viz.core :refer :all]))

(def no-sentence
  (-> (response "No sentence supplied") (status 400)))

(def form
  (html
    [:div
     [:form {:type "post" :action "/svg" }
      [:input {:type "text" :placeholder "Enter a setence" :name "q" :size 50}]
      [:input {:type "submit" :value "svg"}]]]))

(defn svg [sentence]
  (if (seq sentence)
    (let [result (analyze sentence)
          nodes  (node-finder result)
          edges  (edge-finder result)
          labels (leaf-finder result)]
      (->
        #(->svg nodes edges labels %)
        (piped-input-stream)
        (response)
        (content-type "image/svg+xml")))
    no-sentence))

(defn text [sentence]
  (if (seq sentence)
    (let [result (analyze sentence)]
      (->
        #(with-open [out (clojure.java.io/writer %)] (pprint result out))
        (piped-input-stream)
        (response)
        (content-type "text/plain")))
    no-sentence))

(defroutes app-routes
  (GET "/svg"  [:as req] (svg (get-in req [:params :q])))
  (GET "/text" [:as req] (text (get-in req [:params :q])))
  (GET "/"     [:as req] (response form)))

(def app
  (->
    (handler/site app-routes)
    (wrap-params)))
