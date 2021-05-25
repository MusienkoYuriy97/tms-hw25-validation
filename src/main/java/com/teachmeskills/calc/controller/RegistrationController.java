package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.dao.UserDao;
import com.teachmeskills.calc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping(value = "/reg", name = "RegistrationController")
public class RegistrationController {
    @Autowired
    UserDao userDao;

    @GetMapping
    public String viewPage(Model model){
        model.addAttribute("regUser",new User());
        return "registration";
    }

    @PostMapping
    public String checkPerson(@ModelAttribute("regUser") @Valid User regUser, BindingResult bindingResult,
                           Model model){
        if (userDao.contains(regUser.getUsername())){
            model.addAttribute("message","User with the same username already exist");
            return "registration";
        }
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userDao.save(regUser);
        return "redirect:auth";
    }
}
