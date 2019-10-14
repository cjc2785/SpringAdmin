package com.ss.lms.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "tbl_author", schema = "library")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorId;

    @NotBlank(message = "Summary should not be blank")
    private String authorName;

    public Author() {

    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
