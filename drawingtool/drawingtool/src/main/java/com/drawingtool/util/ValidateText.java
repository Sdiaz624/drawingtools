package com.drawingtool.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drawingtool.mesagges.Mesagges;
import com.drawingtool.service.BucketFill;
import com.drawingtool.service.CanvanRules;
import com.drawingtool.service.Line;
import com.drawingtool.service.Rectangle;

@Service
public class ValidateText {

	private static final boolean FALSE = false;

	private static final boolean TRUE = true;

	@Autowired
	CanvanRules canvanRules;
	
	@Autowired
	Line line;
	
	@Autowired
	Rectangle rectangle;

	@Autowired
	Mesagges mesagges;
	
	@Autowired
	BucketFill bucketFill;
	
	private static final char BUCKET_FILL = 'B';
	private static final char CANVAN = 'C';
	private static final char LINE = 'L';
	private static final char RECTANGLE = 'R';
	private static final char QUIT = 'Q';

	public boolean validateStructure(String text) {
	
		char getFristWord = text.charAt(0);
		
		switch (getFristWord) {
		case CANVAN:
			canvanRules.validateCreateCanvan(text);
			return TRUE;
		case LINE:
			line.proccesLine(text);
			return TRUE;
		case RECTANGLE:
			rectangle.proccesRectangle(text);
			return TRUE;
		case BUCKET_FILL:
			bucketFill.proccesBucketFill(text);
			return TRUE;
		case QUIT:
			mesagges.exit();
			return FALSE;
		default:
			mesagges.commandInvalid(text);
			return TRUE;
		}
		
	}

	
	
}
