package com.scraper.classes;
import java.util.Stack;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
class Html
{
	private Stack<String> elements;
	private String findElements;
	private static String defaultElements = "div";
	private Document document;
	public Html()
	{
		this.document = new Document("<p></p>");
		this.elements = new Stack<String>();
	}
	public Html(Document document)
	{
		this.document = document;
		this.elements = new Stack<String>();
		this.findElements = Html.defaultElements;
	}
	public void findElementsByTag(String type)
	{
		this.findElements = type;
	}
	public String toString()
	{
		Elements elements = this.document.getElementsByTag(this.findElements);
		for(Element element:elements)
		{
			String domEl = element.toString();
			System.out.println(domEl.toString());
			domEl = domEl.replaceAll("<","&lt;");
			domEl = domEl.replaceAll(">", "&gt;");
			domEl = domEl.replaceAll("\n", "<br>");
			domEl = domEl.replaceAll("\t", "&nbsp;&nbsp;&nbsp;");
			domEl = domEl + "<br>";
			
			// domEl = domEl.replaceAll("<[^>]*>", "");
			this.elements.push(domEl);
		}
		return this.elements.toString();
	}
}