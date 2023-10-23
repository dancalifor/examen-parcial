/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;

import com.mycompany.Infrastructure.DbManagement.Persona;
import com.mycompany.Infrastructure.Models.PersonaModels;

/**
 *
 * @author oem
 */
public class PersonaServices {
    Persona personasDB;
    public PersonaServices(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new Persona(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModels persona){
        if(validarDatos(persona)){
           return personasDB.registrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(PersonaModels persona){
        if(validarDatos(persona)){
            return personasDB.modificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public PersonaModels consultarPersonaPorId(PersonaModels persona){
        return personasDB.consultarPersona(persona);
    }

    private boolean validarDatos(PersonaModels persona) {
        try {
            if(persona.Nombre.trim().isEmpty())
                throw new Exception("El nombre no debe estar vacío");
            else if (persona.Nombre.trim().length() < 3) {
                throw new Exception("El nombre no tiene la longitud necesaria");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
