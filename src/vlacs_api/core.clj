(ns vlacs-api.core
  
  (:require
   [vlacs-api.resources.user :as v-user]
   [liberator.core :refer [resource defresource]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.format :as ring-format]
   [compojure.core :refer [defroutes ANY GET]]))

(defroutes app
  (ANY "/" [] (resource))
  ;;curl -H "Accept:application/json" http://localhost:3000/users

  (GET "/users" [] (v-user/get-all)))

(def handler
  (-> app
      ;;(wrap-trace :header :ui)
      (wrap-params)
      (ring-format/wrap-restful-format)))

  ;;(def server (run-jetty #'app {:port 3000 :join? false}))

(defn -main
  []
  (run-jetty #'app {:port 3000 :join? false})
  )



