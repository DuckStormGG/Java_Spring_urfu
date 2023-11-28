package org.example.app.services;

import org.example.app.exceptions.RegexFailException;
import org.example.web.dto.Regex;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);
    boolean removeItemByRegex(String regex) throws RegexFailException;
}
