/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author yifeij
 */
public class DAO {

    public static int FindCourseNumberbyCourseID(int courseId) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query = "SELECT COURSENUMBER FROM APP.COURSETABLE WHERE COURSEID=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, courseId);
        ResultSet rs = stmt.executeQuery();
        int courseNum =0;
        while (rs.next()) {
            courseNum = rs.getInt("COURSENUMBER");     
        }
        stmt.close();
        rs.close();
        con.close();
        return courseNum;
    }

    public static String FindCourseTitlebyCourseID(int courseId) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query = "SELECT TITLE FROM APP.COURSETABLE WHERE COURSEID=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, courseId);
        ResultSet rs = stmt.executeQuery();
        String courseTitle = null;
        while (rs.next()) {
            courseTitle = rs.getString("TITLE");
        }
        stmt.close();
        rs.close();
        con.close();
        return courseTitle;
    }
        
    public static String FindFirstNameandLastNamebySSN(int ssn) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query = "SELECT FIRSTNAME,LASTNAME FROM APP.STUDENTTABLE WHERE SSN=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, ssn);
        ResultSet rs = stmt.executeQuery();
        String firstName = null;
        String lastName = null;
        while (rs.next()) {
            firstName = rs.getString("FIRSTNAME");
            lastName = rs.getString("LASTNAME");
        }
        stmt.close();
        rs.close();
        con.close();
        return firstName + " " + lastName;
    }
    public static String FindDeptIDbyFirstNameandLastName(String firstName,
            String lastName) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query = "SELECT DEPTID FROM APP.STUDENTTABLE WHERE FIRSTNAME=? and LASTNAME=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        ResultSet rs = stmt.executeQuery();
        String deptId = null;
        while (rs.next()) {
            deptId = rs.getString("DEPTID");
        }
        stmt.close();
        rs.close();
        con.close();
        return deptId;
    }
    
     public static String FindBirthDatebySSN(int ssn) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query = "SELECT BIRTHDATE FROM APP.STUDENTTABLE WHERE SSN=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, ssn);
        ResultSet rs = stmt.executeQuery();
        String birthDate = null;
        while (rs.next()) {
            birthDate = rs.getString("BIRTHDATE");
        }
        stmt.close();
        rs.close();
        con.close();
        return birthDate;
    }
     
    public static String FindGradebyFirstNameandLastName(String firstName,
            String lastName) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query = "SELECT GRADE FROM APP.STUDENTTABLE, APP.ENROLLMENTTABLE "
                + "WHERE APP.STUDENTTABLE.SSN=APP.ENROLLMENTTABLE.SSN and FIRSTNAME=? and LASTNAME=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        ResultSet rs = stmt.executeQuery();
        String output = "";
        while (rs.next()) {
            output = rs.getString("GRADE")+"\n";
        }
        stmt.close();
        rs.close();
        con.close();
        return output;
    }
    
     public static String FindCourseTitlebyFirstNameandLastName(String firstName,
            String lastName) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query="SELECT TITLE"
                + " FROM (APP.COURSETABLE LEFT JOIN APP.ENROLLMENTTABLE ON APP.COURSETABLE.COURSEID=APP.ENROLLMENTTABLE.COURSEID)"
                +" LEFT JOIN APP.STUDENTTABLE ON APP.STUDENTTABLE.SSN=APP.ENROLLMENTTABLE.SSN"
                +" WHERE APP.STUDENTTABLE.FIRSTNAME=? AND APP.STUDENTTABLE.LASTNAME=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        ResultSet rs = stmt.executeQuery();
        String output = "";
        while (rs.next()) {
            output += rs.getString("TITLE")+"\n";
        }
        stmt.close();
        rs.close();
        con.close();
        return output;
    }
    public static String FindFirstNameandLastNamebyCourseTitle(String title) throws SQLException {
        String url = "jdbc:derby://localhost:1527/DataBase";
        String username = "jeff";
        String password = "jeff";
        String query="SELECT FIRSTNAME,LASTNAME"
                + " FROM (APP.COURSETABLE LEFT JOIN APP.ENROLLMENTTABLE ON APP.COURSETABLE.COURSEID=APP.ENROLLMENTTABLE.COURSEID)"
                +" LEFT JOIN APP.STUDENTTABLE ON APP.STUDENTTABLE.SSN=APP.ENROLLMENTTABLE.SSN"
                +" WHERE APP.COURSETABLE.TITLE=?";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, title);
        ResultSet rs = stmt.executeQuery();
        String output="";
        while (rs.next()) {
              output+=rs.getString("FIRSTNAME")+", "+rs.getString("LASTNAME")+"\n";
        }
        stmt.close();
        rs.close();
        con.close();
        return output;
    }
}
