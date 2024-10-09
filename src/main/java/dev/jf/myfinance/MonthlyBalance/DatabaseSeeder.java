package dev.jf.myfinance.MonthlyBalance;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private MonthlyBalanceRepository repository;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {
            try {
                // Load and parse the JSON file
                InputStream inputStream = new ClassPathResource("balances.json").getInputStream();

                // Convert JSON array into List of MonthlyBalance objects
                List<MonthlyBalance> balances = objectMapper.readValue(inputStream, new TypeReference<List<MonthlyBalance>>() {});

                // Iterate through the list and save each entry to the database
                System.out.println("Seeding Started");
                for (MonthlyBalance balance : balances) {
                    repository.save(balance);
                    System.out.println("Balance Saved: " + balance);
                }
                
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        }
        else {
            System.out.println("Not seeding database from JSON because there already is data in the database");
        }

        
    }
}
