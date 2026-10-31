package calculadora;

public class Principal {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        executarOperacao(calculadora, 10, 5, Calculadora.SOMA);
        executarOperacao(calculadora, 10, 5, Calculadora.SUBTRACAO);
        executarOperacao(calculadora, 10, 5, Calculadora.MULTIPLICACAO);
        executarOperacao(calculadora, 7, 2, Calculadora.DIVISAO);
        executarOperacao(calculadora, 10, 0, Calculadora.DIVISAO);
        executarOperacao(calculadora, 10, 5, "%");

        System.out.println("Programa finalizado sem interrupções.");
    }

    private static void executarOperacao(Calculadora calculadora, int primeiroNumero, int segundoNumero,
            String operacao) {
        String expressao = primeiroNumero + " " + operacao + " " + segundoNumero;
        try {
            double resultado = calculadora.calc(primeiroNumero, segundoNumero, operacao);
            System.out.println(expressao + " = " + resultado);
        } catch (ArithmeticException | IllegalArgumentException erro) {
            System.out.println(expressao + " -> Erro: " + erro.getMessage());
        }
    }
}
