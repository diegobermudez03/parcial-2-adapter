package com.diegoBermudez.adapter;

import com.diegoBermudez.entities.EmployeeEntity;
import com.diegoBermudez.rest_api.EmployeesRestApi;

public class EmployeesRestAdapter implements EmployeesAdapter{

    private EmployeesRestApi api;

    public EmployeesRestAdapter(){
        this.api = new EmployeesRestApi();
    }
    @Override
    public EmployeeEntity getEmployee(int id) {
        final var response = api.getEmployeeWithId(id);
        if(response.getRight() != null) return response.getRight();
        return null;
    }
}
