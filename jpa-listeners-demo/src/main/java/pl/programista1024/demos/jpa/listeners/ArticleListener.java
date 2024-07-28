package pl.programista1024.demos.jpa.listeners;

import java.util.Date;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class ArticleListener {

	@PrePersist
	public void beforePersist(Article article) {
		System.out.println("Before persisting the object...");
		article.setDate(new Date());
	}

	@PostPersist
	public void afterPersist(Article article) {
		System.out.println("After persisting the object...");
	}
	
}
