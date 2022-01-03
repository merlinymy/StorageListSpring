package com.mengyu.backend.repository;

import com.mengyu.backend.Model.dataValueObject.StorageData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<StorageData, String> {

}
