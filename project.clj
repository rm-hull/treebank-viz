(defproject delver/treebank-viz "0.1.0"
  :description ""
  :url "https://github.com/rm-hull/treebank-viz"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.9.0"]
    [org.clojure/data.json "0.2.6"]
    [lacij "0.10.0"]
    [instaparse "1.4.9"]
    [clojure-opennlp "0.5.0"]
    [compojure "1.6.1"]
    [ring-logger-timbre "0.7.6"]
    [metrics-clojure-ring "2.10.0"]
    [rm-hull/helpmate "0.1.4"]]
  :ring {
    :handler treebank-viz.handler/app}
  :source-paths ["src"]
  :resouce-paths ["resouces"]
  :jar-exclusions [#"(?:^|/).git"]
  :uberjar-exclusions [#"\.SF" #"\.RSA" #"\.DSA"]
  :min-lein-version "2.6.1"
  :global-vars { *warn-on-reflection* true}
    :profiles {
    :uberjar {:aot :all}
    :dev {
      :global-vars {*warn-on-reflection* true}
      :dependencies [
        [org.clojure/test.check "0.9.0"]]
      :plugins [
        [lein-ring "0.12.4"]
        [lein-cloverage "1.0.13"]]}})

