package Clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class BD {

    public Connection Conexion;
    private String Url;

    public BD(String Usuario, String Contraseña) {
        
        FileReader Leer;
        BufferedReader Linea;
        
        try {
            ArrayList<String> Lineas = new ArrayList<>();
            Leer = new FileReader("config.info");
            Linea = new BufferedReader(Leer);
            String temp;
            
            while ((temp = Linea.readLine()) != null) {
                Lineas.add(temp);
            }
            
            Linea.close();
            Leer.close();
            String Linea0 = Lineas.get(0);
            this.Url = "jdbc:mysql://" + Linea0.substring(Linea0.lastIndexOf('=') + 1) + "/tiendabd";
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.Conexion = DriverManager.getConnection(this.Url, Usuario, Contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            this.Conexion = null;
        }
        
    }
    
}
