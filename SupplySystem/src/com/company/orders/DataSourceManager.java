package com.company.orders;

import com.company.config.Settings;
import com.company.exceptions.BusinessException;
import com.company.exceptions.DataSourceException;

import java.util.ArrayList;
import java.util.Date;

public class DataSourceManager {

    private ArrayList<DataSourceInterface> dataSourceList;

    public DataSourceManager() throws DataSourceException {
        this.dataSourceList = new ArrayList<>();
        int sourceCount = Integer.parseInt(Settings.getProperty(Settings.DATA_SOURCE_COUNT));
        String sourceName = Settings.getProperty(Settings.NAME_OF_PROPERTY_DATA_SOURCE);
        for (int i = 1; i <= sourceCount; i++) {
            try {
                Class clazz = Class.forName(Settings.getProperty(sourceName+i));
                dataSourceList.add((DataSourceInterface) clazz.newInstance());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new DataSourceException(e.getMessage());
            }
        }
    }

    public ArrayList<DataSourceRecord> getData(int userID, Date dataBegin, Date dataEnd) throws DataSourceException, BusinessException {
        ArrayList<DataSourceRecord> result = new ArrayList<>();

        for (DataSourceInterface dataSource : dataSourceList) {
            result.addAll(dataSource.getData(userID, dataBegin, dataEnd));
        }

        return result;
    }

}
