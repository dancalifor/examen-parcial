/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;

import com.mycompany.Infrastructure.DbManagement.Ciudad;
import com.mycompany.Infrastructure.Models.CiudadModels;

/**
 *
 * @author oem
 */
public class CiudadServices {
    Ciudad ciudadDB;
    public CiudadServices(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new Ciudad(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
           return ciudadDB.registrarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCiudad(CiudadModels ciudad, int id){
        if(validarDatos(ciudad)){
            return ciudadDB.modificarCiudad(ciudad, id);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CiudadModels consultarCiudad(int id){
        return ciudadDB.consultarCiudad(id);
    }

    private boolean validarDatos(CiudadModels ciudad) {
        try {
        if(ciudad.nombreCiudad.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (ciudad.nombreCiudad.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
