package ru.kpfu.alexandrov.model;

import java.util.Objects;

public class Article {
    private int id;
    private long publicationDate;
    private String title;
    private String content;
    private int parentId;

    public Article() {
    }

    public Article(long publicationDate, String title, String content) {
        this.publicationDate = publicationDate;
        this.title = title;
        this.content = content;
    }

    public Article(long publicationDate, String title, String content, int parentId) {
        this.publicationDate = publicationDate;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
    }

    public Article(int id, long publicationDate, String title, String content) {
        this.id = id;
        this.publicationDate = publicationDate;
        this.title = title;
        this.content = content;
    }

    public long getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(long publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() { return publicationDate; }

    public void setDate(long publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id &&
                Objects.equals(publicationDate, article.publicationDate) &&
                Objects.equals(title, article.title) &&
                Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publicationDate, title, content);
    }
}
