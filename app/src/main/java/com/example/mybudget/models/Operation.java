package com.example.mybudget.models;


public class Operation {
    private String operationName;
    private String operationDate;
    private String operationSum;
    private String operationDesc;

    public Operation(String operationName, String operationDate,
                     int operationSum, String operationDesc) {
        this.operationName = operationName;
        this.operationDate = operationDate;
        this.operationSum = Integer.toString(operationSum) + '₽';
        this.operationDesc = operationDesc;
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

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setOperationSum(int operationSum) {
        this.operationSum = Integer.toString(operationSum) + '₽';
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }
}
