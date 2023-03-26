package com.example.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class BlogDto implements Validator {
    private Long id;
    @NotEmpty
    @Size(min = 2)
    private String name;
    @Pattern(regexp="^[A-Za-z]*$", message = "phai nhap ky tu chu cai")
    private String author;
    @NotBlank
    private String access;
    public BlogDto(){
    }

    public BlogDto(Long id, String name, String author, String access) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.access = access;
    }
    public BlogDto(String name, String author, String access) {
        super();
        this.name = name;
        this.author = author;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return BlogDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;
        String author = blogDto.getAuthor();
        ValidationUtils.rejectIfEmpty(errors,"author","author.empty");
        if(author.length()<2 || author.length()>40){
            errors.rejectValue("author","author.length");
        }
    }
}
