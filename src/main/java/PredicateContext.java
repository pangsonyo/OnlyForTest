public class PredicateContext {

    private NumberPredicate predicate;

    public PredicateContext(NumberPredicate predicate) {
        this.predicate = predicate;
    }

    public String getNumberPredicate(Integer i){
        if(predicate == null){
            predicate = new NonePredicate();
        }

        return this.predicate.rule(i)?this.predicate.behavior():i.toString();


    }

}
