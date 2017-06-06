package components;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class ValidateLogin {

	
	public static void main (String args[]){		

		System.out.println("Executing Business Component - launchSI ....");
		String strKeyword = "home_txt_Search"; /////////////////////////parameterized
		
	      /*try {	
	          File inputFile = new File("D:\\eclipse_Workspace\\eCommerceAutomation\\objectrepository\\xPathRepository.xml");
	          //File inputFile = new File(relativePath + "\\objectrepository\\xPathRepository.xml");	          
	          
	          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	          Document doc = dBuilder.parse(inputFile);
	          doc.getDocumentElement().normalize();
	          System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	          
	          if (doc.getDocumentElement().getNodeName().equals("xPathNode"))
	          {
		          NodeList nList = doc.getElementsByTagName("object");
		          System.out.println("----------------------------");
		          for (int temp = 0; temp < nList.getLength(); temp++) {
		             Node nNode = nList.item(temp);
		             System.out.println("\nCurrent Element :" + nNode.getNodeName());
		             
		             if (nNode.getNodeName().equals("object"))
		             {
			             if (nNode.getNodeType() == Node.ELEMENT_NODE)
			             {
			            	 Element eElement = (Element) nNode;
				             System.out.println("Student roll no : " + eElement.getAttribute("name"));
				             
				             if (eElement.getAttribute("name").equals(strKeyword))
				             {
					             System.out.println("First Name : " + eElement.getElementsByTagName("desktop").item(0).getTextContent());
					             System.out.println("Last Name : " + eElement.getElementsByTagName("mobile").item(0).getTextContent());
					             if (strPlatform.equalsIgnoreCase("Desktop"))
					             {
					            	 strValue = eElement.getElementsByTagName("desktop").item(0).getTextContent();
					             }
					             else
					             {
					            	 strValue = eElement.getElementsByTagName("mobile").item(0).getTextContent();
					             }
					             break;
				             }
				             else
				             {
				            	 //throw new Exception("No element found for object - " + strKeyword);
				            	 continue;
				             }			             

			             }
		             }
		             

		          }
	          }
	          else
	          {
	        	  throw new Exception("Please specify the root element as [xPathNode]");
	          }	          
	          

	       }
	      catch (Exception ex)
	      {
	    	  addStepDetails("Object Identification", "An error occured in locating the object [" + strKeyword + "]", "FAIL");
	          System.out.println("An error occured in locating the object: " + ex.getMessage());
	          return ex.getMessage();
	       }*/
		
		
	}

}
