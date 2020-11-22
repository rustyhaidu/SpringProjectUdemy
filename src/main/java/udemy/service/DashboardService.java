package udemy.service;

import org.springframework.stereotype.Service;
import udemy.entity.*;

import java.util.HashMap;
import java.util.List;

//@Service
public interface DashboardService {
    HashMap<String, Object> getTodaysRevenueDash();
    List<ProductCategory> getBestCategory();
    List<OrderReceived> getAllOrderReceived();
    List<OrderCollectionStatus> getAllOrderCollection();
    List<EmployeeInformation> getAllEmployee();
    EmployeeInformation addEmployee(EmployeeInformation employeeInformation);
    EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);
    EmployeeInformation getEmployeeInformation(int pk);
    void deleteEmployee(EmployeeInformation employeeInformation);
}
