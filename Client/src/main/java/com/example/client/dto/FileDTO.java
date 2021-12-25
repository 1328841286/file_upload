package com.example.client.dto;

import java.sql.Timestamp;


/**
 * @author w
 */
public class FileDTO {

    /**
     * 主键：UUID
     */
    private String id;

    /**
     * 原始文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 存储位置
     */
    private String location;

    /**
     * 文件大小：单位字节
     */
    private String size;

    /**
     * 创建时间
     */
    private Timestamp time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", size=" + size +
                ", time=" + time +
                '}';
    }
}
