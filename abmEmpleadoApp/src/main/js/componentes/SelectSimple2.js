import ReactDOM from 'react-dom';
import axios from 'axios';
import React from 'react';
import Select from 'react-select';

export default class Selectrubros extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
 
        this.state = {
            selectedOption: null,
            opciones:[]
        }
    }
    componentDidMount(){
        axios.get('http://localhost:8080/rubro/listarTodos')
        .then(response =>{

            let lista=[]
                response.data.map( rubro => {
                var tec={value:rubro.id,label:rubro.descripcion,id:rubro.id}
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
        {
        this.props.objeto==null?
        this.props.funcionRubro(selectedOption)
        :
        this.props.editRubro(selectedOption)
        }
    }
    render() {
    const { selectedOption, opciones } = this.state;

        return (
          <Select
        
            value={selectedOption}
            onChange={this.handleChange}
            options={opciones}
          />
        )
    }
}