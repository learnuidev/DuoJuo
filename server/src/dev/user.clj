(ns user
  (:require [integrant.repl :as ig-repl]
            [integrant.core :as ig]
            [integrant.repl.state :as state]
            [duolingo.server]
            [datomic.client.api :as d]
            [clojure.edn :as edn]))

(comment)
  ; (ig/halt!))


(ig-repl/set-prep!
  (fn [] (-> "src/dev/resources/config.edn" slurp ig/read-string)))

(def start-dev ig-repl/go)
(def stop-dev ig-repl/halt)
(def restart-dev ig-repl/reset)
(def reset-all ig-repl/reset-all)

(def app (-> state/system :duolingo/app))
(def db (-> state/system :db/datomic))
(comment
  (identity state/system))


(comment
  (start-dev)
  (stop-dev)
  (restart-dev))

;;
(comment
  (require 'novus.server {:re-load true})
  (require 'user {:re-load true})
  (d/delete-database (:client db) {:db-name (:db-name db)}))


;; Transact novus schema + Seed Data
(defn seed [conn]
  (let [schema (-> "src/resources/schema.edn" slurp edn/read-string)
        mock  (-> "src/resources/seed.edn" slurp edn/read-string)]
   (d/transact conn {:tx-data schema})
   (d/transact conn {:tx-data mock})))

(comment
 (java.util.UUID/randomUUID))

(comment
  (seed (:conn db)))

;; Query: Give me list of all the students
(comment
  (d/q '[:find (pull ?student [*])
         :where [?student :student/id]]
    (d/db (:conn db)))
;; Query: Give me count of all the students
  (d/q '[:find (count ?student)
         :where [?student :student/id]]
    (d/db (:conn db))))
