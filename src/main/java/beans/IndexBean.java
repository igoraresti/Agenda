package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import database.Database;
import database.DatabaseSQL;
import modelo.Actor;

@ManagedBean
@ApplicationScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -4901741514584007341L;
	private List<Actor> actorList;
	private DatabaseSQL database = new DatabaseSQL();

	@PostConstruct
	public void init() {
		actorList = database.getAllActors();
	}

	public List<Actor> getActorList() {
		return actorList;
	}

}