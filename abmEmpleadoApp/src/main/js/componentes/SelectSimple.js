import ReactDOM from 'react-dom';
import axios from 'axios';
import React from 'react';
import Select from 'react-select';

export default class SelectSimple extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
 
        this.state = {
            selectedOption: null
        }

    }
    
    componentDidMount(){
        /*console.log("opciones")
        console.log(this.props.opciones)
        console.log("funcion setear objeto")
        console.log(this.props.funcionSetObjeto)*/
        console.log("opciones")
        console.log(this.props)
    }
    
    handleChange(selectedOption){
        console.log("select ")
        //console.log(this.state.selectedOption)

        console.log(selectedOption)
        this.setState({ selectedOption})
        console.log(this.state.selectedOption)
        this.props.funcionSetearRubro(this.state.selectedOption)
        //console.log("select2 "+ selectedOption)

    }
    render() {
    const { selectedOption } = this.state;
    /*
    console.log("opciones")
        console.log(this.props.opciones)
        console.log("funcion setear objeto")
        console.log(this.props.funcionSetObjeto)*/
 
        return (
          <Select
            value={selectedOption}
            onChange={this.handleChange}
            options={this.props.opciones}
          />
        )
    }
}