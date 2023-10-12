package com.app.playground.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/school/*")
public class SchoolController {

    @GetMapping("/notes-to-parents")
    public void goToNotesToParents(){;}

    @GetMapping("/notes-to-parents-detail")
    public void goToNotesToParentsDetail(){;}

    @GetMapping("/school-meal")
    public void goToSchoolMeal(){;}

    @GetMapping("/school-schedule")
    public void goToSchoolSchedule(){;}
}
