package com.drawingtool.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class UtilTest {

	@Autowired
	Util var;
		
	@Test
	public void Quit() {
		
		// arrange
		String command = "Q";
		int quantityPositions = 3;
		boolean isBucket = false;
		// act
		String positions[]=	command.split(" ");
		// assert
		assertFalse(var.validateCommand(positions, quantityPositions, isBucket));
	}
	
	@Test
	public void itsGoodTheCommandCreateCanvan() {
		
		// arrange
		String command = "C 20 4";
		int quantityPositions = 3;
		boolean isBucket = false;
		// act
		String positions[]=	command.split(" ");
		// assert
		assertTrue(var.validateCommand(positions, quantityPositions, isBucket));
	}
	
	@Test
	public void itsWrongTheCommandCreateCanvan() {
		
		// arrange
		String command = "C 20 C";
		int quantityPositions = 3;
		boolean isBucket = false;
		// act
		String positions[]=	command.split(" ");
		// assert
		assertFalse(var.validateCommand(positions, quantityPositions, isBucket));
	}
	
	@Test
	public void itsWrongTheCommandbucket() {
		
		// arrange
		String command = "C 20 C";
		int quantityPositions = 3;
		boolean isBucket = true;
		// act
		String positions[]=	command.split(" ");
		// assert
		assertTrue(var.validateCommand(positions, quantityPositions, isBucket));
	}
	
	@Test
	public void itsGoodTheCommandbucket() {
		
		// arrange
		String command = "C 20 10 C";
		int quantityPositions = 4;
		boolean isBucket = true;
		// act
		String positions[]=	command.split(" ");
		// assert
		assertTrue(var.validateCommand(positions, quantityPositions, isBucket));
	}
	

	@Test
	public void itNumberFalse() {
		
		// arrange
		String number = "C 20 C";
		// act
		assertFalse(var.validateCommandNumbers(number));
	}
	
	public void CreateCanvan() {
		
		// arrange
		String number = "20";
		// act
		assertTrue(var.validateCommandNumbers(number));
	}
}
