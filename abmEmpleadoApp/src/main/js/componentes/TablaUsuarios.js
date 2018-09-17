import React, { Component } from 'react'
import ReactDOM from "react-dom";
import axios from 'axios'
import { Table } from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../estilos/style.css';
import * as moment from 'moment'

class TablaUsuarios extends Component {
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
    

    axios.get('http://localhost:8080/usuario/listarTodos')
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
              <th className="text-center">Nombre de Usuario</th>
              <th className="text-center">Baja</th>
              <th className="text-center">Empleado</th>
              <th className="text-center">Legajo_Empleado</th>
            </tr>
          </thead>
          <tbody>
            {
              renderedProjects.map((person,i)=><tr key={i}>
              <td className="text-center" key={'nombre'+i}>{person.nombre}</td>
              <td className="text-center" key={'baja'+i}>{person.baja}</td> 
              <td className="text-center" key={'empleado'+i}>{person.empleado.nombres}{" "}{person.empleado.apellidos}</td>
               <td className="text-center" key={'legajo_empleado'+i}>{person.empleado.legajo}</td>     
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
export default TablaUsuarios