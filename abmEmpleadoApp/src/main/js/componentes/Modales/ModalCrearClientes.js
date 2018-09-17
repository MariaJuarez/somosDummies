import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import FormularioCliente from "../../componentes/formularios/FormularioCliente";
import { Field, reduxForm } from 'redux-form'
import {Values} from 'redux-form-website-template'
import axios from 'axios'


class ModalCliente extends React.Component{
    
    constructor(props, context) {
        super(props, context);
        this.handleHide = this.handleHide.bind(this);
        this.handleShow = this.handleShow.bind(this);
        this.showResults = this.showResults.bind(this);
        this.funcionRubro = this.funcionRubro.bind(this);
        this.state = {
            show: false,
            opciones:[]
        };

    }
    componentDidMount(){
        let lista=[]
        axios.get('http://localhost:8080/rubro/listarTodos')
        .then(response =>{

            
                response.data.map( rubro => {
                var rub={value:rubro.id,label:rubro.descripcion,id:rubro.id}
                lista.push(rub)
                return lista
               })
            
            this.setState({
                opciones: lista
            })
        });
    }
     funcionRubro(param) {
        this.setState({ rubro: param });
    }

    showResults (values){
            new Promise(resolve => {
            values.cliente.rubro = this.state.rubro
            if (this.props.objeto==null) {
                axios.post('http://localhost:8080/cliente/crear', values.cliente)
                .then((result) => {
                    this.props.renewlist();
                    this.handleHide();
                    
                })
                .catch(error => {
                    console.log(error)
                });
            }
            else{
                values.cliente.id = this.props.objeto.id;
                axios.put('http://localhost:8080/cliente/editar',this.props.objeto)
                .then((result) => {
                    this.props.renewlist();
                    this.props.editarRealmenteCliente(null);
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
        
        const { handleSubmit, values, pristine, reset, submitting, 
            objeto, editarRealmenteCliente } = this.props
        

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
                                "Crear Cliente" :
                                "Editar Cliente"
                                }
                            </Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <FormularioCliente onSubmit={this.showResults} objeto={objeto}
                                editNombre={this.props.editNombre} editDescripcion={this.props.editDescripcion} 
                                editGrupo={this.props.editGrupo}
                                editRubro={this.props.editRubro}  handleHide={this.handleHide}
                                editarRealmenteCliente={editarRealmenteCliente}
                                funcionRubro={this.funcionRubro}
                                opciones={this.state.opciones}
                                />
                        </Modal.Body>

                    </Modal>
                </div>

            </div>
        )
    }
}

export default ModalCliente