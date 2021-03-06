package fr.dawan.reseauSoc.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Like_Dislike")
public class LikeDislike {
	
	@Id
	@GeneratedValue
	@Column(name="like_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="likable_id", nullable=false)
	private Likable likable;
	
	private int typeVote;
	@Column(name = "createdAt", columnDefinition="DATETIME")
	@Temporal(TemporalType.DATE)
	private Calendar createdAt;
	private String type;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public LikeDislike() {
		
	}
	
	public LikeDislike(User user, Likable likable_id, int typeVote) {
		this.user= user;
		this.likable= likable_id;
		this.typeVote= typeVote;
	}
	
	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTypeVote() {
		return typeVote;
	}
	public void setTypeVote(int typeVote) {
		this.typeVote = typeVote;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Likable getLikable() {
		return likable;
	}
	public void setLikable(Likable likable) {
		this.likable = likable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
