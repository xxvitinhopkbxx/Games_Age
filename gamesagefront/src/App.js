import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';

function App() {

  //Objeto usuario
  const usuario = {
    idUsuario: 0,
    nome: '',
    sobrenome: '',
    apelido: '',
    email: '',
    progressos: []
  }

  //UseState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [usuarios, setUsuarios] = useState([]);
  const [objUsuario, setObjUsuario] = useState(usuario);

  //UseEffect
  useEffect(() => {
    fetch('http://localhost:8080/usuarios')
      .then(retorno => retorno.json())
      .then(retorno_convertido => setUsuarios(retorno_convertido));
  }, []);

  //Obtendo os dados do formulário
  const aoDigitar = (e) => {
    setObjUsuario({ ...objUsuario, [e.target.name]: e.target.value });
  }

  //Cadastrar usuario
  const cadastrar = () => {
    fetch('http://localhost:8080/usuarios/cadastrar', {
      method: 'post',
      body: JSON.stringify(objUsuario),
      headers: {
        'Content-type': 'application/json',
        'Accept': 'application/json'
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
    setBtnCadastrar(true);
  }

  //Selecionar usuário
  const selecionarUsuario = (indice) => {
    setObjUsuario(usuarios[indice]);
    setBtnCadastrar(false);
  }

  //Alterar usuario
  const alterar = () => {
    fetch('http://localhost:8080/usuarios/alterar', {
      method: 'put',
      body: JSON.stringify(objUsuario),
      headers: {
        'Content-type': 'application/json',
        'Accept': 'application/json'
      }
    })
      .then(retorno => retorno.json())
      .then(retorno_convertido => {
        if (retorno_convertido.mensagem !== undefined) {
          alert(retorno_convertido.mensagem);
        } else {

          //Mensagem
          alert('Produto alterado com sucesso');

          //Cópia do vetor de usuários
          let vetorTemp = [...usuarios];

          //Índice
          let indice = vetorTemp.findIndex((p) => {
            return p.idUsuario === objUsuario.idUsuario;
          });

          //Alterar usuario do vetorTemp
          vetorTemp[indice] = objUsuario;

          //Atualizar o vetor de usuários
          setUsuarios(vetorTemp);

          //Limpar formulário
          limparFormulario();
        }
      })
  }

  //Remover usuário
  const remover = () => {
    fetch('http://localhost:8080/usuarios/remover/' + objUsuario.idUsuario, {
      method: 'delete',
      body: JSON.stringify(objUsuario),
      headers: {
        'Content-type': 'application/json',
        'Accept': 'application/json'
      }
    })
      .then(retorno => retorno.json())
      .then(retorno_convertido => {

        //Mensagem
        alert(retorno_convertido.mensagem);

        //Cópia do vetor de usuários
        let vetorTemp = [...usuarios];

        //Índice
        let indice = vetorTemp.findIndex((p) => {
          return p.idUsuario === objUsuario.idUsuario;
        });

        //Remover usuario do vetorTemp
        vetorTemp.splice(indice, 1);

        //Atualizar o vetor de usuários
        setUsuarios(vetorTemp);

        //Limpar Formulário
        limparFormulario();
      })
  }

  //Retorno
  return (
    <div>
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objUsuario} cancelar={limparFormulario} 
      remover={remover} alterar={alterar} />
      <Tabela vetor={usuarios} selecionar={selecionarUsuario} />
    </div>
  );
}

export default App;
