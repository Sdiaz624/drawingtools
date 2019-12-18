package com.drawingtool;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.drawingtool.mesagges.Mesagges;
import com.drawingtool.util.ValidateText;

@Component
@Profile("!test")
public class DrawingTool implements CommandLineRunner  {

		
	private static final boolean TRUE = true;
	private static final String WELCOME_TO_DRAWING_TOOL = "Welcome to DrawingTool";
	private static final String PLEASE_WRITE_THE_SIZE_OF_CANVAN = "Please, Write the size of canvan";
	private static final String PLEASE_WRITE_THE_NEW_OF_COMMAND = "Please, Write the new of command";
	@Autowired
	ValidateText validateText;
	
	@Autowired
	Mesagges mesagges;
	
	public void run(String... args) throws Exception {
		
		startTool();
		
	}
	
	private void startTool() {
		
		boolean keep = TRUE;
		System.out.println(WELCOME_TO_DRAWING_TOOL);
		System.out.println(PLEASE_WRITE_THE_SIZE_OF_CANVAN);
		
		while (keep) {
			Scanner type = new Scanner(System.in);
			String text = type.nextLine();
			keep = validateInput(keep, text);
			if(keep) {
				System.out.println(PLEASE_WRITE_THE_NEW_OF_COMMAND);
			}
		}
	}

	private boolean validateInput(boolean continuar, String text) {
		if (text.isEmpty()) {
			mesagges.commandInvalid(text);
		}else {
			continuar = validateText.validateStructure(text);
		}
		return continuar;
	}

	
}
