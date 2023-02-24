import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {
  //UseState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [usuarios, setUsuarios] = useState([]);

  //UseEffect
  useEffect(() => {
    fetch("http://localhost:8080/usuarios")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setUsuarios(retorno_convertido));
  }, []);

  //Retorno
  return (
    <div>
      <p>{JSON.stringify(produtos)}</p>
      <Formulario botao={btnCadastrar} />
      <Tabela />
    </div>
  );
}

export default App;
