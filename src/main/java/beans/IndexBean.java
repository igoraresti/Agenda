package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.Database;
import database.DatabaseSQL;
import modelo.Actor;

@ManagedBean
@SessionScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -4901741514584007341L;
	private DatabaseSQL database = new DatabaseSQL();
	private String last_name_filter;
	private List<Actor> lista_actores;
	
	@PostConstruct
	public void init(){
		last_name_filter = "";
		lista_actores = database.getAllActors(last_name_filter);
	}

/*
	public List<Actor> getActorList() {
		return database.getAllActors();
	}*/
	
	public List<Actor> getActorList() {
		lista_actores = database.getAllActors(last_name_filter);
		System.out.println("El filtro es:" +last_name_filter);
		return lista_actores;
	}

	public String getLast_name_filter() {
		return last_name_filter;
	}

	public void setLast_name_filter(String last_name_filter) {
		this.last_name_filter = last_name_filter;
	}
	
	

}