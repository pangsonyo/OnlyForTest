package com.core;

import com.ipredocate.Predicate;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import java.util.*;

/**
 * add by peng
 * RulePraser like a spring container which contain all the behavior class
 */
public class RulePraser {

    static String  file = "src\\main\\resources\\Bean.xml";

    private Element root;
    //the map needs order which defined in the Bean.xml
    private Map<String, Predicate> objPool = Collections.synchronizedMap(new LinkedHashMap<String, Predicate>());


    public  RulePraser (String  file) throws Exception {
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(this.file);
        root = doc.getRootElement();
        initPool();
    }


    private void initPool() throws Exception {
        for(Object obj:root.getChildren()){
            Element ruleEle = (Element) obj;
            String rule = ruleEle.getAttributeValue("expression");
            String behaviorClass = ruleEle.getAttributeValue("BehaviorClass");
            objPool.put(rule, (Predicate) Class.forName(behaviorClass).newInstance());
        }
    }

    public Map getObjPool(){
        return objPool;
    }


}
