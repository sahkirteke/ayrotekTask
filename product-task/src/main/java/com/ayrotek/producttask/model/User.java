package com.ayrotek.producttask.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TUSER")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "EMAIL")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = { CascadeType.DETACH, CascadeType.MERGE,
						CascadeType.PERSIST,CascadeType.REFRESH })
	@JoinTable(name = "TPRODUCT_USER", 
			   joinColumns = @JoinColumn(name = "USER_ID"), 
			   inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Product> products;

}
