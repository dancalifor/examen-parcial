/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Services;

import com.mycompany.Infrastructure.DbManagement.Cuentas;
import com.mycompany.Infrastructure.Models.CuentasModels;

/**
 *
 * @author oem
 */
public class CuentasServices {
    Cuentas cuentasDB;
    public CuentasServices(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentasDB = new Cuentas(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuenta(CuentasModels cuentas){
        if(validarDatos(cuentas)){
           return cuentasDB.registrarCuenta(cuentas);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCuenta(CuentasModels cuentas){
        if(validarDatos(cuentas)){
            return cuentasDB.modificarCuenta(cuentas);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public CuentasModels consultarCuenta(int id){
        return cuentasDB.consultarCuenta(id);
    }

    private boolean validarDatos(CuentasModels cuentas) {
        try {
            if(cuentas.NroCuenta.trim().isEmpty())
                throw new Exception("El numero de cuenta no debe estar vacío");
            else if (cuentas.NroCuenta.trim().length() < 3) {
                throw new Exception("El numero de cuenta no tiene la longitud necesaria");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
