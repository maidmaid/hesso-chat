package archives.message;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Message
{
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	TransformerFactory tf;
	Transformer transformer;
	XPath xpath;
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException
	{
		Message m = new Message();
		
		String xml = m.writeNewUser("Dany");
		System.out.println(xml);
		
		m.readMessage(xml);
	}
	
	public Message() throws ParserConfigurationException, TransformerConfigurationException
	{
		docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setNamespaceAware(true);
		docBuilder = docFactory.newDocumentBuilder();
		
		tf = TransformerFactory.newInstance();
		transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		
		XPathFactory xpathfactory = XPathFactory.newInstance();
        xpath = xpathfactory.newXPath();
	}
	
	public String writeNewUser(String username) throws ParserConfigurationException, TransformerException
	{
		// message 
		Document doc = docBuilder.newDocument();
		Element messageElement = doc.createElement("message");
		doc.appendChild(messageElement);
		
		// newuser
		Attr commandAttr = doc.createAttribute("command");
		commandAttr.setValue("newuser");
		messageElement.setAttributeNode(commandAttr);
		
		Element usernameElement = doc.createElement("username");
		usernameElement.setTextContent(username);
		messageElement.appendChild(usernameElement);
		
		return DocToString(doc);
	}
	
	private String DocToString(Document doc) throws TransformerException
	{
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String output = writer.getBuffer().toString();
		return output;
	}
	
	public void readMessage(String message) throws SAXException, IOException, XPathExpressionException
	{
		InputSource is = new InputSource(new StringReader(message));
        Document document = docBuilder.parse(is);
 
        XPathExpression xpathCommand = xpath.compile("/message/@command");
        String command = (String) xpathCommand.evaluate(document, XPathConstants.STRING);
        System.out.println(command);
        
        if(command.equals("newuser"))
        {
        	readNewUser(document);
        }
	}
	
	private void readNewUser(Document document) throws SAXException, IOException, XPathExpressionException
	{
    	XPathExpression xpathUsername = xpath.compile("/message/username/text()");
        String username = (String) xpathUsername.evaluate(document, XPathConstants.STRING);
        System.out.println(username);
	}
}
