(ns
  ^{:author hsestupin}
  cljs-gwt.css)

(defn add-class-name [el className]
;  :TODO refactor to make this code look similar as corresponding part in UiObject#addClassName
  (let [class-name-prop (.-className el)]
    (set! class-name-prop (+ class-name-prop className))


(defn set-style-name [el style & {:keys [add?]}]
  {:pre [(not (nil? el)) (== (.length style) 0)]}
  (if add?
    (add-class-name el style)
    (remove-class-name el style)))

(defn add-style-name [el style]
  (set-style-name el style :add? true))

