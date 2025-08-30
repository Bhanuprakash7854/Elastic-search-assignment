package com.undoschool.ElasticSearch.service;

import com.undoschool.ElasticSearch.dto.SearchRequest;
import com.undoschool.ElasticSearch.dto.SearchResponse;
import com.undoschool.ElasticSearch.dto.CourseDocument;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseSearchService {

    private final ElasticsearchOperations elasticsearchOperations;

    public CourseSearchService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public SearchResponse searchCourses(SearchRequest request) {
        Criteria criteria = new Criteria();

        if (StringUtils.hasText(request.getQ())) {
            criteria = criteria.and(
                    new Criteria("title").contains(request.getQ())
                            .or("description").contains(request.getQ())
            );
        }

        if (request.getMinAge() != null) criteria = criteria.and("minAge").greaterThanEqual(request.getMinAge());
        if (request.getMaxAge() != null) criteria = criteria.and("maxAge").lessThanEqual(request.getMaxAge());
        if (request.getMinPrice() != null) criteria = criteria.and("price").greaterThanEqual(request.getMinPrice());
        if (request.getMaxPrice() != null) criteria = criteria.and("price").lessThanEqual(request.getMaxPrice());

        if (StringUtils.hasText(request.getCategory())) criteria = criteria.and("category").is(request.getCategory());
        if (StringUtils.hasText(request.getType())) criteria = criteria.and("type").is(request.getType());

        if (request.getStartDate() != null) criteria = criteria.and("nextSessionDate").greaterThanEqual(request.getStartDate());

        Query query = new CriteriaQuery(criteria);

        query.setPageable(PageRequest.of(request.getPage(), request.getSize()));

        Sort sort;
        if ("priceAsc".equals(request.getSort())) {
            sort = Sort.by(Sort.Direction.ASC, "price");
        } else if ("priceDesc".equals(request.getSort())) {
            sort = Sort.by(Sort.Direction.DESC, "price");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "nextSessionDate");
        }
        query.addSort(sort);

        SearchHits<CourseDocument> searchHits = elasticsearchOperations.search(query, CourseDocument.class);

        List<CourseDocument> courses = searchHits.getSearchHits().stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

        return new SearchResponse(searchHits.getTotalHits(), courses);
    }
}
