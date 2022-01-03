package com.mengyu.backend.controller;


import com.mengyu.backend.Model.dataAccessObject.impl.Service;
import com.mengyu.backend.Model.dataValueObject.StorageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageListController {
    @Autowired
    private Service service;


    @GetMapping()
    public List<StorageData> getAllEntries() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public StorageData getItemByData(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public StorageData createNew(@RequestBody StorageData storageData) {
        return service.createNew(storageData);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public StorageData update(@PathVariable String id, @RequestBody StorageData storageData) {
        return service.updateRecord(id, storageData);
    }


}
