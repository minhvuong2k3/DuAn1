package com.raven.model;

import com.raven.table.model.TableRowData;

public class ProductCard extends TableRowData {

    private String ID;
    private String Name;
    private int Amount;

    public ProductCard() {
    }

    public ProductCard(String ID, String Name, int Amount) {
        this.ID = ID;
        this.Name = Name;
        this.Amount = Amount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{ID, Name, Amount};
    }
}

