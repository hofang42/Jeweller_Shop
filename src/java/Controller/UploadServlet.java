/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.FileInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class UploadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileUploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileUploadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        String uploadPath = "D:\\FptUniversity\\ChuyenNganh4\\PRJ301\\PRJ_PROJECT\\RloyalPRJ\\web\\product_detail_img";
        String productName = convertEmptyToNull(request.getParameter("product_name")),
                material = convertEmptyToNull(request.getParameter("material")),
                gemstone = convertEmptyToNull(request.getParameter("gemstone")),
                size = convertEmptyToNull(request.getParameter("size")),
                resizeable = convertEmptyToNull(request.getParameter("resizeable")),
                pendant = convertEmptyToNull(request.getParameter("pendant")),
                diamond = convertEmptyToNull(request.getParameter("diamond")),
                olfactive_family = convertEmptyToNull(request.getParameter("olfactive_family")),
                color = convertEmptyToNull(request.getParameter("color")),
                product_full_desc = convertEmptyToNull(request.getParameter("product_full_desc")),
                product_small_desc = convertEmptyToNull(request.getParameter("product_small_desc")),
                original_price = convertEmptyToNull(request.getParameter("original_price")),
                sale_price = convertEmptyToNull(request.getParameter("sale_price")),
                product_category_id = convertEmptyToNull(request.getParameter("product_category_id")),
                product_collection_id = convertEmptyToNull(request.getParameter("product_collection_id"));
        String img_link = "";
        // Lấy phần file từ request
        response.getWriter().print(d.getCollectionIdByName(product_collection_id));
        Part filePart = request.getPart("image");
        if (filePart != null) {
            // Lấy tên file gốc từ header của part
            String fileName = getSubmittedFileName(filePart);
            if (fileName != null && fileName.endsWith(".zip")) {
                // Tạo đường dẫn đầy đủ cho file zip
                String filePath = uploadPath + File.separator + fileName;

                // Lưu file zip vào server
                try (InputStream fileContent = filePart.getInputStream()) {
                    Files.copy(fileContent, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }

                // Giải nén file zip và lấy danh sách tên các file đã giải nén
                List<String> extractedFileNames = unzipAndGetFileNames(filePath, uploadPath);

                // Xoá file zip sau khi giải nén
                File zipFile = new File(filePath);
                if (zipFile.exists()) {
                    zipFile.delete();
                    System.out.println("Deleted zip file: " + filePath);
                }
                d.Product_Insert(productName, d.getCategoryIdByName(product_category_id), d.getCollectionIdByName(product_collection_id), null);

                // Phản hồi thành công
                response.getWriter().println("File upload and unzip successful!");
                response.getWriter().println("Extracted files:");
                for (String extractedFileName : extractedFileNames) {
                    d.Product_Img_insert(extractedFileName, d.GetMaxProductId());
                    response.getWriter().println(extractedFileName);
                    if (extractedFileName.endsWith(".avif")) {
                        extractedFileName = extractedFileName.replaceAll(".avif", "");
                        if (extractedFileName.equalsIgnoreCase(productName)) {
                            img_link = extractedFileName;
                            img_link += ".avif";
                        }
                    } else {
                        extractedFileName = extractedFileName.replaceAll(".png", "");
                        if (extractedFileName.equalsIgnoreCase(productName)) {
                            img_link = extractedFileName;
                            img_link += ".png";
                        }
                    }

                    response.getWriter().println(img_link);
                }
                d.Update_Product_img(img_link, d.GetMaxProductId());
            } else {
                response.getWriter().print("Please upload a ZIP file.");
            }
        } else {
            response.getWriter().print("No file uploaded.");
        }
        d.ProductDetail_insert(productName, product_small_desc, product_full_desc, material, gemstone,
                size, resizeable, pendant, diamond, olfactive_family, color,
                Integer.parseInt(original_price), 0, d.GetMaxProductId());

    }

    public static String convertEmptyToNull(String value) {
        return (value == null || value.trim().isEmpty()) ? null : value;
    }

    // Lấy tên file gốc từ header của part
    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private List<String> unzipAndGetFileNames(String zipFilePath, String destDirectory) throws IOException {
        List<FileInfo> fileInfos = new ArrayList<>();
        long max = 0;
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();

                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                    File extractedFile = new File(filePath);
                    fileInfos.add(new FileInfo(extractedFile.getName(), extractedFile.lastModified()));
                } else {
                    File dir = new File(filePath);
                    dir.mkdirs(); // Create directories if entry is a directory
                }

                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }

        // Sort fileInfos by lastModified date
        fileInfos.sort(Comparator.comparingLong(FileInfo::getLastModified));

        // Collect sorted file names into a list
        List<String> fileNames = new ArrayList<>();
        for (FileInfo fileInfo : fileInfos) {
            fileNames.add(fileInfo.getName());
        }

        return fileNames;
    }

    // Phương thức giải nén từng file từ file zip
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        // Tạo thư mục cha nếu chưa tồn tại
        File parentDir = new File(new File(filePath).getParent());
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = zipIn.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
