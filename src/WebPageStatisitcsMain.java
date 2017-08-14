
public class WebPageStatisitcsMain
{

	public static void main(String[] args) throws Exception
	{
		WebPage webPage=new WebPage("http://www.city.academic.gr");
		
		String plainText=webPage.getPlainText();
		
		Document document=new Document(plainText);
		
		document.printWordFrequency(document.getWordfrequency(document.getWords()));
		
		System.out.println(document.longestWord(document.getWords()));
		
		System.out.println(document.getCommonLetter(document.getWords()));

	}

}
