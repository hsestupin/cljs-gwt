(ns
  ^{:author hsestupin}
  cljs-gwt.views
  (:require [hiccup
             [page :refer [html5]]
             [page :refer [include-js include-css]]]))

(defn index-page []
  (html5
    (include-css "/css/cljs_gwt.css")
    [:h1 "Web Application Starter Project"]
    [:table {:align "center"}
     [:tr [:td {:style "font-weight:bold;", :colspan "2"}
           "Please enter your name:"]]
     [:tr [:td#nameFieldContainer] [:td#sendButtonContainer]]
     [:tr [:td#errorLabelContainer {:style "color:red;", :colspan "2"}]]]
;    script should be loaded strictly in the end
    (include-js "/js/cljs_gwt.js")))