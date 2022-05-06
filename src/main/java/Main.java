public class Main {

    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
//        try {

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);//второе число получается 0 решение: 1.через exception; 2.добавить еще один оператор
        System.out.println(calc.ex.apply(String.valueOf(c)));

        calc.println.accept(c);

//        }catch (ArithmeticException exception) {
//            System.out.println("второе число 0, делить нельзя");
//        }
    }
}
