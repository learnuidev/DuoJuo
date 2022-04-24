(ns app.view)
  ; (require ["/footer.js" :as Footer]))

(defn header []
  [:header.logged-out-nav
   [:div.logged-out-nav-container
    [:a.duoLogo {:href "/"}]
    [:div.langlogin-container
     [:div.site-lang
      "Site language:"
      [:span.site-lang-language "English"]]
     [:div.login-button-div
      [:button.login-button "Login"]]]]])

(defn body-container []
  [:div.body-container
   [:div.globe]
   [:div.slogan-text-box
    [:h1.slogan-text "Learn a language for free. Forever."]
    [:a.get-started-button "get started"]]])

(defn footer []
  [:div.footer-nav
   [:div.flag-carousel
    [:ul.flag-carousel-list
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size spanish-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "Spanish"]]
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size french-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "French"]]
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size german-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "German"]]
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size italian-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "Italian"]]
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size portuguese-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "Portuguese"]]
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size dutch-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "Dutch"]]
     [:li>a {:href ""}
      [:span {:class "flag-carousel-list-flag flag-size czech-flag-footer"}]
      [:span {:class "flag-carousel-list-text"} "Czech"]]]]])


(defn app []
  [:div.container-splash
   [:div.logged-out-container
    [header]
    [body-container]
    [footer]]])
