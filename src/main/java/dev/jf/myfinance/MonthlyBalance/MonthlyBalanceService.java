package dev.jf.myfinance.MonthlyBalance;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MonthlyBalanceService {

    private final MonthlyBalanceRepository repository;

    public MonthlyBalanceService(MonthlyBalanceRepository repository) {
        this.repository = repository;
    }

    public MonthlyBalance saveMonthlyBalance(MonthlyBalance monthlyBalance) {
        return repository.save(monthlyBalance);
    }

    public List<MonthlyBalance> getAllBalances() {
        return repository.findAll();
    }

    public List<MonthlyBalance> getBalancesByYear(Integer balanceYear) {
        return repository.findByBalanceYearOrderByBalanceMonthAsc(balanceYear);
    }

}
