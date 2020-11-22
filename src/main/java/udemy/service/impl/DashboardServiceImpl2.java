package udemy.service.impl;

import org.springframework.stereotype.Service;
import udemy.entity.EmployeeInformation;
import udemy.entity.OrderCollectionStatus;
import udemy.entity.OrderReceived;
import udemy.entity.ProductCategory;
import udemy.service.DashboardService;

import java.util.HashMap;
import java.util.List;

@Service(value = "mock")
public class DashboardServiceImpl2 implements DashboardService {

    @Override
    public HashMap<String, Object> getTodaysRevenueDash() {
        return null;
    }

    @Override
    public List<ProductCategory> getBestCategory() {
        return null;
    }

    @Override
    public List<OrderReceived> getAllOrderReceived() {
        return null;
    }

    @Override
    public List<OrderCollectionStatus> getAllOrderCollection() {
        return null;
    }

    @Override
    public List<EmployeeInformation> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
        return null;
    }

    @Override
    public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
        return null;
    }

    @Override
    public EmployeeInformation getEmployeeInformation(int pk) {
        return null;
    }

    @Override
    public void deleteEmployee(EmployeeInformation employeeInformation) {

    }
}
