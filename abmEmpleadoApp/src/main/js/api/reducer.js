//reducer.js
//se suele hacer un recuder por aciones(reducer por componente) y lo mismo
//las acciones
import {combineReducers} from "redux"
import App from "./reducers/App"
import { reducer as reduxFormReducer } from 'redux-form'

export default combineReducers({
	App,form: reduxFormReducer
})
