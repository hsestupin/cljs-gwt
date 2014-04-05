(ns
  ^{:author hsestupin}
  cljs-gwt.ui.text-box
  (:use [cljs-gwt.ui.protocols :only [Focusable focus-widget]]
        [dommy.template :only [PElement]]))

(deftype TextBox [el]
  PElement
  (-elem [this] el))

