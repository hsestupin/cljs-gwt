(ns
  ^{:author hsestupin}
  cljs-gwt.ui.text-box
  (:use [cljs-gwt.ui.protocols :only [Focusable focus-widget]]
        [dommy.template :only [PElement]]))

(defrecord TextBox [el]
  Focusable focus-widget

  PElement
  (-elem [this] el))
