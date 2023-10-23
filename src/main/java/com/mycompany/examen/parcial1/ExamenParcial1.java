/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen.parcial1;
import com.mycompany.Infrastructure.DbManagement.Ciudad;
import com.mycompany.Infrastructure.DbManagement.Cliente;
import com.mycompany.Infrastructure.DbManagement.Cuentas;
import com.mycompany.Infrastructure.DbManagement.Movimientos;
import com.mycompany.Infrastructure.DbManagement.Persona;
import com.mycompany.Infrastructure.Models.CiudadModels;
import com.mycompany.Infrastructure.Models.ClienteModels;
import com.mycompany.Infrastructure.Models.CuentasModels;
import com.mycompany.Infrastructure.Models.MovimientosModels;
import com.mycompany.Infrastructure.Models.PersonaModels;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;

/**
 *
 * @author oem
 */
public class ExamenParcial1 {

    public static void main(String[] args) {
        //CONEXIONES
        Ciudad ciudadConn = new Ciudad("prueba","1234","localhost","5432","parcialproyecto");
        Cliente clienteConn = new Cliente("prueba","1234","localhost","5432","parcialproyecto");
        Cuentas cuentaConn = new Cuentas("prueba","1234","localhost","5432","parcialproyecto");
        Movimientos movimientoConn = new Movimientos("prueba","1234","localhost","5432","parcialproyecto");
        Persona personaConn = new Persona("prueba","1234","localhost","5432","parcialproyecto");
        
        LocalDate fechaActual = LocalDate.now();
        Date date = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        //OBJETOS PARA INSERCION O UPDATE EN BASE DE DATOS
        CiudadModels nuevaCiudad = new CiudadModels();
        nuevaCiudad.Ciudad = "Itaugua";
        nuevaCiudad.Departamento = "CENTRAL";
        nuevaCiudad.Postal = 2740;
        //INSERT
        ciudadConn.registrarCiudad(nuevaCiudad);
        //UPDATE
        //int id = 0;
        //ciudaConn.modificarCiudad(nuevaCiudad, id);
        
        ClienteModels  nuevoCliente = new ClienteModels();
        nuevoCliente.IdPersona = 1;
        nuevoCliente.FechaIngreso = date;
        nuevoCliente.Calificacion = "23";
        nuevoCliente.Estado = "Activo";
        //INSERT
        clienteConn.registrarCliente(nuevoCliente);
        //UPDATE
        //int id = 0;
        //clienteConn.modificarCliente(nuevoCliente, id);
        
        
        CuentasModels nuevaCuenta = new CuentasModels();
        nuevaCuenta.IdCliente = 24;
        nuevaCuenta.NroCuenta = "1234567";
        nuevaCuenta.FechaAlta = date;
        nuevaCuenta.TipoCuenta = "Contado";
        nuevaCuenta.Estado = "Inactivo";
        //INSERT
        cuentaConn.registrarCuenta(nuevaCuenta);
        //UPDATE
        //int id = 0;
        //cuentaConn.modificarCuenta(nuevaCuenta, );

        
        //SELECT DE CIUDADES
        int idCiudad = 2;
        CiudadModels queryCity = ciudadConn.consultarCiudad(idCiudad);
        System.out.println("CIUDADES");
        System.out.println("Ciudad: "+ queryCity.getCiudad());
        System.out.println("Departamento: " + queryCity.getDepartamento());
        System.out.println("Postal: "+(int) queryCity.getPostal());
        System.out.println("Aqui terminan las consultas de ciudades\n");
        
        int idCliente = 2;
        ClienteModels queryClient = clienteConn.consultarCliente(idCliente);
        System.out.println("CLIENTES");
        System.out.println("Id de Persona: "+ queryClient.getIdPersona());
        System.out.println("Fecha de ingreso: " + queryClient.getFechaIngreso());
        System.out.println("Estado: " + queryClient.getEstado());
        System.out.println("Calificacion: " + queryClient.getCalificacion());
        System.out.println("Aqui terminan las consultas de clientes\n");
        
        int idCuenta = 1;
        CuentasModels queryCuenta = cuentaConn.consultarCuenta(idCuenta);
        System.out.println("CUENTAS");
        System.out.println("ID de cliente: "+ queryCuenta.getIdCliente());
        System.out.println("Fecha de alta: " + queryCuenta.getFechaAlta());
        System.out.println("Tipo de cuenta: " + queryCuenta.getTipoCuenta());
        System.out.println("Aqui terminan las consultas de cuentas\n");
        
        //DELETES
        //int id = 3;
        //ciudadConn.eliminarCiudad(id);
        //clienteConn.eliminarCliente(id);
        //cuentaConn.eliminarCuenta(id);
    }
}
