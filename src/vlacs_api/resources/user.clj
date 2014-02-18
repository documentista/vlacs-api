(ns vlacs-api.resources.user

  (:require [liberator.core :refer [resource defresource]]
            ))

(defn get-user []
  {:comp
   {:id 1
    :id_sk "external key"
    :name "Algebra 1"
    :description "Intro to Algebra 1"
    :version "A1"
    :status "Online"
    :duration_rating_days 180
    :date_created "2013-11-27-14:59:30.252" }
    }

   )

(defresource
  ^{:doc "This service provides a simple hello world implementation example."
    :example "<code>curl -I 'http://localhost:9292/hello_world?name=Malcolm'</code>"
    :params ["name" "The name of the person to greet."]} 

  get-all []
    ;;:get (get-user)
    :available-media-types [ "application/json" "application/edn"]
    :handle-ok (get-user) )


