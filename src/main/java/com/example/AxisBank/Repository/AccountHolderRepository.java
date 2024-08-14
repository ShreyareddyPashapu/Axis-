package com.example.AxisBank.Repository;

import com.example.AxisBank.Entity.AccountHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountHolderRepository extends CrudRepository<AccountHolder,Integer> {
    Optional<AccountHolder> findByMobileNumber(String mobileNumber);
    Optional<AccountHolder> findByAccountNumber(String accountNumber);


}
