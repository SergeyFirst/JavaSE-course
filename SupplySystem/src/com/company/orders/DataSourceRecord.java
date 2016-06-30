package com.company.orders;

import com.company.entitys.Goods;

public class DataSourceRecord {

    public Goods goods;
    public Float count;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }
}
