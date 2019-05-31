(ns diamond-clojure.diamond_maker_test
  (:require [clojure.test :refer :all]
            [diamond-clojure.diamond_maker :refer :all]))


(deftest test-diamond-maker
  (testing "should return A"
    (is (= "A" (diamond-maker "A"))))

  ;(testing "should return diamond"
  ;  (def expected " A\nB B\n A\n")
  ;  (is (= expected (diamond-maker "B"))))

  (testing "should return diamond for C"
    (is (= "  A\n B B\nC   C\n B B\n  A\n" (diamond-maker "C"))))

  (testing "should return diamond for D"
    (is (= "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A\n" (diamond-maker "D"))))

  )


(deftest test-find-index-for-char
  (testing "should get index for chars"
    (is (= 0 (get-index-for-char "A")))
    (is (= 1 (get-index-for-char "B")))
    (is (= 25 (get-index-for-char "Z")))
    )

  (testing "should get char for index"
    (is (= (str "A") (get-char-for-index 0))))
  )


(defn gen-space-value [char index]
  (- (get-index-for-char char) index)
  )

(deftest test-generate-space-value
  (testing "correct spaces"
    (is (= 3 (gen-space-value "D" 0)))
    (is (= 2 (gen-space-value "D" 1)))))



(deftest test-generate-leading-spaces
  (testing "correct spaces for D"
    (is (= (str " ") (gen-leading-spaces "B" 0)))

    (is (= (str "   ") (gen-leading-spaces "D" 0)))
    (is (= (str "  ") (gen-leading-spaces "D" 1)))
    (is (= (str " ") (gen-leading-spaces "D" 2)))
    (is (= (str "") (gen-leading-spaces "D" 3)))

    (is (= (str "    ") (gen-leading-spaces "E" 0)))
    (is (= (str "   ") (gen-leading-spaces "E" 1)))
    (is (= (str "  ") (gen-leading-spaces "E" 2)))
    (is (= (str " ") (gen-leading-spaces "E" 3)))
    (is (= (str "") (gen-leading-spaces "E" 4)))

    )
  )


(deftest test-calc-middle-spaces
  (testing "correct middle space value"
    (is (= 1 (calc-middle-spaces "B")))
    (is (= 3 (calc-middle-spaces "C")))
    (is (= 5 (calc-middle-spaces "D")))
    (is (= 7 (calc-middle-spaces "E")))
    )
  )

(deftest test-generate-middle-spaces
  (testing "generate actual spaces"
    (is (= (str " ") (gen-middle-spaces "B")))
    (is (= (str "   ") (gen-middle-spaces "C")))
    )
  )

(deftest test-generate-line
  (testing "D"
    (is (= (str "D     D\n") (draw-line "D" 3)))
    (is (= (str " C   C\n") (draw-line "D" 2)))
    (is (= (str "  B B\n") (draw-line "D" 1)))
    )

  (testing "C"
    (is (= (str "C   C\n") (draw-line "C" 2)))
    (is (= (str " B B\n") (draw-line "C" 1)))
    )

  )