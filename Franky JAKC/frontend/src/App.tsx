import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import ReservaForm from './components/ReservaForm';
import ReservaList from './components/ReservaList';

const App: React.FC = () => {
  return (
    <div className="container mt-4">
      <h1>Gestión de Reservas</h1>
      <ReservaForm />
      <hr />
      <ReservaList />
    </div>
  );
};

export default App;
