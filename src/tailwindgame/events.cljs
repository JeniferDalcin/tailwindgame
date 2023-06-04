(ns tailwindgame.events
  (:require
   [re-frame.core :as rf]
   [tailwindgame.db :as db]))

;; Initialize db.
(rf/reg-event-db ::initialize-db
  (fn [_ _]
    db/default-db))

;; Add 1 to the level, if the level is smaller than 10.
(rf/reg-event-db ::!add-level
  (fn [db _]
    (when 
      (< (get db :level) 10)
      (update db :level inc))))

;; Dec 1 to the level, if the level is bigger than 0.
(rf/reg-event-db ::!dec-level
  (fn [db _]
    (when
      (> (get db :level) 1)
      (update db :level dec))))

;; Add 1 to the current-level, if the current-level is smaller than 10 and smaller than level unlocked.
(rf/reg-event-db ::!add-current-level
  (fn [db _]
    (when 
      (and 
        (< (get db :current-level) 10)
        (< (get db :current-level) (get db :level)))
      (update db :current-level inc))))

;; Dec 1 to the current-level, if the current-level is bigger than 0.
(rf/reg-event-db ::!dec-current-level
  (fn [db _]
    (when
      (> (get db :current-level) 1)
      (update db :current-level dec))))

;; Assoc in db the value of class input.
(rf/reg-event-db ::!set-class
  (fn [db [_ val]]
    (assoc db :class val)))

;; Clean in db the value for class.
(rf/reg-event-db ::!clean-class
  (fn [db [_ _]]
    (assoc db :class nil)))