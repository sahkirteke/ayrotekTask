package com.ayrotek.producttask.model.dto;

import java.util.List;

import com.ayrotek.producttask.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private long id;

	private String email;

	private List<Product> products;

}
