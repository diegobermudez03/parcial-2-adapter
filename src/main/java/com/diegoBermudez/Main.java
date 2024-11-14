package com.diegoBermudez;

import com.diegoBermudez.adapter.EmployeesAdapter;
import com.diegoBermudez.adapter.EmployeesPostgresAdapter;
import com.diegoBermudez.adapter.EmployeesRestAdapter;
import com.diegoBermudez.entities.EmployeeEntity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(true){
            System.out.println("\nIngrese que adaptador quiere usar (ingrese 0 para salir):");
            System.out.println("1. Postgres");
            System.out.println("2. Rest");
            int op = cin.nextInt();
            if(op == 0) break;
            if(op != 1 && op != 2) continue;
            EmployeesAdapter adapter = op == 1 ? new EmployeesPostgresAdapter() : new EmployeesRestAdapter();

            System.out.println("Ingrese el codigo del empleado a buscar");
            int id = cin.nextInt();
            EmployeeEntity employee = adapter.getEmployee(id);
            if(employee == null){
                System.out.println("No se pudo obtener el empleado, o no existe o hubo un error");
            }
            else{
                System.out.println(employee);
            }

        }
        cin.close();
    }
}