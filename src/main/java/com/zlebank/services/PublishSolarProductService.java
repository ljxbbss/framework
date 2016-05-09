package com.zlebank.services;

import com.zlebank.service.business.dto.req.PublishSolarProductDto;

public interface PublishSolarProductService {
	
	public boolean saveSolarProduct(PublishSolarProductDto productDto);

}
