package com.java7book.chapter6.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
	
	public void namedCapturingGroup() {
		String url = "http://www.example.org/uid/alex/docid/1/title/My+First+Blog";
		Pattern pattern = Pattern.compile("^.*/uid/(?<uid>.*)/docid/(?<docid>.*)/title/(?<title>.*)");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches()) {
			String uid = matcher.group("uid");
			String docId = matcher.group("docid");
			String title = matcher.group("title");
			System.out.println(uid);
			System.out.println(docId);
			System.out.println(title);
		}
	}
	
	public void repeatPattern() {
		String str = "123-123-12-456-456";
		Pattern pattern = Pattern.compile("(?<num>\\d+)-\\k<num>");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String repeat = matcher.group("num");
		}
	}

	public void useUnicodeCharacterClass() {
		String str = "100１００";
		Pattern pattern = Pattern.compile("(\\d+)");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			String digit = matcher.group(1); //值为100
		}
		pattern = Pattern.compile("(\\d+)", Pattern.UNICODE_CHARACTER_CLASS);
		matcher = pattern.matcher(str);
		if (matcher.find()) {
			String digit = matcher.group(1); //值为100１００
		}
	}
	
	public void matchScript() {
		String str = "abc你好123";
		Pattern pattern = Pattern.compile("(\\p{script=Han}+)");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			String hans = matcher.group(1);
			System.out.println(hans);
		}
	}
	
	public static void main(String[] args) {
		RegExp re = new RegExp();
		re.namedCapturingGroup();
		re.repeatPattern();
		re.useUnicodeCharacterClass();
		re.matchScript();
	}

}
