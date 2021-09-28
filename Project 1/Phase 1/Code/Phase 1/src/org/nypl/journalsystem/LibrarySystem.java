package org.nypl.journalsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class LibrarySystem {
	
	public LibrarySystem() {
		//TODO: Initialize system with default journals.

	}
	
	public void load() throws FileNotFoundException, IOException {
		loadAuthors();
		loadArticles();
	}
	
	protected void loadAuthors() throws FileNotFoundException, IOException {
		File file = new File("data/Authors.csv");

		//TODO: Load authors from file 
	}
	
	protected void loadArticles() throws FileNotFoundException, IOException {
		File file = new File("data/Articles.csv");

		//TODO: Load articles from file and assign them to appropriate journal
	}
	
	
	public void listContents() {
		//TODO: Print all journals with their respective articles and authors to the console.
	}
	
	public static final void main(String[] args) throws Exception {
		LibrarySystem librarySystem = new LibrarySystem();
		
		librarySystem.load();
		librarySystem.listContents();
	}
}

class Journal {
    public String name, ISSN;
    public int publisher;
    public List<Article> articles = new ArrayList<Article>();
    public boolean full_issue;

    public Journal(String name, int publisher, String ISSN) {
        this.name = name;
        this.publisher = publisher;
        this.ISSN = ISSN;
    }

    public void addArticle(Article article){
        this.articles.add(article);
        if (this.articles.size() == 3)
            this.full_issue = true;
    }
}

class Article {
    public String title;
    public List<String> authors = new ArrayList<String>();

    public Article(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }
}
