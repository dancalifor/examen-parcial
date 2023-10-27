/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infrastructure.DbManagement;

import com.mycompany.Infrastructure.Connections.Connections;
import com.mycompany.Infrastructure.Models.ClienteModels;
import java.sql.SQLException;

/**
 *
 * @author oem
 */
public class Cliente {
    private Connections connection;

    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO cliente (idpersona, fechaingreso, calificacion, estado)" +
                    "values('" +
                    cliente.IdPersona+ "', '" +
                    cliente.FechaIngreso + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.Estado + "')");
            connection.connectionDB().close();
            return "El cliente fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClienteModels cliente){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE cliente SET " +
                    "idpersona = '" + cliente.IdPersona + "'," +
                    "fechaingreso= '" + cliente.FechaIngreso + "'," +
                    "calificacion = '" + cliente.Calificacion + "'," +
                    "estado= '" + cliente.Estado + "' " + " Where id = " + cliente.IdCliente);
            connection.connectionDB().close();
            return "Los datos del cliente fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteModels consultarCliente(int id){
        ClienteModels cliente = new ClienteModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from cliente where id = " + id));
            if(connection.getResultadoQuery().next()){
                cliente.setIdPersona(connection.getResultadoQuery().getInt("idpersona"));
                cliente.setFechaIngreso(connection.getResultadoQuery().getDate("fechaingreso"));  
                cliente.setCalificacion(connection.getResultadoQuery().getString("calificacion"));
                

                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public String eliminarCliente(int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("DELETE FROM cliente" +
                    " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos del cliente fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
