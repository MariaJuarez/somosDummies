import React from "react"
import Tabla from "../../componentes/tablas/TablaAreas"


class Areas extends React.Component{

	render(){
		return(
			<div className='container tabla'>
				<h2 className="titulo">Areas</h2>
				<Tabla/>
			</div>

		)
	}
}



export default Areas