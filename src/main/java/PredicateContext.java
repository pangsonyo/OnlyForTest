import org.reflections.Reflections;

import java.lang.reflect.Method;
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

    public void NumberPredicateTest(Integer i)  throws Exception{
        PredicateContext predicateContext = new PredicateContext();
        Set<Class<? extends NumberPredicate >> classes = predicateContext.getAllNumberPredicateClass();
        for(Class clazz : classes) {
            //System.out.println("Found: " + clazz.getName());
            Method rule = clazz.getMethod("rule", Integer.class);
            Method behavior = clazz.getMethod("behavior");

            Boolean b = (Boolean)rule.invoke(clazz.forName(clazz.getName()).newInstance(), i);
            if(!b){
                continue;
            }else {
               String a = (String)behavior.invoke(clazz.forName(clazz.getName()).newInstance());

               //deal with the bussiness
               System.out.println(a);
            }

        }

    }

    public static void main(String[] args) {
        PredicateContext predicateContext = new PredicateContext();
        try {
            predicateContext.NumberPredicateTest(13);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
