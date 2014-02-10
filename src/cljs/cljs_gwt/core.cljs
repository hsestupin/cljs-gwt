(ns cljs-gwt.core
  (:require [cljs-gwt.ui :as ui]
            [dommy.core :as dommy])
  (:use-macros
    [dommy.macros :only [by-id]]))

(enable-console-print!)

(let [send-button (ui/new-button "Send")
      name-field (ui/new-text-box)
      error-label (ui/new-label)]
  (dommy/add-class! send-button :sendButton)
  (dommy/append! (by-id "nameFieldContainer") name-field)
  (dommy/append! (by-id "sendButtonContainer") send-button)
  (dommy/append! (by-id "errorLabelContainer") error-label))

(println "Hello world! 121")
