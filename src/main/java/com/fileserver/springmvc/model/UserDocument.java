package com.fileserver.springmvc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Model for Files
@Entity
@Table(name="USER_DOCUMENT")
public class UserDocument {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //Primary Key
	private Integer id;	
	
	@Column(name="name", length=100, nullable=false)     //file name
	private String name;
	
	@Column(name="description", length=255)              //description
	private String description;
	
	@Column(name="type", length=100, nullable=false)	 //file type
	private String type;
	//////////////////////////////////////////////////////////////////////////////////////////
    //To Store file contents
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="content", nullable=false)				 //content:bytes
	private byte[] content;
    ///////////////////////////////////////////////////////////////////////////////////////////
	@ManyToOne(optional = false)						 //Foreign Key
	@JoinColumn(name = "USER_ID")
	private User user;
	
	//Setters and Getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//Functions
	@Override
	public int hashCode() {   //returns hash code of objects
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { //Check if 2 Documents / Files are equal or not
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserDocument))
			return false;
		UserDocument other = (UserDocument) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {  //To string method for Object
		return "UserDocument [id=" + id + ", name=" + name + ", description="
				+ description + ", type=" + type + "]";
	}


	
}
