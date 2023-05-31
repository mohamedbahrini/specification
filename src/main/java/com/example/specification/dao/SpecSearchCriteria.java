package com.example.specification.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecSearchCriteria {

    private String key;
    private SearchOperation operation;
    private Object value;
    private boolean orPredicate;

    public SpecSearchCriteria(String key, String operation, String value, boolean orPredicate) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        this.key = key;
        this.operation = op;
        this.value = value;
        this.orPredicate = orPredicate;
    }
}
