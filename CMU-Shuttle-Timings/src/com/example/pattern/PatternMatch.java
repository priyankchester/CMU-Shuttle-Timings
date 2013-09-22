package com.example.pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternMatch {
	final static  Pattern h1pattern = Pattern.compile("<h1>(.+?)</h1>");
	final static  Pattern h2pattern = Pattern.compile("<h2>(.+?)</h2>");
	final static  Pattern ppattern = Pattern.compile("<p>(.+?)</p>");
	final static  Pattern strongpattern = Pattern.compile("<strong>(.+?)</strong>$");
	final static  Pattern spanpattern = Pattern.compile("<span>(.+?)</span>");
	
	public static String clean(String toClean, String elementType){
		
		if(elementType.equalsIgnoreCase("h1")){
			Matcher matcher = h1pattern.matcher(toClean);
			matcher.find();
			return matcher.group(1);
		}
		else if(elementType.equalsIgnoreCase("h2")){
			Matcher matcher = h2pattern.matcher(toClean);
			matcher.find();
			return matcher.group(1);
		}
		else if(elementType.equalsIgnoreCase("span")){
				Matcher matcher = spanpattern.matcher(toClean);
				matcher.find();
				return matcher.group(1);
		}
		else if(elementType.equalsIgnoreCase("strong")){
			Matcher matcher = strongpattern.matcher(toClean);
			matcher.find();
			return matcher.group(1);
		}
		else if(elementType.equalsIgnoreCase("p")){
			Matcher matcher = ppattern.matcher(toClean);
			matcher.find();
			return matcher.group(1);
		}
		else{
			if(toClean.contains("<p>"))
				toClean = clean(toClean,"p");
			if(toClean.contains("<span>"))
				toClean = clean(toClean,"span");
			if(toClean.contains("<strong>"))
				toClean = clean(toClean,"strong");
			if(toClean.contains("<strong>"))
				toClean = clean(toClean,"strong");
			return toClean;
		}
		
	}
	
	public static String cleanup(String toClean){
		toClean = toClean.replace("<br />", "");
		toClean = toClean.replace("&nbsp;", "");
		return toClean;
	}	
}
