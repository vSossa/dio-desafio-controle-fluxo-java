public class Contador {
    public static void main(String[] args) {
        int comeco = 0;
        int fim = 0;

        if (args.length != 2) {
            System.out.println("Uso: java Contador <começo> <fim>");
            System.err.printf("ERRO: exatamente 2 argumentos são esperados, " + 
            "mas obtemos %d.%n", args.length);
            System.exit(1);
        }

        try {
            comeco = Integer.parseInt(args[0]);
            fim = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("ERRO: ambos os argumentos devem ser numéricos.");
            System.exit(1);
        }

        if (comeco < 0 || fim < 0) {
            System.err.println("ERRO: ambos os argumentos devem ser não " +
            "negativos.");
            System.exit(1);
        }

        try {
            contar(comeco, fim);
        } catch (ParametrosInvalidosException e) {
            System.err.println("ERRO: o primeiro parâmetro deve ser menor ou " +
            "igual ao segundo.");
            System.exit(1);
        }
    }

    static void contar(final int comeco, final int fim) 
    throws ParametrosInvalidosException {
        int contagem = fim - comeco;

        if (contagem < 0) {
            throw new ParametrosInvalidosException();
        }

        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    } 
}
