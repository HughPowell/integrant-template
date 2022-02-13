(ns {{main/ns}}-spec
  (:require [clojure.test :refer [deftest is testing]]
            [{{main/ns}} :as sut]))

(deftest a-test
  (testing "I work."
    (is (= "Hello, You!" (sut/greet nil))))
  (testing "FIXME, I fail."
    (is (= "Hello, World!" (sut/greet "Me")))))
