package com.company.entitys;

import com.company.abstractions.Catalog;

@DBAnnotation(tableName = "goods")
public class Goods extends Catalog{

    @DBAnnotation(colomnName = "name", getter = "getName", setter = "setName")
    private String name;

    @DBAnnotation(colomnName = "height", getter = "getHeight", setter = "setHeight")
    private Float height;

    @DBAnnotation(colomnName = "width", getter = "getWidth", setter = "setWidth")
    private Float width;

    @DBAnnotation(colomnName = "depth", getter = "getDepth", setter = "setDepth")
    private Float depth;

    @DBAnnotation(colomnName = "weight", getter = "getWeight", setter = "setWeight")
    private Float weight;

    public Goods() {
        super();
    }

    public Goods(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
