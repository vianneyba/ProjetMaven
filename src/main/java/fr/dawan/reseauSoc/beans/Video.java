package fr.dawan.reseauSoc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Embeddable
public class Video extends Likable {
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(
		name= "Video_PeopleContent",
		joinColumns = { @JoinColumn(name = "Video_id") },
		inverseJoinColumns = { @JoinColumn(name = "peopleContent_id") }
	)
	private List<PeopleContent> actors= new ArrayList<>();
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(
		name= "Video_Category",
		joinColumns = { @JoinColumn(name = "video_id") },
		inverseJoinColumns = { @JoinColumn(name = "Category_id") }
	)
	private List<Category> categorys= new ArrayList<>();
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	
	public void setActor(PeopleContent actor) {
		actors.add(actor);
	}
	public void setCategory(Category category) {
		categorys.add(category);
	}

	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/	
	public List<Category> getCategorys() {
		return categorys;
	}
	
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
	public void setActors(List<PeopleContent> actors) {
		this.actors = actors;
	}	
	public List<PeopleContent> getActors() {
		return actors;
	}
	
}
