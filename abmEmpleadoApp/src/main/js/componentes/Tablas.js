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

                    </tr>
                    </thead>
                    <tbody>
                    {renderedProjects.map((person,i)=><tr key={i}>
                            <td key={'legajo'+i}>{person.legajo}</td>
                            <td key={'nombres'+i}>{person.nombres}</td>
                            <td key={'apellidos'+i}>{person.apellidos}</td>
                            <td key={'cuil'+i}>{person.cuil}</td>
                            <td key={'responsable'+i}>{person.responsable}</td>
                            <td key={'ingreso'+i}>{person.ingreso}</td>
                            <td key={'egreso'+i}>{person.egreso}</td>
                            <td key={'domicilio'+i}>{person.domicilio}</td>
                            <td key={'observaciones'+i}>{person.observaciones}</td>
                            <td key={'promovido'+i}>{person.promovido}</td>
                            <td key={'email'+i}>{person.email}</td>
                            <td key={'telefono'+i}>{person.telefono}</td>
                            <td key={'senority'+i}>{person.senority}</td>
                            <td key={'perfil'+i}>{person.perfil.descripcion}</td>
                            <td key={'area'+i}>{person.area.descripcion}</td>
                            <td key={'tecnologias'+i}>
                                {person.tecnologias.map((tecnos,t)=>
                                    <div key={'tecnos'+t}>
                                        {tecnos.tipo.descripcion} {tecnos.senority}
                                    </div>
                                )}
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
export default Tablas
