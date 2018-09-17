import React from "react"
import Tablas from "../../componentes/tablas/TablaTecnologias"

class Tecnologias extends React.Component{
	
	render(){
		return(
			<div className='container tabla'>
				
				
				<h2 className="titulo">Tecnologias</h2>
				<Tablas />
				{/*
				<Modal/>
				<Tablas/>*/}
			</div>

		)
	}
}



export default Tecnologias