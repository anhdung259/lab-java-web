/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import java.io.Serializable;

/**
 *
 * @author Haima
 */
public class TransactionDto implements Serializable{
    int transactionID;
    String username, Payment, transactionDate;
    float amountOfMoney;

    public int getTransactionID() {
        return transactionID;
    }

    public TransactionDto(int transactionID, String username, String Payment, String transactionDate, float amountOfMoney) {
        this.transactionID = transactionID;
        this.username = username;
        this.Payment = Payment;
        this.transactionDate = transactionDate;
        this.amountOfMoney = amountOfMoney;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionDto(String username, String transactionDate, float amountOfMoney) {
        this.username = username;
        this.transactionDate = transactionDate;
        this.amountOfMoney = amountOfMoney;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String Payment) {
        this.Payment = Payment;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
    
}
