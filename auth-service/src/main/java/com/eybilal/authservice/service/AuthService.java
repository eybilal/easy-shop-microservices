package com.eybilal.authservice.service;

import com.eybilal.authservice.model.entity.AppRole;
import com.eybilal.authservice.model.entity.AppUser;
import com.eybilal.authservice.model.pojo.UserStatus;

import java.util.List;

public interface AuthService {
    AppUser addUser(AppUser user);
    AppUser findUserByUsername(String username);
    List<AppUser> findAllUsers(UserStatus status);

    AppRole addRole(AppRole role);
    void addRoleToUser(String username, String roleName);
}
