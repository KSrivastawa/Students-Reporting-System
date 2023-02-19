package com.studentapp.Student.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UIController {

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @GetMapping("/")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("listStudentsDocuments",elasticSearchQuery.searchAllDocuments());
        return "index";
    }

    @PostMapping("/saveStudent")
    public String saveProduct(@ModelAttribute("Students") Students students) throws IOException {
        elasticSearchQuery.createOrUpdateDocument(students);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) throws IOException {

        Students students = elasticSearchQuery.getDocumentById(id);
        model.addAttribute("product", students);
        return "updateStudentsDocument";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Students students = new Students();
        model.addAttribute("students", students);
        return "newStudentsDocument";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteProduct(@PathVariable(value = "id") String id) throws IOException {

        this.elasticSearchQuery.deleteDocumentById(id);
        return "redirect:/";
    }
}
