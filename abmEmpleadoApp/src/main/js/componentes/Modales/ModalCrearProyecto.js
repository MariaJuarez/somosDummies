import React from "react"
import {  Popover ,Modal,Button,Tooltip  } from 'react-bootstrap';
import FormularioProyecto from "../../componentes/formularios/FormularioProyecto";
import axios from 'axios'

class Home extends React.Component{
	constructor(props, context) {
	    super(props, context);
		this.handleHide = this.handleHide.bind(this);
	    this.funcionTecnologia = this.funcionTecnologia.bind(this);
	    this.showResults = this.showResults.bind(this);
	    this.state = {
	    	clientes:[],
	    	tiposDeProyecto:[],
	    	metodologias:[],
	      show: false
	    };
  	}
  	componentDidMount() {
        axios.get('http://localhost:8080/cliente/listarTodos')
        .then(response =>{
          const clientesAux = response.data
          
          this.setState({
            clientes:clientesAux
          });
        })
        axios.get('http://localhost:8080/tipoProyecto/listarTodos')
        .then(response =>{
          const tiposDeProyectoAux = response.data
          this.setState({
            tiposDeProyecto:tiposDeProyectoAux
          });
        })
        axios.get('http://localhost:8080/metodologia/listarTodos')
        .then(response =>{
          const metodologiasAux = response.data
          this.setState({
            metodologias:metodologiasAux
          });
        })
    }
	funcionTecnologia(params) {
        this.setState({ tecnologias: params });
    }

    showResults (values){
        new Promise(resolve => {
        values.proyecto.tecnologias=this.state.tecnologias
        //obj.empleadoss.ingreso=values.empleado.fechaIngreso._d;
        
        axios.post('http://localhost:8080/proyecto/crear', values.proyecto)
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

	    const { handleSubmit, values, pristine, reset, submitting} = this.props
	  	const {clientes,tiposDeProyecto,
	  			metodologias} = this.state
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
		        	<FormularioProyecto onSubmit={this.showResults} funcionTecnologia={this.funcionTecnologia} 
		        	clientes={clientes}
	    			tiposDeProyecto={tiposDeProyecto}
	    			metodologias={metodologias}/>
		          </Modal.Body>
		          
		        </Modal>
		      </div>

			</div>

		)
	}
}

export default Home