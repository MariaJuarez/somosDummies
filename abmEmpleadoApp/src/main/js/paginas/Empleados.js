import React from "react"
import Tablas from "../componentes/Tablas"
import ModalCrearEmpleados from "../componentes/ModalCrearEmpleados"
class Empleados extends React.Component{
	render(){
		return(
			<div className='container tabla'>
				<h2 className="titulo">Empleados</h2>
				<ModalCrearEmpleados/>
				<Tablas/>
			</div>

		)
	}
}

export default Empleados