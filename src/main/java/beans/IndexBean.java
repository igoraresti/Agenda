package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.Actor;
import service.ActorService;

@ManagedBean
@RequestScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -4901741514584007341L;
	private ActorService actorService = new ActorService();
	private String last_name_filter;
	private String first_name_filter;
	private String actor_id_filter;
	

	@PostConstruct
	public void init() {
		last_name_filter = "";
		first_name_filter = "";
		actor_id_filter = "";
	}

	public List<Actor> getActorList() {
		List<Actor> listaActores = new ArrayList<Actor>();
		if(actor_id_filter.length()>0)
			listaActores.add(actorService.getActorById(actor_id_filter));
		else
			listaActores = actorService.getAllActors(first_name_filter,last_name_filter);
		return listaActores;
	}

	public String getLast_name_filter() {
		return last_name_filter;
	}

	public void setLast_name_filter(String last_name_filter) {
		this.last_name_filter = last_name_filter;
	}

	public String getFirst_name_filter() {
		return first_name_filter;
	}

	public void setFirst_name_filter(String first_name_filter) {
		this.first_name_filter = first_name_filter;
	}

	public String getActor_id_filter() {
		return actor_id_filter;
	}

	public void setActor_id_filter(String actor_id_filter) {
		this.actor_id_filter = actor_id_filter;
	}
	
	

}