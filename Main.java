package com.gmail.s12348.evgen;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		SiteVerification sver=new SiteVerification();
		File file=new File("url.txt");
		sver.loadAdressFromFileToArray(file);
		for (String urlAdress : sver.getUrlAdress()) {
			System.out.println(urlAdress+" "+sver.checkOneURL(urlAdress));
		}

	}

}
