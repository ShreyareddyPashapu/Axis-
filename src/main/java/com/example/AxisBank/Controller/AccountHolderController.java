package com.example.AxisBank.Controller;

import com.example.AxisBank.Entity.AccountHolder;
import com.example.AxisBank.Service.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/axis")
public class AccountHolderController {
    @Autowired
    private AccountHolderService service;
@PostMapping("/register")
    public AccountHolder registerAccountHolder(@Valid @RequestBody AccountHolder accountHolder)
    {
return this.service.registerAccountHolder(accountHolder);
    }

    @PutMapping("/update/{id}")
    public AccountHolder updateAccountHolder(@PathVariable int id, @RequestBody AccountHolder updatedAccountHolder)
    {
        return this.service.updateAccountHolder(id, updatedAccountHolder);
    }
    @GetMapping("/accountholder/id/{id}")
    public AccountHolder getAccountHolderById(@PathVariable Integer id)
    {
        return this.service.getAccountHolderById(id);
    }

    @GetMapping("/accountholder/mobileno/{mobile_no}")
    public AccountHolder getAccountHolderByMobileNumber(@PathVariable String mobile_no)
    {
return this.service.getAccountHolderByMobileNumber(mobile_no);
    }
    @GetMapping("/accountholder/accountnumber/{account_number}")
    public AccountHolder getAccountHolderByAccountNumber(@PathVariable String account_number)
    {
        return this.service.getAccountHolderByAccountNumber(account_number);
    }

    @GetMapping("/all")
    public List<AccountHolder> getAllAccountHolders()
    {
        return this.service.getAllAccountHolders();
    }
}
