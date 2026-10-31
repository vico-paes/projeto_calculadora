package calculadora;

/**
 * Programa de demonstração da {@link Calculadora}.
 *
 * <p>Executa as quatro operações e também dois casos de erro (divisão por zero
 * e operação inválida). Os erros são tratados e exibidos como mensagem, e o
 * programa segue executando até o fim, sem ser interrompido.</p>
 *
 * @author Vinicius Paes Lima
 * @version 2.0
 * @since 1.0
 */
public class Principal {

    /** Construtor privado: a classe só possui métodos estáticos e não deve ser instanciada. */
    private Principal() {
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Operações válidas
        executarOperacao(calculadora, 10, 5, Calculadora.SOMA);
        executarOperacao(calculadora, 10, 5, Calculadora.SUBTRACAO);
        executarOperacao(calculadora, 10, 5, Calculadora.MULTIPLICACAO);
        executarOperacao(calculadora, 7, 2, Calculadora.DIVISAO);

        // Casos de erro: devem mostrar uma mensagem sem encerrar o programa
        executarOperacao(calculadora, 10, 0, Calculadora.DIVISAO);
        executarOperacao(calculadora, 10, 5, "%");

        System.out.println("Programa finalizado sem interrupções.");
    }

    /**
     * Executa uma operação e mostra o resultado ou a mensagem de erro no console.
     *
     * @param calculadora    calculadora usada no cálculo
     * @param primeiroNumero primeiro operando
     * @param segundoNumero  segundo operando
     * @param operacao       símbolo da operação
     */
    private static void executarOperacao(Calculadora calculadora, int primeiroNumero, int segundoNumero,
            String operacao) {
        String expressao = primeiroNumero + " " + operacao + " " + segundoNumero;
        try {
            double resultado = calculadora.calc(primeiroNumero, segundoNumero, operacao);
            System.out.println(expressao + " = " + resultado);
        } catch (ArithmeticException | IllegalArgumentException erro) {
            // Os dois erros previstos são tratados aqui, mantendo o programa em execução.
            System.out.println(expressao + " -> Erro: " + erro.getMessage());
        }
    }
}
