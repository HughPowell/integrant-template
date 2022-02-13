(ns user
  (:require [integrant.repl :refer [clear go halt prep init reset reset-all]]
            [kaocha.repl :refer [run run-all]]
            [{{main/ns}}.system :refer [start-system configure]]))

(integrant.repl/set-prep! (fn [& _] (start-system (configure))))
