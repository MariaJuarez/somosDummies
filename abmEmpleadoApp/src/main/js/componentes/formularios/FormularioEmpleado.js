import React from 'react'
import {Field, FieldArray, reduxForm } from 'redux-form'
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';

import DateTime from 'react-datetime';
import '../../estilos/react-datetime.css';
import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';
import SelecTecno from '../SelectTecnologias'

const FormularioEmpleado = props => {
  const { handleSubmit, values, pristine, reset, submitting, funcionTecnologia, areas, perfiles} = props
  return (
    <Form inline onSubmit={handleSubmit}>
      
      <FormGroup>
        <ControlLabel>Promovido LPS</ControlLabel>
        <div>
          <Field
            name="empleado.promovido"
            id="promovidoLPS"
            component="input"
            type="checkbox"
          />
        </div>
      </FormGroup>
      <FormGroup>
        <ControlLabel>Legajo</ControlLabel>
        <Field
            name="empleado.legajo"
            className='form-control'
            component="input"
            type="number"
            placeholder="Ingrese el numero de Legajo"
          />
      </FormGroup>
      <FormGroup>
        <ControlLabel>Cuil</ControlLabel>
        <Field
            name="empleado.cuil"
            className='form-control'
            component="input"
            type="text"
            placeholder="ej 20-99999999-0"
          />
      </FormGroup>
      <FormGroup>
        <ControlLabel>Senority</ControlLabel>
        <Field name="empleado.senority" component="select" className='form-control'>
            <option />
            <option value="TRAINEE">TRAINEE</option>
            <option value="JUNIOR">JUNIOR</option>
            <option value="SEMISENIOR">SEMISENIOR</option>
            <option value="SENIOR">SENIOR</option>
          </Field>
      </FormGroup>
      <FormGroup className="enLinea">
        <ControlLabel>Nombres</ControlLabel>
        <Field
            name="empleado.nombres"
            className='form-control'
            component="input"
            type="text"
            placeholder="ingrese los nombres del empleado"
          />
      </FormGroup>
      <FormGroup className="enLinea">
        <ControlLabel>Apellidos</ControlLabel>
        <Field
            name="empleado.apellidos"
            className='form-control'
            component="input"
            type="text"
            placeholder="ingrese los apellidos del empleado"
          />
      </FormGroup>
      <FormGroup className="enLinea">
        <ControlLabel>Email</ControlLabel>
        <Field
            name="empleado.email"
            className='form-control'
            component="input"
            type="email"
            placeholder="email@ejemplo.com"
          />
      </FormGroup>

      <FormGroup controlId="fechaIngreso" className ="inputCalendar" disabled>
      <ControlLabel>Fecha Ingreso</ControlLabel>
        <Field name='empleado.ingreso' 
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

      <FormGroup controlId="fechaEgreso" className ="inputCalendar" disabled>
      <ControlLabel>Fecha Egreso</ControlLabel>
        <Field name='empleado.egreso' 
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
        <ControlLabel>Telefono</ControlLabel>
        <Field
            name="empleado.telefono"
            className='form-control'
            component="input"
            type="text"
            placeholder="ej. 1199999999"
          />
      </FormGroup>
      
      <FormGroup>
        <ControlLabel>Area</ControlLabel>
          <Field name="empleado.area.id" component="select" className='form-control'>
            <option />
            {
              areas.map(
                (area,i)=>
                <option  key={i} value={area.id}>{area.descripcion}</option>  
              )
            }
          </Field>
      </FormGroup>
      
      <FormGroup>
        <ControlLabel>Perfil</ControlLabel>
          <Field name="empleado.perfil.id" component="select" className='form-control'>
            <option />
            {
              perfiles.map(
                (perfil,i)=>
                <option  key={i} value={perfil.id}>{perfil.descripcion}</option>  
              )
            }
          </Field>
      </FormGroup>
      
      <FormGroup className="enLinea">
          <ControlLabel>Tecnologias</ControlLabel>
          <Field name="empleado.tecnologias"  value="empleado.tecnologia" component={SelecTecno} className='form-control' funcionTecnologia={funcionTecnologia}>
          </Field>
      </FormGroup>
      
      <FormGroup className="enLinea">
        <ControlLabel>Domicilio Laboral</ControlLabel>
        <Field
            name="empleado.domicilio"
            className='form-control'
            component="input"
            type="text"
            placeholder="ej. 1199999999"
          />
      </FormGroup>
      
      <FormGroup className="enLinea">
        <ControlLabel>Observaciones</ControlLabel>
        <Field
            name="empleado.observaciones"
            className='form-control'
            component="textarea"
            type="text"
            
          />
      </FormGroup>
      
      <FormGroup className="enLinea">
        <ControlLabel>Responsable</ControlLabel>
        <Field
            name="empleado.responsable"
            className='form-control'
            component="input"
            type="text"
            placeholder="nombre del responsable"
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
  form: 'formEmpleado' // a unique identifier for this form
})(FormularioEmpleado)