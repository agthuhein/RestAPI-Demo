package com.restapi.demo.PersonExpenseTracker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


//@Data - getters, setters, toString(), equals(), hashCode()
@Data
public class Expense {
    @JsonProperty("expenseType")
    private int expenseType;

    @JsonProperty("date")
    private String date;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("category")
    private String category;

    @JsonProperty("account")
    private String account;

    @JsonProperty("note")
    private String note;
}
