package com.mitar.ebankservice.service;

import com.mitar.ebankservice.dto.BankAccountRequestDto;
import com.mitar.ebankservice.dto.BankAccountResponseDto;
import com.mitar.ebankservice.entities.BankAccount;
import com.mitar.ebankservice.mappers.AccountMapper;
import com.mitar.ebankservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private BankAccountRepository repository;
private AccountMapper mapper;

    public AccountServiceImpl(BankAccountRepository repositoryBank,AccountMapper accountMapper){
        repository=repositoryBank;
        mapper=accountMapper;
    }
    @Override
    public BankAccountResponseDto addAcount(BankAccountRequestDto bankAccountDto) {
        BankAccount account=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .createAt(new Date())
                .balance(bankAccountDto.getBalance())
                .build();

        BankAccount saveAccount= repository.save(account);

        BankAccountResponseDto accountResponseDto =mapper.fromBankAccount(saveAccount);
        return accountResponseDto;
    }
}
