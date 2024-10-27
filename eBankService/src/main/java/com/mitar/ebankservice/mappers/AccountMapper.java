package com.mitar.ebankservice.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mitar.ebankservice.dto.BankAccountRequestDto;
import com.mitar.ebankservice.dto.BankAccountResponseDto;
import com.mitar.ebankservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount){

        BankAccountResponseDto responseDto=new BankAccountResponseDto();

        BeanUtils.copyProperties(bankAccount,responseDto);

        return responseDto;
    }


}
