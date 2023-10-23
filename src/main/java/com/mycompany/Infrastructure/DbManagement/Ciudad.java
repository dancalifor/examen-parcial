package com.mycompany.Infrastructure.DbManagement;


import com.mycompany.Infrastructure.Connections.Connections;
import com.mycompany.Infrastructure.Models.CiudadModels;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author oem
 */
public class Ciudad {
    private Connections connection;

    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO ciudad (ciudad,departamento,postal)" +
                    "values('" +
                    ciudad.nombreCiudad+ "', '" +
                    ciudad.Departamento + "', '" +
                    ciudad.Postal + "')");
            connection.connectionDB().close();
            return "La ciudad " + ciudad.nombreCiudad + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(CiudadModels ciudad){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE ciudad SET " +
                    "ciudad = '" + ciudad.nombreCiudad + "'," +
                    "departamento = '" + ciudad.Departamento + "'," +
                    "postal = '" + ciudad.Postal + "' " + " Where id = " + ciudad.Id);
            connection.connectionDB().close();
            return "Los datos de la ciudad " + ciudad.nombreCiudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModels consultarCiudad(CiudadModels ciudad){
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from ciudad where id = " + ciudad.Id));
            if(connection.getResultadoQuery().next()){
                ciudad.setCiudad( connection.getResultadoQuery().getString("ciudad"));
                ciudad.setDepartamento(connection.getResultadoQuery().getString("departamento"));
                ciudad.setPostal(connection.getResultadoQuery().getInt("postal"));
                
                return ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public String eliminarCiudad(int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("DELETE FROM ciudad" +
                    " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos de la ciudad fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
