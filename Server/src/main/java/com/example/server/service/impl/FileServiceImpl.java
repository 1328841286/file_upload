package com.example.server.service.impl;

import com.example.server.Log4jTest;
import com.example.server.dao.FileDao;
import com.example.server.dto.FileDTO;
import com.example.server.service.FileService;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author saysky
 * @date 2020/2/29 11:05 下午
 */
public class FileServiceImpl implements FileService {
    /**
     * 日志
     */
    Logger logger = Logger.getLogger(String.valueOf(Log4jTest.class));

    /**
     * 注入dao层
     */
    private static FileDao fileDao = new FileDao();

    @Override
    public List<FileDTO> findAll() throws SQLException {
        try {
            return fileDao.findAll();
        } catch (SQLSyntaxErrorException e) {
            e.printStackTrace();
            logger.info("查询数据库表发生异常");
        }
        return Collections.emptyList();
    }

    @Override
    public FileDTO findById(String id) throws SQLException {
        return fileDao.findById(id);
    }

    @Override
    public void insert(FileDTO fileDTO) throws SQLException {
        fileDao.insert(fileDTO);
    }
}
