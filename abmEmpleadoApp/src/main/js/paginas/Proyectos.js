import React from "react"
import Tablas from "../componentes/Tablas"
import {Button} from "react-bootstrap"
import Modal from "../componentes/ModalCrearProyecto"


class Proyectos extends React.Component{
	render(){
		return(

			<div className='container tabla'>
				<h2 className="titulo">Proyectos</h2>
				<Modal/>
				<Tablas/>
			</div>

		)
	}
}

export default Proyectos