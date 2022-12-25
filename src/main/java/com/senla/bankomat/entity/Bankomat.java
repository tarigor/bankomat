package com.senla.bankomat.entity;

public class Bankomat {
    private double totalBalance;

    public Bankomat(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "Bankomat{" +
                "totalBalance=" + totalBalance +
                '}';
    }
}
