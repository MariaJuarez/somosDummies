import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import FormularioEmpleado from "../../componentes/formularios/FormularioEmpleado";
import { Field, reduxForm } from 'redux-form'
import {Values} from 'redux-form-website-template'
import axios from 'axios'

class Home extends React.Component{
    
    constructor(props, context) {
        super(props, context);
        this.handleHide = this.handleHide.bind(this);
        this.showResults = this.showResults.bind(this);
        this.funcionTecnologia = this.funcionTecnologia.bind(this);
        this.state = {
            tecnologias:[],
            areas:[],
            perfiles:[],
            show: false
        };

    }

    componentDidMount() {
        
        axios.get('http://localhost:8080/area/listarTodos')
        .then(response =>{
          const areasAux = response.data
          this.setState({
            areas:areasAux
          });
        })
        axios.get('http://localhost:8080/perfil/listarTodos')
        .then(response =>{
          const perfilesAux = response.data
          this.setState({
            perfiles:perfilesAux
          });
        })
    }
    funcionTecnologia(params) {
        this.setState({ tecnologias: params });
    }
    
    showResults (values){
        new Promise(resolve => {
        values.empleado.tecnologias=this.state.tecnologias
        //obj.empleadoss.ingreso=values.empleado.fechaIngreso._d;
        
        axios.post('http://localhost:8080/empleado/crear', values.empleado)
                .then((result) => {
                    console.log(result)
                })
                .catch(error => {
                    console.log(error)
                });
        
        
        this.handleHide();
      })

    }

    
    handleHide() {
        this.setState({ show: false });
    }

    render(){

        const popover = (
            <Popover id="modal-popover" title="popover">
                very popover. such engagement
            </Popover>
        )

        const tooltip = <Tooltip id="modal-tooltip">wow.</Tooltip>
        
        const { handleSubmit, values, pristine, reset, submitting } = this.props
        const {areas, perfiles} = this.state

        return(
            <div className='container'>

                <div className="modal-container" >
                    <div className="buttonMarginBottom">
                        <Button
                            bsStyle="primary"
                            bsSize="sm"
                            onClick={() => this.setState({ show: true })}
                        >
                            Nuevo
                        </Button>
                    </div>

                    <Modal
                        show={this.state.show}
                        onHide={this.handleHide}
                        container={this}
                        aria-labelledby="contained-modal-title"
                    >
                        <Modal.Header closeButton>
                            <Modal.Title id="contained-modal-title">
                                Crear Empleado
                            </Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <FormularioEmpleado onSubmit={this.showResults} funcionTecnologia={this.funcionTecnologia} areas={areas} perfiles={perfiles}/>
                        </Modal.Body>

                    </Modal>
                </div>

            </div>
        )
    }
}

export default Home