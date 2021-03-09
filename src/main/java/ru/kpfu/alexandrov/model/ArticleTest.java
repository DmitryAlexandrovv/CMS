package ru.kpfu.alexandrov.model;

public class ArticleTest {
    private String content;
    private String title;

    public ArticleTest() {
    }

    public ArticleTest(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
