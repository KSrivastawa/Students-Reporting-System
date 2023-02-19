package com.studentapp.Student.Application;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchRepo extends ElasticsearchRepository<Students, String> {

    public double findAveragePercentageOfWholeClassInRecentSemester() throws Exception;

    public double findAverageMarksOfStudentsInASubject(String subjectName) throws Exception;

    public String findTop2ConsistentStudentsAcrossAllSemesters() throws Exception;



}
