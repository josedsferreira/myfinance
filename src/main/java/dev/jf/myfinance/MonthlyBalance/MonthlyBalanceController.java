package dev.jf.myfinance.MonthlyBalance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from Next.js ap
public class MonthlyBalanceController {

    @Autowired
    private MonthlyBalanceService balanceService;

    @GetMapping("/balances")
    public List<MonthlyBalance> getAllBalances() {
        return balanceService.getAllBalances();
    }

    @PostMapping("/balances")
    public ResponseEntity<MonthlyBalance> saveBalance(@RequestBody MonthlyBalance balance) {
        MonthlyBalance savedBalance = balanceService.saveMonthlyBalance(balance);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBalance);
    }

}
