(ns tailwindgame.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub ::?name
  (fn [db]
    (:name db)))

(re-frame/reg-sub ::?level
  (fn [db]
   (:level db)))

(re-frame/reg-sub ::?current-level
  (fn [db]
   (:current-level db)))

(re-frame/reg-sub ::?class
  (fn [db]
   (:class db)))

