package com.mengyu.backend.Model.dataValueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class StorageData {
    @Id
    private String id;

    private String itemName;

    private String expDate;

    private int quantity;
}
