package com.mengyu.backend.repository;

import com.mengyu.backend.Model.dataValueObject.StorageData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepo extends MongoRepository<StorageData, String> {
    List<StorageData> findAllByItemNameOrderByExpDate(String itemName);
    List<StorageData> findAllByOrderByExpDate();
}
