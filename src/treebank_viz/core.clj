(ns treebank-viz.core
  (:require
    [clojure.java.io :as io]
    [clojure.pprint :refer [pprint]]
    [opennlp.nlp :refer :all]
    [opennlp.treebank :refer :all]
    [treebank-viz.tree-zipper :refer :all]
    [treebank-viz.penn-tags :refer :all]))

(def treebank-parser
  (make-treebank-parser
    (or
      (io/resource "en-parser-chunking.bin")
      (io/input-stream "https://github.com/rm-hull/treebank-viz/raw/master/resources/en-parser-chunking.bin"))))

(defn- add-identifiers
  "Takes a zipper and adds a unique identifier and description to each map node"
  [zipper]
  (tree-edit zipper map? (fn [_ node]
                           (assoc node
                             :id (keyword (gensym))
                             :desc (get tags (:tag node) "Unknown")))))

(defn analyze
  "Breaks a sentence down into a tree zipper structure"
  [sentence]
  (-> sentence vector treebank-parser first make-tree tree-zipper add-identifiers))

(defn- walk-edges [node]
  (when (map? node)
    (filter map? (:chunk node))))

(defn- make-edges [id nodes]
  (map #(hash-map :from id :to (:id %)) nodes))

(defn- leaf-visitor [node state]
  (when (and (map? node) (-> node :chunk first string?))
    {:state (conj state {:from (:id node) :to (keyword (gensym)) :label (-> node :chunk first)})}))

(defn- edge-visitor [node state]
  {:state (concat state (make-edges (:id node) (walk-edges node)))})

(defn- node-visitor [node state]
  (when (map? node)
    {:state (conj state (select-keys node [:id :tag :desc]))}))


(defn finder [visitor]
  (fn [node]
    (:state
      (tree-visitor (tree-zipper node) #{} [visitor]))))

(def leaf-finder (finder leaf-visitor))

(def node-finder (finder node-visitor))

(def edge-finder (finder edge-visitor))
