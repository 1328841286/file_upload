package com.example.client.Test;

import com.alibaba.fastjson.JSON;
import com.example.client.controller.FileController;
import com.example.client.dto.FileDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FilControllerTest {

    /**
     * 日志
     */
//    Logger logger = Logger.getLogger(String.valueOf(Log4jTest.class));

    /**
     * 声明 restTemplate
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    /**
     * 注入 restTemplate
     */
    @Autowired
    private RestTemplate restTemplate;


    /**
     * 服务器主机
     */
    public static String SERVER_DOMAIN = "http://localhost:8080";

    FileController fileController = new FileController();

    @Test
    private HttpHeaders builderHeader() throws Exception {
        // 请求头设置属性
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.parseMediaType("multipart/form-data; charset=UTF-8"));
        return headers;
    }

    @Test
    @GetMapping
    public String index(Model model) throws Exception {

        // 设置header
        HttpHeaders headers = builderHeader();
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(form, headers);
        List<FileDTO> fileDTOList = new ArrayList<>();
        try {
            // 向Server端请求获得列表
            ResponseEntity<String> result = restTemplate.exchange(SERVER_DOMAIN + "/file/list", HttpMethod.GET, httpEntity, String.class);
            if (result.getStatusCode() == HttpStatus.OK) {
                fileDTOList = JSON.parseArray(result.getBody(), FileDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            logger.info("Server接口调用失败");
        }
        model.addAttribute("fileDTOList", fileDTOList);
        return "index";
    }
}
