import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
    ControlLabel,FormControl, HelpBlock,Form,Col} from 'react-bootstrap';


class FormularioProyecto extends React.Component{
    constructor() {
        super();
    }


    render(){
        return(
            <Form inline>
                <FormGroup controlId="formControlsSelect">
                    <ControlLabel>Promovido LPS</ControlLabel>
                    <FormControl componentClass="select" placeholder="select">
                        <option value="select">seleccionar</option>
                        <option value="other">...</option>
                    </FormControl>
                </FormGroup>
                <FormGroup controlId="formInlineName">
                    <ControlLabel>Legajo</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Numero de legajo" />
                </FormGroup>{' '}
                <hr/>


                <FormGroup controlId="formInlineName" className="enLinea">
                    <ControlLabel>Nombres</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}
                <FormGroup controlId="formInlineEmail" className="enLinea">
                    <ControlLabel>Apellidos</ControlLabel>{' '}
                    <FormControl type="email" placeholder="jane.doe@example.com" />
                </FormGroup>{' '}


                <br/>

                <FormGroup controlId="formControlsSelect">
                    <ControlLabel>Fecha Ingreso</ControlLabel>
                    <FormControl componentClass="select" placeholder="select">
                        <option value="select">seleccionar</option>
                        <option value="other">...</option>
                    </FormControl>
                </FormGroup>
                <FormGroup controlId="formControlsSelect" >
                    <ControlLabel>Fecha Egreso</ControlLabel>
                    <FormControl componentClass="select" placeholder="select">
                        <option value="select">seleccionar</option>
                        <option value="other">...</option>
                    </FormControl>
                </FormGroup>


                <hr/>

                <FormGroup controlId="formInlineName">
                    <ControlLabel>Email</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}

                <FormGroup controlId="formInlineName">
                    <ControlLabel>Cargo RHPRO</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}

                <FormGroup controlId="formInlineName">
                    <ControlLabel>Centro de Costo</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}

                <FormGroup controlId="formInlineEmail">
                    <ControlLabel>Email</ControlLabel>{' '}
                    <FormControl type="email" placeholder="jane.doe@example.com" />
                </FormGroup>{' '}

                <FormGroup controlId="formInlineName">
                    <ControlLabel>Name</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}

                <FormGroup controlId="formControlsTextarea">
                    <ControlLabel>Textarea</ControlLabel>
                    <FormControl componentClass="textarea" placeholder="textarea" />
                </FormGroup>

                <FormGroup controlId="formInlineName">
                    <ControlLabel>Name</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}

                <FormGroup controlId="formInlineName">
                    <ControlLabel>Name</ControlLabel>{' '}
                    <FormControl type="text" placeholder="Jane Doe" />
                </FormGroup>{' '}
            </Form>
        )
    }
}

export default FormularioProyecto