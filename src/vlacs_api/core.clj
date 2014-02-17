(ns vlacs-api.core
  (:require
    [liberator.core :refer [resource defresource]]
    [ring.middleware.params :refer [wrap-params]]
    [ring.adapter.jetty :refer [run-jetty]]
    [ring.middleware.format :refer [wrap-restful-format]]
    [compojure.core :refer [defroutes ANY GET]]
    [vlacs-api.resources.competency :as v-comp ]))

(defroutes app
  (ANY "/" [] (resource))
  ;;curl -H "Content-Type:application/json" http://localhost:3000/users

  (GET "/users" [] (v-comp/get-all)))

(def handler
  (-> app
      (wrap-params)
      (wrap-restful-format)))

(def server (run-jetty #'app {:port 3000 :join? false}))

