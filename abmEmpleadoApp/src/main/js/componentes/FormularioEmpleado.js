import React from "react";
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import 'moment/locale/es';
import MomentLocaleUtils from 'react-day-picker/moment';

import DateTime from 'react-datetime';
import '../estilos/react-datetime.css';

class FormularioEmpleado extends React.Component{

    constructor() {
        super();

    }

    render(){
        const {empleado} = this.props;
        const {onSubmit} = this.props;
        const {onChange} = this.props;
        return(
            <Form inline onSubmit={onSubmit}>
                <FormGroup controlId="promovidoLPS">
                    <ControlLabel>Promovido LPS</ControlLabel>
                    <Checkbox inline defaultValue={empleado.promovidoLps} onChange={onChange}></Checkbox>
                </FormGroup>

                <FormGroup controlId="legajo">
                    <ControlLabel>Legajo</ControlLabel>{' '}
                    <FormControl type="number" placeholder="Numero de legajo" defaultValue={empleado.legajo} onChange={onChange}/>
                </FormGroup>{' '}

                <FormGroup controlId="cuil">
                    <ControlLabel>Cuil</ControlLabel>{' '}
                    <FormControl type="number" placeholder="Numero Cuil sin guiones" defaultValue={empleado.cuil} onChange={onChange} />
                </FormGroup>{' '}

                <FormGroup controlId="formControlPromovidoLPS">
                    <ControlLabel>Senioriti</ControlLabel>
                    <FormControl componentClass="select" placeholder="select" defaultValue={empleado.senioriti} onChange={onChange}>
                        <option value="select">seleccionar</option>
                        <option value="other">...</option>
                    </FormControl>
                </FormGroup>
                <hr/>

                <FormGroup controlId="nombres" className="enLinea">
                    <ControlLabel>Nombres</ControlLabel>{' '}
                    <FormControl type="text" placeholder="nombres" defaultValue={empleado.nombres} onChange={onChange}/>
                </FormGroup>{' '}

                <FormGroup controlId="apellidos" className="enLinea">
                    <ControlLabel>Apellidos</ControlLabel>{' '}
                    <FormControl type="text" placeholder="apellidos" defaultValue={empleado.apellidos} onChange={onChange}/>
                </FormGroup>{' '}

                <FormGroup controlId="email" className="enLinea">
                    <ControlLabel>Email</ControlLabel>{' '}
                    <FormControl type="text" placeholder="mail@ejemplo.com" defaultValue={empleado.email} onChange={onChange}/>
                </FormGroup>{' '}
                <hr/>
                <FormGroup controlId="fechaIngreso" className ="inputCalendar" disabled>
                    <ControlLabel>Fecha Ingreso</ControlLabel>{' '}
                    <DateTime closeOnSelect={true}
                              dateFormat='DD-MM-YYYY'
                              timeFormat={false} onChange={this.onChange}
                    />
                </FormGroup>{' '}

                <FormGroup controlId="fechaEgreso" className ="inputCalendar" disabled>
                    <ControlLabel>Fecha Ingreso</ControlLabel>{' '}
                    <DateTime closeOnSelect={true}
                              dateFormat='DD-MM-YYYY'
                              timeFormat={false}  onChange={this.onChange}
                    />
                </FormGroup>{' '}
                <hr/>
                <FormGroup controlId="telefono">
                    <ControlLabel>Telefono</ControlLabel>{' '}
                    <FormControl type="text" placeholder="ej 1122232425" defaultValue={empleado.telefono} onChange={onChange}/>
                </FormGroup>{' '}

                <FormGroup controlId="centroDeCosto">
                    <ControlLabel>Área</ControlLabel>
                    <FormControl componentClass="select" placeholder="select" defaultValue={empleado.area} onChange={onChange}>
                        <option value="select">seleccionar</option>
                        <option value="other">...</option>
                    </FormControl>
                </FormGroup>

                <FormGroup controlId="perfil">
                    <ControlLabel>Perfil</ControlLabel>
                    <FormControl componentClass="select" placeholder="select" defaultValue={empleado.perfil} onChange={onChange}>
                        <option value="select">seleccionar</option>
                        <option value="other">...</option>
                    </FormControl>
                </FormGroup>
                <hr/>
                <FormGroup controlId="domicilioLaboral" className="enLinea">
                    <ControlLabel>Domicilio Laboral</ControlLabel>{' '}
                    <FormControl type="text" placeholder="lugar de trabajo" defaultValue={empleado.domicilioLaboral} onChange={onChange}/>
                </FormGroup>{' '}

                <FormGroup controlId="observaciones" className="enLinea">
                    <ControlLabel>Observaciones</ControlLabel>
                    <FormControl componentClass="textarea" placeholder="describa una breve observacion" defaultValue={empleado.observaciones} onChange={onChange}/>
                </FormGroup>

                <FormGroup controlId="responsable" className="enLinea">
                    <ControlLabel>Responsable</ControlLabel>{' '}
                    <FormControl type="text" placeholder="nombre de responsable" defaultValue={empleado.responsable} onChange={onChange}/>
                </FormGroup>{' '}
                <input type="submit"/>
            </Form>
        )
    }
}

export default FormularioEmpleado