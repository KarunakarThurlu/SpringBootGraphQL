package com.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String customerPhoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private List<Address> customerAddress= new ArrayList<>();
    private String customerSignUpDate;
    private Boolean customerAccountVerified;


}
