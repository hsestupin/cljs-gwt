(ns cljs-gwt.core
  (:use compojure.core
        cljs-gwt.views)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app (handler/site main-routes))
