import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class PredicateContext {

   private NumberPredicate predicate;

//    public PredicateContext(NumberPredicate predicate) {
//        this.predicate = predicate;
//    }

    public PredicateContext(){};

//    public String getNumberPredicate(Integer i){
//        if(predicate == null){
//            predicate = new NonePredicate();
//        }
//        return this.predicate.rule(i)?this.predicate.behavior():i.toString();
//
//    }

    private Set getAllNumberPredicateClass(){
        Reflections reflections = new Reflections("");
        //get all the class which implements the NumberPredicate
        return reflections.getSubTypesOf(NumberPredicate .class);

    }

    public static void NumberPredicateTest(Integer i,NumberPredicate n)  throws Exception{
//        PredicateContext predicateContext = new PredicateContext();
//        Set<Class<? extends NumberPredicate >> classes = predicateContext.getAllNumberPredicateClass();
       // for(Class clazz : predicateMap.v) {
            //System.out.println("Found: " + clazz.getName());
            Method rule = n.getClass().getMethod("rule", Integer.class);
            Method behavior = n.getClass().getMethod("behavior");

            Boolean b = (Boolean)rule.invoke(n, i);
            if(!b){
                //continue;
            }else {
               String a = (String)behavior.invoke(n);

               //deal with the bussiness
               System.out.println(a);
            }

        //}

    }

    public static void main(String[] args) throws Exception {

        PredicateFactory factory = PredicateFactory.getInstance();
        Map<String,NumberPredicate> predicateMap = factory.getPredicateMap();

        for (int i=1 ;i<=100;i++){
            for (String s:predicateMap.keySet()) {
                PredicateContext.NumberPredicateTest(i, predicateMap.get(s));
            }

        }

    }

}
