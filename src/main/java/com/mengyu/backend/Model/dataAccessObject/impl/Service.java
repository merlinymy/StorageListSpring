package com.mengyu.backend.Model.dataAccessObject.impl;

import com.mengyu.backend.Model.dataAccessObject.StorageService;
import com.mengyu.backend.Model.dataValueObject.StorageData;
import com.mengyu.backend.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@org.springframework.stereotype.Service
public class Service implements StorageService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<StorageData> findRecordsByNameOrderByExpDate(String itemName) {
        return itemRepo.findAllByItemNameOrderByExpDate(itemName);
    }

    @Override
    public StorageData updateRecord(@PathVariable String id, @RequestBody StorageData storageData) {
        System.out.println("entry updated");
        StorageData old = itemRepo.findById(id).get();
        System.out.println("item " + old.getItemName() + " updated");
        return itemRepo.save(storageData);
    }

    @Override
    public StorageData findById(String id) {
        try {
            return itemRepo.findById(id).get();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Id#: " + id + " does not match anything in the database.");
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
            System.out.println("Id#: " + id + " does not exists");
        }
    }


    @Override
    public StorageData createNew(StorageData storageData) {
        System.out.println("item added");
        return itemRepo.save(storageData);
    }

    @Override
    public List<StorageData> findAllOrderByExpDate() {
        return itemRepo.findAllByOrderByExpDate();
    }
}
