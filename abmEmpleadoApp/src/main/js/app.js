import React from "react"
import ReactDOM from "react-dom"
import App from "./layout/App"
import {Provider}  from "react-redux"
import store from "./api/store"

ReactDOM.render(
    //<ComponenteDeReact/>
    //document.getElementBy
    <Provider store={store}>
        <App/>

    </Provider>
    ,
    document.getElementById("app")
)
