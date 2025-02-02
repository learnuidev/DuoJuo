(ns duolingo.conversation.handlers
  (:require [ring.util.response :as rr]
            [duolingo.conversation.db :as conversation-db]
            [duolingo.responses :as responses])
  (:import (java.util UUID)))

(defn list-conversations
  [{:keys [env claims] :as _request}]
  (let [account-id (:sub claims)]))
    ;; FIXME: conversation-db/find-conversations-by-account-id


(defn create-conversation!
  [{:keys [claims parameters env]}]
  (let [message (:body parameters)
        message-id (str (UUID/randomUUID))
        from (:sub claims)
        conversation-id (UUID/randomUUID)]))
    ;; FIXME: conversation-db/transact-conversation


(defn list-messages
  [{:keys [env parameters] :as _request}]
  (let [conversation-id (-> parameters :path :conversation-id)]))
    ;; FIXME: conversation-db/find-messages-by-conversation-id


(defn create-message!
  [{:keys [parameters env claims] :as _request}]
  (let [conversation-id (-> parameters :path :conversation-id)
        message (:body parameters)
        from (:sub claims)]))
    ;; FIXME: conversation-db/transact-message


(defn update-notifications!
  [{:keys [claims env parameters] :as _request}]
  (let [account-id (:sub claims)
        conversation-id (-> parameters :path :conversation-id)]))
    ;; FIXME: conversation-db/read-messages
