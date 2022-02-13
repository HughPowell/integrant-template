(ns {{main/ns}}.system
  (:require [clojure.java.io :as io]
            [aero.core :as aero]
            [integrant.core :as ig]
            [meta-merge.core :as meta-merge]))

(defn simplify-keys [config]
  (letfn [(simplify-key [hierarchy] (apply derive hierarchy) (first hierarchy))]
    (->> config
         (map (fn [[k v]]
                (if (vector? k)
                  [(simplify-key k) v]
                  [k v])))
         (into {}))))

(defn read-config [f]
  (->> f
       (aero/read-config)
       (simplify-keys)))

(defn configure [& variations]
  (apply
    meta-merge/meta-merge
    (read-config (io/resource "config.edn"))
    (map simplify-keys variations)))

(defn start-system [config]
  (ig/load-namespaces config)
  (-> config
      (ig/prep)
      (ig/init)))

(def stop-system! ig/halt!)
