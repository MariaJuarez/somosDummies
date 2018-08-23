import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
	ControlLabel,FormControl, HelpBlock,Form,Col} from 'react-bootstrap';
import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';
import DateTime from 'react-datetime';
import '../estilos/react-datetime.css';
import '../estilos/style.css';

class FormularioProyecto extends React.Component{
	render(){
		return(
			
			
			<Form inline>
	           	<FormGroup className="promovidoLPS">
	           		<ControlLabel>Promovido LPS</ControlLabel>
			      	<Checkbox inline></Checkbox>
			    </FormGroup>

			    <FormGroup>
	           		<ControlLabel>Externo</ControlLabel>
			      	<Checkbox inline></Checkbox>
			    </FormGroup>
			  
				<hr/>  
				
				<FormGroup controlId="Jira">
					<ControlLabel>Jira</ControlLabel>{' '}
				    <FormControl type="text" placeholder="nombre en jira" />
				</FormGroup>{' '}
				  
				<FormGroup controlId="crm">
					<ControlLabel>CRM</ControlLabel>{' '}
				    <FormControl type="number" placeholder="código CRM" />
				</FormGroup>{' '}

				<FormGroup controlId="nombreProyecto" className="enLinea">
					<ControlLabel>Nombre De Proyecto</ControlLabel>{' '}
				   	<FormControl type="text" placeholder="mail@ejemplo.com" />
				</FormGroup>{' '}

				<FormGroup controlId="lider" className="enLinea">
					<ControlLabel>Lider</ControlLabel>{' '}
				   	<FormControl type="text" placeholder="mail@ejemplo.com" />
				</FormGroup>{' '}

				<hr/>
				<FormGroup controlId="fechaInicio" className ="inputCalendar" disabled>
				  	<ControlLabel>Fecha Inicio</ControlLabel>{' '}
				  		<DateTime closeOnSelect={true}
	                      dateFormat='DD-MM-YYYY'
	                      timeFormat={false}
	                    />
				</FormGroup>{' '}
				  	
			  	<FormGroup controlId="fechaFin" className ="inputCalendar" disabled>
			  		<ControlLabel>Fecha Fin</ControlLabel>{' '}
			  		<DateTime closeOnSelect={true}
                      dateFormat='DD-MM-YYYY'
                      timeFormat={false}
                    />
			  	</FormGroup>{' '}
				<hr/>
			    <FormGroup controlId="TipoProyecto">
			      <ControlLabel>Tipo de Proyecto</ControlLabel>
			      <FormControl componentClass="select" placeholder="select">
			        <option value="select">seleccionar</option>
			        <option value="other">...</option>
			      </FormControl>
			    </FormGroup>  
				
				<FormGroup controlId="cliente">
			      <ControlLabel>Cliente</ControlLabel>
			      <FormControl componentClass="select" placeholder="select">
			        <option value="select">seleccionar</option>
			        <option value="other">...</option>
			      </FormControl>
			    </FormGroup>

			    <FormGroup controlId="metodologia">
			      <ControlLabel>Metodologia</ControlLabel>
			      <FormControl componentClass="select" placeholder="select">
			        <option value="select">seleccionar</option>
			        <option value="other">...</option>
			      </FormControl>
			    </FormGroup>

				<hr/>
				<FormGroup controlId="areaSolicitante" className="enLinea">
			    	<ControlLabel>Área solicitante</ControlLabel>{' '}
				    <FormControl type="text" placeholder="área de destino del proyecto" />
				</FormGroup>{' '}
				  
				<FormGroup controlId="equipotDeTrabajo" className="enLinea">
			      	<ControlLabel>Equipo de Trabajo</ControlLabel>
			      	<FormControl componentClass="textarea" placeholder="breve descripcion de los empleados requeridos para el proyecto" />
			    </FormGroup>
				
				<FormGroup controlId="objetivo" className="enLinea">
			      	<ControlLabel>Objetivo</ControlLabel>
			      	<FormControl componentClass="textarea" placeholder=" descripcion de proyecto" />
			    </FormGroup>

			    <FormGroup controlId="requerimientoFuncional" className="enLinea">
			      	<ControlLabel>Requerimiento Funcional</ControlLabel>
			      	<FormControl componentClass="textarea" placeholder="describa el requerimiento funcional" />
			    </FormGroup>

			    <FormGroup controlId="usuarios" className="enLinea">
			      	<ControlLabel>Usuarios</ControlLabel>
			      	<FormControl componentClass="textarea" placeholder="describa los usuarios del proyecto"/>
			    </FormGroup>

			    <FormGroup controlId="areasInvolucradas" className="enLinea">
			      	<ControlLabel>Roles o Áreas Involucradas</ControlLabel>
			      	<FormControl componentClass="textarea" placeholder="una breve descripcion de roles" />
			    </FormGroup>

			    <FormGroup controlId="observaciones" className="enLinea">
			      	<ControlLabel>Observaciones</ControlLabel>
			      	<FormControl componentClass="textarea" placeholder="describa una breve observacion" />
			    </FormGroup>
				
			</Form>			
		)	
	}
}

export default FormularioProyecto