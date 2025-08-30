package com.undoschool.ElasticSearch.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.undoschool.ElasticSearch.dto.CourseDocument;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataIndexer {

    private static final Logger logger = LoggerFactory.getLogger(DataIndexer.class);

    private final ElasticsearchOperations elasticsearchOperations;
    private final ResourceLoader resourceLoader;

    public DataIndexer(ElasticsearchOperations elasticsearchOperations, ResourceLoader resourceLoader) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void indexData() {
        try {
            if (elasticsearchOperations.indexOps(CourseDocument.class).exists()) {
                logger.info("Courses index already exists. Skipping data ingestion.");
                return;
            }

            Resource resource = resourceLoader.getResource("classpath:sample-courses.json");
            try (InputStream inputStream = resource.getInputStream()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());

                List<CourseDocument> courses = mapper.readValue(inputStream, new TypeReference<>() {});
                elasticsearchOperations.save(courses);

                logger.info("Successfully indexed {} courses.", courses.size());
            }

        } catch (Exception e) {
            logger.error("Failed to index sample data.", e);
        }
    }
}
