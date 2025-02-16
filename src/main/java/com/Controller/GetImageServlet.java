package com.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetImageServlet")
public class GetImageServlet extends HttpServlet {
    private static final String IMAGE_DIRECTORY = "E:/Backend Project/Travel Data Project/src/main/webapp/AllImages/";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageId = request.getParameter("imageId1");
        Connection con = DBConnection.getDataConnection();

        try {
            String sql = "SELECT filename FROM images WHERE img_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, imageId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String fileName = rs.getString("filename");
                File file = new File(IMAGE_DIRECTORY + fileName);

                if (file.exists()) {
                    response.setContentType("image/jpeg");
                    Files.copy(file.toPath(), response.getOutputStream());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
