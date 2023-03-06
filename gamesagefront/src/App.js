import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Auth from "./pages/TelaInicial/Login"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/login' element={<Auth />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
