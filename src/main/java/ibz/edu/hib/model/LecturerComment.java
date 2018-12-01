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
@Table(name = "eduplatformdb.lecturer_comment")
public class LecturerComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer rating;
	private Integer difficulty;
	private Integer teachingRating;
	private Integer lecturerId;
	private String text;
	private String author;
	private LocalDate date;
	
	public LecturerComment() {
		
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
	@Column(name = "`TeachingRating`")
	public Integer getTeachingRating() {
		return teachingRating;
	}
	public void setTeachingRating(Integer teachingRating) {
		this.teachingRating = teachingRating;
	}
	@Column(name = "`Lecturerid`")
	public Integer getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(Integer lecturerId) {
		this.lecturerId = lecturerId;
	}
	@Column(name = "`Text`")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	
	
	
}
