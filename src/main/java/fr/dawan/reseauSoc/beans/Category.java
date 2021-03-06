package fr.dawan.reseauSoc.beans;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Category")
@PrimaryKeyJoinColumn(name="id")
public class Category extends Likable {

	private String name;
	
	/* ****************************************************************************************
	 * ****************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public Category() {
	
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
