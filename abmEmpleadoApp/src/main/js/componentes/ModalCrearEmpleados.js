import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import FormularioEmpleado from "../componentes/FormularioEmpleado";
import axios from 'axios'

class Home extends React.Component{
    constructor(props, context) {
        super(props, context);

        this.handleHide = this.handleHide.bind(this);
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.state = {
            show: false,
            empleado:{
                "legajo" : 3,
                "nombres": "unico Wilber",
                "apellidos": "Martinez Rojas",
                "cuil":"20-879765-2",
                "responsable" : "Juan Carlos",
                "fechaIngreso" : null,
                "fechaEgreso" : null,
                "domicilioLaboral" : "HIT",
                "observaciones" : "Viejo",
                "promovidoLps" : false,
                "email": "rrojas@tecno.com",
                "telefono":"1125746993",
                "perfil": {
                    "id": 2
                },
                "area": {
                    "id" : 1
                },
                "senority":3,
                "tecnologias":[
                    {
                        "id" : 1
                    }
                ]
            }



        };

    }
    onChange (e){
        this.setState({ [e.target.empleado]: e.target.value });
    }

    onSubmit(e){
        console.log("ssss")
        e.preventDefault();
        const {empleado} = this.state;

        axios.post('http://localhost:8080/empleado/crear', this.state.empleado)
            .then((result) => {
                console.log(result)
            })
            .catch(error => {
                console.log(error)
            });

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
                            <FormularioEmpleado empleado={this.state.empleado} onChange={this.onChange} onSubmit={this.onSubmit}/>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button onClick={this.handleHide}>Cerrar</Button>
                            <Button onClick={this.onSubmit} type="submit" bsStyle="primary">Crear</Button>
                        </Modal.Footer>
                    </Modal>
                </div>

            </div>
        )
    }
}

export default Home