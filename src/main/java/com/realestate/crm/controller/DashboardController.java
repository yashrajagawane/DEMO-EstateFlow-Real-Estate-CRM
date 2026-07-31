package com.realestate.crm.controller;

import com.realestate.crm.security.AppUserDetails;
import com.realestate.crm.serviceImpl.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/dashboard")
public class DashboardController {
    private final DashboardService dashboard;
    public DashboardController(DashboardService dashboard){this.dashboard=dashboard;}
    @GetMapping public String dashboard(Model model, @AuthenticationPrincipal AppUserDetails current){
        model.addAttribute("metrics", dashboard.metrics(current.getUser()));
        model.addAttribute("currentUser",current.getUser());
        return "dashboard";
    }
}
