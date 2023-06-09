package Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.Add student records");
                System.out.println("2.Display student records");
                System.out.println("3.Save");
                System.out.println("4.Exit");
                System.out.println("0.invite to choice:");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "");
                             Statement stmt = conn.createStatement();
                        ) {
                        System.out.println("Insert StudentID:");
                        String StudentID = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Insert StudentName:");
                        String StudentName = sc.nextLine();
                        System.out.println("Insert Address:");
                        String Address = sc.nextLine();
                        System.out.println("Insert Phone:");
                        String Phone = sc.nextLine();
                        String sqlInsert = "insert into Student values (?,?,?,?)";
                        PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);
                        pstInsert.setString(1,StudentID);
                        pstInsert.setString(2,StudentName);
                        pstInsert.setString(3,Address);
                        pstInsert.setString(4,Phone);
                        int check = pstInsert.executeUpdate();
                        if (check >= 1){
                            System.out.println("rows :" + check);
                            System.out.println("Insert done.");
                        }else {
                            System.out.println("rows :" + check);
                            System.out.println("Insert erros.");
                        }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "");
                             Statement ignored = conn.createStatement();
                        ) {
                                String sqlSelect = "select * from Student";
                                PreparedStatement pst1 = conn.prepareStatement(sqlSelect);
                                ResultSet rs1 = pst1.executeQuery();
                                ResultSetMetaData rsetMD = rs1.getMetaData();
                                int numColumns = rsetMD.getColumnCount();

                                for (int i = 1; i <= numColumns; ++i) {
                                    System.out.printf("%-30s", rsetMD.getColumnName(i));
                                }
                                System.out.println();
                                for (int i = 1; i <= numColumns; ++i) {
                                    System.out.printf("%-30s", "(" + rsetMD.getColumnClassName(i) + ")");
                                }
                                System.out.println();
                                while (rs1.next()) {
                                    for (int i = 1; i <= numColumns; ++i) {
                                        System.out.printf("%-30s", rs1.getString(i));
                                    }
                                    System.out.println();
                                }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        for (Student student : students) {
                            System.out.println(student.getStudentID() + "," + student.getStudentName() + "," + student.getAddress() + "," + student.getPhone());
                        }

                        break;
                    case 4:
                        System.out.println("Exit Display");
                        return;
                    default:
                        System.out.println("invite to choice again");
                        break;
                }
            } while (true);
    }
}
