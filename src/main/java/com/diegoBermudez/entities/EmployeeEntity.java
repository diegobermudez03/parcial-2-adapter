package com.diegoBermudez.entities;

public record EmployeeEntity(
        int id,
        double salary,
        String name,
        String role,
        String tech,
        String email
) {
}
