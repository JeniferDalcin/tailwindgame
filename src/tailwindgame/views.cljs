(ns tailwindgame.views
  (:require
   [re-frame.core :as rf]
   
   [tailwindgame.subs :as subs]
   [tailwindgame.frames.level1 :as level1]
   [tailwindgame.frames.level2 :as level2]
   [tailwindgame.frames.level3 :as level3]
   [tailwindgame.frames.level4 :as level4]
   [tailwindgame.frames.level5 :as level5]
   [tailwindgame.frames.level6 :as level6]
   [tailwindgame.frames.level7 :as level7]
   [tailwindgame.frames.level8 :as level8]
   [tailwindgame.frames.level9 :as level9]
   [tailwindgame.frames.level10 :as level10]
   [tailwindgame.frames.level11 :as level11]
   [tailwindgame.frames.level12 :as level12]
   [tailwindgame.frames.level13 :as level13]
   [tailwindgame.frames.level14 :as level14]
   [tailwindgame.frames.level15 :as level15]))


(defn main-panel []
  (let [current-level (rf/subscribe [::subs/?current-level])] 
    [:div.flex.flex-1
     
     
     (cond 
       (= @current-level 1)
       [level1/Frame]
       
       (= @current-level 2)
       [level2/Frame]
       
       (= @current-level 3)
       [level3/Frame]
       
       (= @current-level 4)
       [level4/Frame]
       
       (= @current-level 5)
       [level5/Frame]
       
       (= @current-level 6)
       [level6/Frame]
       
       (= @current-level 7)
       [level7/Frame]
       
       (= @current-level 8)
       [level8/Frame]
       
       (= @current-level 9)
       [level9/Frame]
       
       (= @current-level 10)
       [level10/Frame]
       
       (= @current-level 11)
       [level11/Frame]
       
       (= @current-level 12)
       [level12/Frame]
       
       (= @current-level 13)
       [level13/Frame]
       
       (= @current-level 14)
       [level14/Frame]
       
       (= @current-level 15)
       [level15/Frame])]))








