package com.diegoBermudez.adapter;

import com.diegoBermudez.entities.EmployeeEntity;
import com.diegoBermudez.rest_api.EmployeesRestApi;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class EmployeesRestAdapter implements EmployeesAdapter{

    private EmployeesRestApi api;

    public EmployeesRestAdapter(){
        this.api = new EmployeesRestApi();
    }
    @Override
    public EmployeeEntity getEmployee(int id) {
        final ImmutablePair<String, EmployeeEntity> response = api.getEmployeeWithId(id);
        if(response.getRight() != null) return response.getRight();
        return null;
    }
}
