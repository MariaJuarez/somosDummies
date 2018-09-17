import React from "react"
import Header from "./Header"
import Footer from "./Footer"
import Main from "./Main"
import axios from 'axios'

		
import {BrowserRouter as Router,Switch,Route} from "react-router-dom"

import Home from "../paginas/Home"
import Empleados from "../paginas/Empleados"
import Proyectos from "../paginas/Proyectos"
import Login from "../paginas/Login"
import Cargos  from "../paginas/Administracion/Cargos"
import Areas from "../paginas/Administracion/Areas"
import Perfiles from "../paginas/Administracion/Perfiles"
import Rubros from "../paginas/Administracion/Rubros"
import Metodologias from "../paginas/Administracion/Metodologias"
import Clientes from "../paginas/Administracion/Clientes"
import Tecnologias  from "../paginas/Administracion/Tecnologias"
import TiposDeProyecto from "../paginas/Administracion/TiposDeProyecto"
import Usuarios  from "../paginas/Administracion/Usuarios"
import '../estilos/style.css'


class App extends React.Component{
	constructor(props){
		super(props) 	
		this.state={
			titulo:"Somos",
			links:[
				{texto:"Empleados", url: "empleados"},
				{texto:"Proyectos", url: "proyectos"},
				{texto:"Administracion", url: "administracion", Dropdown:[
				{texto:"Cargos", url: "cargos"},
				{texto:"Areas", url: "areas"},
				{texto:"Clientes", url: "clientes"},
				{texto:"Rubros", url: "rubros"},
				{texto:"Metodologias", url: "metodologias"},
				{texto:"Perfiles", url: "perfiles"},
				{texto:"Tecnologias", url: "tecnologias"},
				{texto:"Tipos de Proyecto", url: "tiposDeProyecto"},
				{texto:"Usuarios", url: "usuarios"}
				]},
				
				
			],
			session:{texto:"Logout", url: "login"}
		}	
	}

	render(){
		let {titulo,links, session}=this.state
		return(
			<Router>
				<React.Fragment>
					<Header titulo={titulo} links={links} session={session}>
					</Header>

					<Main id="home" >
						<Switch>
							<Route path="/" exact component={Home} />
							<Route path="/empleados" exact component={Empleados}/>
							<Route path="/proyectos" exact component={Proyectos}/>
							<Route path="/cargos" exact component={Cargos}/>
							<Route path="/areas" exact component={Areas}/>
							<Route path="/clientes" exact component={Clientes}/>
							<Route path="/rubros" exact component={Rubros}/>
							<Route path="/metodologias" exact component={Metodologias}/>
							<Route path="/perfiles" exact component={Perfiles}/>
							<Route path="/tecnologias" exact component={Tecnologias}/>
							<Route path="/tiposDeProyecto" exact component={TiposDeProyecto}/>
							<Route path="/usuarios" exact component={Usuarios}/>
							<Route path="/login" exact component={Login}/>
						</Switch>
					</Main>
					 
				    <Footer/>
				</React.Fragment>
			</Router>
		)
	}
}

export default App