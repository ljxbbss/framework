package com.zlebank.app.impl;

import org.springframework.stereotype.Service;

import com.zlebank.service.DubboConsumerInterface;

@Service("portalInterfaceImpl")
public class DubboConsumerInterfaceImpl implements DubboConsumerInterface {

	@Override
	public String getName(String name) {
		return "portal:"+name;
	}

}
