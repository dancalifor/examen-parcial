/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Infrastructure.DbManagement;

import com.mycompany.Infrastructure.Connections.Connections;
import com.mycompany.Infrastructure.Models.MovimientosModels;
import java.sql.SQLException;

/**
 *
 * @author oem
 */
public class Movimientos {
    private Connections connection;

    public Movimientos (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        connection = new Connections(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(MovimientosModels movimiento){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("INSERT INTO movimientos (idcuenta, fechamovimiento, tipomovimiento, saldoanterior, saldoactual, montomovimiento, cuentaorigen, cuentadestino, canal)" +
                    "values('" +
                    movimiento.getIdCuenta()+ "', '" +
                    movimiento.getFechaMovimiento() + "', '" +
                    movimiento.getTipoMovimiento() + "', '" +
                    movimiento.getSaldoAnterior() + "', '" +
                    movimiento.getSaldoActual()+ "', '" +
                    movimiento.getMontoMovimiento() + "', '" +
                    movimiento.getCuentaOrigen()+ "', '" +
                    movimiento.getCuentaDestino() + "', '" +
                    movimiento.getCanal() + "')");
            connection.connectionDB().close();
            return "El registro de movimiento fue insertado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimiento(MovimientosModels movimiento, int id){

        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            boolean execute = connection.getQuerySQL().execute("UPDATE movimientos SET " +
                    "idcuenta= '" + movimiento.getIdCuenta() + "'," +
                    "fechamovimiento = '" + movimiento.getFechaMovimiento() + "'," +
                    "tipomovimiento= '" + movimiento.getTipoMovimiento() + "'," +
                    "saldoanterior= '" + movimiento.getSaldoAnterior() + "'," +
                    "saldoactual = '" + movimiento.getSaldoActual() + "'," +
                    "montomovimiento = '" + movimiento.getMontoMovimiento() + "'," +
                    "cuentaorigen = '" + movimiento.getCuentaOrigen() + "'," +
                    "cuentadestino= '" + movimiento.getCuentaDestino() + "'," +
                    "canal = '" + movimiento.getCanal() + "' " + " Where id = " + id);
            connection.connectionDB().close();
            return "Los datos del movimiento fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientosModels consultarMovimiento(int id){
        MovimientosModels movimiento = new MovimientosModels();
        try {
            connection.setQuerySQL(connection.connectionDB().createStatement());
            connection.setResultadoQuery(connection.getQuerySQL().executeQuery("Select * from movimiento where id = " + id));
            if(connection.getResultadoQuery().next()){
                movimiento.setIdCuenta(connection.getResultadoQuery().getInt("idcuenta"));
                movimiento.setMontoMovimiento(connection.getResultadoQuery().getInt("montomovimiento"));


                return movimiento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
