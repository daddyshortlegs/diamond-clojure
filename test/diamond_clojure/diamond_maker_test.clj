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
    (is (= 0 (get-index-for-char "A")))
    (is (= 1 (get-index-for-char "B")))
    (is (= 25 (get-index-for-char "Z")))
    )
  )


(defn gen-space-value [char index]
  (- (get-index-for-char char) index)
  )

(deftest test-generate-space-value
  (testing "correct spaces"
    (is (= 3 (gen-space-value "D" 0)))
    (is (= 2 (gen-space-value "D" 1)))))



(deftest test-generate-leading-spaces
  (testing "correct spaces"
    (is (= (str "   ") (gen-leading-spaces "D" 0)))
    (is (= (str "  ") (gen-leading-spaces "D" 1)))
    (is (= (str " ") (gen-leading-spaces "D" 2)))
    (is (= (str "") (gen-leading-spaces "D" 3)))
    )
  )