(ns gui.components
  (:require
   [re-frame.core :as rf]
   
   [tailwindgame.subs :as subs]
   
   ["@heroicons/react/24/solid" :as heroicons-solid]))


(defn ButtonLevel 
  "Button with chevrons to change level."
  [{:keys [on-click-left on-click-right]}]
  
  (let [current-level (rf/subscribe [::subs/?current-level])] 
    
    [:div.flex.shrink.justify-center.items-center.shadow-md.shadow-indigo-700.rounded.h-7
     
     [:> heroicons-solid/ChevronLeftIcon
      {:class "h-7 w-7 text-white bg-slate-800 p-1 rounded-l-md hover:bg-slate-900"
       :on-click on-click-left}]
     
     [:span.min-w-fit.bg-slate-800.text-white.text-sm.font-thin.tracking-wide.p-1 "Level " @current-level " de 15"]
     
     [:> heroicons-solid/ChevronRightIcon
      {:class "h-7 w-7 text-white bg-slate-800 p-1 rounded-r-md hover:bg-slate-900"
       :on-click on-click-right}]]))


(defn CodeEditor 
  "Editor code component."
  [{:keys [value on-change pre-code rows desired-class on-click-check]}]
  
  [:div.flex.flex-1.flex-col.w-full.h-fit.border.border-indigo-700.rounded-md
   [:div.flex.flex-1
    [:div
     {:class "flex flex-col w-6 bg-indigo-700/30 p-1 rounded-ss-md rounded-es-md"}
     
     ;; column of numbers
     (map 
       (fn [n] 
         [:span
          {:class "h-[24px] text-white text-sm font-thin self-end"} n])
       (range 1 (+ rows 1)))]
    
    [:div.flex.flex-col.w-full.bg-slate-800.rounded-r-md.px-4.pb-4.pt-7
     
     ;;previous code
     [:span.text-sm.text-white.font-normal.px-2.py-1 pre-code]
     
     ;; input class
     [:input
      {:class "text-sm text-white font-normal rounded-md h-[24px] w-[300px] p-2 outline-none w-20 bg-slate-600"
       :value value
       :placeholder "Type your code here :) "
       :type "text"
       :on-change on-change}]
     
     ;; button check
     [:div.flex.flex-1.w-full.justify-end.items-end
      [:button.w-16.h-8.text-sm.border.border-indigo-700.rounded.shadow-lg.active:shadow-inner
       {:class
        (if (= desired-class value)
          "bg-white text-indigo-700 animate-bounce hover:animate-none"
          "bg-slate-400 pointer-events-none")
        :on-click on-click-check}
       [:label.cursor-pointer "Check"]]]]]])


(defn GitHubLink 
  "Link to GitHub repo."
  []
  [:div.flex.flex-1.flex-col.items-center
   [:span.text-slate-300.text-xs.tracking-wider.font-extralight "Collaborate with the astronaut :)"]
   [:a
    {:class "text-slate-300 text-xs tracking-wider font-extralight hover:text-indigo-700"
     :href "https://github.com/JeniferDalcin"} "GitHub"]])




