package com.phone.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
 
    private String name;
 
    private String phone;

}
