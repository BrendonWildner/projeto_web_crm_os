
import React, { useEffect, useState } from 'react';

function App() {
  const [ordens, setOrdens] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/ordens')
      .then(res => res.json())
      .then(data => setOrdens(data));
  }, []);

  const colunas = ['NOVO', 'ANDAMENTO', 'FINALIZADO'];

  return (
    <div style={{ display: 'flex', gap: '20px', padding: '20px' }}>
      {colunas.map(status => (
        <div key={status} style={{ flex: 1 }}>
          <h2>{status}</h2>
          {ordens.filter(o => o.status === status).map(o => (
            <div key={o.id} style={{ padding: '10px', background: '#eee', marginBottom: '10px' }}>
              <strong>{o.cliente}</strong><br/>
              <small>{o.descricao}</small>
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}

export default App;
