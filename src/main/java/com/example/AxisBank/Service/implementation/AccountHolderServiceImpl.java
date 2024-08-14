package com.example.AxisBank.Service.implementation;

import com.example.AxisBank.Entity.AccountHolder;
import com.example.AxisBank.Exceptions.AccountHolderNotFoundException;
import com.example.AxisBank.Repository.AccountHolderRepository;
import com.example.AxisBank.Service.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {
@Autowired
private AccountHolderRepository repository;
    @Override
    public AccountHolder registerAccountHolder(AccountHolder accountHolder) {
        AccountHolder response = this.repository.save(accountHolder);
        return response;
    }

    @Override
    public AccountHolder updateAccountHolder(int id, AccountHolder updatedAccountHolder) {
        Optional<AccountHolder> optionalAccountHolder = repository.findById(id);

        if (optionalAccountHolder.isPresent()) {
            AccountHolder accountHolder = optionalAccountHolder.get();
            accountHolder.setName(updatedAccountHolder.getName());
            accountHolder.setAddress(updatedAccountHolder.getAddress());
            accountHolder.setMobileNumber(updatedAccountHolder.getMobileNumber());
            accountHolder.setAccountNumber(updatedAccountHolder.getAccountNumber());

            AccountHolder savedaccountholder =repository.save(accountHolder); // Save updated accountHolder back to repository

            return savedaccountholder; // Return updated AccountHolder wrapped in Optional
        } else {
            throw new AccountHolderNotFoundException("AccountHolder not found with  "+id);
        }
    }

    @Override
    public AccountHolder getAccountHolderById(Integer id) {
        {
            Optional<AccountHolder> optional = this.repository.findById(id);
            if (optional.isPresent()) {
                return optional.get();
            }
            throw new AccountHolderNotFoundException("AccountHolder not found with  " + id);

        }
    }

    @Override
        public AccountHolder getAccountHolderByMobileNumber(String mobile_no)
        {
            Optional<AccountHolder> optional  =this.repository.findByMobileNumber(mobile_no);
            if(optional.isPresent())
            {
                return optional.get();
            }
            throw new AccountHolderNotFoundException("AccountHolder not found with  "+mobile_no);
        }

        @Override
        public AccountHolder getAccountHolderByAccountNumber(String account_number) {
            Optional<AccountHolder> optional  =this.repository.findByAccountNumber(account_number);
            if(optional.isPresent())
            {
                return optional.get();
            }
            throw new AccountHolderNotFoundException("AccountHolder not found with  "+account_number);

        }

    @Override
    public List<AccountHolder> getAllAccountHolders() {
        List<AccountHolder> accountHolders = (List<AccountHolder>) this.repository.findAll();
        return accountHolders;
    }


}
