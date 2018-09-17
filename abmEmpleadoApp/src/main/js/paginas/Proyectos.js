import React from "react"
import Tablas from "../componentes/tablas/TablaProyecto"
import {Button} from "react-bootstrap"
import Modal from "../componentes/modales/ModalCrearProyecto"
import {connect} from "react-redux"
import {bindActionCreators} from "redux"


class Proyectos extends React.Component{
	constructor(props){
		super(props);
	}

	componentDidMount() {
		this.props.cambiarTitulo();
	} 
	
	render(){
		return(

			<div className='container tabla'>
				<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				<Tablas/>
			</div>

		)
	}
}

let cambiarTitulo=()=>{
	return{
		type:"CAMBIAR_TITULO"
		,payload:"Proyectos"
		
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

export default connect(unaCopiaDelStore,laFuncionDispatch)(Proyectos)