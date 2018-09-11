import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import FormularioEmpleado from "../componentes/FormularioEmpleado";
import 'moment/locale/es';


import DateTime from 'react-datetime';
import '../estilos/react-datetime.css';
import axios from 'axios'

class Home extends React.Component{
    constructor(props, context) {
        super(props, context);

        this.handleHide = this.handleHide.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.state = {
            show: false,

        empleado:{
                    legajo: 3,
                    nombres: "unico Wilber",
                    apellidos: "Martinez Rojas",
                    cuil:"20-879765-2",
                    responsable : "Juan Carlos",
                    fechaIngreso : null,
                    fechaEgreso : null,
                    domicilioLaboral : "HIT",
                    observaciones : "Viejo",
                    promovidoLps : false,
                    email: "rrojas@tecno.com",
                    telefono:"1125746993",
                    perfil: {
                        id: 2
                    },
                    area: {
                        id : 1
                    },
                    senority:3,
                    tecnologias:[
                        {
                            id : 1
                        }
                    ]
                }



        };

    }

    handleInputChange(event) {
        console.log('handleInputChange antes');
        console.log(this.state.empleado);

        this.setState({[event.empleado.nombres]: event.target.defaultValue});


        console.log('handleInputChange despues');
        console.log(this.state.empleado);
    }

    onSubmit(e){
        e.preventDefault();
        const nuevoEmpleado = this.state.empleado;

        axios.post('http://localhost:8080/empleado/crear', nuevoEmpleado)
            .then((result) => {
                console.log("console onsubmit");
                console.log(nuevoEmpleado);
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
        let {onSubmit,empleado}= this.state;
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
                            <Form inline onSubmit={onSubmit}>
                                <FormGroup controlId="promovidoLPS">
                                    <ControlLabel>Promovido LPS</ControlLabel>
                                    <Checkbox inline defaultValue={empleado.promovidoLps} onChange={this.handleInputChange}></Checkbox>
                                </FormGroup>

                                <FormGroup controlId="legajo">
                                    <ControlLabel>Legajo</ControlLabel>{' '}
                                    <FormControl type="number" placeholder="Numero de legajo" defaultValue={empleado.legajo} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}

                                <FormGroup controlId="cuil">
                                    <ControlLabel>Cuil</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="Numero de cuil" defaultValue={empleado.cuil} onChange={this.handleInputChange} />
                                </FormGroup>{' '}

                                <FormGroup controlId="formControlPromovidoLPS">
                                    <ControlLabel>Senioriti</ControlLabel>
                                    <FormControl componentClass="select" placeholder="select" defaultValue={empleado.senority} onChange={this.handleInputChange}>
                                        <option value="select">seleccionar</option>
                                        <option value="other">...</option>
                                    </FormControl>
                                </FormGroup>
                                <hr/>

                                <FormGroup controlId="nombres" className="enLinea">
                                    <ControlLabel>Nombres</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="nombres" defaultValue={empleado.nombres} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}

                                <FormGroup controlId="apellidos" className="enLinea">
                                    <ControlLabel>Apellidos</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="apellidos" defaultValue={empleado.apellidos} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}

                                <FormGroup controlId="email" className="enLinea">
                                    <ControlLabel>Email</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="mail@ejemplo.com" defaultValue={empleado.email} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}
                                <hr/>
                                <FormGroup controlId="fechaIngreso" className ="inputCalendar" disabled>
                                    <ControlLabel>Fecha Ingreso</ControlLabel>{' '}
                                    <DateTime closeOnSelect={true}
                                              dateFormat='DD-MM-YYYY'
                                              timeFormat={false} onChange={this.handleInputChange}
                                    />
                                </FormGroup>{' '}

                                <FormGroup controlId="fechaEgreso" className ="inputCalendar" disabled>
                                    <ControlLabel>Fecha Ingreso</ControlLabel>{' '}
                                    <DateTime closeOnSelect={true}
                                              dateFormat='DD-MM-YYYY'
                                              timeFormat={false}  onChange={this.handleInputChange}
                                    />
                                </FormGroup>{' '}
                                <hr/>
                                <FormGroup controlId="telefono">
                                    <ControlLabel>Telefono</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="ej 1122232425" defaultValue={empleado.telefono} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}

                                <FormGroup controlId="centroDeCosto">
                                    <ControlLabel>Área</ControlLabel>
                                    <FormControl componentClass="select" placeholder="select" defaultValue={empleado.area} onChange={this.handleInputChange}>
                                        <option value="select">seleccionar</option>
                                        <option value="other">...</option>
                                    </FormControl>
                                </FormGroup>

                                <FormGroup controlId="perfil">
                                    <ControlLabel>Perfil</ControlLabel>
                                    <FormControl componentClass="select" placeholder="select" defaultValue={empleado.perfil} onChange={this.handleInputChange}>
                                        <option value="select">seleccionar</option>
                                        <option value="other">...</option>
                                    </FormControl>
                                </FormGroup>
                                <hr/>
                                <FormGroup controlId="domicilioLaboral" className="enLinea">
                                    <ControlLabel>Domicilio Laboral</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="lugar de trabajo" defaultValue={empleado.domicilioLaboral} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}

                                <FormGroup controlId="observaciones" className="enLinea">
                                    <ControlLabel>Observaciones</ControlLabel>
                                    <FormControl componentClass="textarea" placeholder="describa una breve observacion" defaultValue={empleado.observaciones} onChange={this.handleInputChange}/>
                                </FormGroup>

                                <FormGroup controlId="responsable" className="enLinea">
                                    <ControlLabel>Responsable</ControlLabel>{' '}
                                    <FormControl type="text" placeholder="nombre de responsable" defaultValue={empleado.responsable} onChange={this.handleInputChange}/>
                                </FormGroup>{' '}
                                <input type="submit" value="Submit" />
                            </Form>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button onClick={this.handleHide}>Cerrar</Button>
                            <Button type="submit" bsStyle="primary">Crear</Button>
                        </Modal.Footer>
                    </Modal>
                </div>

            </div>
        )
    }
}

export default Home