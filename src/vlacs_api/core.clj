(ns vlacs-api.core
  :require
    [liberator.core :refer [resource defresource]]
    [ring.middleware.params :refer [wrap-params]]
    [ring.adapter.jetty :refer [run-jetty]]
    [ring.middleware.format :refer [wrap-restful-format]]
    [compojure.core :refer [defroutes ANY]])

(defroutes app
  (ANY "/" [] (resource)))

(def handler
  (-> app
      (wrap-params)
      (wrap-restful-format)))

(def server (run-jetty #'app {:port 3000 :join? false}))
