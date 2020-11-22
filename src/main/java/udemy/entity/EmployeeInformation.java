package udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "EmployeeInformation", schema = "ecomdashapp")
public class EmployeeInformation extends KeyEntity{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="position", nullable = false)
    private String position;

    @Column(name="officeLocation", nullable = false)
    private String officeLocation;

    @Column(name="age", nullable = false)
    private int age;

    @Column(name="startDate", nullable = false)
    private Date startDate;

    @Column(name="salary", nullable = false)
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
