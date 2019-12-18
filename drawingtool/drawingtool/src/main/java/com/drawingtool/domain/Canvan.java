package com.drawingtool.domain;

import org.springframework.stereotype.Component;

@Component 
public class Canvan {

	public boolean exists = false;
	public String[][] canvan;
		
	public boolean isExists() {
		return exists;
	}
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	public String[][] getCanvan() {
		return canvan;
	}
	public void setCanvan(String[][] canvan) {
		this.canvan = canvan;
	}


	
	
}

