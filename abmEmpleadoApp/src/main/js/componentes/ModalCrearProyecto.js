import React from "react"
import {  Popover ,Modal,Button,Tooltip  } from 'react-bootstrap';
import FormularioProyecto from "../componentes/FormularioProyecto";
import axios from 'axios'

class Home extends React.Component{
    constructor(props, context) {
        super(props, context);

        this.handleHide = this.handleHide.bind(this);

        this.state = {
            show: false
        };
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
                                Contained Modal
                            </Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <FormularioProyecto onChange={this.onChange} onSubmit={this.onSubmit}/>
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