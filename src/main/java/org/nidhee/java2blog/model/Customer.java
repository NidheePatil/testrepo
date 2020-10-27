package org.nidhee.java2blog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="customerName")
    String customerName;

    @Column(name="email")
    String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreignId", referencedColumnName = "id")
    private List<Address> address= new ArrayList<>();

    public Customer() {
        super();
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Customer(String customerName, String email) {
        super();
        this.customerName=customerName;
        this.email=email;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

}

