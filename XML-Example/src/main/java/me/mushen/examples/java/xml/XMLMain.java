package me.mushen.examples.java.xml;

/**
 * @Desc
 * @Author Remilia
 * @Create 2017-11-23
 */
public class XMLMain {

    public static void main(String[] args){
//        System.out.println(XMLConvert.parseUpdatePlan("/Users/Remilia/Repository/CWDevilWH/Java-Examples/XML-Example/src/main/resources/updateplan/dc_home_ju_product.xml"));
    }
//    public static Map<String, String> parseSqlMap(Resource resource) {
//        Map<String, String> sqlMap = new LinkedHashMap<>();
//        try(InputStream is = resource.getInputStream()){
//            // Document Builder
//            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            Document document = builder.parse(is);
//            Element root = document.getDocumentElement();
//            NodeList children = root.getChildNodes();
//
//            for(int i = 0; i < children.getLength(); i++) {
//                Node child = children.item(i);
//                if(child instanceof Element) {
//                    Element childElement = (Element)child;
//                    String key = childElement.getAttribute("id");
//                    String sql = Strings.stringWithTrim(((Text)childElement.getFirstChild()).getData());
//                    if(!Strings.isNullOrEmpty(key) && !Strings.isNullOrEmpty(sql)) {
//                        sqlMap.put(key, sql);
//                    }
//                }
//            }
//        } catch(Exception e) {
//            sqlMap = new HashMap<>();
//        }
//
//        return sqlMap;
//    }
}
