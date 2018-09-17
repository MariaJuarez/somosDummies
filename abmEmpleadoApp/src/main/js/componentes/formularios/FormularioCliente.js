import React from 'react'
import {Field, FieldArray, reduxForm } from 'redux-form'
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import axios from 'axios';
import DateTime from 'react-datetime';
import '../../estilos/react-datetime.css';
import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';
import SelectSimple from '../SelectSimple2'


class FormularioCliente extends React.Component{

  constructor(props) {
        super(props);
        this.cerrarModal = this.cerrarModal.bind(this);
        this.state={
          objetoSeleccionado:null
        }
  }



  /*componentDidMount(){
        let lista=[]
        axios.get('http://localhost:8080/rubro/listarTodos')
        .then(response =>{

            
                response.data.map( rubro => {
                var rub={value:rubro.id,label:rubro.descripcion,id:rubro.id}
                lista.push(rub)
                return lista
               })
            console.log("opciones "+ this.state.opciones)
            this.setState({
                opciones: lista
            })
        });

    }*/
  cerrarModal(){
    
    this.props.editarRealmenteCliente(null);
    this.props.handleHide();  
    
  }
  render(){
    const { handleSubmit, values, pristine, reset, submitting, objeto,
      editNombre, editDescripcion, editGrupo, editRubro ,handleHide, opciones} = this.props
  

  return (
    <Form inline onSubmit={handleSubmit}>
      
    
      <FormGroup className="enLinea">
        <ControlLabel >Nombre</ControlLabel>

        {
          objeto==null ? 
            <Field
              name="cliente.nombre"
              className='form-control'
              component="input"
              type="text"
              placeholder="ingrese el nombre del cliente"
              /> 
          : 
            <Field
              name="cliente.nombre"
              className='form-control'
              component="input"
              onChange={editNombre}
              type="text"
              model="jefe"
              props={{value : objeto.nombre}}
            />
        
        }
      </FormGroup>
       <FormGroup className="enLinea">
        <ControlLabel >Descripcion</ControlLabel>

        {
          objeto==null ? 
            <Field
              name="cliente.descripcion"
              className='form-control'
              component="input"
              type="text"
              placeholder="ingrese la descripcion del cliente"
              /> 
          : 
            <Field
              name="cliente.descripcion"
              className='form-control'
              component="input"
              onChange={editDescripcion}
              type="text"
              props={{value : objeto.descripcion}}
            />
        
        }
      </FormGroup>
       <FormGroup className="enLinea">
        <ControlLabel >Grupo</ControlLabel>

        {
          objeto==null ? 
            <Field
              name="cliente.grupo"
              className='form-control'
              component="select"
              placeholder="ingrese la descripcion del cliente"
            > 
            <option value="NORMAL">Normal</option>
            <option value="TERNIUM">Ternium</option>
            <option value="TENARIS">Tenaris</option>
            </Field>
          : 
            <Field
              name="cliente.grupo"
              className='form-control'
              component="select"
              onChange={this.props.editGrupo}
              model="jefe"
              props={{value : objeto.grupo}}
            >
             <option></option>
            <option value="NORMAL">Normal</option>
            <option value="TERNIUM">Ternium</option>
            <option value="TENARIS">Tenaris</option>
            </Field>
        }
      </FormGroup>
      
      {/*<FormGroup className="enLinea">
        <ControlLabel >Rubro</ControlLabel>
        <SelectSimple funcionRubro = {this.props.funcionRubro} objeto={objeto}
         editRubro={this.props.editRubro}/ >
      </FormGroup>*/}

      <FormGroup className="enLinea">
          <ControlLabel>Rubro</ControlLabel>
           
          <Field name="cliente.rubro"  value="cliente.rubro" component={SelectSimple} 
          className='form-control' editRubro={this.props.editRubro}
          objeto={this.props.objeto}
          funcionRubro={this.props.funcionRubro}>
          </Field>
          
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
  form: 'formCliente' // a unique identifier for this form
})(FormularioCliente)