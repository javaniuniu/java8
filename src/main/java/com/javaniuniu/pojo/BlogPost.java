package com.javaniuniu.pojo;

/**
 * @auther: javaniuniu
 * @date: 2020/6/30 6:20 PM
 */
public class BlogPost {
    private String title;
    private String author;
    private int type;
    private int detail;

    public BlogPost() {
    }

    public BlogPost(String title, String author, int type, int detail) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.detail = detail;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDetail() {
        return detail;
    }

    public void setDetail(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", name='" + author + '\'' +
                ", type=" + type +
                ", detail=" + detail +
                '}';
    }
}
