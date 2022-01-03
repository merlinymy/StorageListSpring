package com.mengyu.backend.Model.dataAccessObject;


import com.mengyu.backend.Model.dataValueObject.StorageData;

import java.util.List;
import java.util.Optional;

//@Service //here Service is better than Component, because the easy understanding
////However, service is a part of Component. Like one blade on a "Swiss knife"
public interface StorageService {
    List<StorageData> getAllRecords();
    StorageData saveRecord(StorageData storageData);
    StorageData findId(String id);
    void deleteById(String id);
}
