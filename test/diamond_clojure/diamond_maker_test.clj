(ns diamond-clojure.diamond_maker_test
  (:require [clojure.test :refer :all]
            [diamond-clojure.diamond_maker :refer :all]))


(deftest test-diamond-maker
  (testing "should return A"
    (is (= "A" (diamond-maker "A"))))

  (testing "should return diamond"
    (def expected " A\nB B\n A\n")
    (is (= expected (diamond-maker "B"))))

  (testing "should return diamond for C"
    (is (= "  A\n B B\nC   C\n B B\n  A\n" (diamond-maker "C"))))

  (testing "should return diamond for D"
    (is (= "   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A\n" (diamond-maker "D"))))

  (testing "the big Z"
    (def expected (str "                         A\n"
                       "                        B B\n"
                       "                       C   C\n"
                       "                      D     D\n"
                       "                     E       E\n"
                       "                    F         F\n"
                       "                   G           G\n"
                       "                  H             H\n"
                       "                 I               I\n"
                       "                J                 J\n"
                       "               K                   K\n"
                       "              L                     L\n"
                       "             M                       M\n"
                       "            N                         N\n"
                       "           O                           O\n"
                       "          P                             P\n"
                       "         Q                               Q\n"
                       "        R                                 R\n"
                       "       S                                   S\n"
                       "      T                                     T\n"
                       "     U                                       U\n"
                       "    V                                         V\n"
                       "   W                                           W\n"
                       "  X                                             X\n"
                       " Y                                               Y\n"
                       "Z                                                 Z\n"
                       " Y                                               Y\n"
                       "  X                                             X\n"
                       "   W                                           W\n"
                       "    V                                         V\n"
                       "     U                                       U\n"
                       "      T                                     T\n"
                       "       S                                   S\n"
                       "        R                                 R\n"
                       "         Q                               Q\n"
                       "          P                             P\n"
                       "           O                           O\n"
                       "            N                         N\n"
                       "             M                       M\n"
                       "              L                     L\n"
                       "               K                   K\n"
                       "                J                 J\n"
                       "                 I               I\n"
                       "                  H             H\n"
                       "                   G           G\n"
                       "                    F         F\n"
                       "                     E       E\n"
                       "                      D     D\n"
                       "                       C   C\n"
                       "                        B B\n"
                       "                         A\n"
                       ))
    (is (= expected (diamond-maker "Z"))))
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