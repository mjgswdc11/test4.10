package sample.util;

import sample.entity.Shuttle;
import sun.awt.geom.AreaOp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    public static List<Shuttle> readShuttle()
    {
        List<Shuttle> list=new ArrayList<Shuttle>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");
            PreparedStatement statement = connection.prepareStatement("select *from shuttle");
            ResultSet rs=statement.executeQuery();

            while (rs.next()) {
                Shuttle shuttle=new Shuttle();
                shuttle.setStartTime(rs.getString(2));
                shuttle.setTicketsPrices(rs.getFloat(3));
                shuttle.setTicketsNumber(rs.getInt(4));
                list.add(shuttle);
            }
            System.out.println(list.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
    public static  boolean userLoginCheck(String userName,String passWord)
    {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","123456");
            PreparedStatement statement = connection.prepareStatement("select * from user ");
//            statement.setString(1,userName);
//            statement.setString(2,passWord);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
            if(userName.equals(rs.getString(2))&&passWord.equals(rs.getString(4)))
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
