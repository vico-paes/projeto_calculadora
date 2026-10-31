package calculadora;

public class Calculadora {

    public static final String SOMA = "+";
    public static final String SUBTRACAO = "-";
    public static final String MULTIPLICACAO = "*";
    public static final String DIVISAO = "/";

    static final String MENSAGEM_DIVISAO_POR_ZERO = "Divisão por zero não é permitida.";
    static final String MENSAGEM_OPERACAO_INVALIDA = "Operação inválida: %s. Use +, -, * ou /.";

    public double calc(int primeiroNumero, int segundoNumero, String operacao) {
        if (operacao == null) {
            throw operacaoInvalida(operacao);
        }

        switch (operacao) {
            case SOMA:
                return somar(primeiroNumero, segundoNumero);
            case SUBTRACAO:
                return subtrair(primeiroNumero, segundoNumero);
            case MULTIPLICACAO:
                return multiplicar(primeiroNumero, segundoNumero);
            case DIVISAO:
                return dividir(primeiroNumero, segundoNumero);
            default:
                throw operacaoInvalida(operacao);
        }
    }

    private double somar(int primeiroNumero, int segundoNumero) {
        return (double) primeiroNumero + segundoNumero;
    }

    private double subtrair(int minuendo, int subtraendo) {
        return (double) minuendo - subtraendo;
    }

    private double multiplicar(int primeiroFator, int segundoFator) {
        return (double) primeiroFator * segundoFator;
    }

    private double dividir(int dividendo, int divisor) {
        validarDivisor(divisor);
        return (double) dividendo / divisor;
    }

    private void validarDivisor(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException(MENSAGEM_DIVISAO_POR_ZERO);
        }
    }

    private IllegalArgumentException operacaoInvalida(String operacao) {
        return new IllegalArgumentException(String.format(MENSAGEM_OPERACAO_INVALIDA, operacao));
    }
}
