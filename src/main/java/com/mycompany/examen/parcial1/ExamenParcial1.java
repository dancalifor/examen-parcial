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
        
       
    }
}
