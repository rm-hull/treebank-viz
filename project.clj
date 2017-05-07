(defproject delver/treebank-viz "0.0.1"
  :description ""
  :url "https://github.com/rm-hull/treebank-viz"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [lacij "0.9.1"]
    [instaparse "1.4.2"]
    [clojure-opennlp "0.3.3"]
    [compojure "1.5.0"]
    [rm-hull/helpmate "0.1.3"]]
  :ring {
    :handler treebank-viz.handler/app}
  :plugins [
    [lein-ring "0.9.7"]]
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
        [lein-cloverage "1.0.6"]]}})

