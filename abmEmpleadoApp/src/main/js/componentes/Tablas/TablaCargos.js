import React, { Component } from 'react';
import ReactDOM from "react-dom";
import axios from 'axios';
import { Table ,Glyphicon,Button} from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../../estilos/style.css';
import * as moment from 'moment';
import Modal from "../../componentes/modales/ModalCrearCargo";
import {cloneDeep} from 'lodash'; 
import ModalConfirmacion from "../../componentes/modales/ModalConfirmacionDelete";

class TablaCargos extends Component {
  constructor(props) {

    super(props);
    this.eliminarCargo = this.eliminarCargo.bind(this);
    this.editarRealmenteCargo = this.editarRealmenteCargo.bind(this);
    this.editInputCargo = this.editInputCargo.bind(this);
    this.renewList = this.renewList.bind(this);
    this.state = {
      listadeactivos:[],
      cargos:[],
      activePage: 1,
      itemPerPage: 9,
      productList: [],
      duplicateProductList: [],
      listaProyectoEmpleados:[],
      objetoSetter:null
    };
  }

  componentDidMount() {
    {/* */}
    
    this.renewList();
    axios.get('http://localhost:8080/proyectoEmpleado/listarTodos')
        .then(response =>{
          const listaProyectoEmpleados=response.data
          this.setState({listaProyectoEmpleados});
        })


    {/* */}

  }
  //*------------------------------------------------------
  // FUNCION QUE REFRESCA LA TABLA
  //*------------------------------------------------------
  renewList(){
    axios.get('http://localhost:8080/cargo/listarTodos')
        .then(response =>{
          const cargos=response.data
          this.setState({cargos,
            projectList: cargos,
                duplicateProductList: cargos
          });
        })

  }
  //*------------------------------------------------------
  // FUNCION QUE settea el objetoSetter 
  //el objeto setter permite definir si es un post o un put, si es un null es post, y si no es un put
  //*------------------------------------------------------
  editarRealmenteCargo(objeto){
    this.setState({ 
      objetoSetter:objeto
    });
  }
  editCargoyMostrar(objeto){
    this.editarRealmenteCargo(objeto);
    this.refs.child.handleShow();
    //this.modalCrearCargo.current.handleShow();

  }
  //*-----------------------------------------------------------------------------------
  // FUNCION QUE VA A USAR EL FORMULARIO PARA DITAR LOS CAMPOS DEL CARGO DESDE EL INPUT
  //__el deepclone()____ te permite copiar el objeto,  recibido como parametro. 
  //si le pusiera el igual aría una referencia y no una copia.
  //*-----------------------------------------------------------------------------------
  editInputCargo(evento){
    const objetoSetter = cloneDeep(this.state.objetoSetter);
    objetoSetter.descripcion=evento.target.value
    this.setState({ 
      objetoSetter
    });
    
  }
  //*-----------------------------------------------------------------------------------
  // FUNCION QUE VA A USAR EL FORMULARIO PARA ELIMINAR UN CARGO, ENVIANDO 
  //*-----------------------------------------------------------------------------------

  eliminarCargo(objeto){
    this.refs.confirmacion.handleShow();
    this.editarRealmenteCargo(objeto);
        
  }
  handlePageChange(pageNumber) {
    this.setState({ activePage: pageNumber });
  }



  render () {
    const { cargos, activePage, itemPerPage } = this.state;

    const indexOfLastTodo = activePage * itemPerPage;
    const indexOfFirstTodo = indexOfLastTodo - itemPerPage;
    const renderedProjects = cargos.slice(indexOfFirstTodo, indexOfLastTodo);
    return (
      <div className='container tabla'>
        <Modal renewlist={this.renewList} objeto={this.state.objetoSetter} 
          listaProyectoEmpleados={this.state.listaProyectoEmpleados}
          editarRealmenteCargo={this.editarRealmenteCargo} 
          editInputCargo ={this.editInputCargo }
          ref="child" 
        />
        <ModalConfirmacion objeto={this.state.objetoSetter} 
          editarRealmente={this.editarRealmenteCargo}
          nombreTabla={"cargo"}
          renewlist={this.renewList} 
          ref="confirmacion"
        />
        <Table responsive striped bordered condensed hover className='margenes'>
          <thead>
            <tr>
              <th className="text-center">Descripcion</th>
              <th className="text-center">Activo</th>
              <th className="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {
              renderedProjects.map((cargo,i)=><tr key={i}>
              <td className="text-center" key={'descripcion'+i}>{cargo.descripcion}</td>
              <td className="text-center" key={'baja'+i}>
              {
                cargo.baja==false ? <Glyphicon glyph="ok"/> : <Glyphicon glyph="remove"/> 
        
              }
              </td>
              
               {
                cargo.baja==false ?
                <td className="text-center" key={'acciones'+i}>
                 <Button  bsClass="btn coloreditar" onClick={()=>this.editCargoyMostrar(cargo)}>
                  <Glyphicon glyph="pencil"  />
                </Button>
                
                <Button bsClass="btn colorborrar espacioBoton" onClick={()=>this.eliminarCargo(cargo)} >
                  <Glyphicon glyph="trash"  />
                </Button>
                </td> 
                 : 
                 <td className="text-center" key={'acciones'+i}>
                 <Button  bsClass="btn colorreactivar" onClick={()=>this.eliminarCargo(cargo)}>
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
export default TablaCargos