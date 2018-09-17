import React from 'react'
import {Field, FieldArray, reduxForm } from 'redux-form'
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import '../../estilos/react-datetime.css';
import DateTime from 'react-datetime';

import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';
import SelecTecno from '../SelectTecnologias'

const FormularioProyecto = props => {
  const { handleSubmit, values, pristine, reset, submitting, funcionTecnologia, tiposDeProyecto, clientes, metodologias} = props
  return (
    <Form inline onSubmit={handleSubmit}>
      
      <FormGroup>
        <ControlLabel>Promovido LPS</ControlLabel>
        <div>
          <Field
            name="proyecto.promovido"
            id="promovidoLPS"
            component="input"
            type="checkbox"
          />
        </div>
      </FormGroup>
      <FormGroup>
        <ControlLabel>Externo</ControlLabel>
        <div>
          <Field
            name="proyecto.externo"
            id="externo"
            component="input"
            type="checkbox"
          />
        </div>
      </FormGroup>
      <FormGroup>
        <ControlLabel>Jira</ControlLabel>
        <Field
            name="proyecto.jira"
            className='form-control'
            component="input"
            type="text"
            placeholder="Ingrese el codigo de jira"
          />
      </FormGroup>
      <FormGroup>
        <ControlLabel>Crm</ControlLabel>
        <Field
            name="proyecto.crm"
            className='form-control'
            component="input"
            type="number"
            placeholder="ingrese el crm"
          />
      </FormGroup>
       <FormGroup className="enLinea">
        <ControlLabel>Nombre</ControlLabel>
        <Field
            name="proyecto.nombre"
            className='form-control'
            component="input"
            type="text"
            placeholder="ingrese el nombre"
          />
      </FormGroup>
      <FormGroup className="enLinea">
        <ControlLabel>Area Solicitante</ControlLabel>
        <Field
            name="proyecto.solicitante"
            className='form-control'
            component="input"
            type="text"
            placeholder="area solicitante"
          />
      </FormGroup>
       <FormGroup className="enLinea">
        <ControlLabel>Descripcion</ControlLabel>
        <Field
            name="proyecto.descripcion"
            className='form-control'
            component="textarea"
            type="text"
            
          />
      </FormGroup>
      <FormGroup>
        <ControlLabel>Lider</ControlLabel>
        <Field
            name="proyecto.lider"
            className='form-control'
            component="input"
            type="text"
            placeholder="ingrese el nombre del lider"
          />
      </FormGroup>
      
      <FormGroup>
        <ControlLabel>Cliente</ControlLabel>
          <Field name="proyecto.cliente.id" component="select" className='form-control'>
            <option />
            {
              clientes.map(
                (cliente,i)=>
                <option  key={i} value={cliente.id}>{cliente.descripcion}</option>  
              )
            }
          </Field>
      </FormGroup>

      <FormGroup>
        <ControlLabel>Tipos de Proyecto</ControlLabel>
          <Field name="proyecto.tipo.id" component="select" className='form-control'>
            <option />
            {
              tiposDeProyecto.map(
                (tipo,i)=>
                <option  key={i} value={tipo.id}>{tipo.descripcion}</option>  
              )
            }
          </Field>
      </FormGroup>

      <FormGroup>
        <ControlLabel>Metodologia</ControlLabel>
          <Field name="proyecto.metodologia.id" component="select" className='form-control'>
            <option />
            {
              metodologias.map(
                (metodologia,i)=>
                <option  key={i} value={metodologia.id}>{metodologia.descripcion}</option>  
              )
            }
          </Field>
      </FormGroup>
      
      <FormGroup className="enLinea">
        <ControlLabel>Tecnologias</ControlLabel>
        
          <Field name="proyecto.tecnologias"  value="proyecto.tecnologia" component={SelecTecno} 
          className='form-control' funcionTecnologia={funcionTecnologia}>
          </Field>
      </FormGroup>
      
      <FormGroup className="enLinea">
	        <ControlLabel>Objetivo</ControlLabel>
	        <Field
	            name="proyecto.objetivo"
	            className='form-control'
	            component="textarea"
	            type="text"
	        />
      </FormGroup>
      
      <FormGroup className="enLinea">
	        <ControlLabel>equipo</ControlLabel>
	        <Field
	            name="proyecto.equipo"
	            className='form-control'
	            component="textarea"
	            type="text"
	            placeholder="integrantes del equipo"
	        />
      </FormGroup>
      
      <FormGroup controlId="inicio" className ="inputCalendar" disabled>
        <ControlLabel>Fecha Ingreso</ControlLabel>
          <Field name='proyecto.inicio' 
          component={props => 
            <DateTime  
            value={props.input.value} 
            closeOnSelect={true}
            dateFormat='DD-MM-YYYY'
            timeFormat={false}
            onChange={param => props.input.onChange(param)} 
            required />} 
            />
      </FormGroup>
      
      <FormGroup controlId="fin" className ="inputCalendar" disabled>
        <ControlLabel>Fecha Ingreso</ControlLabel>
          <Field name='proyecto.fin' 
          component={props => 
            <DateTime  
            value={props.input.value} 
            closeOnSelect={true}
            dateFormat='DD-MM-YYYY'
            timeFormat={false}
            onChange={param => props.input.onChange(param)} 
            required />} 
            />
      </FormGroup>
      <FormGroup className="enLinea">
	        <ControlLabel>Usuarios</ControlLabel>
	        <Field
	            name="proyecto.usuarios"
	            className='form-control'
	            component="textarea"
	            type="text"
	        />
      </FormGroup>
      
      <FormGroup className="enLinea">
	        <ControlLabel>Roles o Areas Involucras</ControlLabel>
	        <Field
	            name="proyecto.roles"
	            className='form-control'
	            component="textarea"
	            type="text"
	        />
      </FormGroup>
      <FormGroup className="enLinea">
	        <ControlLabel>Requerimiento Funcional</ControlLabel>
	        <Field
	            name="proyecto.requerimiento"
	            className='form-control'
	            component="textarea"
	            type="text"
	        />
      </FormGroup>
      <FormGroup className="enLinea">
	        <ControlLabel>Observaciones</ControlLabel>
	        <Field
	            name="proyecto.observaciones"
	            className='form-control'
	            component="textarea"
	            type="text"
	        />
      </FormGroup>
      
      
      <div className="botonesModal">
        <button type="submit" disabled={pristine || submitting} className="btn btn-primary submit">
          Submit
        </button>
        <button type="button" disabled={pristine || submitting} onClick={reset} className="btn btn-primary reset">
          Clear Values
        </button>
      </div>
    </Form>
  )
}

export default reduxForm({
  form: 'formProyecto' // a unique identifier for this form
})(FormularioProyecto)
