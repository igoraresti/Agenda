package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import database.Database;
import modelo.Contacto;



@ManagedBean
@ApplicationScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -4901741514584007341L;	
	private List<Contacto> usersList;
	private Database database = new Database();

	@PostConstruct
	public void init() {
        usersList = database.getAllContacts();
    }

	public List<Contacto> getContactList() {
		return usersList;
	}


	

	
}