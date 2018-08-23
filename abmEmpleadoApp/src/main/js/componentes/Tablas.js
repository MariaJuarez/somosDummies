import React, { Component } from 'react'
import ReactDOM from "react-dom";
import axios from 'axios'
import { Table } from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../estilos/style.css';

class Tablas extends Component {
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

    axios.get('https://jsonplaceholder.typicode.com/posts')
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
        <Table striped bordered condensed hover className='margenes'>
          <thead>
            <tr><th className="text-center">UserId</th>
            <th className="text-center">Id</th>
            <th className="text-center">Title</th>
            <th className="text-center">Body</th></tr>
          </thead>
          <tbody>
           {renderedProjects.map((person,i)=><tr key={i}>
            <td key={'user'+i}>{person.userId}</td>
            <td key={'id'+i}>{person.id}</td>
            <td key={'title'+i}>{person.title}</td>
            <td key={'body'+i}>{person.body}</td></tr>)}
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
export default Tablas
