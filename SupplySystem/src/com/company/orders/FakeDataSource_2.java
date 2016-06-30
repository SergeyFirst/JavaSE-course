package com.company.orders;

import com.company.entitys.Goods;
import com.company.entitys.GoodsManager;
import com.company.exceptions.BusinessException;
import com.company.exceptions.DataSourceException;
import com.company.filters.GoodsFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class FakeDataSource_2  implements DataSourceInterface {
    public static final int ORDER_LENGTH = 50;
    public static final Float ORDER_COUNT = 50f;

    @Override
    public ArrayList<DataSourceRecord> getData(int userID, Date dataBegin, Date dataEnd) throws DataSourceException, BusinessException {

        GoodsManager goodsManager = new GoodsManager();
        ArrayList<Goods> allGoodsList = goodsManager.find(new GoodsFilter());

        //Заполним список случайным образом
        ArrayList<DataSourceRecord> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < ORDER_LENGTH; i++) {
            DataSourceRecord record = new DataSourceRecord();
            record.goods = allGoodsList.get(random.nextInt(allGoodsList.size()));
            record.count = random.nextFloat()*ORDER_COUNT;
            result.add(record);
        }

        return result;
    }
}
