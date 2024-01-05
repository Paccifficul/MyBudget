package com.example.mybudget.models;


public class Operation {
    private int operationNum;
    private String operationName;
    private String operationDate;
    private String operationSum;
    private String operationDesc;
    private String operationCategory;

    public Operation(int operationNum, String operationName, String operationDate,
                     int operationSum, String operationDesc, String operationCategory) {
        this.operationNum = operationNum;
        this.operationName = operationName;
        this.operationDate = operationDate;
        this.operationSum = Integer.toString(operationSum) + '₽';
        this.operationDesc = operationDesc;
        this.operationCategory = operationCategory;
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

    public String getOperationCategory() { return operationCategory; }

    public void setOperationNum(int operationNum) { this.operationNum = operationNum; }

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

    public void setOperationCategory(String operationCategory) {
        this.operationCategory = operationCategory;
    }
}
