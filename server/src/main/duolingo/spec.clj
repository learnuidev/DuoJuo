(ns duolingo.spec
  (:require [clojure.spec.alpha :as s]))


(s/def :user/username string?)
(s/def :user/password_digest string?)
(s/def :user/session_token string?)
(s/def :user/email string?)
(s/def :user/site_streak integer?)

(comment
  (s/valid? :user/language_data 12)
  (s/valid? :user/language_data 12.3))

(s/def ::user (s/keys :req-un [:user/username
                               :user/password_digest
                               :user/session_token
                               :user/email
                               :user/site_streak]))

(comment
  (s/valid? ::user {:username "Jon Snow"
                    :password_digest "hello"
                    :session_token "hello"
                    :email "john@gmail.com"
                    :site_streak 42}))



