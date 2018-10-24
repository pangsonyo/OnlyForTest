package com.core;import org.jdom.Document;import org.jdom.Element;import org.jdom.input.SAXBuilder;import java.io.StringReader;import java.lang.reflect.Field;import java.util.*;public class RulePraser {    static String  file = "src\\main\\resources\\Bean.xml";    private Element root;    //the map needs order which defined in the Bean.xml    private Map<String,Object> objPool = Collections.synchronizedMap(new LinkedHashMap<String, Object>());    public  RulePraser (String  file) throws Exception {        SAXBuilder sb = new SAXBuilder();        Document doc = sb.build(this.file);        root = doc.getRootElement();        initPool();    }    private void initPool() throws Exception {        for(Object obj:root.getChildren()){            Element ruleEle = (Element) obj;            String rule = ruleEle.getAttributeValue("expression");            String behaviorClass = ruleEle.getAttributeValue("BehaviorClass");            objPool.put(rule,Class.forName(behaviorClass).newInstance());        }    }    private void behavior(){//        for (String s: objPool.keySet() ) {//            if(s)//        }    }    public static void main(String[] args) throws Exception {    }    public static Object xmlToBean(String xml,Class obj){        SAXBuilder builder=new SAXBuilder();        Field[] fields = obj.getDeclaredFields();        String  beanName=obj.getSimpleName();        try {            Object object = Class.forName(obj.getName()).newInstance();            Document doc = builder.build(new StringReader(xml));            Element books = doc.getRootElement();            List booklist = books.getChildren(beanName);            for (Iterator iter = booklist.iterator(); iter.hasNext(); ) {                Element book = (Element) iter.next();                for (int j = 0; j < fields.length; j++) {                    fields[j].setAccessible(true);                    if (!fields[j].toString().contains("final")) {                        fields[j].set(object,book.getChildTextTrim(fields[j].getName())==null?"":book.getChildTextTrim(fields[j].getName()));                    }                }            }            System.out.println(fields.toString());            return object;        }catch(Exception e){            e.printStackTrace();        }        return null;    }}