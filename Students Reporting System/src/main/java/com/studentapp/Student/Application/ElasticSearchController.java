package com.studentapp.Student.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;


    @Autowired
    ElasticSearchController(ElasticSearchQuery elasticSearchQuery) {
        this.elasticSearchQuery = elasticSearchQuery;
    }

    @PostMapping("/createOrUpdateDocument")
    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Students students) throws IOException {
        String response = elasticSearchQuery.createOrUpdateDocument(students);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findAveragePercentageOfWholeClassInRecentSemester")
    public ResponseEntity<Object> findAveragePercentageOfWholeClassInRecentSemester() throws Exception {
        double response = elasticSearchQuery.getAveragePercentageOfWholeClassInRecentSemester();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findAverageMarksOfStudentsInASubject")
    public ResponseEntity<Object> findAverageMarksOfStudentsInASubject(@RequestParam String subjectName) throws Exception {
        double response = elasticSearchQuery.getAverageMarksOfStudentsInASubject(subjectName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findTop2ConsistentStudentsAcrossAllSemesters")
    public ResponseEntity<Object> findTop2ConsistentStudentsAcrossAllSemesters() throws Exception {
        String response = elasticSearchQuery.getTop2ConsistentStudentsAcrossAllSemesters();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDocument")
    public ResponseEntity<Object> getDocumentById(@RequestParam String productId) throws IOException {
        Students students =  elasticSearchQuery.getDocumentById(productId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDocument")
    public ResponseEntity<Object> deleteDocumentById(@RequestParam String productId) throws IOException {
        String response =  elasticSearchQuery.deleteDocumentById(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/searchDocument")
    public ResponseEntity<Object> searchAllDocument() throws IOException {
        List<Students> students = elasticSearchQuery.searchAllDocuments();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }





}
