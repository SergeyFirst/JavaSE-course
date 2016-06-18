package com.company.basic.entitys;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
