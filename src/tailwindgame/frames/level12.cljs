(ns tailwindgame.frames.level12
  (:require
   [re-frame.core :as rf]
   
   [tailwindgame.subs :as subs]
   [tailwindgame.events :as events]
   
   [gui.components :as gui]))

(defn Frame []
  (let [class (rf/subscribe [::subs/?class])
        level (rf/subscribe [::subs/?level])
        current-level (rf/subscribe [::subs/?current-level])] 
    
    [:div.flex.w-full.min-h-screen
     
     ;; div left side
     [:div
      {:class "flex flex-1 flex-col bg-slate-950 w-1/2"} 
      
      ;; div with bg color
      [:div
       {:class "flex flex-1 flex-col px-10 py-5 gap-7"}
       
       ;; div with explanation
       [:div.flex.w-full.justify-between
        [:span.text-white.text-2xl "Tailwindcss, let's practice!"]
        
        ;; button to change level
        [gui/ButtonLevel
         {:on-click-left #(rf/dispatch [::events/!dec-current-level])
          :on-click-right #(rf/dispatch [::events/!add-current-level])}]]
       
       [:div.gap-3.text-slate-300.text-lg
        "Bring the astronaut back to home! Use the"
        [:span.text-white.text-lg.bg-slate-800.px-2.rounded.self-center.mx-2 "Flex Direction"]
        "for controlling the direction of flex items."]
       
       [:div.flex.flex-1.flex-col.gap-3
        [:span.text-slate-300.text-lg "Try one:"]
        [:span.text-white.text-lg.bg-slate-800.px-2.rounded.self-start.ml-6 "flex-row"]
        [:span.text-white.text-lg.bg-slate-800.px-2.rounded.self-start.ml-6 "flex-row-reverse"]
        [:span.text-white.text-lg.bg-slate-800.px-2.rounded.self-start.ml-6 "flex-col"]
        [:span.text-white.text-lg.bg-slate-800.px-2.rounded.self-start.ml-6 "flex-col-reverse"]]
       
       ;; code editor component
       [gui/CodeEditor
        {:value @class
         :on-change #(rf/dispatch [::events/!set-class (-> % .-target .-value)])
         :pre-code "flex"
         :rows 7
         :desired-class "flex-col-reverse"
         :on-click-check (fn [] 
                           ;; the logic is if the level unlocked is equal to the current level than add-level add-curren-level and clean-class
                           (cond 
                             (= @level @current-level) 
                             (do 
                               (rf/dispatch [::events/!add-level])
                               (rf/dispatch [::events/!add-current-level])
                               (rf/dispatch [::events/!clean-class]))
                             
                           ;; otherwise we don't want to add level when current level is less than unlocked level, this could be problem if
                           ;; the user go back to a lower level and reevaluate a class again, would be a 'trick'.
                             (not= @level @current-level)
                             (do
                               (rf/dispatch [::events/!add-current-level])
                               (rf/dispatch [::events/!clean-class]))))}]
       
       ;; GitHub
       [gui/GitHubLink]]]
     
     
     ;; div right side
     [:div
      {:class "flex flex-col justify-center items-center bg-slate-950 w-6/12"}
      
      ;; div inside a div thats have a bg color
      [:div
       {:class "flex flex-1 px-10 py-5 w-full 
                h-full bg-slate-950"}
       
       ;; earth
       [:div.relative.h-full.w-full.bg-slate-950.rounded-md.border.border-indigo-700.p-7
        [:img.absolute.bottom-7.left-7.h-20.w-20
         {:src "images/earth.png"}]
        
        [:img.absolute.bottom-32.left-7.h-20.w-20
         {:src "images/earth.png"}]
        
        
        ;; astronaut 
        [:div.flex.flex-1.w-full.h-full.p-4.gap-12
         {:class @class}
         
         [:img.h-12.w-12.z-10
          {:src "images/astronaut.png"}]
         [:img.h-12.w-12.z-10
          {:src "images/astronaut.png"}]]]]]]))