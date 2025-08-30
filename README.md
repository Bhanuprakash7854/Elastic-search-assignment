# Course Search API with Spring Boot & Elasticsearch

This project is a Spring Boot application that provides a REST API to search for courses. It uses Elasticsearch for fast and relevant results, featuring full-text search, dynamic filtering, sorting, pagination, and automatic data indexing from a JSON file.

This document serves as a complete guide to setting up, running, and using the application.

## Technologies used
* Java
* Springboot
* ElasticSearch

## Launch elastic search
In the project's root directory, run : docker-compose up -d

## Populating sample data
Sample data will be populated from the sample-courses.json file in resources folder, you can update the sample-courses.json if you want to change the data

## Run the springboot application
start the springboot application, by default it will be running on port number:8080

## Sample requests and responses

* Request : http://localhost:8080/api/search?category=Science&minPrice=200&sort=priceDesc
* Response : 
{
    "total": 3,
    "courses": [
        {
            "id": "CS150",
            "title": "Healthcare Technology",
            "description": "Explore how technology is transforming the healthcare industry.",
            "category": "Science",
            "type": "COURSE",
            "gradeRange": "11th-12th",
            "minAge": 16,
            "maxAge": 18,
            "price": 259.99,
            "nextSessionDate": "2026-01-30T10:00:00Z"
        },
        {
            "id": "CS102",
            "title": "Data Structures and Algorithms",
            "description": "Covers arrays, linked lists, trees, graphs, sorting, and searching techniques.",
            "category": "Science",
            "type": "COURSE",
            "gradeRange": "11th-12th",
            "minAge": 15,
            "maxAge": 20,
            "price": 249.99,
            "nextSessionDate": "2025-09-10T10:00:00Z"
        },
        {
            "id": "CS149",
            "title": "Biotechnology Basics",
            "description": "Introduction to genetics, DNA, and biotechnology applications.",
            "category": "Science",
            "type": "COURSE",
            "gradeRange": "11th-12th",
            "minAge": 16,
            "maxAge": 18,
            "price": 229.99,
            "nextSessionDate": "2026-01-25T10:00:00Z"
        }
    ]
}

* Request : http://localhost:8080/api/search?size=2
* Response : 
{
    "total": 50,
    "courses": [
        {
            "id": "CS101",
            "title": "Introduction to Computer Science",
            "description": "A foundational course covering the basics of programming, algorithms, and data structures.",
            "category": "Science",
            "type": "COURSE",
            "gradeRange": "9th-12th",
            "minAge": 14,
            "maxAge": 18,
            "price": 199.99,
            "nextSessionDate": "2025-09-01T10:00:00Z"
        },
        {
            "id": "CS102",
            "title": "Data Structures and Algorithms",
            "description": "Covers arrays, linked lists, trees, graphs, sorting, and searching techniques.",
            "category": "Science",
            "type": "COURSE",
            "gradeRange": "11th-12th",
            "minAge": 15,
            "maxAge": 20,
            "price": 249.99,
            "nextSessionDate": "2025-09-10T10:00:00Z"
        }
    ]
}