/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infrastructure.Models;

/**
 *
 * @author oem
 */
public class CiudadModels {
    public int Id;
    public String Ciudad;
    public String Departamento;
    public int Postal;
    
    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public int getPostal() {
        return Postal;
    }

    public void setPostal(int Postal) {
        this.Postal = Postal;
    }
    
}