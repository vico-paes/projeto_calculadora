package calculadora;

/**
 * Módulo de cálculos matemáticos básicos do aplicativo FinançApp.
 *
 * <p>Realiza as quatro operações fundamentais (soma, subtração, multiplicação
 * e divisão) sobre dois números inteiros. Ela será usada em funcionalidades
 * como orçamento mensal, divisão de despesas e projeção de economia.</p>
 *
 * <p>Os resultados são devolvidos como {@code double} para que divisões não
 * exatas (por exemplo, {@code 7 / 2 = 3.5}) não percam a parte decimal, o que
 * é importante em valores financeiros.</p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * Calculadora calculadora = new Calculadora();
 * double total = calculadora.calc(1200, 3, Calculadora.DIVISAO); // 400.0
 * }</pre>
 *
 * @author Nome do Aluno
 * @version 2.0
 * @since 1.0
 */
public class Calculadora {

    /** Símbolo da operação de soma: {@value}. */
    public static final String SOMA = "+";

    /** Símbolo da operação de subtração: {@value}. */
    public static final String SUBTRACAO = "-";

    /** Símbolo da operação de multiplicação: {@value}. */
    public static final String MULTIPLICACAO = "*";

    /** Símbolo da operação de divisão: {@value}. */
    public static final String DIVISAO = "/";

    /** Mensagem da exceção lançada quando o divisor é zero: {@value}. */
    static final String MENSAGEM_DIVISAO_POR_ZERO = "Divisão por zero não é permitida.";

    /**
     * Modelo da mensagem da exceção lançada para operações não suportadas.
     * O marcador {@code %s} é substituído pelo operador recebido.
     */
    static final String MENSAGEM_OPERACAO_INVALIDA = "Operação inválida: %s. Use +, -, * ou /.";

    /**
     * Cria uma calculadora. A classe não guarda estado, então a mesma
     * instância pode ser reutilizada em vários cálculos.
     */
    public Calculadora() {
        // Nada a inicializar: todos os atributos são constantes.
    }

    /**
     * Executa a operação matemática indicada sobre dois números inteiros.
     *
     * @param primeiroNumero primeiro operando (por exemplo, o dividendo na divisão)
     * @param segundoNumero  segundo operando (por exemplo, o divisor na divisão)
     * @param operacao       símbolo da operação: {@code "+"}, {@code "-"},
     *                       {@code "*"} ou {@code "/"}
     * @return o resultado da operação
     * @throws ArithmeticException      se a operação for divisão e
     *                                  {@code segundoNumero} for zero
     * @throws IllegalArgumentException se {@code operacao} for {@code null}
     *                                  ou não for um dos quatro símbolos aceitos
     */
    public double calc(int primeiroNumero, int segundoNumero, String operacao) {
        // O switch lançaria NullPointerException com null; tratamos antes
        // para devolver uma mensagem clara ao usuário.
        if (operacao == null) {
            throw operacaoInvalida(operacao);
        }

        // Cada operação foi extraída para um método próprio, deixando aqui
        // apenas a escolha de qual cálculo executar.
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

    /**
     * Soma dois números.
     *
     * @param primeiroNumero primeira parcela
     * @param segundoNumero  segunda parcela
     * @return a soma das parcelas
     */
    private double somar(int primeiroNumero, int segundoNumero) {
        // A conversão para double antes da conta evita estouro do limite de int.
        return (double) primeiroNumero + segundoNumero;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param minuendo   valor do qual se subtrai
     * @param subtraendo valor subtraído
     * @return a diferença {@code minuendo - subtraendo}
     */
    private double subtrair(int minuendo, int subtraendo) {
        return (double) minuendo - subtraendo;
    }

    /**
     * Multiplica dois números.
     *
     * @param primeiroFator primeiro fator
     * @param segundoFator  segundo fator
     * @return o produto dos fatores
     */
    private double multiplicar(int primeiroFator, int segundoFator) {
        return (double) primeiroFator * segundoFator;
    }

    /**
     * Divide o dividendo pelo divisor, mantendo a parte decimal.
     *
     * @param dividendo valor a ser dividido
     * @param divisor   valor pelo qual se divide; não pode ser zero
     * @return o quociente com casas decimais (por exemplo, {@code 7 / 2 = 3.5})
     * @throws ArithmeticException se {@code divisor} for zero
     */
    private double dividir(int dividendo, int divisor) {
        validarDivisor(divisor);
        // Converter para double evita a divisão inteira, que descartaria os decimais.
        return (double) dividendo / divisor;
    }

    /**
     * Garante que o divisor seja diferente de zero.
     *
     * @param divisor valor a ser verificado
     * @throws ArithmeticException se {@code divisor} for zero
     */
    private void validarDivisor(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException(MENSAGEM_DIVISAO_POR_ZERO);
        }
    }

    /**
     * Cria a exceção usada quando a operação não é suportada.
     *
     * @param operacao operador recebido (pode ser {@code null})
     * @return exceção com a mensagem explicando quais operadores são aceitos
     */
    private IllegalArgumentException operacaoInvalida(String operacao) {
        return new IllegalArgumentException(String.format(MENSAGEM_OPERACAO_INVALIDA, operacao));
    }
}
