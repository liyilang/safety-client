package com.util;

import java.util.regex.Pattern;

public class PathSegment {
	public static String[] pathSegments; 
	
	
	public static void pathPro(String uri){
		Pattern pattern = Pattern.compile("[//?]+");
		pathSegments = pattern.split(uri);
		for (int i=0;i<pathSegments.length;i++) {
		    System.out.println(pathSegments[i]);
		} 
	}
	
	public static void main(String[] args){
		
		Pattern pattern = Pattern.compile("[//?]+");
		String uri="entity/entityID/location?path=1&name=2";
		String[] strs = pattern.split(uri);
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		} 
		
	}
}
