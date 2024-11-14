package com.diegoBermudez.database;

import com.diegoBermudez.entities.EmployeeEntity;
import com.diegoBermudez.utilidades.UtilidadesAcceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class EmployeesPostgres {

    private String url;
    private String user;
    private String password;


    EmployeesPostgres(){
        Properties props = UtilidadesAcceso.loadProperty(
                "com/propiedades/portgreProperties.properties");
        String url = props.getProperty("url");
        this.user = props.getProperty("user");
        this.password = props.getProperty("password");
        this.user = "jdbc:postgresql://" + url;
    }

    EmployeeEntity findEmployeeById(int idPam) throws DatabaseError {
        EmployeeEntity employee;
        String query = "SELECT id, salary, name, role, tech, email FROM employees WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idPam);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String tech = resultSet.getString("tech");
                String email = resultSet.getString("email");
                employee = new EmployeeEntity(id, salary, name, role, tech, email);
            }else{
                throw new EmployeeNotFound();
            }
        } catch (Exception e) {
            throw new DatabaseError();
        }
        return employee;
    }
}
