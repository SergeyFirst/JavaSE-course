package com.company.entitys;

import com.company.abstractions.CatalogManager;

public class GoodsManager extends CatalogManager<Goods>{

    public GoodsManager() {
        super(Goods.class);
    }

}
