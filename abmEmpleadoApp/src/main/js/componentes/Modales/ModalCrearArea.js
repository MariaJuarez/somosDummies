import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import FormularioArea from "../../componentes/formularios/FormularioArea";
import { Field, reduxForm } from 'redux-form'
import {Values} from 'redux-form-website-template'
import axios from 'axios'


class ModalArea extends React.Component{
    
    constructor(props, context) {
        super(props, context);
        this.handleHide = this.handleHide.bind(this);
        this.handleShow = this.handleShow.bind(this);
        this.showResults = this.showResults.bind(this);
        
        this.state = {
            show: false
        };

    }

    showResults (values){
            new Promise(resolve => {

            if (this.props.objeto==null) {
                axios.post('http://localhost:8080/area/crear', values.area)
                .then((result) => {
                    this.props.renewlist();
                    this.handleHide();
                    
                })
                .catch(error => {
                    console.log(error)
                });
            }
            else{
                
                axios.put('http://localhost:8080/area/editar',this.props.objeto)
                .then((result) => {
                    this.props.renewlist();
                    this.props.editarRealmenteArea(null);
                    this.handleHide();

                    
                })
                .catch(error => {
                    console.log(error)
                }); 
            }
        
        
      })
    }

    
    handleHide() {
        this.setState({ show: false });

    }
    handleShow() {
        this.setState({ show: true });

    }

    render(){

        const popover = (
            <Popover id="modal-popover" title="popover">
                very popover. such engagement
            </Popover>
        )

        const tooltip = <Tooltip id="modal-tooltip">wow.</Tooltip>
        
        const { handleSubmit, values, pristine, reset, submitting, objeto, editInputArea, editarRealmenteArea } = this.props
        

        return(
            <div className='container'>

                <div className="modal-container" >
                    <div className="buttonMarginBottom">
                        <Button
                            
                            bsClass="btn colornuevo"
                            bsSize="sm"
                            onClick={this.handleShow}
                            
                        >
                            Nuevo
                        </Button>
                    </div>

                    <Modal
                        show={this.state.show}
                        onHide={this.handleHide}
                        container={this}
                        aria-labelledby="contained-modal-title"
                        backdrop="static"
                    >
                        <Modal.Header>
                            <Modal.Title id="contained-modal-title">
                                {this.props.objeto==null?
                                "Crear area" :
                                "Editar area"
                                }
                            </Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <FormularioArea onSubmit={this.showResults} objeto={objeto}
                                editInputArea={editInputArea} handleHide={this.handleHide}
                                editarRealmenteArea={editarRealmenteArea}/>
                        </Modal.Body>

                    </Modal>
                </div>

            </div>
        )
    }
}

export default ModalArea