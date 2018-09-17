import React, { Component } from 'react'
import ReactDOM from "react-dom";
import axios from 'axios'
import { Table ,Glyphicon,Button} from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../../estilos/style.css';
import * as moment from 'moment'

class TablaTecnologias extends Component {
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
    

    axios.get('http://localhost:8080/tecnologia/listarTodos')
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
              <th className="text-center">Descripcion</th>
              <th className="text-center">Tipo</th>
              <th className="text-center">Baja</th>
              <th className="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {
              renderedProjects.map((person,i)=><tr key={i}>
              <td className="text-center" key={'abreviatura'+i}>{person.descripcion}</td>
              <td className="text-center" key={'descripcion'+i}>{person.tipo.descripcion}</td>
              <td className="text-center" key={'baja'+i}>{person.baja}</td> 
              <td className="text-center" key={'acciones'+i}>
              
              <Button onClick={()=>this.editCargo(cargo)}>
                <Glyphicon glyph="pencil"  />
              </Button>
              
              <Button className="btn btm-sm btn-danger espacioBoton" >
                <Glyphicon glyph="trash"  />
              </Button>

              </td>    
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
export default TablaTecnologias 