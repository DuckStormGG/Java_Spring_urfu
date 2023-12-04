package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private ArrayList<Author> getAuthorsData(){

        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum)->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setAuthor(rs.getString("author"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public Map<String, List<Author>> createAuthorDictionary(){
        Map<String,List<Author>> authorDictionary = new HashMap<>();
        for (Author author: this.getAuthorsData()) {
            String temp = author.getAuthor().substring(0,1);
            if(!authorDictionary.containsKey(temp)){
                List<Author> tempList = new ArrayList<>();
                tempList.add(author);
                authorDictionary.put(temp,tempList);
            }
            else {
                authorDictionary.get(temp).add(author);
            }
        }
        for (Map.Entry<String, List<Author>> entry : authorDictionary.entrySet()) {
            List<Author> value = entry.getValue();
            value.sort((o1, o2) -> o1.getAuthor().compareTo(o2.getAuthor()));

        }
        System.out.println(authorDictionary);
        return authorDictionary;
    }

}
