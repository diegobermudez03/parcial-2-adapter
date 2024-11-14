package com.diegoBermudez.rest_api;

import com.diegoBermudez.utilidades.UtilidadesAcceso;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Properties;

public class EmployeesRestApi {

    private String url;

    EmployeesRestApi(){
        Properties props = UtilidadesAcceso.loadProperty("com/propiedades/restApi.properties");
        this.url = props.getProperty("url");
    }


}
