package com.pocketmoney.user.model;

import lombok.Data;

@Data
public class Family{
    private int familyId;
    private int carerId;
    private int firstChild;
    private int secondChild;
    private double familyRate;
}