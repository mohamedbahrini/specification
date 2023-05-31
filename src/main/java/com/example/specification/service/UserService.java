package com.example.specification.service;

import com.example.specification.model.UserProfile;

import java.util.List;

public interface UserService {
    List<UserProfile> getByUsername(List<String> names);
}
