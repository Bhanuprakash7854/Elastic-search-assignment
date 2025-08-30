package com.undoschool.ElasticSearch.controller;

import com.undoschool.ElasticSearch.service.CourseSearchService;
import com.undoschool.ElasticSearch.dto.SearchRequest;
import com.undoschool.ElasticSearch.dto.SearchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class CourseController {

    private final CourseSearchService courseSearchService;

    public CourseController(CourseSearchService courseSearchService) {
        this.courseSearchService = courseSearchService;
    }

    @GetMapping
    public SearchResponse search(SearchRequest request) {
        return courseSearchService.searchCourses(request);
    }
}
