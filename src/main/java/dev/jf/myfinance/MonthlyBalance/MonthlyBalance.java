package dev.jf.myfinance.MonthlyBalance;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "balances")
public class MonthlyBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    BigDecimal amount;
    Integer balanceYear;
    Integer balanceMonth;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Integer getBalanceYear() {
        return balanceYear;
    }
    public void setBalanceYear(Integer balanceYear) {
        this.balanceYear = balanceYear;
    }
    public Integer getBalanceMonth() {
        return balanceMonth;
    }
    public void setBalanceMonth(Integer balanceMonth) {
        this.balanceMonth = balanceMonth;
    }

}

