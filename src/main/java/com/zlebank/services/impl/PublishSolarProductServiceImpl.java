package com.zlebank.services.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zlebank.dao.AccountBookDao;
import com.zlebank.service.business.dto.req.PublishSolarProductDto;
import com.zlebank.services.PublishSolarProductService;

/**
 * @author Donald
 * @createdate 2016年4月13日
 * @version 1.0 
 * @description :光伏项目发布相应功能实现类
 */
@Service("publishSolarProductService")
public class PublishSolarProductServiceImpl implements PublishSolarProductService {
	
	private final static Logger logger = LoggerFactory.getLogger(PublishSolarProductServiceImpl.class); 
	@Resource
	private AccountBookDao accountBookDao;
	
	//发布项目入口操作
	@Override
	@Transactional
	public boolean saveSolarProduct(PublishSolarProductDto productDto) {
		
		return true;
	}
	

}
