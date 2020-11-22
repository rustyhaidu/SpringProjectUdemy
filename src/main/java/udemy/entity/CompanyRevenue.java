package udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CompanyRevenue", schema = "ecomdashapp")
public class CompanyRevenue extends KeyEntity {

    @Column(name = "Revenue_Month", nullable = false)
    private String month;

    @Column(name = "revenue", nullable = false)
    private double revenue;

    @Column(name = "expense", nullable = false)
    private double expense;

    @Column(name = "margins", nullable = false)
    private double margins;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getMargins() {
        return margins;
    }

    public void setMargins(double margins) {
        this.margins = margins;
    }
}
