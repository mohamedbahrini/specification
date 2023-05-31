package com.example.specification.dao;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class GenericSpecificationsBuilder<T> {

    public Specification<T> build(List<SpecSearchCriteria> params) {
        if (params.size() == 0) return null;

        Specification<T> result = new GenericSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate() ? result.or(new GenericSpecification(params.get(i))) : result.and(new GenericSpecification(params.get(i)));
        }

        return result;
    }

}
