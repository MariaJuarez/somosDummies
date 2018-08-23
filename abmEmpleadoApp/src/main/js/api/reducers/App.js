
export default (store={titulo : "mi pagina"},action) =>{
	switch (action.type) {
		case "CAMBIAR_TITULO":
			return {titulo:action.payload}
		break;
		case "CAMBIAR_LINK":
			
		break;
		default:
			return store;
		break;
	}
}