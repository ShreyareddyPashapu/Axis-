package com.example.AxisBank.Service;

import com.example.AxisBank.Entity.AccountHolder;

import java.util.List;

public interface AccountHolderService {

    AccountHolder registerAccountHolder(AccountHolder accountHolder);
    AccountHolder updateAccountHolder(int id ,AccountHolder updatedAccountHolder);
    AccountHolder getAccountHolderById(Integer id);
    AccountHolder getAccountHolderByMobileNumber(String mobile_no);
    AccountHolder getAccountHolderByAccountNumber(String account_number);
    List<AccountHolder> getAllAccountHolders();




}
