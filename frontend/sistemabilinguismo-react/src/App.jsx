import { Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Footer from "./components/Footer";

import Home from "./pages/Home";
import Login from "./pages/Login";
import Registro from "./pages/Registro";
import Cursos from "./pages/Cursos";
import Perfil from "./pages/Perfil";

function App() {
  return (
    <>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="/cursos" element={<Cursos />} />
        <Route path="/perfil" element={<Perfil />} />
      </Routes>

      <Footer />
    </>
  );
}

export default App;