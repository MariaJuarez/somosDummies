import React from "react"
import Tablas from "../../componentes/tablas/TablaPerfiles"

class Perfiles extends React.Component{

	render(){
		return(
			<div className='container tabla'>
				
				<h2 className="titulo">Perfiles</h2>
				<Tablas/>
				{/*<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				<Tablas/>*/}
			</div>

		)
	}
}



export default Perfiles