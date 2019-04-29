package io.project.classproject.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Summary cannot be blank")
    private String summary;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String acceptanceCriteria;
    private String cuisine;

    public Recipe(){

    }

    public Recipe(String summary, String name, String acceptanceCriteria, String status) {
        this.summary = summary;
        this.name = name;
        this.acceptanceCriteria = acceptanceCriteria;
        this.cuisine = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String status) {
        this.cuisine = status;
    }
}
