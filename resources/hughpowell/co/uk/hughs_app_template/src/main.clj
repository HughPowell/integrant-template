(ns {{main/ns}}
  (:require [integrant.core :as ig]
            [{{main/ns}}.system :as system])
  (:gen-class))

(defmethod ig/init-key ::component [_key {:keys [name]}]
  (format "Hello, %s!" (or name "World")))

(defn greet
  "Callable entry point to the application"
  [x]
  (let [config (if x
                 (system/configure {::greeting {:name x}})
                 (system/configure))]
    (-> config
        (system/start-system)
        ::greeting)))

(defn -main
  "I don't do a whole lot"
  [& args]
  (greet (first args)))