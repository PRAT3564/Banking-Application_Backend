package com.pratham1.banking_app;

import com.pratham1.banking_app.controller.AccountController;
import com.pratham1.banking_app.dto.AccountDto;
import com.pratham1.banking_app.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddAccount(){
        AccountDto mockAccount = new AccountDto(1L, "John", 1000.0);
        when(accountService.createAccount(mockAccount)).thenReturn(mockAccount);

        ResponseEntity<AccountDto> response = accountController.addAccount(mockAccount);

        assertEquals(mockAccount, response.getBody());
        verify(accountService).createAccount(mockAccount);
    }

    @Test
    void testGetAccount(){
        AccountDto mockAccount = new AccountDto(1L, "Johnny", 2000.0);
        when(accountService.getAccountById(1L)).thenReturn(mockAccount);

        ResponseEntity<AccountDto> response = accountController.getAccountById(1L);

        assertEquals(mockAccount, response.getBody());
        verify(accountService).getAccountById(1L);
    }

    @Test
    void testDeposit(){
        AccountDto updateAccount = new AccountDto(1L, "Jack", 3000.0);
        when(accountService.deposit(1L, 1000.0)).thenReturn(updateAccount);

        ResponseEntity<AccountDto> response = accountController.deposit(1L, Map.of("amount", 1000.0));

        assertEquals(updateAccount, response.getBody());
        verify(accountService).deposit(1L, 1000.0);
    }

    @Test
    void testWithdraw(){
        AccountDto updateAccount = new AccountDto(1L, "Jacky", 4000.0);
        when(accountService.withdraw(1L, 1000.0)).thenReturn(updateAccount);

        ResponseEntity<AccountDto> response = accountController.withdraw(1L, Map.of("amount", 1000.0));

        assertEquals(updateAccount, response.getBody());
        verify(accountService).withdraw(1L, 1000.0);
    }

    @Test
    void testGetAllAccounts(){
        List<AccountDto> accounts = Arrays.asList(
                new AccountDto(1L, "Jessica", 2000.0),
                new AccountDto(2L, "Rebbica", 1000.0)
        );

        when(accountService.getAllAccounts()).thenReturn(accounts);

        ResponseEntity<List<AccountDto>> response = accountController.getAllAccounts();

        assertEquals(accounts, response.getBody());
        verify(accountService).getAllAccounts();
    }

    @Test
    void testDeleteAccount(){
        doNothing().when(accountService).deleteAccount(1L);

        ResponseEntity<String> response = accountController.deleteAccount(1L);

        assertEquals("Account is deleted successfully!" ,response.getBody());
        verify(accountService).deleteAccount(1L);
    }

}
