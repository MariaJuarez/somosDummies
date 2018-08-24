import React from "react"
import {Popover ,Modal,Button,Tooltip,Checkbox,Radio,FormGroup,
	ControlLabel,FormControl, HelpBlock,Form} from 'react-bootstrap';
import FormularioEmpleado from "../componentes/FormularioEmpleado";

class Home extends React.Component{
	constructor(props, context) {
    super(props, context);

    this.handleHide = this.handleHide.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.state = {
      	show: false, 
      	empleado:{
      	
			legajo : 2,
			nombres: "Daniel Wilber",
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
				idPerfil: 2
			},
			
			area: {
					idCentroCosto : 2
				},
			senority: 3,
			tecnologias:[
				{
					idTecnologia : 1
				},{
					idTecnologia : 3
				}
			]
    }



    };
    
  	}

	onSubmit(e){
	    e.preventDefault();
	    // get our form data out of state
		console.log(this.state.empleado);
	    const {empleado} = this.state.empleado;

	    axios.post('https://localhost:8080/crud/crearEmpleado', {empleado})
	      .then((result) => {
	        console.log(result)
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
		           	<FormularioEmpleado empleado={this.state.empleado} onSubmit={this.onSubmit}/>
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