package com.javaniuniu.stream;

/**
 * @auther: javaniuniu
 * @date: 2020/6/30 6:46 PM
 */
public class Tuple {
    private String author;
    private int type;

    public Tuple() {
    }

    public Tuple(String author, int type) {
        this.author = author;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "author='" + author + '\'' +
                ", type=" + type +
                '}';
    }
}
