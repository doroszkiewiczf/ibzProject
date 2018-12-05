package ibz.edu.hib.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "eduplatformdb.student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private String login;
	private String password;
	private Set<Group> groups;
	private Integer permission;
	@Transient
	private String token;
	

	public Student() {
		
	}
	
	public Student(Integer studentId, String login, String password) {
		super();
		this.studentId = studentId;
		this.login = login;
		this.password = password;
	}
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Column(name = "`login`")
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String userLogin) {
		this.login = userLogin;
	}

	@Column(name = "`password`")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "eduplatformdb.student_group", 
        joinColumns =  @JoinColumn(name = "Studentid") , 
        inverseJoinColumns = @JoinColumn(name = "Groupid") )
	@JsonIgnore
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@Column(name = "`Permission`")
	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}
	@Transient
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
