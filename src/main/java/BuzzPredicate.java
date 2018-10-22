public class BuzzPredicate implements NumberPredicate{

    public boolean rule(Integer i) {
        return  i % 3 == 0;
    }

    public String behavior() {
        return  "Buzz";
    }
}
