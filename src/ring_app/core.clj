(ns ring-app.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.util.http-response :as response]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.format :refer [wrap-restful-format]]))

(defn handler [request]
  (response/ok
   (str "<html><body>doaa your IP: "
   (:remote-addr request)
   "</body></html>")))

(defn -main []
  (jetty/run-jetty
   (-> #'handler wrap-reload)
   {:port 3000
    :join? false}))
