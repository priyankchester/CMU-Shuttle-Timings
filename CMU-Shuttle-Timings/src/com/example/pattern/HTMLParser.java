package com.example.pattern;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class HTMLParser {
  public static ArrayList<String> parse(String url) {
	Document doc;
	ArrayList<String> resultList=new ArrayList<String>();
	try {
 
		// need http protocol
		doc = Jsoup.connect(url).get(); 
		
		Elements div = doc.select("div#admin_2ColLevelContent");
		Elements headingElem = div.select("h1");
		String heading = PatternMatch.clean(headingElem.toString(),"h1");
		heading = PatternMatch.cleanup(heading);
		System.out.println(heading); // Prints String I want to extract
		resultList.add(heading);
		
		Elements heading2Elem = div.select("h2");
		String heading2 = PatternMatch.clean(heading2Elem.toString(),"h2");
		heading2 = PatternMatch.cleanup(heading2);
		System.out.println(heading2); // Prints String I want to extract
		resultList.add(heading2);
		
		Elements data = div.select("p");
		Iterator<Element> ite = data.iterator();
		
		ite.next();
		
		while(ite.hasNext()){
			String line = ite.next().toString();
			line = PatternMatch.cleanup(line);
			String result = PatternMatch.clean(line, "other");
			System.out.println(result);
			resultList.add(result);	
		}
 
	} catch (IOException e) {
		e.printStackTrace();
	}
	return resultList;
  }
 
}