import { useState } from "react";

function Registro() {
  const [usuario, setUsuario] = useState({
    nombre: "",
    apellido: "",
    correo: "",
    contrasena: "",
  });

  const manejarCambio = (e) => {
    setUsuario({
      ...usuario,
      [e.target.name]: e.target.value,
    });
  };

  const registrar = async (e) => {
    e.preventDefault();

    try {
      const respuesta = await fetch("http://localhost:8080/api/usuarios", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(usuario),
      });

      if (respuesta.ok) {
        alert("Usuario registrado correctamente");

        setUsuario({
          nombre: "",
          apellido: "",
          correo: "",
          contrasena: "",
        });
      } else {
        alert("Error al registrar el usuario");
      }
    } catch (error) {
      alert("No se pudo conectar con el servidor");
    }
  };

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        marginTop: "50px",
      }}
    >
      <form
        onSubmit={registrar}
        style={{
          background: "#fff",
          padding: "30px",
          width: "400px",
          borderRadius: "10px",
          boxShadow: "0 0 10px #ccc",
        }}
      >
        <h2 style={{ textAlign: "center", marginBottom: "20px" }}>
          Registro de Usuario
        </h2>

        <input
          type="text"
          name="nombre"
          placeholder="Nombre"
          value={usuario.nombre}
          onChange={manejarCambio}
          style={{ width: "100%", padding: "10px", marginBottom: "15px" }}
        />

        <input
          type="text"
          name="apellido"
          placeholder="Apellido"
          value={usuario.apellido}
          onChange={manejarCambio}
          style={{ width: "100%", padding: "10px", marginBottom: "15px" }}
        />

        <input
          type="email"
          name="correo"
          placeholder="Correo electrónico"
          value={usuario.correo}
          onChange={manejarCambio}
          style={{ width: "100%", padding: "10px", marginBottom: "15px" }}
        />

        <input
          type="password"
          name="contrasena"
          placeholder="Contraseña"
          value={usuario.contrasena}
          onChange={manejarCambio}
          style={{ width: "100%", padding: "10px", marginBottom: "20px" }}
        />

        <button type="submit" style={{ width: "100%" }}>
          Registrarse
        </button>
      </form>
    </div>
  );
}

export default Registro;