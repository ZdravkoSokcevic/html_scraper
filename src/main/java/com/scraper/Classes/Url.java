package com.scraper.classes;
import java.net.URLConnection;
import java.net.URL;
import java.util.Scanner;

public class Url
{
	private String data;
	private String url;
	private URLConnection connection;

	public Url(String url)
	{
		this.url = url;
	}

	public String getData()
	{
		try{
			this.connection = new URL(url).openConnection();
			Scanner s = new Scanner(this.connection.getInputStream());
			s.useDelimiter("\\Z");
			this.data = s.next();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		// System.out.println(this.data);
		return this.data;
	}

}