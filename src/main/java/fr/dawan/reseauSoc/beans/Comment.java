package fr.dawan.reseauSoc.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	

	@Id
	@GeneratedValue
	@Column(name="Comment_id")
	private Integer id;
	@ManyToOne
	private Mur wall;
	@ManyToOne
	private User user;
	@Column(length=500)
	private String contenu;
	@Temporal(value=TemporalType.DATE)
	private Date created_Date;
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String textValue) {
		this.contenu = textValue;
	}
	public Mur getWall() {
		return wall;
	}
	public void setWall(Mur wall) {
		this.wall = wall;
	}
	public Date getCreated_Date() {
		return created_Date;
	}
	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}
}
