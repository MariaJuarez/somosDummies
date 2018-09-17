import React, { Component } from 'react'
import ReactDOM from "react-dom";
import axios from 'axios'
import { Table ,Glyphicon,Button} from 'react-bootstrap';
import Pagination from "react-js-pagination";
import '../../estilos/style.css';
import * as moment from 'moment'

class TablaProyecto extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: [],
      projects:[],
      activePage: 1,
      itemPerPage: 9,
      projectList: [],
      duplicateProjectList: []
    };
  }

  componentDidMount() {
    {/* */}

    axios.get('http://localhost:8080/proyecto/listarTodos')
        .then(response =>{
          const projects=response.data
          this.setState({projects,
            projectList: projects,
                duplicateProjectList: projects
          });
        })

  }

  handlePageChange(pageNumber) {
    this.setState({ activePage: pageNumber });
  }



  render () {
    const { projects, activePage, itemPerPage } = this.state;

    const indexOfLastTodo = activePage * itemPerPage;
    const indexOfFirstTodo = indexOfLastTodo - itemPerPage;
    const renderedProjects = projects.slice(indexOfFirstTodo, indexOfLastTodo);
    return (
      <div className='container tabla'>
        <Table responsive striped bordered condensed hover className='margenes'>
          <thead>
            <tr>
              <th className="text-center">Jira</th>
              <th className="text-center">Crm</th>
              <th className="text-center">Nombre</th>
              <th className="text-center">Descripcion</th>
              <th className="text-center">Lider</th>
              <th className="text-center">Objetivo</th>
              <th className="text-center">Externo</th>
              <th className="text-center">Equipo</th>
              <th className="text-center">Inicio</th>
              <th className="text-center">Fin</th>
              <th className="text-center">Usuarios</th>
              <th className="text-center">Solicitante</th>
              <th className="text-center">Roles</th>
              <th className="text-center">Requerimiento</th>
              <th className="text-center">Observaciones</th>
              <th className="text-center">Promovido</th>
              <th className="text-center">Baja</th>
              <th className="text-center">Cliente</th>
              <th className="text-center">Metodologia</th>
              <th className="text-center">Tipo Proyecto</th>
              <th className="text-center">Tecnologias</th>
              <th className="text-center">Acciones</th>
            </tr>
          </thead>
          <tbody>
           {renderedProjects.map((proyect,i)=><tr key={i}>
              <td key={'jira'+i}>{proyect.jira}</td>
              <td key={'crm'+i}>{proyect.crm}</td>    
              <td key={'Nombre'+i}>{proyect.nombre}</td>
              <td key={'descripcion'+i}>{proyect.descripcion}</td>
              <td key={'lider'+i}>{proyect.lider}</td>
              <td key={'objetivo'+i}>{proyect.objetivo}</td>
              <td key={'externo'+i}>{proyect.externo}</td>
              <td key={'equipo'+i}>{proyect.equipo}</td>
              <td key={'inicio'+i}>{moment.default(proyect.inicio).format('DD-MM-YYYY')}</td>
              <td key={'fin'+i}>{moment.default(proyect.fin).format('DD-MM-YYYY')}</td>
              <td key={'usuarios'+i}>{proyect.usuarios}</td>
              <td key={'solicitante'+i}>{proyect.solicitante}</td>
              <td key={'roles'+i}>{proyect.roles}</td>
              <td key={'requerimiento'+i}>{proyect.requerimiento}</td>
              <td key={'observaciones'+i}>{proyect.observaciones}</td>
              <td key={'promovido'+i}>{proyect.promovido}</td>
              <td key={'baja'+i}>{proyect.baja}</td>
              <td key={'cliente'+i}>{proyect.cliente.nombre}</td>
              <td key={'metodologia'+i}>{proyect.metodologia.descripcion}</td>
              <td key={'tipo'+i}>{proyect.tipo.descripcion}</td>
              
              <td key={'tecnologias'+i}>
              {proyect.tecnologias.map((tecnos,t)=>
                <div key={'tecnos'+t}>
                  {tecnos.descripcion}
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
              totalItemsCount={this.state.duplicateProjectList.length}
              pageRangeDisplayed={5}
              onChange={this.handlePageChange.bind(this)}/>
        </div>

        
      </div>
    )
  }
}
export default TablaProyecto