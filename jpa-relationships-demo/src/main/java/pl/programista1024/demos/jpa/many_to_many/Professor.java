package pl.programista1024.demos.jpa.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int professorId;
	
	@Column(name = "name")
	private String professorName;
	
	@ManyToMany(mappedBy = "professors", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<ResearchProject> projects;
	
	public Professor() {
		this.projects = new ArrayList<>();
	}
	
	public Professor(String professorName) {
		this();
		this.professorName = professorName;
	}

	public void assignProjectToProfessor(ResearchProject project) {
		this.projects.add(project);
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public List<ResearchProject> getProjects() {
		return projects;
	}

	public void setProjects(List<ResearchProject> projects) {
		this.projects = projects;
	}
	
	
}
