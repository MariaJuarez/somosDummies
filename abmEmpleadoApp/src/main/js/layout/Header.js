import React from "react"
import {NavLink} from "react-router-dom"
import {  Navbar,NavItem,MenuItem ,NavDropdown ,NavbarHeader,Nav ,ResponsiveEmbed, Image} from 'react-bootstrap';
import ReactRouterBootstrap, { LinkContainer } from 'react-router-bootstrap';
import logo from '../imagenes/logoTecno.png';
import '../estilos/style.css';


class Header extends React.Component{
	render(){
		let {titulo,links}=this.props
		return(
			<header>
				<Navbar  fixedTop inverse collapseOnSelect >
				  <Navbar.Header>
				    <Navbar.Brand componentClass='span'>
				    
				    <NavLink activeClassName="coloractivo" className="letra" activeStyle={{ color: 'red' }} exact key="titulo2" to="/">
				    		{titulo}
					</NavLink>
				    
				   
				    </Navbar.Brand>
				    <Navbar.Toggle/>
				    
				  </Navbar.Header>

				  <Navbar.Collapse>
					  <Nav>
					  	
					 	{
			           	links.map((link,i)=>
			           	<LinkContainer  to={link.url}  key={i}>
						  <NavItem  key={i}>{link.texto}</NavItem>	
						</LinkContainer>
							
				        )}
				    	</Nav>
				    	 <div className="logoHeader">
					      <img className="pull-right imagenTecno" src={logo} alt="logo"  />
					      
					    </div>
				  </Navbar.Collapse>

				</Navbar>
				
			</header>
		)
	}
}

export default Header