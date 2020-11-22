package udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.service.DashboardService;
import udemy.service.impl.DashboardServiceImpl;

@RestController
public class ThymeLeafController {

    @Autowired
    @Qualifier("mock")
    private DashboardService dashboardService;


    @GetMapping("/")
    public String getDashDetails(Model model) {
        model.addAttribute("cr", dashboardService.getTodaysRevenueDash());

        return "/index";
    }

}
