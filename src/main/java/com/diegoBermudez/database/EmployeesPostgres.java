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

    EmployeeEntity findEmployeeById(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
             String query =
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
