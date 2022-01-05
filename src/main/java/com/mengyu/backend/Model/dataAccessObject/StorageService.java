package com.mengyu.backend.Model.dataAccessObject;


import com.mengyu.backend.Model.dataValueObject.StorageData;

import java.util.List;

//@Service //here Service is better than Component, because the easy understanding
////However, service is a part of Component. Like one blade on a "Swiss knife"
public interface StorageService {
    List<StorageData> findRecordsByNameOrderByExpDate(String itemName);
    StorageData updateRecord(String id, StorageData storageData);
    StorageData findById(String id);
    void deleteById(String id);
    StorageData createNew(StorageData storageData);
    List<StorageData> findAllOrderByExpDate();
}
