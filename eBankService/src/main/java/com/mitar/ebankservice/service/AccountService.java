package com.mitar.ebankservice.service;

import com.mitar.ebankservice.dto.BankAccountRequestDto;
import com.mitar.ebankservice.dto.BankAccountResponseDto;
import com.mitar.ebankservice.entities.BankAccount;

public interface AccountService {
    BankAccountResponseDto addAcount(BankAccountRequestDto bankAccountDto);
}
