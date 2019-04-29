package io.project.classproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Summary cannot be blank")
    private String summary;
    @NotBlank(message = "Name cannot be blank")
    private String name;

    public Ingredient(@NotBlank(message = "Summary cannot be blank") String summary, @NotBlank(message = "Name cannot be blank") String name) {
        this.summary = summary;
        this.name = name;
    }

    public Ingredient(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
