public class Util {

    //stage1
    public static void ifFizzBuzzOrBuzz(int p) {
        for (int i = 1; i < p; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0)
                    System.out.println("FizzBuzz");
                else
                    System.out.println("Fizz");
            }
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

    //stage2
    public static void ifFizzBuzzOrBuzzStage2(int p) {
        for (Integer i = 1; i < p; i++) {
            if (i % 3 == 0 || i.toString().contains("3")) {
                if (i % 5 == 0||i.toString().contains("5"))
                    System.out.println("FizzBuzz");
                else
                    System.out.println("Fizz");
            }
            else if (i % 5 == 0||i.toString().contains("5"))
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

}
