package com.undoschool.ElasticSearch.dto;

import java.util.List;

public record SearchResponse(long total, List<CourseDocument> courses) {}