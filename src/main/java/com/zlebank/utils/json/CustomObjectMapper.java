package com.zlebank.utils.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author xuchu-tang
 * @createdate 2016年3月23日
 * @version 1.0 
 * @description :1、扩展json的序列化参数
 *               2、扩展后通过XML配置注入到MappingJackson2HttpMessageConverter类的属性objectMapper中
 */
public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 8792711417701355747L;
	private boolean camelCaseToLowerCaseWithUnderscores = false;  
    private String dateFormatPattern;  
  
    public void setCamelCaseToLowerCaseWithUnderscores(boolean camelCaseToLowerCaseWithUnderscores) {  
        this.camelCaseToLowerCaseWithUnderscores = camelCaseToLowerCaseWithUnderscores;  
    }  
  
    public void setDateFormatPattern(String dateFormatPattern) {  
        this.dateFormatPattern = dateFormatPattern;  
    }  
  
    public void init() {  
        // 排除值为空属性  
        setSerializationInclusion(JsonInclude.Include.NON_NULL);  
        // 进行缩进输出  
        configure(SerializationFeature.INDENT_OUTPUT, true);  
        // 将驼峰转为下划线  
        if (camelCaseToLowerCaseWithUnderscores) {  
            setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);  
        }  
        // 进行日期格式化  
        if (dateFormatPattern != null) {  
            DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);  
            setDateFormat(dateFormat);  
        }  
    }  
}
