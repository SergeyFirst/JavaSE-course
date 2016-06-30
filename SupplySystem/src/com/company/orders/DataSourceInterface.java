package com.company.orders;

import com.company.exceptions.BusinessException;
import com.company.exceptions.DataSourceException;

import java.util.ArrayList;
import java.util.Date;

public interface DataSourceInterface {

    public ArrayList<DataSourceRecord> getData(int userID, Date dataBegin, Date dataEnd) throws DataSourceException, BusinessException;

}
