package com.vince.service.impl;

import com.vince.service.AnimalService;

public class Dog implements AnimalService {

	@Override
	public void call() {
		System.out.println("С����...");
	}

}
