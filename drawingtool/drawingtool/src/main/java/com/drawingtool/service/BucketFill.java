package com.drawingtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawingtool.domain.Canvan;
import com.drawingtool.draw.DrawingCanvan;
import com.drawingtool.mesagges.Mesagges;
import com.drawingtool.util.Util;

@Service
public class BucketFill {

	private static final boolean TRUE = true;

	private static final String VACIO = " ";

	@Autowired
	Util util;

	@Autowired
	Canvan canvan;

	@Autowired
	Mesagges mesagges;

	@Autowired
	DrawingCanvan drawingLine;

	public void proccesBucketFill(String text) {

		if (canvan.isExists()) {
			createBucketFill(text);
		} else {
			mesagges.dontExistsACanvan();
		}

	}

	private void createBucketFill(String text) {
		String[] positions = text.split(VACIO);
		if (util.validateCommand(positions, 4, TRUE)) {
			int x = Integer.parseInt(positions[1]) - 1;
			int y = Integer.parseInt(positions[2]) - 1;
			String word = positions[3];
			if (util.validateCoordinates(x, y, canvan.getCanvan())) {
				setBucketFill(canvan.getCanvan(), word);
			} else {
				return;
			}
			drawingLine.drawing(canvan.getCanvan());
			mesagges.rectangleDrawed();
		}
	}

	private void setBucketFill(String[][] canvan, String word) {

		for (int i = 0; i < canvan.length; i++) {
			for (int j = 0; j < canvan[i].length; j++) {
				if (canvan[i][j] == null) {
					canvan[i][j] = word;

				}
			}
		}
	}

}
