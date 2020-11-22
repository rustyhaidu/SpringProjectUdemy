package udemy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import udemy.entity.*;
import udemy.repositories.*;
import udemy.service.DashboardService;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

//@Service(value = "db")
@Service
@Qualifier("db")
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private EmployeeInformationRepository employeeInformationRepository;

    @Autowired
    private CompanyRevenueRepository companyRevenueRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private OrderReceivedRepository orderReceivedRepository;

    @Autowired
    private OrderCollectionStatusRepository orderCollectionStatusRepository;


    @Override
    public HashMap<String, Object> getTodaysRevenueDash() {
        // return companyRevenueRepository.findAll();
        HashMap<String, Object> populateCompanyRev = new HashMap<>();

        List<CompanyRevenue> companyRevenueList = companyRevenueRepository.findAll();

        List<String> label = new ArrayList<>();
        List<String> revenue = new ArrayList<>();
        double totalMargin = 0;
        double totalExpense = 0;
        double totalRevenue = 0;

        Locale locale = new Locale("en", "US");
        NumberFormat currentFormatter = NumberFormat.getCurrencyInstance(locale);

        for (CompanyRevenue companyRevenue : companyRevenueList) {
            label.add(companyRevenue.getMonth());
            revenue.add(String.valueOf(companyRevenue.getRevenue()));
            totalExpense = totalMargin + companyRevenue.getExpense();
            totalMargin = totalMargin + companyRevenue.getMargins();
            totalRevenue = totalRevenue + companyRevenue.getRevenue();
        }
        populateCompanyRev.put("crLabels", label.toString());
        populateCompanyRev.put("crRevenue", revenue.toString());
        populateCompanyRev.put("totalExpense", currentFormatter.format(totalMargin));
        populateCompanyRev.put("totalMargin", currentFormatter.format(totalExpense));
        populateCompanyRev.put("totalRevenue", currentFormatter.format(totalRevenue));

        return populateCompanyRev;
    }

    @Override
    public List<ProductCategory> getBestCategory() {
        return productCategoryRepository.findByBestCategory(true);
    }

    public List<OrderReceived> getAllOrderReceived() {
        return orderReceivedRepository.findAll();
    }


    public List<OrderCollectionStatus> getAllOrderCollection() {
        return orderCollectionStatusRepository.findAll();
    }


    public List<EmployeeInformation> getAllEmployee() {
        return employeeInformationRepository.findAll();
    }


    public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }


    public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }


    public EmployeeInformation getEmployeeInformation(int pk) {
        return employeeInformationRepository.findByPk(pk);
    }


    public void deleteEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.delete(employeeInformation);
    }
}
