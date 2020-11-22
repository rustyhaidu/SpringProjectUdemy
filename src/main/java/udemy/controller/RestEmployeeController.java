package udemy.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import udemy.entity.EmployeeInformation;
import udemy.service.DashboardService;
import udemy.service.impl.DashboardServiceImpl;
import udemy.service.impl.DashboardServiceImpl2;

import java.util.List;

@RestController
public class RestEmployeeController {

    @Autowired
    private ConfigurationClass configurationClass;

    @Autowired
    BeanFactory beans;

    private DashboardService dashboardService;

    @Bean
    public void doSomething() {
        if (configurationClass.getJDBC().equals("db")) {
            dashboardService = beans.getBean(DashboardServiceImpl.class);
        } else {
            dashboardService = beans.getBean(DashboardServiceImpl2.class);
        }
    }


    //@Qualifier("db")
    //@Autowired
    // @Qualifier(value = "db")
    //@Qualifier(value = "db")
    // private DashboardService dashboardService;

    public RestEmployeeController() {
    }

    @RequestMapping("/employee")
    public List<EmployeeInformation> getAllEmpl() {
        System.out.println(configurationClass.getJDBC());
        return dashboardService.getAllEmployee();
    }

/*    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/employee/add")
    public String saveEmployeeInfo(@RequestBody EmployeeInformation employeeInformation) {
        if (dashboardService.addEmployee(employeeInformation) != null) {
            return "Employee data saved succesfully!";
        } else {
            return "Error saving employee information";
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/delete")
    public String deleteEmp(@RequestParam(name = "empId", required = true) int pk) {
        try {
            dashboardService.deleteEmployee(dashboardService.getEmployeeInformation(pk));
            return "deleted";
        } catch (Exception e) {
            return "error deleting";
        }

    }
}
