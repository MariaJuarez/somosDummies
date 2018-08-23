import React from "react"
import Tablas from "../componentes/Tablas"
import Modal from "../componentes/ModalCrearEmpleados"

class Empleados extends React.Component{
	render(){
		return(
			<div className='container tabla'>
				<h2 className="titulo">Empleados</h2>
				<Modal/>
				<Tablas/>
			</div>

		)
	}
}

export default Empleados