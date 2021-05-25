package com.teachmeskills.calc.controller;

import com.teachmeskills.calc.dao.OperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogOutController {
    @Autowired
    OperationDao operationDao;

    @GetMapping
    public String viewPage(HttpSession session){
        operationDao.removeAll();
        session.invalidate();
        return "redirect:auth";
    }
}
