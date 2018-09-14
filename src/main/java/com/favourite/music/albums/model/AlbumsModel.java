package com.favourite.music.albums.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Albums")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AlbumsModel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="seqgenerator")
	@SequenceGenerator(name="seqgenerator",initialValue=1,allocationSize=1,sequenceName="albumcount")
	@ApiModelProperty(notes="Adds id of album to database")
	private Integer id;

	@ApiModelProperty(notes="Adds User Id of album to database")
	@Column
	private String user_id;
	
	
	@ApiModelProperty(notes="Adds name of album to database")
	@NotBlank
	@Column
	private String name;
	
	@ApiModelProperty(notes="Adds gender of album to database")
	@NotBlank
	@Column
	private String gender;
	
	@ApiModelProperty(notes="Adds artist of album to database")
	@NotBlank
	@Column
	private String artist;
	
	@ApiModelProperty(notes="Adds year of album to database")
	@NotBlank
	@Column
	private String year;
	
	@ApiModelProperty(notes="Adds rating of album to database")
	@NotBlank
	@Column
	private String rating;
	
	@ApiModelProperty(notes="Adds comments of album to database")
	@NotBlank
	@Column
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
	

}
