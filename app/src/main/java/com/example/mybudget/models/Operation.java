package com.example.mybudget.models;


public class Operation {
    private String operationName;
    private String operationDate;
    private String operationSumSTRING;
    private int operationSumINT;
    private String operationDesc;
    private String operationCategory;
    private String operationCurrency;
    private String operationType;

    public Operation(String operationName, String operationDate, String operationCurrency,
                     int operationSum, String operationType, String operationDesc,
                     String operationCategory) {
        this.operationType = operationType;
        this.operationName = operationName;
        this.operationDate = operationDate;
        this.operationCurrency = operationCurrency;
        this.operationDesc = operationDesc;
        this.operationCategory = operationCategory;
        this.operationSumINT = operationSum;

        switch (this.operationCurrency) {
            case "USD":
                this.operationSumSTRING = Integer.toString(operationSum) + '$';
                break;
            case "RUB":
                this.operationSumSTRING = Integer.toString(operationSum) + '₽';
                break;
            case "EUR":
                this.operationSumSTRING = Integer.toString(operationSum) + '€';
                break;
            case "ZLOTY":
                this.operationSumSTRING = Integer.toString(operationSum) + "zł";
                break;
            case "BYR":
                this.operationSumSTRING = Integer.toString(operationSum) + "Br";
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

    public String getOperationSumSTRING() {
        return operationSumSTRING;
    }
    public int getOperationSumINT() { return operationSumINT; }

    public String getOperationDesc() {
        return operationDesc;
    }

    public String getOperationCategory() { return operationCategory; }

    public String getOperationCurrency() { return operationCurrency; }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setOperationSumSTRING(int operationSumSTRING) {
        switch (this.operationCurrency) {
            case "USD":
                this.operationSumSTRING = Integer.toString(operationSumSTRING) + '$';
                break;
            case "RUB":
                this.operationSumSTRING = Integer.toString(operationSumSTRING) + '₽';
                break;
            case "EUR":
                this.operationSumSTRING = Integer.toString(operationSumSTRING) + '€';
                break;
            case "ZLOTY":
                this.operationSumSTRING = Integer.toString(operationSumSTRING) + "zł";
                break;
            case "BYR":
                this.operationSumSTRING = Integer.toString(operationSumSTRING) + "Br";
                break;
            default:
                break;
        }
    }

    public void setOperationCurrency(String operationCurrency) {
        this.operationCurrency = operationCurrency;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public void setOperationCategory(String operationCategory) {
        this.operationCategory = operationCategory;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
