package ibz.edu.hib.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eduplatformdb.subject_comment")
public class SubjectComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer subjectId;
	private Integer rating;
	private Integer difficulty;
	private String text;
	private Integer workEffort;
	private String author;
	private LocalDate date;
	private Integer lecturerId;
	
	
	public SubjectComment(){
		
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
	@Column(name = "`Subjectid`")
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	@Column(name = "`Rating`")
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Column(name = "`Difficulty`")
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	@Column(name = "`Text`")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(name = "`WorkEffort`")
	public Integer getWorkEffort() {
		return workEffort;
	}
	public void setWorkEffort(Integer workEffort) {
		this.workEffort = workEffort;
	}
	@Column(name = "`Author`")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "`Date`")
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Column(name = "`LecturerId`")
	public Integer getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(Integer lecturerId) {
		this.lecturerId = lecturerId;
	}
	
	
}
