package com.example.server.servlet;

import com.alibaba.fastjson.JSON;
import com.example.server.Log4jTest;
import com.example.server.dto.FileDTO;
import com.example.server.service.FileService;
import com.example.server.service.impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Logger;


/**
 * @author w
 */
@WebServlet(name = "FileDetailServlet", urlPatterns = "/file/detail")
public class FileDetailServlet extends HttpServlet {

    /**
     * 日志
     */
    Logger logger = Logger.getLogger(String.valueOf(Log4jTest.class));


    /**
     * 注入FileService
     */
    FileService fileService = new FileServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null) {
            return;
        }
        response.setContentType("text/html; charset=UTF-8");
        OutputStream out = response.getOutputStream();
        try {
            FileDTO fileDTO = fileService.findById(id);
            out.write(JSON.toJSONString(fileDTO).getBytes());
            out.flush();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("文件读取时发生异常");

        } finally {
            out.close();
        }
    }
}
