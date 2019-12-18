package com.drawingtool.draw;

import org.springframework.stereotype.Service;

@Service
public class DrawingCanvan {

	public void drawing(String[][] canvan) {

		int altura = canvan.length;
		int ancho = canvan[0].length;
		String aux = " ";
		String auxEnd = aux;
		for (int i = 0; i < canvan[0].length; i++) {
			aux = aux + "-";
		}
		auxEnd = aux;
		System.out.println(aux);

		for (int alto = 0; alto < altura; alto++) {
			aux = "|";
			for (int largo = 0; largo < ancho; largo++) {
				if (canvan[alto][largo] == null) {
					aux = aux + " ";
				} else {
					aux = aux + canvan[alto][largo];
				}
			}
			aux = aux + "|";
			System.out.println(aux);
		}

		System.out.println(auxEnd);

	}

}
