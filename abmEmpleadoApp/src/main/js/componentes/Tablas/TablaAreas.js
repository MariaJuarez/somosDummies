import React, { Component } from 'react';
import ReactDOM from "react-dom";
import axios from 'axios';
import { Table ,Glyphicon,Button} from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../../estilos/style.css';
import * as moment from 'moment';
import Modal from "../../componentes/modales/ModalCrearArea";
import {cloneDeep} from 'lodash'; 
import ModalConfirmacion from "../../componentes/modales/ModalConfirmacionDelete";

class TablaAreas extends Component {
  constructor(props) {

    super(props);
    this.eliminarArea = this.eliminarArea.bind(this);
    this.editarRealmenteArea = this.editarRealmenteArea.bind(this);
    this.editInputArea = this.editInputArea.bind(this);
    this.renewList = this.renewList.bind(this);
    this.state = {
      listadeactivos:[],
      areas:[],
      activePage: 1,
      itemPerPage: 9,
      productList: [],
      duplicateProductList: [],
      listaEmpleados:[],
      objetoSetter:null
    };
  }

  componentDidMount() {
    {/* */}
    
    this.renewList();
    axios.get('http://localhost:8080/empleado/listarTodos')
        .then(response =>{
          const listaEmpleados=response.data
          this.setState({listaEmpleados});
        })


    {/* */}

  }
  //*------------------------------------------------------
  // FUNCION QUE REFRESCA LA TABLA
  //*------------------------------------------------------
  renewList(){
    axios.get('http://localhost:8080/area/listarTodos')
        .then(response =>{
          const areas=response.data
          this.setState({areas,
            projectList: areas,
                duplicateProductList: areas
          });
        })

  }
  //*------------------------------------------------------
  // FUNCION QUE settea el objetoSetter 
  //el objeto setter permite definir si es un post o un put, si es un null es post, y si no es un put
  //*------------------------------------------------------
  editarRealmenteArea(objeto){
    this.setState({ 
      objetoSetter:objeto
    });
  }
  editAreayMostrar(objeto){
    this.editarRealmenteArea(objeto);
    this.refs.child.handleShow();
    //this.modalCreararea.current.handleShow();

  }
  //*-----------------------------------------------------------------------------------
  // FUNCION QUE VA A USAR EL FORMULARIO PARA DITAR LOS CAMPOS DEL area DESDE EL INPUT
  //__el deepclone()____ te permite copiar el objeto,  recibido como parametro. 
  //si le pusiera el igual aría una referencia y no una copia.
  //*-----------------------------------------------------------------------------------
  editInputArea(evento){
    const objetoSetter = cloneDeep(this.state.objetoSetter);
    objetoSetter.descripcion=evento.target.value
    this.setState({ 
      objetoSetter
    });
    
  }
  //*-----------------------------------------------------------------------------------
  // FUNCION QUE VA A USAR EL FORMULARIO PARA ELIMINAR UN area, ENVIANDO 
  //*-----------------------------------------------------------------------------------

  eliminarArea(objeto){
    this.refs.confirmacion.handleShow();
    this.editarRealmenteArea(objeto);
        
  }
  handlePageChange(pageNumber) {
    this.setState({ activePage: pageNumber });
  }



  render () {
    const { areas, activePage, itemPerPage } = this.state;

    const indexOfLastTodo = activePage * itemPerPage;
    const indexOfFirstTodo = indexOfLastTodo - itemPerPage;
    const renderedProjects = areas.slice(indexOfFirstTodo, indexOfLastTodo);
    return (
      <div className='container tabla'>
        <Modal renewlist={this.renewList} objeto={this.state.objetoSetter} 
          listaEmpleados={this.state.listaEmpleados}
          editarRealmenteArea={this.editarRealmenteArea} editInputArea ={this.editInputArea }
         ref="child" />
        <ModalConfirmacion objeto={this.state.objetoSetter} 
         editarRealmente={this.editarRealmenteArea}
         nombreTabla={"area"}
         renewlist={this.renewList} ref="confirmacion"/>
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
              renderedProjects.map((area,i)=><tr key={i}>
              <td className="text-center" key={'descripcion'+i}>{area.descripcion}</td>
              <td className="text-center" key={'baja'+i}>
              {
                area.baja==false ? <Glyphicon glyph="ok"/> : <Glyphicon glyph="remove"/> 
        
              }
              </td>
              
               {
                area.baja==false ?
                <td className="text-center" key={'acciones'+i}>
                 <Button  bsClass="btn coloreditar" onClick={()=>this.editAreayMostrar(area)}>
                  <Glyphicon glyph="pencil"  />
                </Button>
                
                <Button bsClass="btn colorborrar espacioBoton" onClick={()=>this.eliminarArea(area)} >
                  <Glyphicon glyph="trash"  />
                </Button>
                </td> 
                 : 
                 <td className="text-center" key={'acciones'+i}>
                 <Button  bsClass="btn colorreactivar" onClick={()=>this.eliminarArea(area)}>
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
export default TablaAreas