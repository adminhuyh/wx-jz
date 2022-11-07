package com.tencent.wxcloudrun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 配置本地资源映射
     *
     * @Param:
     * @Return:
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String file_path = "";
            file_path = "file:D:\\wx-project\\wx-jz\\src\\main\\resources\\static\\images\\";  //本地测试配置
        registry.addResourceHandler("/static/images/**")  //请求路径
                .addResourceLocations(file_path);        //本地地址
    }
}
