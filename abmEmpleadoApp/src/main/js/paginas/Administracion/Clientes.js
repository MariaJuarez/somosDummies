import React from "react"
import Tablas from "../../componentes/tablas/TablaClientes"


class Clientes extends React.Component{

	render(){
		return(
			<div className='container tabla'>
				
				<h2 className="titulo">Clientes</h2>
				
				<Tablas/>
				{/*<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				<Tablas/>*/}
			</div>

		)
	}
}



export default Clientes