import React from "react"
import Tablas from "../../componentes/tablas/TablaCargos"
import Modal from "../../componentes/modales/ModalCrearCargo"

class Cargos extends React.Component{

	render(){
		return(
			<div className='container tabla'>
				
				<h2 className="titulo">Cargos</h2>
				
				<Tablas/>
				{/*<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				<Tablas/>*/}
			</div>

		)
	}
}



export default Cargos