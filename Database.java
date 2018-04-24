/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class Database {

    public static void main(String[] args) {

        int choice = 2;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@150.254.11.225:1521:xe", "user1", "student");
            Statement stmt = con.createStatement();
            ResultSet rs;
            while (choice != 4) {
                System.out.println("\nMENU:\n------------\n1.Dodaj wiersz do bazy\n2.Usun wiersz z bazy\n3.Wyswietl baze\n4.Zakoncz prace\n------------\n");
                System.out.print("Twoj wybor: ");
                Scanner rdr = new Scanner(System.in);
                choice = rdr.nextInt();

                switch (choice - 1) {
                    case 0: {
                        int nr_indeksu;
                        int id;
                        String imie, nazwisko;
                        System.out.println("Podaj dane do wprowadzenia: \n1.NR_INDEKSU\t2.IMIE\t3.NAZWISKO\t4.ID");
                        System.out.print("1: ");
                        nr_indeksu = rdr.nextInt();
                        System.out.print("2: ");
                        rdr.nextLine();
                        imie = rdr.nextLine();
                        System.out.print("3: ");
                        nazwisko = rdr.nextLine();
                        System.out.print("4: ");
                        id = rdr.nextInt();
                        rs = stmt.executeQuery("insert into student "
                                + "(nr_indeksu, imie, nazwisko, id)"
                                + "values"
                                + "("+nr_indeksu+", '"+imie+"', '"+nazwisko+"', "+id+")");
                        break;
                    }
                    case 1: {
                        break;
                    }
                    case 2: {
                        rs = stmt.executeQuery("select * from student");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "   " + rs.getString(2));
                        }
                        break;
                    }
                    case 3: {
                        try {
                            con.close();
                            System.out.println("Zamykanie systemu..");
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    default: {
                        System.out.println("Nieznany symbol, sprobuj ponownie");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
