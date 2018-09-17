import React, { Component } from 'react';
import ReactDOM from "react-dom";
import axios from 'axios';
import { Table ,Glyphicon,Button} from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../../estilos/style.css';
import * as moment from 'moment';
import Modal from "../../componentes/Modales/ModalCrearClientes";
import {cloneDeep} from 'lodash'; 
import ModalConfirmacion from "../../componentes/modales/ModalConfirmacionDelete";

class TablaClientes extends Component {
  constructor(props) {

    super(props);
    this.eliminarCliente = this.eliminarCliente.bind(this);
    this.editarRealmenteCliente = this.editarRealmenteCliente.bind(this);
    this.editInputNombre = this.editInputNombre.bind(this);
    this.editInputDescripcion = this.editInputDescripcion.bind(this);
    this.editInputGrupo = this.editInputGrupo.bind(this);
    this.editInputRubro = this.editInputRubro.bind(this);
    this.renewList = this.renewList.bind(this);
    this.state = {
      listadeactivos:[],
      clientes:[],
      activePage: 1,
      itemPerPage: 9,
      productList: [],
      duplicateProductList: [],
      listaProyectos:[],
      objetoSetter:null
    };
  }

  componentDidMount() {
    this.renewList();
    axios.get('http://localhost:8080/proyecto/listarTodos')
        .then(response =>{
          const listaProyectos=response.data
          this.setState({listaProyectos});
        })
  }
  //*------------------------------------------------------
  // FUNCION QUE REFRESCA LA TABLA
  //*------------------------------------------------------
  renewList(){
    axios.get('http://localhost:8080/cliente/listarTodos')
        .then(response =>{
          const clientes=response.data
          this.setState({clientes,
            projectList: clientes,
                duplicateProductList: clientes
          });
        })

  }
  //*------------------------------------------------------
  // FUNCION QUE settea el objetoSetter 
  //el objeto setter permite definir si es un post o un put, si es un null es post, y si no es un put
  //*------------------------------------------------------
  editarRealmenteCliente(objeto){
    this.setState({ 
      objetoSetter:objeto
    });
  }
  editClienteyMostrar(objeto){
    this.editarRealmenteCliente(objeto);
    this.refs.child.handleShow();
    //this.modalCrearcliente.current.handleShow();

  }
  //*-----------------------------------------------------------------------------------
  // FUNCIONES QUE VA A USAR EL FORMULARIO PARA DITAR LOS CAMPOS DEL CLIENTE DESDE EL INPUT
  //__el deepclone()____ te permite copiar el objeto,  recibido como parametro. 
  //si le pusiera el igual aría una referencia y no una copia.
  //*-----------------------------------------------------------------------------------
  editInputNombre(evento){
    const objetoSetter = cloneDeep(this.state.objetoSetter);
    objetoSetter.nombre = evento.target.value;
    this.setState({ 
      objetoSetter
    });
    
  }
  editInputDescripcion(evento){
    
    const objetoSetter = cloneDeep(this.state.objetoSetter);
    objetoSetter.descripcion = evento.target.value;
    this.setState({ 
      objetoSetter
    });
    
  }
  editInputGrupo(evento){
    
    const objetoSetter = cloneDeep(this.state.objetoSetter);
    objetoSetter.grupo = evento.target.value;
    this.setState({ 
      objetoSetter
    });
    
  }
  editInputRubro(evento){
    const objetoSetter = cloneDeep(this.state.objetoSetter);
    objetoSetter.rubro = evento;
    this.setState({ 
      objetoSetter
    });
    
  }
  //*-----------------------------------------------------------------------------------
  // FUNCION QUE VA A USAR EL FORMULARIO PARA ELIMINAR UN CLIENTE, ENVIANDO 
  //*-----------------------------------------------------------------------------------

  eliminarCliente(objeto){
    this.refs.confirmacion.handleShow();
    this.editarRealmenteCliente(objeto);
  }
  handlePageChange(pageNumber) {
    this.setState({ activePage: pageNumber });
  }



  render () {
    const { clientes, activePage, itemPerPage } = this.state;

    const indexOfLastTodo = activePage * itemPerPage;
    const indexOfFirstTodo = indexOfLastTodo - itemPerPage;
    const renderedProjects = clientes.slice(indexOfFirstTodo, indexOfLastTodo);
    return (
      <div className='container tabla'>
        <Modal renewlist={this.renewList} objeto={this.state.objetoSetter} 
          listaProyectos={this.state.listaProyectos}
          editarRealmenteCliente={this.editarRealmenteCliente} 
          editNombre ={this.editInputNombre}
          editDescripcion ={this.editInputDescripcion}
          editGrupo ={this.editInputGrupo}
          editRubro ={this.editInputRubro }
          ref="child" 
        />
        <ModalConfirmacion objeto={this.state.objetoSetter} 
          editarRealmente={this.editarRealmenteCliente}
          nombreTabla={"cliente"}
          renewlist={this.renewList} 
          ref="confirmacion"
        />
        <Table responsive striped bordered condensed hover className='margenes'>
          <thead>
            <tr>
              <th className="text-center">Nombre</th>
              <th className="text-center">Descripcion</th>
              <th className="text-center">Grupo</th>
              <th className="text-center">Rubro</th>
              <th className="text-center">Activo</th>
              <th className="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {
              renderedProjects.map((cliente,i)=><tr key={i}>
              <td className="text-center" key={'nombre'+i}>{cliente.nombre}</td>
              <td className="text-center" key={'descripcion'+i}>{cliente.descripcion}</td>
              <td className="text-center" key={'grupo'+i}>{cliente.grupo}</td>
              <td className="text-center" key={'rubro'+i}>{cliente.rubro.descripcion}</td>
              <td className="text-center" key={'baja'+i}>
              {
                cliente.baja==false ? <Glyphicon glyph="ok"/> : <Glyphicon glyph="remove"/> 
        
              }
              </td>
              
               {
                cliente.baja==false ?
                <td className="text-center" key={'acciones'+i}>
                 <Button  bsClass="btn coloreditar" onClick={()=>this.editClienteyMostrar(cliente)}>
                  <Glyphicon glyph="pencil"  />
                </Button>
                
                <Button bsClass="btn colorborrar espacioBoton" onClick={()=>this.eliminarCliente(cliente)} >
                  <Glyphicon glyph="trash"  />
                </Button>
                </td> 
                 : 
                 <td className="text-center" key={'acciones'+i}>
                 <Button  bsClass="btn colorreactivar" onClick={()=>this.eliminarCliente(cliente)}>
                  Reactivar <Glyphicon glyph="transfer"  />
                </Button>
                </td> 
              }
              </tr>
              )
            }
          </tbody>
        </Table>

        <div className="titulo">
          <Pagination
              prevPageText='Anterior'
              nextPageText='Siguiente'
              firstPageText='Primera'
              lastPageText='Última'
              activePage={this.state.activePage}
              itemsCountPerPage={this.state.itemPerPage}
              totalItemsCount={this.state.duplicateProductList.length}
              pageRangeDisplayed={5}
              onChange={this.handlePageChange.bind(this)}/>
        </div>

        
      </div>
    )
  }
}
export default TablaClientes