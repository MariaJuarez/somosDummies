import React from "react"
import {Form,FormControl,Col, ControlLabel,FormGroup,Button} from 'react-bootstrap'
import '../estilos/style.css'
import {connect} from "react-redux"
import {bindActionCreators} from "redux"

class Login extends React.Component{
	render(){
		return(
			<div className="pagina">
			<div className="container tabla">
				<div className="login-page">
				  <div className="form">
					  <form className="login-form">
				      <input type="text" placeholder="usuario"  autoComplete="off"/>
				      <input type="password" placeholder="contraseña"  autoComplete="off"/>
				      <button>Iniciar Sesion</button>
				      <p className="message">No estas registrado? <a href="#">Crear una cuenta</a></p>
				    </form>
				  </div>
				</div>
			</div>
			</div>

		)
	}
}

let cambiarTitulo=()=>{
	return{
		type:"CAMBIAR_TITULO"
		,payload:"Login"
		
	}

}


let unaCopiaDelStore=store=> {
	return{
		titulo:store.App.titulo
	}
}
let laFuncionDispatch=dispatch=> {
	return{
		cambiarTitulo:bindActionCreators(cambiarTitulo,dispatch)
	}
	
}

export default connect(unaCopiaDelStore,laFuncionDispatch)(Login)