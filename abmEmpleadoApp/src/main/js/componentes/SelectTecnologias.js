import ReactDOM from 'react-dom';
import axios from 'axios';
import React from 'react';
import Select from 'react-select';

export default class SelectTecnologias extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
 
        this.state = {
            selectedOption: null,
            opciones:[]
        }
    }
    componentDidMount(){
        axios.get('http://localhost:8080/tecnologia/listarTodos')
        .then(response =>{

            let lista=[]
                response.data.map( tecnologia => {
                var tec={value:tecnologia.id,label:tecnologia.descripcion+" (" +tecnologia.senority+")",id:tecnologia.id}
                lista.push(tec)
                return lista
               })
            
            this.setState({
                opciones: lista
            })
        });

    }
    handleChange(selectedOption){
        this.setState({ selectedOption})
        this.props.funcionTecnologia(selectedOption)
    }
    render() {
    const { selectedOption, opciones } = this.state;

        return (
          <Select
            isMulti
            value={selectedOption}
            onChange={this.handleChange}
            options={opciones}
          />
        )
    }
}


