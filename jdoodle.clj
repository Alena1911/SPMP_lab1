(ns clojure.examples.hello
(:gen-class))

(let [v [4 8 8 8 8 1 1 2 2 3 3 3]
         size (count v)
         n 2]
     ;; временный вектор
     (def tmpVec [])
     ;; текущее число 
     (def currNum (v 0))
     ;; конечный вектор
     (def endVec [])
     
     ;; цикл по элементам вектора v
     (loop [i 0]
       (when (< i size)
         (if (= currNum (v i))
            ;; если текущее число равно текущему элементу вертора
            ;; добавляем во временный вектор текущий элемент вектора v
           (def tmpVec (into tmpVec [(v i)]))
           ;; иначе
           (do
             ;; в текущее число записываем текущмй элемент вектора v
             (def currNum (v i))
             ;; если во временном векторе количество элементов <= n
             ;; добавляем его в конечный вектор
             (if (<=(count tmpVec) n)
                   (def endVec (into endVec tmpVec))
                   (def endVec (into endVec [(first tmpVec)]))
                   )
             ;; обнуляем временный вектор 
             (def tmpVec [])
             ;; добавляем во временный вектор текущий элемент вектора v
             (def tmpVec (into tmpVec [(v i)]))))
         ;; инкремент i и возврат к началу цикла
         (recur (inc i))))
     
     
     ;; после цикла если во временном векторе количество элементов <= n
     ;; добавляем его в конечный вектор
     (if (<=(count tmpVec) n)
                   (def endVec (into endVec tmpVec))
                   (def endVec (into endVec [(first tmpVec)]))
                   )
        ;; выводим конечный вектор
        (println endVec)
     )