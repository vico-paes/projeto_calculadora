package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Testes unitários da classe {@link Calculadora}.
 *
 * <p>Cada teste exibe no console a entrada utilizada, o resultado esperado
 * e o resultado obtido, além de validar o resultado com asserções do JUnit.</p>
 *
 * @author Vinicius Paes Lima
 * @version 1.0
 */
@DisplayName("Testes da Calculadora")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TesteCalculadora {

    /** Margem de erro aceita na comparação de valores decimais. */
    private static final double DELTA = 0.0001;

    /** Instância da calculadora testada, recriada antes de cada teste. */
    private Calculadora calculadora;

    /** Construtor usado pelo JUnit para instanciar a classe de testes. */
    TesteCalculadora() {
    }

    /** Cria uma calculadora nova antes de cada teste. */
    @BeforeEach
    void prepararCalculadora() {
        calculadora = new Calculadora();
    }

    /** Caso de teste 1: Soma: 10 + 5 = 15. */
    @Test
    @Order(1)
    @DisplayName("Soma: 10 + 5 = 15")
    void deveSomarDoisNumeros() {
        double esperado = 15;
        double obtido = calculadora.calc(10, 5, "+");
        exibir("10 + 5", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 2: Soma com negativo: -8 + 3 = -5. */
    @Test
    @Order(2)
    @DisplayName("Soma com negativo: -8 + 3 = -5")
    void deveSomarNumeroNegativo() {
        double esperado = -5;
        double obtido = calculadora.calc(-8, 3, "+");
        exibir("-8 + 3", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 3: Subtração: 10 - 5 = 5. */
    @Test
    @Order(3)
    @DisplayName("Subtração: 10 - 5 = 5")
    void deveSubtrairDoisNumeros() {
        double esperado = 5;
        double obtido = calculadora.calc(10, 5, "-");
        exibir("10 - 5", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 4: Subtração com resultado negativo: 5 - 10 = -5. */
    @Test
    @Order(4)
    @DisplayName("Subtração com resultado negativo: 5 - 10 = -5")
    void deveSubtrairComResultadoNegativo() {
        double esperado = -5;
        double obtido = calculadora.calc(5, 10, "-");
        exibir("5 - 10", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 5: Multiplicação: 10 * 5 = 50. */
    @Test
    @Order(5)
    @DisplayName("Multiplicação: 10 * 5 = 50")
    void deveMultiplicarDoisNumeros() {
        double esperado = 50;
        double obtido = calculadora.calc(10, 5, "*");
        exibir("10 * 5", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 6: Multiplicação por zero: 10 * 0 = 0. */
    @Test
    @Order(6)
    @DisplayName("Multiplicação por zero: 10 * 0 = 0")
    void deveMultiplicarPorZero() {
        double esperado = 0;
        double obtido = calculadora.calc(10, 0, "*");
        exibir("10 * 0", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 7: Divisão exata: 10 / 5 = 2. */
    @Test
    @Order(7)
    @DisplayName("Divisão exata: 10 / 5 = 2")
    void deveDividirDoisNumeros() {
        double esperado = 2;
        double obtido = calculadora.calc(10, 5, "/");
        exibir("10 / 5", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 8: Divisão com decimal: 7 / 2 = 3.5. */
    @Test
    @Order(8)
    @DisplayName("Divisão com decimal: 7 / 2 = 3.5")
    void deveDividirComResultadoDecimal() {
        double esperado = 3.5;
        double obtido = calculadora.calc(7, 2, "/");
        exibir("7 / 2", String.valueOf(esperado), String.valueOf(obtido));
        assertEquals(esperado, obtido, DELTA);
    }

    /** Caso de teste 9: Divisão por zero: 10 / 0 lança ArithmeticException. */
    @Test
    @Order(9)
    @DisplayName("Divisão por zero: 10 / 0 lança ArithmeticException")
    void deveImpedirDivisaoPorZero() {
        ArithmeticException erro = assertThrows(ArithmeticException.class,
                () -> calculadora.calc(10, 0, "/"));
        exibir("10 / 0", "ArithmeticException", erro.getClass().getSimpleName() + " (" + erro.getMessage() + ")");
        assertEquals("Divisão por zero não é permitida.", erro.getMessage());
    }

    /** Caso de teste 10: Operação inválida: 10 % 5 lança IllegalArgumentException. */
    @Test
    @Order(10)
    @DisplayName("Operação inválida: 10 % 5 lança IllegalArgumentException")
    void deveRejeitarOperacaoInvalida() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, "%"));
        exibir("10 % 5", "IllegalArgumentException", erro.getClass().getSimpleName() + " (" + erro.getMessage() + ")");
        assertEquals("Operação inválida: %. Use +, -, * ou /.", erro.getMessage());
    }

    /** Caso de teste 11: Operação nula: 10 null 5 lança IllegalArgumentException. */
    @Test
    @Order(11)
    @DisplayName("Operação nula: 10 null 5 lança IllegalArgumentException")
    void deveRejeitarOperacaoNula() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, null));
        exibir("10 null 5", "IllegalArgumentException", erro.getClass().getSimpleName() + " (" + erro.getMessage() + ")");
        assertEquals("Operação inválida: null. Use +, -, * ou /.", erro.getMessage());
    }

    /**
     * Mostra no console a entrada, o resultado esperado e o resultado obtido de um teste.
     *
     * @param entrada  operação testada, por exemplo {@code "10 + 5"}
     * @param esperado resultado esperado
     * @param obtido   resultado realmente devolvido pela calculadora
     */
    private static void exibir(String entrada, String esperado, String obtido) {
        System.out.printf("Entrada: %-10s | Esperado: %-25s | Obtido: %s%n", entrada, esperado, obtido);
    }
}
