import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyDDirGIU6lsfnQuM6hBznVRXF0jtA2Mkbg",
  authDomain: "sistemachamados-6dc4e.firebaseapp.com",
  projectId: "sistemachamados-6dc4e",
  storageBucket: "sistemachamados-6dc4e.appspot.com",
  messagingSenderId: "472984176897",
  appId: "1:472984176897:web:fa9da8846dfbc43e933300",
  measurementId: "G-8P052Z4QBD"
};

const app = initializeApp(firebaseConfig);  

export const auth = getAuth(app);