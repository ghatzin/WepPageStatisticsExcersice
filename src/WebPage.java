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

        // The Document class does not yet handle charset's properly.
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

        // Create a reader on the HTML content.

       
        Reader rd = getReader(url);

        // Parse the HTML.

        kit.read(rd, doc, 0);

        //  The HTML text is now stored in the document

        String plainText=doc.getText(0, doc.getLength());
		return plainText;
	}
	
	
	private  Reader getReader(URL url)  throws IOException
    {
		        // Retrieve from Internet.
		      
		            URLConnection conn = url.openConnection();
		            return new InputStreamReader(conn.getInputStream());	      
    }

}
