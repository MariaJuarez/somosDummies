import React from "react"
import Header from "./Header"
import Footer from "./Footer"
import Main from "./Main"

import Tablas from "../componentes/Tablas"
import axios from 'axios'

		
import {BrowserRouter as Router,Switch,Route} from "react-router-dom"

import Home from "../paginas/Home"
import Empleados from "../paginas/Empleados"
import Proyectos from "../paginas/Proyectos"
import Login from "../paginas/Login"


class App extends React.Component{
	constructor(props){
		super(props)
		this.sumar=this.sumar.bind(this)
		this.restar=this.restar.bind(this)
		this.handleData = this.handleData.bind(this)    	
		this.state={
			titulo:"Somos",
			links:[
				{texto:"Empleados", url: "empleados"},
				{texto:"Proyectos", url: "proyectos"},
				{texto:"Login", url: "login"}
				
				
				
			],
			contador:0,
			username: '',
			fromChild: ''
		}	
	}

	handleData(data) {
	    this.setState({
	      contador:parseInt(data) 
	    });
	}

	sumar(){
		this.setState({
			contador:this.state.contador+1
		})
	}

	restar(){
		if (this.state.contador>0) {
			this.setState({
				contador:this.state.contador-1
			})
		}
		
	}

	handleClick () {
    	axios.get('https://api.github.com/users/maecapozzi')
      	.then(response => this.setState({username: response.data.id}))
  	}

	render(){
		let {titulo,links,contador,username,publish}=this.state
		return(
			<Router>
				<React.Fragment>
					<Header titulo={titulo} links={links}>
					</Header>

					<Main id="home" >
						<Switch>
							<Route path="/" exact component={Home} />
							<Route path="/empleados" exact component={Empleados}/>
							<Route path="/proyectos" exact component={Proyectos}/>
							<Route path="/login" exact component={Login}/>
							
						</Switch>
					</Main>
					
						{/*<Contador contador={contador} handlerFromParant={this.handleData} sumar={this.sumar} restar={this.restar} editar={this.editar} />*/}
					
					
					{/*<Child handlerFromParant={this.handleData} /> */}
					
					
					
					{/*<PersonList/>*/}
					 

 
					
					 
				    <Footer/>
				</React.Fragment>
			</Router>
		)
	}
}

export default App