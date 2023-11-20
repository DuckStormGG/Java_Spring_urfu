package org.example.web.dto;

import javax.validation.constraints.NotEmpty;

public class Book {

    private Integer id;
    @NotEmpty(message = "Author is required")
    private String author;
    @NotEmpty(message = "Title is required")
    private String title;
    @NotEmpty(message = "Size is required")
    private String size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return "Book{"+"id="+id+", author='"+author+'\''+", title='"+title+'\''+", size="+size+'\'';
    }
}
