(defn render[data]
    (cond
        (= (type data) java.lang.Long) (str "INTEGERR[" data "]")
        (= (type data) java.lang.Double) (str "FLOAT[" data "]")
        (= (type data) java.lang.String) data
        (= (type data) clojure.lang.PersistentVector) (for [i data] (render i))
        :else                          "BLANK")
    )

(println (render 10))
(println (render 3.1415))
(println (render "hello world"))
(println (render [1, 2.1, 3]))
(println (render '(10, 20)))