package com.in28minutes.database.databasedemo.Controller;

import com.in28minutes.database.databasedemo.Model.Destination;
import com.in28minutes.database.databasedemo.Model.User;
import com.in28minutes.database.databasedemo.Repository.DestinationRepo;
import com.in28minutes.database.databasedemo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller("LoginController")
public class LoginController {
@Autowired UserRepo userRepo;
@Autowired DestinationRepo destinationRepo;

    @GetMapping(value="/home")
     public String home(Model model,Destination destination){
        List<Destination> destinationList = new ArrayList<>();
        destinationList=destinationRepo.findAll();
        model.addAttribute("destination",destination);
        model.addAttribute("destinationList",destinationList);
     return "/homePage";
    }

    @GetMapping(value="/searchPrice")
    public String searchPrice(Model model,Destination destination,@RequestParam(value="destId",required = false) Long destId){
        List<Destination> destinationList = new ArrayList<>();
        destinationList=destinationRepo.findAll();
        model.addAttribute("destination",destination);
        model.addAttribute("destinationList",destinationList);
        if(destId!=null){
            Destination priceList=destinationRepo.findById(destId);
            model.addAttribute("priceList",priceList);
        }
        return "/homePage";
    }

    @GetMapping(value="/login")
    public String login(Model model,User user){
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping(value="/add-Login")
    public String addLogin(@ModelAttribute User user){
        User user1 = userRepo.findByEmailAndPassword(user.getEmail(),user.getPassword());
       if(user1 !=null){
        return "redirect:/visitor";
       }
        else{
           return "redirect:/login";
       }
    }


}
