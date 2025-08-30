package com.undoschool.ElasticSearch.dto;
import java.time.Instant;

public class SearchRequest {
    private String q;
    private Integer minAge;
    private Integer maxAge;
    private String category;
    private String type;
    private Double minPrice;
    private Double maxPrice;
    private Instant startDate;
    private String sort = "upcoming";
    private int page = 0;
    private int size = 10;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SearchRequest(String category, Integer maxAge, Double maxPrice, Integer minAge, Double minPrice, int page, String q, int size, String sort, Instant startDate, String type) {
        this.category = category;
        this.maxAge = maxAge;
        this.maxPrice = maxPrice;
        this.minAge = minAge;
        this.minPrice = minPrice;
        this.page = page;
        this.q = q;
        this.size = size;
        this.sort = sort;
        this.startDate = startDate;
        this.type = type;
    }

    public SearchRequest()
    {

    }
}
