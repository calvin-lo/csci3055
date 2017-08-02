(defprotocol renderP
  (render [data] "Result"))

(extend-protocol renderP
    java.lang.Long
        (render [data] (str "INTEGERR[" data "]"))
    java.lang.Double 
        (render [data] (str "Float[" data "]"))
    java.lang.String 
        (render [data] data)  
    clojure.lang.PersistentVector 
        (render [data] (for [i data] (render i)))
    Object
        (render [data] "BLANK"))
    
    
(println (render 10))
(println (render 3.1415))
(println (render "hello world"))
(println (render [1, 2.1, 3]))
(println (render '(10, 20)))