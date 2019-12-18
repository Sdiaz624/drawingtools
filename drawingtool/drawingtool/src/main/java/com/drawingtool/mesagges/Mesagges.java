package com.drawingtool.mesagges;

import org.springframework.stereotype.Service;

@Service
public class Mesagges {

	private static final String Y_IS_WRONG = "Y is wrong";
	private static final String X_IS_WRONG = "X is wrong";
	private static final String THE_RECTANGLE_WAS_DRAWED = "the rectangle was drawed";
	private static final String Y1_OR_Y2_ARE_HIGHER_THAN_RECTANGLE_SIZE = "y1 or y2 are higher than rectangle size";
	private static final String X1_OR_X2_ARE_HIGHER_THAN_RECTANGLE_SIZE = "x1 or x2 are higher than rectangle size";
	private static final String Y1_IS_HIGHER_THAN_Y2 = "Y1 is higher than Y2";
	private static final String X1_IS_HIGHER_THAN_X2 = "X1 is higher than X2";
	private static final String THE_COORDINATES_ARE_BUSY = "the Coordinates are busy";
	private static final String THE_COORDINATES_ARE_WRONG = "the Coordinates are wrong, please try again";
	private static final String THE_LINE_WAS_DRAWED = "the line was drawed";
	private static final String DON_T_EXIST_A_CANVAN_PLEASE_TRY_AGAIN = "don't exist a canvan, please try again";
	private static final String THE_DIMENSIONS_FOR_CANVAN_ARE_IS_LETTER = "the dimensions for canvan ARE/IS letter";
	private static final String THE_SIZE_OF_COMMAND_IS_WRONG = "the size of command is wrong";
	private static final String EXIST_A_CANVAN_PLEASE_TRY_AGAIN = "exist a canvan, please try again";
	private static final String THE_CANVAN_WAS_CREATED_CORRECTY = "The canvan was created correcty";
	private static final String ANSWER_WITH_MISTAKES = "this command have mistake. please verify and try again";
	private static final String YOU_ARE_EXIT = "you are exit";

	public void canvanCreated() {
		System.out.println(THE_CANVAN_WAS_CREATED_CORRECTY);
	}

	public void existsACanvan() {
		System.out.println(EXIST_A_CANVAN_PLEASE_TRY_AGAIN);
	}

	public void sizeCommand() {
		System.out.println(THE_SIZE_OF_COMMAND_IS_WRONG);
	}

	public void letterInCommand() {
		System.out.println(THE_DIMENSIONS_FOR_CANVAN_ARE_IS_LETTER);
	}

	public void dontExistsACanvan() {
		System.out.println(DON_T_EXIST_A_CANVAN_PLEASE_TRY_AGAIN);
	}

	public static void commandInvalid(String text) {
		System.out.println(text + ANSWER_WITH_MISTAKES);
	}

	public void exit() {
		System.out.println(YOU_ARE_EXIT);
	}
	
	public void lineDrawed() {
		System.out.println(THE_LINE_WAS_DRAWED);
	}
	
	public void rectangleDrawed() {
		System.out.println(THE_RECTANGLE_WAS_DRAWED);
	}
	
	public void coordinatesAreWrong() {
		System.out.println(THE_COORDINATES_ARE_WRONG);
	}
	
	public void x1IHigherThanX2() {
		System.out.println(X1_IS_HIGHER_THAN_X2);
	}
	
	public void y1IHigherThanY2() {
		System.out.println(Y1_IS_HIGHER_THAN_Y2);
	}
	
	public void x1Orx2AreHigherThatRectangleSize() {
		System.out.println(X1_OR_X2_ARE_HIGHER_THAN_RECTANGLE_SIZE);
	}
	
	public void y1Ory2AreHigherThatRectangleSize() {
		System.out.println(Y1_OR_Y2_ARE_HIGHER_THAN_RECTANGLE_SIZE);
	}
	
	public void coordinatesAreBusy() {
		System.out.println(THE_COORDINATES_ARE_BUSY);
	}
	
	public void xIsWrong() {
		System.out.println(X_IS_WRONG);
	}
	
	public void yIsWrong() {
		System.out.println(Y_IS_WRONG);
	}
}
