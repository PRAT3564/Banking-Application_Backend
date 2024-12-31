package com.pratham1.banking_app;

import com.pratham1.banking_app.dto.AccountDto;
import com.pratham1.banking_app.entity.Account;
import com.pratham1.banking_app.mapper.AccountMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountMapperTest {

    @Test
    void testMapToAccount() {
        // Given
        AccountDto accountDto = new AccountDto(1L, "John Doe", 5000.0);

        // When
        Account account = AccountMapper.mapToAccount(accountDto);

        // Then
        assertEquals(accountDto.getId(), account.getId());
        assertEquals(accountDto.getAccountHolderName(), account.getAccountHolderName());
        assertEquals(accountDto.getBalance(), account.getBalance());
    }

    @Test
    void testMapToAccountDto() {
        // Given
        Account account = new Account(2L, "Jane Doe", 7500.0);

        // When
        AccountDto accountDto = AccountMapper.mapToAccountDto(account);

        // Then
        assertEquals(account.getId(), accountDto.getId());
        assertEquals(account.getAccountHolderName(), accountDto.getAccountHolderName());
        assertEquals(account.getBalance(), accountDto.getBalance());
    }
}
