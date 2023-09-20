/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infrastructure.DbManagement;

import com.mycompany.Infrastructure.Connections.Connections;
import com.mycompany.Infrastructure.Models.PersonaModelos;
import java.sql.SQLException;

/**
 *
 * @author oem
 */
public class Persona {
    private Connections connection;

    public Persona (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModelos persona){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO persona (idpersona, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado)" +
                    "values('" +
                    persona.IdCiudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Email + "', '" +
                    persona.Celular + "', '" +
                    persona.Estado + "')");
            connection.connectionDB().close();
            return "La persona con nombre: " + persona.Nombre+", y apellido: "+persona.Apellido + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModelos persona, int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE persona SET " +
                    "nombre = '" + persona.Nombre + "'," +
                    "apellido = '" + persona.Apellido + "'," +
                    "tipodocumento = '" + persona.TipoDocumento + "'," +
                    "nrodocumento= '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "email = '" + persona.Email + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "estado = '" + persona.Estado + "' " + " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos de la persona " + persona.Nombre +" "+ persona.Apellido + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModelos consultarPersona(int id){
        PersonaModelos persona = new PersonaModelos();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from persona where id = " + id));
            if(connection.getResultadoQuery().next()){
                persona.Nombre = connection.getResultadoQuery().getString("nombre");
                persona.Apellido = connection.getResultadoQuery().getString("apellido");


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
