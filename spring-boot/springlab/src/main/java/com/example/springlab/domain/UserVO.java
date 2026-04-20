package com.example.springlab.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserVO {
	private String userName;
	private String address;
	private String[] favoriteFruit;
}
