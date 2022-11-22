/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jorge.rodriguez
 */
public class Consultas extends Conexion {

    public boolean insertar(String nombre, int tarjeta) throws SQLException {
        boolean operacion = false;
        PreparedStatement pst = null; //registro

        ResultSet rs = null;

        try {
            String sql = "insert into registro (nombre, tarjeta,status )"
                    + " values (?,?,1); ";

            pst = conectarMySQL().prepareStatement(sql);

            pst.setString(1, nombre);
            pst.setInt(2, tarjeta);

            //pst.setString(2, contra);
            int eje = pst.executeUpdate();

            if (eje > 0) {

                operacion = true;
            } else {
                operacion = false;
            }
        } catch (Exception e) {
            System.out.println(e);
            operacion = false;

            conectarMySQL().rollback();
        } finally {
            try {
                if (conectarMySQL() != null) {
                    conectarMySQL().close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception e) {
                System.out.println(e);
                operacion = false;
            }
        }

        return operacion;

    }

    public boolean Modificasal(float saldo, String tarjeta) throws SQLException {
        boolean operacion = false;

        float saldoq = cantida(tarjeta);
        float cantidad = saldoq + saldo;
        PreparedStatement pst = null; //registro

        ResultSet rs = null;

        try {
            String sql = "update registro set saldoactual=? where tarjeta=?";

            pst = conectarMySQL().prepareStatement(sql);
            pst.setFloat(1, cantidad);
            pst.setString(2, tarjeta);

            //pst.setString(2, contra);
            int eje = pst.executeUpdate();

            if (eje > 0) {

                operacion = true;
            } else {
                operacion = false;
            }
        } catch (Exception e) {
            System.out.println(e);
            operacion = false;

            conectarMySQL().rollback();
        } finally {
            try {
                if (conectarMySQL() != null) {
                    conectarMySQL().close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception e) {
                System.out.println(e);
                operacion = false;
            }
        }

        return operacion;

    }

    public float cantida(String tarjeta) throws SQLException {
        float operacion = 0;
        PreparedStatement pst = null; //registro

        ResultSet rs = null;

        try {
            String sql = "select saldoactual from registro where tarjeta=?";

            pst = conectarMySQL().prepareStatement(sql);

            pst.setString(1, tarjeta);

            rs = pst.executeQuery();
            if (rs.next()) {
                String dato=rs.getString("saldoactual");
                if (dato==null || dato==""){
                operacion = 0;
                }
                else{operacion = Integer.parseInt(rs.getString("saldoactual"));}
                
            } else {
                operacion = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            operacion = 0;

            conectarMySQL().rollback();
        } finally {
            try {
                if (conectarMySQL() != null) {
                    conectarMySQL().close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception e) {
                System.out.println(e);
                operacion = 0;
            }
        }

        return operacion;

    }
}
