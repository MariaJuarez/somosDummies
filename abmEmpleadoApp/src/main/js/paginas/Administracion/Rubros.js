import React from "react"
import Tablas from "../../componentes/tablas/TablaRubros"

class Rubros extends React.Component{


   

	render(){
		return(
			<div className='container tabla'>
				<h2 className="titulo">Rubros</h2>
				<Tablas/>
				
				{/*<h2 className="titulo">{this.props.titulo}</h2>
				<Modal/>
				<Tablas/>*/}
			</div>

		)
	}
}



export default Rubros