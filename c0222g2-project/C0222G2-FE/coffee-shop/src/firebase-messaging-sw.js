importScripts('https://www.gstatic.com/firebasejs/8.0.2/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.0.2/firebase-messaging.js');

firebase.initializeApp({
    apiKey: "AIzaSyCsrF2SQ5PRuUi-IrIW_khM1_z9GYPlwgU",
    authDomain: "c0222g2-4cf09.firebaseapp.com",
    databaseURL: "https://c0222g2-4cf09-default-rtdb.asia-southeast1.firebasedatabase.app",
    projectId: "c0222g2-4cf09",
    storageBucket: "c0222g2-4cf09.appspot.com",
    messagingSenderId: "184074448800",
    appId: "1:184074448800:web:2bc5f589b22959ec64bec5"
});

const messaging = firebase.messaging();

if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('/firebase-messaging-sw.js')
      .then(function(registration) {
        console.log('Registration successful, scope is:', registration.scope);
      }).catch(function(err) {
        console.log('Service worker registration failed, error:', err);
      }); }
