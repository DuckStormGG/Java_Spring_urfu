package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.app.exceptions.RegexFailException;
import org.example.web.dto.Book;
import org.example.web.dto.Regex;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class BookRepository implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);

    private ApplicationContext context;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retreiveAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setSize(rs.getInt("size"));
            return book;
        });
        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author", book.getAuthor());
        parameterSource.addValue("title", book.getTitle());
        parameterSource.addValue("size", book.getSize());
        jdbcTemplate.update("INSERT INTO books(author,title,size) VALUES(:author, :title, :size)", parameterSource);
        logger.info("store new book: " + book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", bookIdToRemove);
        jdbcTemplate.update("DELETE FROM books WHERE id = :id", parameterSource);
        logger.info("remove book completed");
        return true;
    }
    public boolean removeItemByRegex(String regex) throws RegexFailException {
        List<String> temp = Arrays.asList("author", "title", "size");
        if(!Pattern.matches(".+=.+",regex)){
            throw new RegexFailException("Null or Wrong Pattern");
        }
        String[] splitRegex = regex.split("=");
        if(!temp.contains(splitRegex[0])){
            throw new RegexFailException("Wrong Colum");
        }
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("regexData", splitRegex[1]);
        boolean isRemoved = false;
        switch (splitRegex[0]){
            case "author":{
                jdbcTemplate.update("DELETE FROM books WHERE author = :regexData", parameterSource);
                isRemoved = true;
            }
            case "title":{
                jdbcTemplate.update("DELETE FROM books WHERE title = :regexData", parameterSource);
                isRemoved = true;
            }
            case "size":{
                jdbcTemplate.update("DELETE FROM books WHERE size = :regexData", parameterSource);
                isRemoved = true;
            }
            default:{
                System.out.println("Deffff");
            }
        }
        return isRemoved;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void defaultInit() {
        logger.info("default INIT in book repo bean");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book repo bean");
    }
}
