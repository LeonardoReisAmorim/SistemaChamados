import { BrowserRouter } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import Rotas from "./Rotas";
import 'react-toastify/dist/ReactToastify.css';
import AuthProvider from "./contexts/auth";

function App(){
    return (
        <AuthProvider>
          <ToastContainer autoClose={3000} />
          <BrowserRouter>
            <Rotas/>
          </BrowserRouter>
        </AuthProvider>
      );
    
    
}export default App;