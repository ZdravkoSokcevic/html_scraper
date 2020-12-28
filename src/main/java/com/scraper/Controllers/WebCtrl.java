package com.scraper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;
import com.scraper.classes.Url;
import com.scraper.classes.HtmlParser;

@Controller
public class WebCtrl {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello!";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Map json()
    {
    	HashMap<String, String> nesto = new HashMap<>();
    	nesto.put("ime", "Pera");
    	nesto.put("prezime", "Peric");
    	return nesto;
    }

    @RequestMapping("/fetch")
    @ResponseBody
    public String getHTML(@RequestParam("site") String siteName)
    {
        Url site= new Url(siteName);
        return site.getData();
    }

    @RequestMapping("/fetch/site")
    @ResponseBody
    public String getSite(@RequestParam("site") String url)
    {
        HtmlParser parser = new HtmlParser(url);
        String retData = parser.getHtmlContent();
        return retData; 
    }
}