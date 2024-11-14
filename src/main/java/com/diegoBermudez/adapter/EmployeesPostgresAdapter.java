package com.diegoBermudez.adapter;

import com.diegoBermudez.database.DatabaseError;
import com.diegoBermudez.database.EmployeesPostgres;
import com.diegoBermudez.entities.EmployeeEntity;

public class EmployeesPostgresAdapter implements  EmployeesAdapter{

    private EmployeesPostgres db;

    public EmployeesPostgresAdapter(){
        this.db = new EmployeesPostgres();
    }

    @Override
    public EmployeeEntity getEmployee(int id) {
        try{
            return db.findEmployeeById(id);
        }catch(DatabaseError e){
            return null;
        }
    }
}
