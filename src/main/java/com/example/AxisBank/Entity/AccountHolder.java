package com.example.AxisBank.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name ="accountholder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column
    @NotNull(message = "AccountHolder name should be declare")
    private String name;
    @Column
    @NotNull(message = "AccountHolder address should be declare")
    private String address;
    @Column(name="mobile_no")
    @NotNull(message = "AccountHolder mobile_no should be enter")
    private String mobileNumber;
    @Column(name ="account_number")
    @NotNull(message= "AccountHolder accountnumber should be enter")
    private String accountNumber;
}
