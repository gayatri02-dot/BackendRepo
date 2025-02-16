package com.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/UploadimgServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50, // 50MB
    location = "E:/Backend Project/Travel Data Project/src/main/webapp/AllImages/" // Ensure this folder exists
)
public class UploadimgServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "E:/Backend Project/Travel Data Project/src/main/webapp/AllImages/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        // Ensure directory exists
        File uploadDir = new File(UPLOAD_DIRECTORY);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Create directory if not present
        }

        // Get the uploaded file
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String photoId = request.getParameter("did");

//        if (fileName != null && !fileName.isEmpty()) {
//            String filePath = UPLOAD_DIRECTORY + fileName;
//            filePart.write(filePath); // Save file to folder

            try (Connection con = DBConnection.getDataConnection()) {
                String sql = "INSERT INTO images (img_id, filename) VALUES (?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, photoId);
                stmt.setString(2, fileName);
                stmt.executeUpdate();
                stmt.close();

                out.println("Image uploaded successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Error saving image name.");
            }
//        } else {
//            out.println("Please select a file.");
//        }
    }
}
