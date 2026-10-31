package calculadora;

public class Calculadora {

    public double calc(int a, int b, String op) {
        double r = 0;
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida: null. Use +, -, * ou /.");
        }
        if (op.equals("+")) {
            r = (double) a + b;
        } else if (op.equals("-")) {
            r = (double) a - b;
        } else if (op.equals("*")) {
            r = (double) a * b;
        } else if (op.equals("/")) {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero não é permitida.");
            } else {
                r = (double) a / b;
            }
        } else {
            throw new IllegalArgumentException("Operação inválida: " + op + ". Use +, -, * ou /.");
        }
        return r;
    }
}
