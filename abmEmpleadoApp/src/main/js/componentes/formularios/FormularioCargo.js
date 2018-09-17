import React from 'react'
import {Field, FieldArray, reduxForm } from 'redux-form'
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';

import DateTime from 'react-datetime';
import '../../estilos/react-datetime.css';
import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';



class FormularioCargo extends React.Component{

  constructor(props) {
        super(props);
        this.cerrarModal = this.cerrarModal.bind(this);


    }
  cerrarModal(){
    
    this.props.editarRealmenteCargo(null);
    this.props.handleHide();
    
    
  }
  render(){
    const { handleSubmit, values, pristine, reset, submitting, objeto,
      editInputCargo,handleHide} = this.props
  

  return (
    <Form inline onSubmit={handleSubmit}>
      
    
      <FormGroup className="enLinea">
        <ControlLabel >Nombre del Cargo</ControlLabel>

        {
          objeto==null ? 
            <Field
              name="cargo.descripcion"
              className='form-control'
              component="input"
              type="text"
              placeholder="ingrese la descripcion del cargo"
              /> 
          : 
            <Field
              name="cargo.descripcion"
              className='form-control'
              component="input"
              onChange={editInputCargo}
              type="text"
              model="jefe"
              props={{value:objeto.descripcion}}
            />
        
        }
      </FormGroup>
      <hr/>
      <div className="botonesModal">
        <Button bsClass="btn colorcerrar " onClick={this.cerrarModal} >
        Cerrar
        </Button>
        <Button
          type="submit" disabled={pristine || submitting}
          bsClass={this.props.objeto==null?
                                "btn colornuevo espacioBoton" 
                                :"btn coloreditar espacioBoton"
                  }
          bsSize="sm"
          onClick={this.handleShow}
        >
          {this.props.objeto==null?
            "Crear " :
            "Editar"
          }                  
        </Button>
        
      </div>
     
    </Form>
  )
  }
}

export default reduxForm({
  form: 'formCargo' // a unique identifier for this form
})(FormularioCargo)