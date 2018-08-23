import React from "react"
/*
* this.props: propiedades
* React developer tools
*/

class Main extends React.Component{
	
	render(){
		let {id,children:children}=this.props
		return(
			<main id={id}>
				
				{children}
				
			</main>
		)
	}
}

export default Main