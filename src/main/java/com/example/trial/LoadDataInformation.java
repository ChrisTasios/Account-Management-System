package com.example.trial;

import com.example.trial.entities.AccountEntity;
import com.example.trial.entities.BeneficiaryEntity;
import com.example.trial.entities.CsvLoadedEntity;
import com.example.trial.entities.TransactionEntity;
import com.example.trial.entities.enums.ActionType;
import com.example.trial.repositories.AccountRepository;
import com.example.trial.repositories.BeneficiaryRepository;
import com.example.trial.repositories.CsvLoadedRepository;
import com.example.trial.repositories.TransactionRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class LoadDataInformation {

    private final BeneficiaryRepository beneficiaryRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final CsvLoadedRepository csvLoadedRepository;

    public LoadDataInformation(final BeneficiaryRepository beneficiaryRepository, final AccountRepository accountRepository, final TransactionRepository transactionRepository, final CsvLoadedRepository csvLoadedRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.csvLoadedRepository = csvLoadedRepository;
    }
    private static final Logger log = LoggerFactory.getLogger(LoadDataInformation.class);


    @EventListener(ApplicationReadyEvent.class)
    public void importData() throws IOException, CsvException {

        if (csvLoadedRepository.findAll().isEmpty()) {
            log. info("Loading data from CSV files ............");
            URL beneficiaryFile = Optional.ofNullable(LoadDataInformation.class.getClassLoader().getResource("beneficiaries.csv")).orElseThrow(() -> new RuntimeException("Beneficiary csv not found"));
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(beneficiaryFile.getFile()))
                    .withSkipLines(1)
                    .build();

            List<BeneficiaryEntity> beneficiaryEntities = new ArrayList<>();

            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                BeneficiaryEntity beneficiary = new BeneficiaryEntity();
                beneficiary.setId(Long.valueOf(record[0]));
                beneficiary.setName(record[1]);
                beneficiary.setLastName(record[2]);
                beneficiaryEntities.add(beneficiary);
            }
            beneficiaryRepository.saveAll(beneficiaryEntities);
//----------------------------------------------------------------------------------------------------------------
            URL accountFile = Optional.ofNullable(LoadDataInformation.class.getClassLoader().getResource("accounts.csv")).orElseThrow(() -> new RuntimeException("Accounts csv not found"));
            CSVReader csvReader1 = new CSVReaderBuilder(new FileReader(accountFile.getFile()))
                    .withSkipLines(1)
                    .build();

            List<AccountEntity> accountEntities = new ArrayList<>();


            List<String[]> records1 = csvReader1.readAll();

            for (String[] record : records1) {
                AccountEntity account = new AccountEntity();
                account.setId(Long.valueOf(record[0]));
                account.setBeneficiaryEntity(beneficiaryRepository.getReferenceById(Long.valueOf(record[1])));
                accountEntities.add(account);
            }
            accountRepository.saveAll(accountEntities);
//----------------------------------------------------------------------------------------------------------------
            URL transactionsFile = Optional.ofNullable(LoadDataInformation.class.getClassLoader().getResource("transactions.csv")).orElseThrow(() -> new RuntimeException("Transaction csv not found."));
            CSVReader csvReader3 = new CSVReaderBuilder(new FileReader(transactionsFile.getFile()))
                    .withSkipLines(1)
                    .build();

            List<TransactionEntity> transactionEntities = new ArrayList<>();


            List<String[]> records3 = csvReader3.readAll();

            for (String[] record : records3) {
                TransactionEntity transaction = new TransactionEntity();
                transaction.setId(Long.valueOf(record[0]));
                transaction.setAccount(accountRepository.getReferenceById(Long.valueOf(record[1])));
                transaction.setAmount(Double.parseDouble(record[2]));
                transaction.setType(ActionType.valueOf(record[3].toUpperCase()));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
                LocalDate localDate = LocalDate.parse(record[4], formatter);
                transaction.setDate(localDate);
                transactionEntities.add(transaction);
            }
            transactionRepository.saveAll(transactionEntities);

            csvLoadedRepository.save(new CsvLoadedEntity(true));
            log.info("Loading completed");
        }
    }
}
