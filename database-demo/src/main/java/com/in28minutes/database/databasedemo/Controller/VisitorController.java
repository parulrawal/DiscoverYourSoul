package com.in28minutes.database.databasedemo.Controller;

import com.in28minutes.database.databasedemo.Model.Visitor;
import com.in28minutes.database.databasedemo.Repository.VisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller("VisitorController")
public class VisitorController{

@Autowired
private VisitorRepo visitorRepo;

    @GetMapping(value="/visitor")
    public String viewVisitor(Model model,Visitor visitor){
    model.addAttribute("visitor",visitor);
        return "/view";
    }

    @PostMapping(value="/add-visitor")
    public @ResponseBody String addVisitorDetail(@ModelAttribute Visitor visitor){
        visitor.setName(visitor.getName());
        visitor.setGender(visitor.getGender());
        visitor.setEmail(visitor.getEmail());
        visitorRepo.save(visitor);
        return "redirect:/visitor";
    }

}
