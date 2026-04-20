package com.example.springlab.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PageDTO {
	private int startNum;
	private int endNum;
	private int countNum;
}
