import React from "react"
import {connect} from "react-redux"
import {bindActionCreators} from "redux"

import '../estilos/style.css';


class Home extends React.Component{
	
	constructor(props){
		super(props);
	}

	componentDidMount() {
		this.props.cambiarTitulo();
	}   

	render(){
		return(
			<div className='container tabla'>
			<h1 className= "letra">{this.props.titulo}</h1>			
			</div>

		)
	}

}

let cambiarTitulo=()=>{
	return{
		type:"CAMBIAR_TITULO"
		,payload:"Home"
		
	}

}


let unaCopiaDelStore=store=> {
	return{
		titulo:store.App.titulo
	}
}
let laFuncionDispatch=dispatch=> {
	return{
		cambiarTitulo:bindActionCreators(cambiarTitulo,dispatch)
	}
	
}

export default connect(unaCopiaDelStore,laFuncionDispatch)(Home)
