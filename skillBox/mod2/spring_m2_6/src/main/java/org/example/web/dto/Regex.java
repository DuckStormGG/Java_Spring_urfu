package org.example.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Regex {
    @Pattern(regexp = ".+=.+")
    @NotBlank
    public String regex;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Regex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return "Regex{" +
                "regex='" + regex + '\'' +
                '}';
    }
}

