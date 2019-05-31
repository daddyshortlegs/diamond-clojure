(ns diamond-clojure.diamond_maker_test
  (:require [clojure.test :refer :all]
            [diamond-clojure.diamond_maker :refer :all]))


(deftest test-diamond-maker
  (testing "should return A"
    (is (= "A" (diamond-maker "A"))))

  (testing "should return diamond"
    (def expected " A\nB B\n A\n")
    (is (= expected (diamond-maker "B"))))

  ;(testing "should return diamond for C"
  ;  (def expected "  A\n B B\nC   C\n B B\n   A\n")
  ;  (is (= expected (diamond-maker "C"))))
  )


(deftest test-find-index-for-char
  (testing "should get index for chars"
    (is (= 1 (get-index-for-char "A")))
    (is (= 2 (get-index-for-char "B")))
    (is (= 26 (get-index-for-char "Z")))
    )
  )

(defn gen-leading-spaces [char index]
  (str "   "))

(deftest test-generate-leading-spaces
  (testing "correct spaces"
    (is (= (str "   ") (gen-leading-spaces "D" 0)))))
