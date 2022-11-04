import firebase from "firebase/app";

import 'firebase/analytics'
import 'firebase/auth'
import 'firebase/firestore'

const firebaseConfig = {
    apiKey: "AIzaSyBEvyYkDxoM9aXrkDKlxYC-LBzFYzuhNV0",
    authDomain: "chat-app-b8c44.firebaseapp.com",
    projectId: "chat-app-b8c44",
    storageBucket: "chat-app-b8c44.appspot.com",
    messagingSenderId: "191818447694",
    appId: "1:191818447694:web:41aa84317e5527d4a87c1f",
    measurementId: "G-781DN7DQFD"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();

const auth = firebase.auth();
const db = firebase.firestore();

export {db , auth}
export default  firebase;
