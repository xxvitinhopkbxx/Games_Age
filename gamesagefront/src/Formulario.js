function Formulario({botao, eventoTeclado, cadastrar, obj, cancelar, remover, alterar}) {
    return (
        <form>
            <input onChange={eventoTeclado} value={obj.nome} name="nome" type="text" placeholder="Nome" className="form-control" />
            <input onChange={eventoTeclado} value={obj.sobrenome} name="sobrenome" type="text" placeholder="Sobrenome" className="form-control" />
            <input onChange={eventoTeclado} value={obj.apelido} name="apelido" type="text" placeholder="Nickname" className="form-control" />
            <input onChange={eventoTeclado} value={obj.email} name="email" type="email" placeholder="Email" className="form-control" />

            {
                botao ?
                    <input onClick={cadastrar} type="button" value="Cadastrar" className="btn btn-primary" />
                    :
                    <div>
                        <input type="button" value="Alterar" onClick={alterar} className="btn btn-warning" />
                        <input type="button" value="Remover" onClick={remover} className="btn btn-danger" />
                        <input type="button" value="Cancelar" onClick={cancelar} className="btn btn-secondary" />
                    </div>
            }
        </form>
    )
}

export default Formulario;