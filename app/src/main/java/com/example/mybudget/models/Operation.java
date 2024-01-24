package com.example.mybudget.models;


import com.example.mybudget.enums.CurrencyEnum;
import com.example.mybudget.enums.OperationType;
import com.example.mybudget.enums.PurchaseCategory;

public class Operation {
    private String operationName;
    private String operationDate;
    private String operationSum;
    private String operationDesc;
    private PurchaseCategory operationCategory;
    private CurrencyEnum currencyEnum;
    private OperationType operationType;

    public Operation(String operationName, String operationDate, CurrencyEnum currencyEnum,
                     int operationSum, OperationType operationType, String operationDesc,
                     PurchaseCategory operationCategory) {
        this.operationType = operationType;
        this.operationName = operationName;
        this.operationDate = operationDate;
        this.currencyEnum = currencyEnum;
        this.operationDesc = operationDesc;
        this.operationCategory = operationCategory;
        switch (this.currencyEnum) {
            case USD:
                this.operationSum = Integer.toString(operationSum) + '$';
                break;
            case RUB:
                this.operationSum = Integer.toString(operationSum) + '₽';
                break;
            case EUR:
                this.operationSum = Integer.toString(operationSum) + '€';
                break;
            case ZLOTY:
                this.operationSum = Integer.toString(operationSum) + "zł";
                break;
            case BYR:
                this.operationSum = Integer.toString(operationSum) + "Br";
                break;
            default:
                break;
        }
    }

    public String getOperationName() {
        return operationName;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public String getOperationSum() {
        return operationSum;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public PurchaseCategory getOperationCategory() { return operationCategory; }

    public CurrencyEnum getCurrencyEnum() { return currencyEnum; }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setOperationSum(int operationSum) {
        switch (currencyEnum) {
            case USD:
                this.operationSum = Integer.toString(operationSum) + '$';
                break;
            case RUB:
                this.operationSum = Integer.toString(operationSum) + '₽';
                break;
            case EUR:
                this.operationSum = Integer.toString(operationSum) + '€';
                break;
            case ZLOTY:
                this.operationSum = Integer.toString(operationSum) + "zł";
                break;
            case BYR:
                this.operationSum = Integer.toString(operationSum) + "Br";
                break;
            default:
                break;
        }
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public void setOperationCategory(PurchaseCategory operationCategory) {
        this.operationCategory = operationCategory;
    }

    public void setCurrencyEnum(CurrencyEnum currencyEnum) {
        this.currencyEnum = currencyEnum;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
