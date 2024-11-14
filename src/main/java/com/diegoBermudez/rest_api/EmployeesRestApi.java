package com.diegoBermudez.rest_api;

import com.diegoBermudez.entities.EmployeeEntity;
import com.diegoBermudez.utilidades.UtilidadesAcceso;
import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class EmployeesRestApi {

    private String url;

    public EmployeesRestApi(){
        Properties props = UtilidadesAcceso.loadProperty("com/propiedades/restApi.properties");
        this.url = props.getProperty("url");
    }

    public ImmutablePair<String, EmployeeEntity> getEmployeeWithId(int id){
        String apiUrl = this.url + "/employee/" + id;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                EmployeeEntity employee = gson.fromJson(response.body(), EmployeeEntity.class);
                return new ImmutablePair<>(null, employee);
            } else {
                return new ImmutablePair<>("There's no employee with that ID", null);
            }
        } catch (Exception e) {
            return new ImmutablePair<>("Error making api call", null);
        }
    }
}
