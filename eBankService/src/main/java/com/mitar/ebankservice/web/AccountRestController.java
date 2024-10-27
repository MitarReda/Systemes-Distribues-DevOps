package com.mitar.ebankservice.web;

import com.mitar.ebankservice.dto.BankAccountRequestDto;
import com.mitar.ebankservice.dto.BankAccountResponseDto;
import com.mitar.ebankservice.entities.BankAccount;
import com.mitar.ebankservice.repositories.BankAccountRepository;
import com.mitar.ebankservice.service.AccountServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountServiceImpl service;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankaccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankaccounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/banckaccounts")
    public BankAccountResponseDto Save(@RequestBody BankAccountRequestDto bankAccountDto){
        //if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        //return bankAccountRepository.save(bankAccount);
        return service.addAcount(bankAccountDto);
    }

    @PutMapping("/banckaccounts/{id}")
    public  BankAccount Update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreateAt()!=null) account.setCreateAt(new Date());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/banckaccounts/{id}")
    public void Delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
