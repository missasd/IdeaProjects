package JavaCoreVolumeTwo.chp2xml.p1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * title author year price
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            File xmlfile = new File("src/JavaCoreVolumeTwo/chp2xml/p1/Status.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlfile);
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Node name: " + node.getNodeName());
                Element element = (Element)node;
                System.out.println("------------");
                if (node.getNodeType() == Element.ELEMENT_NODE){
                    System.out.println("book category: " + element.getAttribute("category"));
                    System.out.println("title name: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("author name: " + element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("year : " + element.getElementsByTagName("year").item(0).getTextContent());
                    System.out.println("price : " + element.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("----------");

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
