package com.student.studentcrud.controller;

// import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
    
    @RequestMapping("/beranda")    
    public String beranda(){
        String html = "beranda";
        return html;
    }

   
    @RequestMapping("/login/action")
    public String tujuan(HttpServletRequest request, Model model){

       
        String mintaUser = request.getParameter("username");
        String mintaAl = request.getParameter("alamat");
        String mintaJk = request.getParameter("jk");
        String mintaWr = request.getParameter("wr");


        model.addAttribute("userLempar", mintaUser);
        model.addAttribute("allempar", mintaAl);
        model.addAttribute("jklempar", mintaJk);
        model.addAttribute("wrlempar", mintaWr);
        String home = "beranda";
        return home;
    }
}
