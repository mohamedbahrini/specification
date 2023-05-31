package com.example.specification.service.impl;

import com.example.specification.dao.GenericSpecificationsBuilder;
import com.example.specification.dao.SpecSearchCriteria;
import com.example.specification.model.UserProfile;
import com.example.specification.repository.UserRepository;
import com.example.specification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserProfile> getByUsername(List<String> names) {
        List<SpecSearchCriteria> searchCriteriaList = new ArrayList<>();

        Field[] fields = UserProfile.class.getDeclaredFields();
        for (Field field: fields) {
            if(field.getName().equals("id")) {
                continue;
            }
            for (String name : names) {
                searchCriteriaList.add(new SpecSearchCriteria(field.getName(), "~", name, true));
            }
        }

        GenericSpecificationsBuilder<UserProfile> specificationsBuilder = new GenericSpecificationsBuilder<>();
        Specification<UserProfile> specification = specificationsBuilder.build(searchCriteriaList);
        return userRepository.findAll(specification);
    }
}
