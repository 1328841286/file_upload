package com.example.server.servlet;

import com.example.server.Log4jTest;
import com.example.server.dto.FileDTO;
import com.example.server.service.FileService;
import com.example.server.service.impl.FileServiceImpl;
import org.eclipse.jetty.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Logger;


/**
 * @author w
 */
@WebServlet(name = "FileDownloadServlet", urlPatterns = "/file/download")
public class FileDownloadServlet extends HttpServlet {

    /**
     * 日志
     */
    Logger logger = Logger.getLogger(String.valueOf(Log4jTest.class));


    /**
     * 注入FileService
     */
    FileService fileService = new FileServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (StringUtil.isBlank(id)) {
            return;
        }
        try {
            FileDTO fileDTO = fileService.findById(id);
            if (fileDTO != null) {
                String realPath = fileDTO.getLocation();
                String fileName = fileDTO.getName();
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("text/html; charset=UTF-8");
                //获取文件输入流
                InputStream in = new FileInputStream(realPath);
                OutputStream out = response.getOutputStream();
                int nRead = 0;
                byte[] cache = new byte[1024];
                while ((nRead = in.read(cache)) != -1) {
                    out.write(cache, 0, nRead);
                    out.flush();
                }
                in.close();
                out.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("下载时操作数据库发生错误");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("下载时发生异常");
        }

    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
