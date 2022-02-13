(ns build
  (:refer-clojure :exclude [test])
  (:require [clojure.tools.build.api :as b] ; for b/git-count-revs
            [org.corfield.build :as bb]
            [clojure.java.shell :as shell]))

(def lib 'hughpowell.co.uk/integrant-template)

(def version (format "1.0.%s" (b/git-count-revs nil)))

(defn tag [message & _]
  (shell/sh "git" "tag" "-a" version "-m" message)
  (shell/sh "git" "push" "--tags"))

(defn test "Run the tests." [opts]
  (bb/run-tests opts))
