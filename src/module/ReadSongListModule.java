package module;

import java.io.File;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ReadSongListModule {

	private ServletContext ctx;
	private DocumentBuilder builder;
	private Document songDoc;
	
	public ReadSongListModule(ServletContext ctx) {
		this.ctx = ctx;
		readSongList();
	}
	
	private void readSongList() {	
		try {
			File fXmlFile = new File(ctx.getRealPath(File.separator + "WEB-INF" + File.separator + "raw" + File.separator + "string-array.xml"));
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			songDoc = builder.parse(fXmlFile);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fatal : Song List File Read ERROR !!!");
		}
	}
	
	public Document getSongDoc() {
		return songDoc;
	}
	
}
