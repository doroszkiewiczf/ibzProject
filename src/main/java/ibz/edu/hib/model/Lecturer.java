package ibz.edu.hib.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "eduplatformdb.Lecturer", uniqueConstraints = {
		@UniqueConstraint(columnNames = "`id`"),
		@UniqueConstraint(columnNames = "`Name`"),
		@UniqueConstraint(columnNames = "`Difficulty`"),
		@UniqueConstraint(columnNames = "`Rating`"),
		@UniqueConstraint(columnNames = "`TeachingRating`"),
		@UniqueConstraint(columnNames = "`CommentsNum`")
		})

public class Lecturer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private float difficulty;
	private float rating;
	private float teachingRating;
	private Integer CommentsNum;
	private Set<Subject> subjects;
	private int isAccepted;
	
	
	public Lecturer() {
		difficulty = 0;
		rating = 0;
		teachingRating = 0;
		CommentsNum = 0;
	}

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "`Name`")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "`Difficulty`")
	public float getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}
	@Column(name = "`Rating`")
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Column(name = "`TeachingRating`")
	public float getTeachingRating() {
		return teachingRating;
	}
	public void setTeachingRating(float teachingRating) {
		this.teachingRating = teachingRating;
	}
	
	@Column(name = "`CommentsNum`")
	public Integer getCommentsNum() {
		return CommentsNum;
	}

	public void setCommentsNum(Integer commentsNum) {
		CommentsNum = commentsNum;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "eduplatformdb.subject_lecturer", 
        joinColumns =  @JoinColumn(name = "Lecturerid") , 
        inverseJoinColumns = @JoinColumn(name = "Subjectid") )
	@JsonIgnore
	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Column(name = "`Is_accepted`")
	public int getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	


	
	}
