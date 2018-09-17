import React from 'react'
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';

import { Field, reduxForm } from 'redux-form'
import {cloneDeep} from 'lodash'; 
import axios from 'axios'

class Example extends React.Component {
  constructor(props, context) {
    super(props, context);

    this.handleShow = this.handleShow.bind(this);
    this.handleClose = this.handleClose.bind(this);
    this.showResults = this.showResults.bind(this);
    this.state = {
      show: false
    };
  }

  showResults (values){
    new Promise(resolve => {
      
        const objeto = cloneDeep(this.props.objeto);

        objeto.baja==1?objeto.baja=0:objeto.baja=1;
        
       
        axios.put('http://localhost:8080/'+this.props.nombreTabla+'/editar', objeto)
        .then((result) => {
            this.props.renewlist();
            this.props.editarRealmente(null);
            this.handleClose();


            
        })
        .catch(error => {
            console.log(error)
        }); 
    })
  }


  

  handleClose() {
    this.setState({ show: false });
    this.props.editarRealmente(null);
  }

  handleShow() {
    this.setState({ show: true });
  }


  render() {

    
    const { handleSubmit, values, pristine, reset, submitting} = this.props
    

    const popover = (
        <Popover id="modal-popover" title="popover">
          very popover. such engagement
        </Popover>
      );
      const tooltip = <Tooltip id="modal-tooltip">wow.</Tooltip>;
      return(
      <div className="static-modal">
        <Modal show={this.state.show} onHide={this.handleClose} backdrop="static">
          
          <Modal.Header>
            <Modal.Title> 
              {(this.props.objeto!=null)?
                (this.props.objeto.baja==0)?
                "¿Realmente desea eliminar el registro?"
                :
                "¿Realmente desea reactivar el registro?"
                :
                ""
              }
              </Modal.Title>
          </Modal.Header>

          <Modal.Body>
            
            <h4>
            {(this.props.objeto!=null)?
              (this.props.objeto.baja==0)?
              "Sí elimina el registro no podrá volver a seleccionarlo como opción en otros registros"
              :
              "Sí reactiva el podrá volver a seleccionarlo como opción en otros registros"
              :
              ""
            }
            </h4>
          </Modal.Body>

          <Modal.Footer>
            <div className="botonesModal">
              <Button bsClass="btn espacioBoton colorcerrar" onClick={this.handleClose}>
                  Cancelar
                </Button>
              
                <Button
                  type="submit" disabled={pristine || submitting}
                  bsClass= {
                    (this.props.objeto!=null)?
                      (this.props.objeto.baja==1)?
                        "btn colornuevo"
                        :"btn colorborrar"
                        :"btn colorborrar"
                    } 
                  bsSize="sm"
                  onClick={this.showResults}
                >
                  Confirmar                
                </Button>

            </div>
          </Modal.Footer>
        </Modal>
      </div>)
  }
}

export default Example;