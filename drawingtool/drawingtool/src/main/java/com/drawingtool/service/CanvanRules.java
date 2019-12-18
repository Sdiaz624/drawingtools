package com.drawingtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawingtool.domain.Canvan;
import com.drawingtool.draw.DrawingCanvan;
import com.drawingtool.mesagges.Mesagges;
import com.drawingtool.util.Util;

@Service
public class CanvanRules {

	private static final boolean FALSE = false;
	private static final boolean TRUE = true;
	private static final String VACIO = " ";
		
	@Autowired
	Mesagges mesagges;
	
	@Autowired
	Util util;
	
	@Autowired
	Canvan canvan;
	
	@Autowired
	DrawingCanvan drawingCanvan;

	public void validateCreateCanvan(String text) {

		if (!canvan.isExists()) {
			createCanvan(text);
		} else {
			mesagges.existsACanvan();
		}

	}

	private void createCanvan(String text) {
		String[] positions = text.split(VACIO);
		if (util.validateCommand(positions,3,FALSE)) {
			int width = Integer.parseInt(positions[1]);
			int heigth = Integer.parseInt(positions[2]);
			canvan.setCanvan(new String[heigth][width]);
			canvan.setExists(TRUE);
			drawingCanvan.drawing(canvan.getCanvan());
			mesagges.canvanCreated();
		}
	}
}
