package calculadora;

public class Principal {

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        int[][] nums = { { 10, 5 }, { 10, 5 }, { 10, 5 }, { 7, 2 }, { 10, 0 }, { 10, 5 } };
        String[] ops = { "+", "-", "*", "/", "/", "%" };
        for (int i = 0; i < ops.length; i++) {
            try {
                double r = c.calc(nums[i][0], nums[i][1], ops[i]);
                System.out.println(nums[i][0] + " " + ops[i] + " " + nums[i][1] + " = " + r);
            } catch (ArithmeticException e) {
                System.out.println(nums[i][0] + " " + ops[i] + " " + nums[i][1] + " -> Erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(nums[i][0] + " " + ops[i] + " " + nums[i][1] + " -> Erro: " + e.getMessage());
            }
        }
        System.out.println("Programa finalizado sem interrupções.");
    }
}
