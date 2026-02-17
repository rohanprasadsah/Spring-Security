package com.example.springsecurity.entity;

import java.util.Set;

public enum Role {
    ADMIN(Set.of(Permissions.WEATHER_DELETE,Permissions.WEATHER_READ,Permissions.WEATHER_WRITE)),
    USER(Set.of(Permissions.WEATHER_READ));
    
    private final Set<Permissions> permissions;

    Role(Set<Permissions> permission) {
        this.permissions=permission;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}
