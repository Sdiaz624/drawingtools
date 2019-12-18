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
public class ValidateTextTest {

	@Autowired
	ValidateText validateText;
	
	@Test
	public void structureCanvanItsGood() {
		
		// arrange
		String text = "C 20 4";
		// act
		assertTrue(validateText.validateStructure(text));
	}
	
	@Test
	public void structureLineItsGoodHorizontal() {
		
		// arrange
		String text = "L 1 2 6 2";
		// act
		assertTrue(validateText.validateStructure(text));
	}

	@Test
	public void structureLineItsGoodVertical() {
		
		// arrange
		String text = "L 6 3 6 4";
		// act
		assertTrue(validateText.validateStructure(text));
	}
	
	@Test
	public void structureRectangleItsGood() {
		
		// arrange
		String text = "R 16 1 20 3";
		// act
		assertTrue(validateText.validateStructure(text));
	}
	
	@Test
	public void structureBucketItsGood() {
		
		// arrange
		String text = "B 10 3 o";
		// act
		assertTrue(validateText.validateStructure(text));
	}
}
