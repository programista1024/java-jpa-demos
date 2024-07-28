package pl.programista1024.demos.jpa.listeners;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "article_name")
	private String article;

	public Article() {

	}

	public Article(String article) {
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	@PrePersist
	public void beforePersist() {
		System.out.println("Before persisting the object...");
	}

	@PostPersist
	public void afterPersist() {
		System.out.println("After persisting the object...");
	}
}
