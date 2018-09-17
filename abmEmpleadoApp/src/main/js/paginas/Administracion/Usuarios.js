import React from "react"
import Tablas from "../../componentes/tablas/TablaUsuarios"


class Usuarios extends React.Component{

	render(){
		return(
			<div className='container tabla'>
				
				<h2 className="titulo">Usuarios</h2>
				<Tablas/>
				{/*<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				*/}
			</div>

		)
	}
}



export default Usuarios