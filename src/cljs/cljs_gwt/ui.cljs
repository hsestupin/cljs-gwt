(ns
  ^{:author hsestupin}
  cljs-gwt.ui
  (:use [cljs-gwt.utils :only [set-class!]]
        [cljs-gwt.ui.text-box :only [->TextBox]])
  (:require [dommy.attrs :as attrs]
            [dommy.core :as dommy]))


;var e = doc.createElement("BUTTON");
;e.type = "button";
;return e;
(defn new-button [name]
  (let [button (.createElement js/document "BUTTON")]
    (set! (.-type button) "button")
    (set! (.-innerHTML button) (or name ""))
    (set-class! button :gwt-Button)))

;var e = doc.createElement("INPUT");
;e.type = type;
;return e;
(defn new-text-box []
  (-> (let [text-box (.createElement js/document "INPUT")]
        (set! (.-type text-box) "text")
        text-box)
    (dommy/add-class! :gwt-TextBox)
    ->TextBox))

(defn new-dialog-box
  ([]
    (new-dialog-box true))
  ([auto-hide?]
    (new-dialog-box auto-hide? true))
  ([auto-hide? modal?]
    ))

(defn new-label-base [& {:keys [inline?]}]
  (if inline?
    (.createElement js/document "span")
    (.createElement js/document "div")))

(defn new-label []
  (let [label (new-label-base :inline? false)]
    (dommy/add-class! label :gwt-Label)))
