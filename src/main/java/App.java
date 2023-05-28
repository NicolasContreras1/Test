import configuration.MysqlConfig;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertCliente();

    }
    public static void insertCliente() throws SQLException, ClassNotFoundException {

        MysqlConfig mysqlConfig = new MysqlConfig();
        Connection conn = mysqlConfig.getMysqlConnection();

        String commandSql = "{call insert_cliente(?,?,?,?,?,?)}";

        CallableStatement cs = conn.prepareCall(commandSql);
        cs.setString(1,"Juan");
        cs.setString(2,"Perez");
        cs.setString(3, "Salazar");
        cs.setString(4,"2000-05-17");
        cs.setString(5, "martin@isil.pe" );
        cs.setString(6,"Lima");

        ResultSet resultSet = mysqlConfig.getResulset(cs);

        while (resultSet.next()){
            System.out.println(resultSet.getString(1) +" "+
                    resultSet.getString(2)+" "+
                    resultSet.getString(3)+" "+
                    resultSet.getString(4)+" "+
                    resultSet.getString(5)+" "+
                    resultSet.getString(6)+" "+
                    resultSet.getString(7)+" ");
        }


    }
}
