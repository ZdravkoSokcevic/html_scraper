package com.scraper.classes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.util.Stack;

public class HtmlParser
{
	public Url url;
	private String htmlContent;
	private Document document;
	private Html html;
	public HtmlParser(String url)
	{
		this.url = new Url(url);
	}

	public String getHtmlContent()
	{
		String data = this.url.getData();
		this.document = Jsoup.parse(data);
		this.html = new Html(this.document);
		this.html.findElementsByTag("div");
		System.out.println(this.html.toString());
		return this.html.toString();
	}
}