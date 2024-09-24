package com.traneeSE.learn_spring_framework.Pojo;

public class Course {
    private long id;
    private String name;
    private String Author;


    public Course(long id, String author, String name) {
        Author = author;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


}
