package com.example.mybudget.models;

import java.util.List;


public class OperationItem {
    private String operationName;
    private String operationAuthor;
    private String operationDate;
    private List<String> operations;
    private int operationSum;

    public OperationItem(String operationName, String operationAuthor, String operationDate,
                         List<String> operations, int operationSum) {
        this.operationName = operationName;
        this.operationAuthor = operationAuthor;
        this.operationDate = operationDate;
        this.operations = operations;
        this.operationSum = operationSum;
    }


    public String getOperationName() {
        return operationName;
    }

    public String getOperationAuthor() {
        return operationAuthor;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public List<String> getOperations() {
        return operations;
    }

    public int getOperationSum() {
        return operationSum;
    }

    public void setOperationAuthor(String operationAuthor) {
        this.operationAuthor = operationAuthor;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public void setOperationSum(int operationSum) {
        this.operationSum = operationSum;
    }
}
