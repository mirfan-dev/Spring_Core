package com.result.view.controller;


import com.result.view.dto.StudentForm;
import com.result.view.entity.Mark;
import com.result.view.entity.Student;
import com.result.view.repository.StudentRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private StudentRepository studentRepo;
    private ModelMapper modelMapper;

    public AdminController(StudentRepository studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/result-page")
    public String redirectHandler(){
        return "redirect:/admin/add-result";
    }



    @GetMapping("/add-result")
    public String addResultForm(Principal principal, Model model) {
        StudentForm studentForm = new StudentForm();
        String name=principal.getName();
        List<String> standardOptions = new ArrayList<>();
        standardOptions.add("CLASS 1");
        standardOptions.add("CLASS 2");
        standardOptions.add("CLASS 3");
        standardOptions.add("CLASS 4");
        standardOptions.add("CLASS 5");
        standardOptions.add("CLASS 6");


        model.addAttribute("studentForm", studentForm);
        model.addAttribute("standardOptions", standardOptions);
        model.addAttribute("name",name);
        return "admin/add_result";
    }

    @RequestMapping(value = "/add-result-action", method = RequestMethod.POST)
    public String processAddResultForm(
            @Valid @ModelAttribute StudentForm studentForm,
            BindingResult bindingResult,
            Model model
    ) {


        if (bindingResult.hasErrors()) {
            List<String> standardOptions = new ArrayList<>();
            standardOptions.add("CLASS 1");
            standardOptions.add("CLASS 2");
            standardOptions.add("CLASS 3");
            standardOptions.add("CLASS 4");
            standardOptions.add("CLASS 5");
            standardOptions.add("CLASS 6");
            model.addAttribute("standardOptions", standardOptions);
            return "admin/add_result";
        }


//        convert student form to student entity

        Student student = modelMapper.map(studentForm, Student.class);

        //har marks to attach student
        List<Mark> updatedList = student.getMarks().stream().map(mark -> {
            mark.setStudent(student);
            return mark;
        }).toList();

        //update student list
        student.setMarks(updatedList);


        student.setId(UUID.randomUUID().toString());
        studentRepo.save(student);
        return "redirect:/admin/add-result?message=Student added successfully ";

    }


}
