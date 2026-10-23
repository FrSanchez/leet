package com.splabs.Questions;

import java.util.*;

public class UserRolesSolution extends UserRoles {
    private String findRoleName(List<Feature> grants) {
        Set<Feature> set = new HashSet<>(grants);
        StringBuilder sb = new StringBuilder();
        for(var f: set) {
            sb.append(f);
        }
        return sb.toString();
    }
    @Override
    public List<Role> GenerateRoles(List<User> users) {
        var map = new HashMap<String, List<User>>();
        for(User user : users) {
            String roleName = findRoleName(user.grant());
            if(!map.containsKey(roleName)) {
                map.put(roleName, new ArrayList<>());
            }
            map.get(roleName).add(user);
        }
        List<Role> roles = new ArrayList<>();
        for(var roleName : map.keySet()) {
            var usersInRole = map.get(roleName);
            List<Account> accounts = new ArrayList<>();
            usersInRole.forEach(user -> { accounts.add(new Account(user)); });
            Role role = new Role(roleName, usersInRole.get(0).grant(),accounts);
            roles.add(role);
        }
        return roles;
    }
}
