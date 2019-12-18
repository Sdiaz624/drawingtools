package com.drawingtool.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawingtool.mesagges.Mesagges;

@Service
public class Util {

	private static final int UNO = 1;
	private static final int CERO = 0;

	@Autowired
	Mesagges mesagges;

	private static final boolean FALSE = false;
	private static final boolean TRUE = true;

	public boolean validateCommand(String[] positions, int quantityPositions, boolean isBucket) {

		if (positions.length == quantityPositions) {
			return validateCommandLetter(positions,isBucket);
		} else {
			mesagges.sizeCommand();
			return FALSE;
		}
	}

	private boolean validateCommandLetter(String[] positions, boolean isBucket) {

		boolean itsgood = TRUE;
		int size = 0;
		
		size = getSize(positions, isBucket);
		
		for (int i = UNO; i < size; i++) {
			if (validateCommandNumbers(positions[i])) {
				itsgood = itsgood && TRUE;
			} else {
				itsgood = itsgood && FALSE;
			}
		}

		if (!itsgood) {
			mesagges.letterInCommand();
		}

		return itsgood;

	}

	private int getSize(String[] positions, boolean isBucket) {
		int size;
		if(isBucket) {
			size= positions.length-2;
		}else {
			size= positions.length;
		}
		return size;
	}

	public boolean validateCommandNumbers(String number) {
		try {
			Integer.parseInt(number);
			return TRUE;
		} catch (NumberFormatException excepcion) {
			return FALSE;
		}

	}

	public boolean validateCoordinates(int startX, int startY, int endX,int endY, String[][] canvan) {
		
		if (startX<CERO||startY<CERO||endX<CERO||endY<CERO) {
			mesagges.coordinatesAreWrong();
			return FALSE;
		}else if(startX>endX) {
			mesagges.x1IHigherThanX2();
			return FALSE;
		}else if(startY>endY) {
			mesagges.y1IHigherThanY2();
			return FALSE;
		}else if(startX>canvan[CERO].length||endX>canvan[CERO].length) {
			mesagges.x1Orx2AreHigherThatRectangleSize();
			return FALSE;
		}else if(startY>canvan[CERO].length||endY>canvan.length) {
			mesagges.y1Ory2AreHigherThatRectangleSize();
			return FALSE;
		}else {
			return TRUE;
		}
	}
	
	public boolean validateCoordinates(int x, int y, String[][] canvan) {
		
		if(x>canvan[0].length) {
			mesagges.xIsWrong();
			return FALSE;
		}else if (y>canvan.length){
			mesagges.yIsWrong();
			return FALSE;
		}else {
			return TRUE;
		}
	
	}
}
