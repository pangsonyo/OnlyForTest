public class FizzPredicate implements NumberPredicate{

    public boolean rule(Integer i) {
        return i % 5 == 0;
    }

    public String behavior() {
        return  "Fizz";
    }
}
