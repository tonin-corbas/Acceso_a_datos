import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App'; // Importa tu componente raíz
import 'bootstrap/dist/css/bootstrap.min.css'; // Importa Bootstrap

// Renderiza el componente <App /> dentro del div con id="root"
ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
