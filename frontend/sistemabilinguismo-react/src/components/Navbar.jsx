import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {
  return (
    <nav className="navbar">
      <h2 className="logo">Sistema de Bilingüismo</h2>

      <ul className="menu">
        <li><Link to="/">Inicio</Link></li>
        <li><Link to="/login">Login</Link></li>
        <li><Link to="/registro">Registro</Link></li>
        <li><Link to="/cursos">Cursos</Link></li>
        <li><Link to="/perfil">Perfil</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;