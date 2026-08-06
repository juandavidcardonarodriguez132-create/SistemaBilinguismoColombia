function Cursos() {
  return (
    <div className="home">
      <h1>Cursos Disponibles</h1>

      <div style={{display:"flex",justifyContent:"center",gap:"20px",flexWrap:"wrap",marginTop:"40px"}}>

        <div style={{background:"#fff",padding:"20px",width:"250px",borderRadius:"10px",boxShadow:"0 0 10px #ccc"}}>
          <h2>Inglés Básico</h2>
          <p>Aprende vocabulario, saludos y expresiones básicas.</p>
          <button>Ver curso</button>
        </div>

        <div style={{background:"#fff",padding:"20px",width:"250px",borderRadius:"10px",boxShadow:"0 0 10px #ccc"}}>
          <h2>Inglés Intermedio</h2>
          <p>Mejora tu gramática y conversaciones.</p>
          <button>Ver curso</button>
        </div>

        <div style={{background:"#fff",padding:"20px",width:"250px",borderRadius:"10px",boxShadow:"0 0 10px #ccc"}}>
          <h2>Inglés Avanzado</h2>
          <p>Domina el idioma con ejercicios prácticos.</p>
          <button>Ver curso</button>
        </div>

      </div>
    </div>
  );
}

export default Cursos;