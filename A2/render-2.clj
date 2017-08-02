(defmulti render class)

(defmethod render java.lang.Long [data]
    (str "Integer[" data "]")
)
(defmethod render java.lang.Double [data]
    (str "Float[" data "]")
)
(defmethod render java.lang.String [data]
    data
)
(defmethod render clojure.lang.PersistentVector [data]
    (for [i data] (render i))
)
(defmethod render :default [data]
    "BLANK"
)
    
(println (render 10))
(println (render 3.1415))
(println (render "hello world"))
(println (render [1, 2.1, 3]))
(println (render '(10, 20)))