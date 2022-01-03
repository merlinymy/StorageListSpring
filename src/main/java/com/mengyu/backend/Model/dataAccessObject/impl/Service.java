package com.mengyu.backend.Model.dataAccessObject.impl;

import com.mengyu.backend.Model.dataAccessObject.StorageService;
import com.mengyu.backend.Model.dataValueObject.StorageData;
import com.mengyu.backend.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@org.springframework.stereotype.Service
public class Service implements StorageService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<StorageData> getAllRecords() {
        return itemRepo.findAll();
    }

    @Override
    public StorageData saveRecord(StorageData storageData) {
        return itemRepo.save(storageData);
    }

    @Override
    public StorageData findId(String id) {
        try {
            return itemRepo.findById(id).get();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Id#: " + id + "does not match anything in the database.");
            return null;
        }
    }
    @Override
    public void deleteById(String id) {
        try {
            itemRepo.deleteById(id);
            StorageData item = itemRepo.findById(id).get();
            System.out.println("Item " + item.getItemName() + " removed from the database.");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Id#: " + id + "does not exists");
        }
    }
}
