package com.drawingtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawingtool.domain.Canvan;
import com.drawingtool.draw.DrawingCanvan;
import com.drawingtool.mesagges.Mesagges;
import com.drawingtool.util.Util;

@Service
public class Line {

	private static final String VACIO = " ";
	private static final boolean FALSE = false;
	private static final boolean TRUE = true;
	
	@Autowired
	Canvan canvan;
	
	@Autowired
	Util util;
	
	@Autowired
	Mesagges mesagges;
	
	@Autowired
	DrawingCanvan drawingLine;
	
	public void proccesLine(String text) {

		if (canvan.isExists()) {
			createLine(text);
		} else {
			mesagges.dontExistsACanvan();
		}

	}
	
	private void createLine(String text) {
		String[] positions = text.split(VACIO);
		if (util.validateCommand(positions,5,FALSE)) {
			int startX = Integer.parseInt(positions[1])-1;
			int startY = Integer.parseInt(positions[2])-1;
			int endX = Integer.parseInt(positions[3])-1;
			int endY  = Integer.parseInt(positions[4])-1;
			if(util.validateCoordinates(startX, startY, endX, endY, canvan.getCanvan())) {
				setLine(startX,startY,endX,endY);
			}else {
				return;
			}			
			drawingLine.drawing(canvan.getCanvan());
			mesagges.lineDrawed();
		}
	}
	
	public void setLine(int startX, int startY, int endX,int endY) {
		
		boolean horizontal = isHorizontal(startY, endY);
		boolean vertical = isVertical(startX, endX);
		
		for (int i = 0; i<canvan.getCanvan().length;i++) {
			for (int j = 0; j<canvan.getCanvan()[i].length;j++) {
				if(j==startX && i==startY) {
					
					if (startY>endY||startX>endX) {
						break;
					}
					canvan.getCanvan()[i][j]="X";
					if(horizontal) {
						startX++;
					}
					if(vertical) {
						startY++;
					}
					
					
				}
			}
		}
		
	}
	
	private boolean isHorizontal (int startY,int endY) {
		if(startY==endY) {
			return TRUE;
		}else {
			return FALSE;
		}
	}
	
	private boolean isVertical(int startX,int endX) {
		if(startX==endX) {
			return TRUE;
		}else {
			return FALSE;
		}
	}
	
}
