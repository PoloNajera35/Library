package com.libraryupa.dao;

import com.libraryupa.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean validateLogin(String username, String password) {
        String query = "SELECT COUNT(1) FROM Users WHERE Username = ? AND Password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
