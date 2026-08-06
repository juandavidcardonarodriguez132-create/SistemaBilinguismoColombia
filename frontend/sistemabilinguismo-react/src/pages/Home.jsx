import { useEffect, useState } from "react";

function Home() {
  const [mensaje, setMensaje] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/saludo")
      .then((res) => res.text())
      .then((data) => setMensaje(data))
      .catch(() => setMensaje("No se pudo conectar con el backend"));
  }, []);

  return (
    <div className="home">
      <h1>Aprende Inglés con Nosotros</h1>

      <p>{mensaje}</p>

      <button>Comenzar Ahora</button>
    </div>
  );
}

export default Home;