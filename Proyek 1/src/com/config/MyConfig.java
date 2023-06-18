package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dt_produk";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Data Base Connected Succes");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    public static void getDatabase() {
        connection();
        try {
            //String query = "";
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT NAME, PRICE, TOTAL FROM `tb_produk` ORDER BY ID DESC");

            while (resultSet.next()) {
                System.out.println(
                    resultSet.getString("NAME")+ ": Rp."+
                    resultSet.getInt("PRICE")+ " (" +
                    resultSet.getInt("TOTAL") + ")"
                    
                    
                );
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertData() {
        String namaBaru;
        long hargaBaru;
        int jumlahBaru;

        Scanner input = new Scanner(System.in);

        System.out.print("NAME : ");
        namaBaru = input.nextLine();

        System.out.print("PRICE : ");
        hargaBaru = input.nextLong();

        System.out.print("TOTAL : ");
        jumlahBaru = input.nextInt();

        MyConfig.connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `tb_produk` (`ID`, `NAME`, `PRICE`, `TOTAL`) VALUES (NULL, '"+namaBaru+"', '"+hargaBaru+"', '"+jumlahBaru+"') ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void editData() {
        int jumlah = 20;
        try {
            statement = connect.createStatement();
            statement.executeUpdate("UPDATE `tb_produk` SET `TOTAL` = '"+jumlah+"' WHERE `tb_produk`.`ID` = 1; ");

            System.out.println("Data berhasil di update");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteData() {
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan id yang ingin di hapus:");
        id = sc.nextInt();

        try {
            connection();
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tb_produk` WHERE `ID` = " + id);
            System.out.println("Data berhasil dihapus");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}