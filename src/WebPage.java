import java.io.*;
import java.net.*;
import javax.swing.text.*;
import javax.swing.text.Document;
import javax.swing.text.html.*;



public class WebPage
{

	private URL url;

	public WebPage(String pageURL) throws IOException
	{
		url=new URL(pageURL);
	}
	
	
	public String getPlainText() throws Exception
	{
		
		EditorKit kit = new HTMLEditorKit();
        Document doc = kit.createDefaultDocument();

        
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

        // Create a reader on the HTML content.

       
        Reader rd = getReader(url);

        

        kit.read(rd, doc, 0);

       

        String plainText=doc.getText(0, doc.getLength());
		return plainText;
	}
	
	
	private  Reader getReader(URL url)  throws IOException
    {
		       
		      
		            URLConnection conn = url.openConnection();
		            return new InputStreamReader(conn.getInputStream());	      
    }

}
