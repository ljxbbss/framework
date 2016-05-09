package com.zlebank.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlebank.service.business.app.PublishSolarProductApp;
import com.zlebank.service.business.dto.req.PublishSolarProductDto;
import com.zlebank.service.business.dto.res.PublishResultDto;
import com.zlebank.services.PublishSolarProductService;

@Service("publishSolarProductApp")
public class PublishSolarProductAppImpl implements PublishSolarProductApp {

	@Autowired
	private PublishSolarProductService publishSolarProductService;
	
	@Override
	public PublishResultDto publishSolarProduct(PublishSolarProductDto productDto) {
		
		PublishResultDto retDto = new PublishResultDto();
		return retDto;
	}

}
