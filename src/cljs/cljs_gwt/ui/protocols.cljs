(ns
  ^{:author hsestupin}
  cljs-gwt.ui.protocols)

(defprotocol Focusable
  "A widget that implements this interface can receive keyboard focus."

  (get-tab-index [this] "return widget's position in the tab index")

  (set-access-key! [this ^char key]
    "sets the widget's 'access key'. This key is used (in conjunction with a
    browser-specific modifier key) to automatically focus the widget.")

  (set-focus! [this ^boolean focused?]
    "Explicitly focus/unfocus this widget. Only one widget can have focus at a
    time, and the widget that does will receive all keyboard events.")

  (set-tab-index! [this ^int index]
    "Sets the widget's position in the tab index. If more than one widget has
    the same tab index, each such widget will receive focus in an arbitrary
    order. Setting the tab index to <code>-1</code> will cause this widget to
    be removed from the tab order"))

(def focus-widget
  {:get-tab-index (fn [this])}
  {:set-access-key! (fn [this ^char key])}
  {:set-focus! (fn [this ^boolean focused?])}
  {:set-tab-index! (fn [this ^int index])})

