package com.drawingtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawingtool.domain.Canvan;
import com.drawingtool.draw.DrawingCanvan;
import com.drawingtool.mesagges.Mesagges;
import com.drawingtool.util.Util;

@Service
public class Rectangle {

	private static final boolean FALSE = false;

	private static final String VACIO = " ";

	@Autowired
	Canvan canvan;

	@Autowired
	Util util;

	@Autowired
	Mesagges mesagges;

	@Autowired
	DrawingCanvan drawingLine;

	@Autowired
	Line line;

	public void proccesRectangle(String text) {

		if (canvan.isExists()) {
			createRectangle(text);
		} else {
			mesagges.dontExistsACanvan();
		}
		
	}

	private void createRectangle(String text) {
		String[] positions = text.split(VACIO);
		if (util.validateCommand(positions, 5,FALSE)) {
			int startX = Integer.parseInt(positions[1]) - 1;
			int startY = Integer.parseInt(positions[2]) - 1;
			int endX = Integer.parseInt(positions[3]) - 1;
			int endY = Integer.parseInt(positions[4]) - 1;
			if (util.validateCoordinates(startX, startY, endX, endY, canvan.getCanvan())) {
				setRectangle(startX, startY, endX, endY);
			} else {
				return;
			}
			drawingLine.drawing(canvan.getCanvan());
			mesagges.rectangleDrawed();
		}
	}

	private void setRectangle(int startX, int startY, int endX, int endY) {

		line.setLine(startX, startY, startX, endY);
		line.setLine(endX, startY, endX, endY);
		line.setLine(startX, startY, endX, startY);
		line.setLine(startX, endY, endX, endY);

	}
}
