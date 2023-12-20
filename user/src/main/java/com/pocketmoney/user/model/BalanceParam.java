package com.pocketmoney.user.model;

import lombok.Data;

@Data
public class BalanceParam {
    public BalanceParam(int id1, int id2, int price) {
        this.id1 = id1;
        this.id2 = id2;
        this.price = price;
    }
    private int id1;
    private int id2;
    private int price;
}
