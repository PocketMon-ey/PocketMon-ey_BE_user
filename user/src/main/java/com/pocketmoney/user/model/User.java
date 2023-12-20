package com.pocketmoney.user.model;

import lombok.Data;

@Data
public class User {
	private int id;
	private String name;
	private String account;
	private int balance;
	private int level;
	private double preferInterestRate;
	private int familyId;
}