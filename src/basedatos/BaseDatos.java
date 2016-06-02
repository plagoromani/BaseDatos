/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.*;

/**
 *
 * @author Pablite5
 */
public class BaseDatos {

    /**
     * @param args the command line arguments
     */
   
       Connection co;
       
       
       
       public BaseDatos() {
           try{
               Class.forName("com.mysql.jdbc.Driver");
               co = DriverManager.getConnection("jdbc:mysql://localhost/futbol","root","821969");
               //método para que acceda a la base de datos mysql
              
           }
           catch(ClassNotFoundException exc){
               
           }
           catch(SQLException ex) {
             
           }
           
       }
       
       public  void apagar() {
        try {
            co.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       
     public void insertar(String IdJugador, String NomJugador, String PosicionJugador, String Dorsal, String GolesJug, String AsistenciasJug, String NomEquipo) {
       
      Statement stm=null;
       try {
          stm= co.createStatement();
            stm.executeUpdate("insert into datosliga values(" + IdJugador + ",'" + NomJugador + "','" + PosicionJugador + "'," + Dorsal + "," +  GolesJug + "," + AsistenciasJug + ",'" + NomEquipo + "');");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

        public ResultSet consultar()  {
        Statement stm=null;
        ResultSet rs=null;//necesario para mostrar los results
         try {
            stm = co.createStatement();
            rs = stm.executeQuery("select * from datosliga;");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return rs;

    }
        public void eliminar(String PrimaryKey) throws Exception{
           
            Statement stm=null;
        try {
            stm = co.createStatement();
            stm.executeUpdate("delete from datosliga where IdJugador=" + PrimaryKey + "; ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        }
        
        public void actualizar(String PrimaryKey, String columna, String valor) throws Exception{
       
                Statement stm=null;
        try {
           stm = co.createStatement();
            stm.executeUpdate("update datosliga set " + columna + "='" + valor + "' where idJugador=" + PrimaryKey + ";");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
        
           public void actualizar2(String PrimaryKey, String columna, String valor) throws Exception{
       
                Statement stm=null;
        try {
           stm = co.createStatement();
            stm.executeUpdate("update datosliga set " + columna + "=" + valor + " where idJugador=" + PrimaryKey+";");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           }
}
    


