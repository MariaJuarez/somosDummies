import React from "react"
import Tablas from "../componentes/Tablas"
import Modales from "../componentes/ModalCrearEmpleados"
import Modal from "../componentes/ModalCrearProyecto"
class Empleados extends React.Component{
	render(){
		return(
			<div className='container tabla'>
				<h2 className="titulo">Empleados</h2>
                <Modal/>
				<Modales/>
				<Tablas/>
			</div>

		)
	}
}

export default Empleados