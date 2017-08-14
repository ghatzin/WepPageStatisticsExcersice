import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Document
{
	private String plainText;
	
	public Document(String plainText)
	{
		this.plainText=plainText;
	}
	
	public List<String> getTokens(String pattern,String text)
	 {
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	 }
	
	public  List<String> getWords()
	 {
		 
		 List<String> words=new ArrayList<String>();
		 String pattern="\\w*";
		 words=getTokens(pattern,plainText);
		 return words;
	 }
	
	 public Map<String,Integer> getWordfrequency(List<String> words)
	 {
		 
		 Map<String,Integer> wordFrequency=new HashMap<String,Integer>();
		 
		 for (String word:words)
		 {
			 if (wordFrequency.containsKey(word))
			 {
				 wordFrequency.put(word,wordFrequency.get(word)+1);
			 }
			 else
			 {
				 wordFrequency.put(word,1);
			 }	 
		 }
		 
		
		 return wordFrequency;
		 
	 }
	 
	 public void printWordFrequency(Map<String,Integer> wordFrequency)
	 {
		 for (Map.Entry<String,Integer> entry:wordFrequency.entrySet())
		 {
			 
			 String word=entry.getKey();
			 Integer frequency=entry.getValue();
			 
			 System.out.println(word+" "+frequency);
		 }
		 
		 
	 }
	
	 public String longestWord(List<String> words)
	 {
		 int arraySize=words.size();
		 String[] wordsArray=new String[arraySize];
		 for (int i=0;i<words.size();i++)
			 wordsArray[i]=words.get(i);
			 
		 String longestString="";
		 for (int i=0;i<wordsArray.length;i++)
		 {
			 
			if (wordsArray[i].length()>longestString.length())
				longestString=wordsArray[i];
			
			
		 }
		 

		 return longestString;
	 }
	 
	 public char getCommonLetter(List<String> words)
	 {
		
		 String str="";
		 
		for (int i=0;i<words.size();i++)
		  str=str+words.get(i);
	 
				 
		char commonChar=' ';
		int counter=0;
		int[] count=new int[Character.MAX_VALUE];
		
		for (int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if (count[ch]++>=counter)
			{
				counter=count[ch];
				commonChar=ch;
			}
		}
		
		return commonChar;
	 }


}
