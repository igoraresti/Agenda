function redireccionar(){
	console.log("estoy aki");
	var direccion = $("input[name='selector']:checked").attr("value");
	alert(direccion);
	if (direccion="insert") 
		window.location = "buscar.xhtml"
		else if (direccion="delete") 
			window.location = "buscar.xhtml"
			else if (direccion="update")
				window.location = "buscar.xhtml"
				else window.location = "buscar.xhtml"
}				