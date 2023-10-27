/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;

import com.mycompany.Infrastructure.DbManagement.Cliente;
import com.mycompany.Infrastructure.Models.ClienteModels;

/**
 *
 * @author oem
 */
public class ClienteServices {
    Cliente clienteDB;
    public ClienteServices(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new Cliente(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){
        if(validarDatos(cliente)){
           return clienteDB.registrarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(ClienteModels cliente){
        if(validarDatos(cliente)){
            return clienteDB.modificarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public ClienteModels consultarCliente(int id){
        return clienteDB.consultarCliente(id);
    }

    private boolean validarDatos(ClienteModels cliente) {
        try {
        if(cliente.Calificacion.isEmpty()){
            if (cliente.Calificacion.length() < 3) {
                throw new Exception("El nombre no tiene la longitud necesaria");
            }
        }
        else {
            throw new Exception("El nombre no debe estar vacío");
            }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
