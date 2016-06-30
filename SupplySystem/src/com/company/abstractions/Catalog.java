package com.company.abstractions;

import com.company.entitys.DBAnnotation;

import java.util.HashMap;

public abstract class Catalog {

    @DBAnnotation(colomnName = "id", setter = "setID")
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
