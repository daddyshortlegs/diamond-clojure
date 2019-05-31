(ns diamond-clojure.core-test
  (:require [clojure.test :refer :all]
            [diamond-clojure.core :refer :all]))

(deftest test-diamond-maker
  (testing "should return A"
    (is (= "A" (diamond-maker "A")))))
