package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Random;


@Controller
public class HomeController {
    @GetMapping("/surveyform")
    public String loadSurveyForm(Model model){
        int random;
        Random r = new Random();
        random = r.nextInt();
        model.addAttribute("random", random%2);
        model.addAttribute("survey", new Survey());
        return "surveyform";
    }
    @PostMapping("/surveyform")
    public String processSurveyForm(@Valid Survey survey, BindingResult result){
        if (result.hasErrors()) {
            return "surveyform";
        }
        return "surveyconfirm";
    }


}
