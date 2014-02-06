(defproject cljs-gwt "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.0"]]

  :plugins [[lein-cljsbuild "1.0.1"]
            [lein-ring "0.7.0"]]

  :ring {:handler cljs-gwt.core/app}

  :source-paths ["src/clj"]

  :cljsbuild {
               :builds [{:id "dev"
                         :source-paths ["src/cljs"]
                         :compiler {
                                     :output-dir "resources/public/js/"
                                     :output-to "resources/public/js/cljs_gwt.js"
                                     :source-map "resources/public/js/cljs_gwt.js.map"}}
                        {:id "prod"
                         :source-paths ["src/cljs"]
                         :compiler {
                                     :output-to "resources/public/js/cljs_gwt.js"
                                     :optimizations :advanced}}]})
