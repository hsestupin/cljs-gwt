Hello.
This project is the place where I can keep all my thoughts about how the clojurescript port of GWT may actually look.

First here is straightforward implementation of basic GWT widgets using simple dom manipulations. It's not full completed yet:

```clojure
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
(let [send-button (new-button "Send")
      name-field (new-text-box)
      error-label (new-label)]
  (dommy/add-class! send-button :sendButton)
  (dommy/append! (by-id "nameFieldContainer") name-field)
  (dommy/append! (by-id "sendButtonContainer") send-button)
  (dommy/append! (by-id "errorLabelContainer") error-label))
```

And now look at another version of the same UI built with <a href="https://github.com/swannodette/om">Clojurescript om</a>:

```clojure
(defn button [data owner]
  (om/component
    (dom/button #js {:type "button" :className (str "gwt-Button" " " (:className data))} (:name data))))
(defn text-box [data owner]
  (om/component
    (dom/input #js {:type "text" :className "gwt-TextBox"})))
(defn label [data owner]
  (om/component
    (if (:inline? data)
      (dom/span #js {:className "gwt-Label"})
      (dom/div #js {:className "gwt-Label"}))))

(om/root button {:name "Send" :className "sendButton"}
  {:target (by-id "sendButtonContainer")})
(om/root text-box {}
  {:target (by-id "nameFieldContainer")})
(om/root label {:inline false}
  {:target (by-id "errorLabelContainer")})
```

