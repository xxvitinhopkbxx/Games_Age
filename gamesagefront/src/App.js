import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {

//Objeto usuario
const usuario = {
  idUsuario : 0,
  nome : '', 
  sobrenome : '',
  apelido : '',
  email : '',
  progressos : []
}
  
  //UseState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [usuarios, setUsuarios] = useState([]);
  const [objUsuario, setObjUsuario] = useState(usuario);

  //UseEffect
  useEffect(()=>{
    fetch('http://localhost:8080/usuarios')
    .then(retorno => retorno.json())
    .then(retorno_convertido => setUsuarios(retorno_convertido));
  }, []);

  //Obtendo os dados do formulário
  const aoDigitar = (e) => {
    setObjUsuario({...objUsuario, [e.target.name]:e.target.value});
  }

  //Cadastrar usuario
  const cadastrar = () => {
    fetch('http://localhost:8080/usuarios/cadastrar', {
      method : 'post', 
      body : JSON.stringify(objUsuario),
      headers : {
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      if (retorno_convertido.mensagem !== undefined) {
        alert(retorno_convertido.mensagem);
      } else {
        setUsuarios([...usuarios, retorno_convertido]);
        alert('Produto cadastrado com sucesso');
        limparFormulario();
      }
    })
  }

  //Limpar formulário
  const limparFormulario = () => {
    setObjUsuario(usuario);
  }

  //Retorno
  return (
    <div>
      <p>{JSON.stringify(objUsuario)}</p>
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objUsuario} />
      <Tabela vetor={usuarios} />
    </div>
  );
}

export default App;
