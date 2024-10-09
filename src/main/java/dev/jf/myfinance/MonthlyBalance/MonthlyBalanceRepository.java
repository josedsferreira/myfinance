package dev.jf.myfinance.MonthlyBalance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyBalanceRepository extends JpaRepository<MonthlyBalance, Integer>{

    // example of possible methods:
    List<MonthlyBalance> findByBalanceYearOrderByBalanceMonthAsc(Integer balanceYear);
}
