package com.undoschool.ElasticSearch.dto;
// src/main/java/com/example/coursesearch/document/CourseDocument.java

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Document(indexName = "courses")
public class CourseDocument {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    // Use Keyword for exact matching/filtering
    @Field(type = FieldType.Keyword, name = "category")
    private String category;

    @Field(type = FieldType.Keyword, name = "type")
    private String type;

    @Field(type = FieldType.Keyword, name = "gradeRange")
    private String gradeRange;

    @Field(type = FieldType.Integer, name = "minAge")
    private Integer minAge;

    @Field(type = FieldType.Integer, name = "maxAge")
    private Integer maxAge;

    @Field(type = FieldType.Double, name = "price")
    private Double price;

    // Use Date type for date-based queries
    @Field(type = FieldType.Date, name = "nextSessionDate")
    private Instant nextSessionDate;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Instant getNextSessionDate() {
        return nextSessionDate;
    }

    public void setNextSessionDate(Instant nextSessionDate) {
        this.nextSessionDate = nextSessionDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CourseDocument(String category, String description, String gradeRange, String id, Integer maxAge, Integer minAge, Instant nextSessionDate, Double price, String title, String type) {
        this.category = category;
        this.description = description;
        this.gradeRange = gradeRange;
        this.id = id;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.nextSessionDate = nextSessionDate;
        this.price = price;
        this.title = title;
        this.type = type;
    }

    public CourseDocument()
    {

    }
}