import React, { Component } from 'react'
import ReactDOM from "react-dom";
import axios from 'axios'
import { Table, Button, Glyphicon } from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../../estilos/style.css';
import * as moment from 'moment'

class TablaEmpleado extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: [],
      persons:[],
      activePage: 1,
      itemPerPage: 9,
      productList: [],
      duplicateProductList: []
    };
  }

  componentDidMount() {
    {/* */}
    

    axios.get('http://localhost:8080/empleado/listarTodos')
        .then(response =>{
          const persons=response.data
          this.setState({persons,
            projectList: persons,
                duplicateProductList: persons
          });
        })




    {/* */}

  }

  handlePageChange(pageNumber) {
    this.setState({ activePage: pageNumber });
  }



  render () {
    const { persons, activePage, itemPerPage } = this.state;

    const indexOfLastTodo = activePage * itemPerPage;
    const indexOfFirstTodo = indexOfLastTodo - itemPerPage;
    const renderedProjects = persons.slice(indexOfFirstTodo, indexOfLastTodo);
    return (
      <div className='container tabla'>
        <Table responsive striped bordered condensed hover className='margenes'>
          <thead>
            <tr>
              <th className="text-center">Legajo</th>
              <th className="text-center">Nombres</th>
              <th className="text-center">Apellidos</th>
              <th className="text-center">Cuil</th>
              <th className="text-center">Responsable</th>
              <th className="text-center">Ingreso</th>
              <th className="text-center">Egreso</th>
              <th className="text-center">Domicilio</th>
              <th className="text-center">Observaciones</th>
              <th className="text-center">Promovido</th>
              <th className="text-center">Email</th>
              <th className="text-center">Telefono</th>
              <th className="text-center">Senority</th>
              <th className="text-center">Perfil</th>
              <th className="text-center">Area</th>
              <th className="text-center">Tecnologias</th>
              <th className="text-center">Acciones</th>
              
            </tr>
          </thead>
          <tbody>
           {renderedProjects.map((person,i)=><tr key={i}>
              <td className="text-center" key={'legajo'+i}>{person.legajo}</td>
              <td className="text-center" key={'nombres'+i}>{person.nombres}</td>    
              <td className="text-center" key={'apellidos'+i}>{person.apellidos}</td>
              <td className="text-center" key={'cuil'+i}>{person.cuil}</td>
              <td className="text-center" key={'responsable'+i}>{person.responsable}</td>

              
              <td className="text-center" key={'ingreso'+i}>{moment.default(person.ingreso).format('DD-MM-YYYY')}</td>
              <td className="text-center" key={'egreso'+i}>
              {
                person.egreso==null ? '-' : moment.default(person.egreso).format('DD-MM-YYYY')
                
              }
              </td>
              
              
              <td className="text-center" key={'domicilio'+i}>{person.domicilio}</td>
              <td className="text-center" key={'observaciones'+i}>{person.observaciones}</td>
              <td className="text-center" key={'promovido'+i}>{person.promovido}</td>
              <td className="text-center" key={'email'+i}>{person.email}</td>
              <td className="text-center" key={'telefono'+i}>{person.telefono}</td>
              <td className="text-center" key={'senority'+i}>{person.senority}</td>
              <td className="text-center" key={'perfil'+i}>{person.perfil.descripcion}</td>
              <td className="text-center"key={'area'+i}>{person.area.descripcion}</td>
              <td className="text-center" key={'tecnologias'+i}>
              {person.tecnologias.map((tecnos,t)=>
                <div className="text-center" key={'tecnos'+t}>
                  {tecnos.descripcion}{"("+tecnos.senority+")"}
                </div>
                )}
              </td>
              <td className="text-center" key={'acciones'+i}>
              
              <Button onClick={()=>this.editCargo(cargo)}>
                <Glyphicon glyph="pencil"  />
              </Button>
              
              <Button className="btn btm-sm btn-danger espacioBoton" >
                <Glyphicon glyph="trash"  />
              </Button>

              </td>  

                
              </tr>
            
            )}
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
export default TablaEmpleado
