(ns cljs-gwt.core
  (:use [cljs-gwt.utils :only [set-class!]]
        [cljs-gwt.ui.text-box :only [->TextBox]])
  (:require [dommy.attrs :as attrs]
            [dommy.core :as dommy]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true])
  (:use-macros [dommy.macros :only [by-id]]))

(enable-console-print!)

(defn new-button [name]
  (let [button (.createElement js/document "BUTTON")]
    (set! (.-type button) "button")
    (set! (.-innerHTML button) (or name ""))
    (set-class! button :gwt-Button)))

(defn new-text-box []
  (-> (let [text-box (.createElement js/document "INPUT")]
        (set! (.-type text-box) "text")
        text-box)
    (dommy/add-class! :gwt-TextBox)
    ->TextBox))

(defn new-label-base [& {:keys [inline?]}]
  (if inline?
    (.createElement js/document "span")
    (.createElement js/document "div")))

(defn new-label []
  (let [label (new-label-base :inline? false)]
    (dommy/add-class! label :gwt-Label)))

; implementation using simple dom manipulation
;(let [send-button (new-button "Send")
;      name-field (new-text-box)
;      error-label (new-label)]
;  (dommy/add-class! send-button :sendButton)
;  (dommy/append! (by-id "nameFieldContainer") name-field)
;  (dommy/append! (by-id "sendButtonContainer") send-button)
;  (dommy/append! (by-id "errorLabelContainer") error-label))


; OM

(defn button [data owner]
  (om/component
    (dom/button #js {:type "button" :className (str "gwt-Button" " " (:className data))} (:name data))))

(defn handle-change [e owner {:keys [text]}]
  (om/set-state! owner :text (.. e -target -value)))

(defn text-box [data owner]
  (reify
    om/IInitState
    (init-state [_]
      {:text (:init-value data)})
    om.core/IRenderState
    (render-state [_ state]
      (dom/input #js {:type "text"
                      :className "gwt-TextBox"
                      :value (:text state)
                      :onChange #(handle-change % owner state)}))
    om.core/IDidMount
    (did-mount [_]
      (when (:focus? data)
        (.focus (om/get-node owner))))))

(defn label [data owner]
  (om/component
    (if (:inline? data)
      (dom/span #js {:className "gwt-Label"})
      (dom/div #js {:className "gwt-Label"}))))

;(defn )

(def app-state
  (atom
    {:button {:name "Send" :className "sendButton"}
     :text-box {:focus? true :init-value "GWT User"}
     :label {:inline? false}}))

(om/root button (:button @app-state)
  {:target (by-id "sendButtonContainer")})
(om/root text-box (:text-box @app-state)
  {:target (by-id "nameFieldContainer")})
(om/root label (:label @app-state)
  {:target (by-id "errorLabelContainer")})


(println "Hello world! 121")
