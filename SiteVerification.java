package com.gmail.s12348.evgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SiteVerification {
	private List<String>urlAdress=new ArrayList<>();
	
	public SiteVerification() {
		super();		
	}

	public List<String> getUrlAdress() {
		return urlAdress;
	}

	public void loadAdressFromFileToArray(File file) {
		try (BufferedReader br=new BufferedReader(new FileReader(file))){
			String adress="";
			for(;(adress=br.readLine())!=null;){
				this.urlAdress.add(adress);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String checkOneURL(String urlAdress) {
		try {
			URL url = new URL(urlAdress);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responceCode = con.getResponseCode();
			if (responceCode >= 200 && responceCode < 300) {
				return "YES";
			} else {
				return "NO - " + con.getResponseMessage();
			}
		} catch (IOException e) {
			return "not register";
		}
	}
}
