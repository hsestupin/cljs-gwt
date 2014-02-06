(ns cljs-gwt.core
  (:require [cljs-gwt.css :as css]))

(enable-console-print!)

;var e = doc.createElement("BUTTON");
;e.type = "button";
;return e;
(defn new-button [name]
  (let [button (.createElement js/document "BUTTON")]
    (set! (.-type button) "button")
    (set! (.-innerHTML button) (or name ""))
    button))

;var e = doc.createElement("INPUT");
;e.type = type;
;return e;
(defn new-text-box []
  (let [text-box (.createElement js/document "INPUT")]
    (set! (.-type text-box) "text")
    (set! (.-className text-box) "gwt-TextBox")
    text-box))

(defn new-label-base [& {:keys [inline?]}]
  (if inline?
    (.createSpanElement js/document)
    (.createDivElement js/document)))

(defn new-label []
  (let [label (new-label-base :inline? false)]
    (set! (.-className label) "gwt-Label")
    label))

(let [send-button (new-button "Send")
      name-field (new-text-box)
      error-label (new-label)]
  (css/add-style-name send-button "sendButton")
  (.appendChild (.getElementById js/document "nameFieldContainer") name-field)
  (.appendChild (.getElementById js/document "sendButtonContainer") send-button)
  (.appendChild (.getElementById js/document "errorLabelContainer") error-label))


(println "Hello world! 121")
