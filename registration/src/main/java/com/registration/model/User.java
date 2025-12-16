package com.registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class User {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Long id;
       private String usrname="Nikil";
       private String email="nikil@gmail.com";
       private String password = "2200090107";
       private String phno="1234567890";
       // we cannot give values in this class
       //its a model class
}
