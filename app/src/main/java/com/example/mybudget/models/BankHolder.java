package com.example.mybudget.models;

public class BankHolder {
    private int bankIcon;
    private String bankName;
    private String bankBalance;

    public BankHolder(int bankIcon, String bankName, String bankBalance) {
        this.bankBalance = bankBalance;
        this.bankIcon = bankIcon;
        this.bankName = bankName;
    }

    public int getBankIcon() {
        return bankIcon;
    }

    public String getBankBalance() {
        return bankBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankBalance(String bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void setBankIcon(int bankIcon) {
        this.bankIcon = bankIcon;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
