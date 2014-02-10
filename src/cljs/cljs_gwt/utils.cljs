(ns cljs-gwt.utils
  (:require
    [clojure.string :as str]))

(defn set-class!
  "set class to element"
  [el raw-class]
  (let [class (-> raw-class name str/trim)]
    (when (not (identical? (.-className el) class))
      (set! (.-className el) class))
    el))