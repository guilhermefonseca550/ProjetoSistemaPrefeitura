import java.util.Scanner;
public class SistemaPrefeitura {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite sua renda per capita: ");
            double rendaPerCapita = entrada.nextDouble();
            limitador(rendaPerCapita, Double.MAX_VALUE); // ← passa o valor máximo como fallback
            
        
        System.out.print("Digite o número de dependentes: ");
            int numeroDependentes = entrada.nextInt(); 
            limitador(numeroDependentes, Integer.MIN_VALUE);
        
      
        System.out.println("Possui deficiência? S para SIM ou N para NÃO");
            String possuiDeficiencia = entrada.next();
            String possuiDeficienciaNormalizado = possuiDeficiencia.trim().toLowerCase();
            int c = 1;
            while (!possuiDeficienciaNormalizado.equals("s") && !possuiDeficienciaNormalizado.equals("n")) {
                System.out.println("Resposta inválida. Por favor, digite 's' para SIM ou 'n' para NÃO");
                possuiDeficienciaNormalizado = entrada.next();
                 c++;
                 if (c == 3 && !possuiDeficienciaNormalizado.equals("s") && !possuiDeficienciaNormalizado.equals("n")) {
                    possuiDeficiencia = "n";  
                    System.out.println("----------------------------------------------------------------");  
                    System.out.println("Número máximo de tentativas atingido. Continuando para o próximo campo.");
                    System.out.println("----------------------------------------------------------------");
                     break;
    }

        }
        System.out.println("Qual o tempo de desemprego em meses? ");
            int tempoDesemprego = entrada.nextInt();
            limitador(tempoDesemprego, Integer.MIN_VALUE);
            
        System.out.println("Digite o risco do seu bairro sendo 0 para Baixo, 1 para Médio e 2 para Alto: ");
        int riscoBairro = entrada.nextInt();
        limitador(riscoBairro, 0);


        double pontosRenda = calcularRendaPontuacao(rendaPerCapita);
        int pontosDependentes = calcularDependentesPontuacao(numeroDependentes);                
        int pontosDeficiencia = calcularDeficienciaPontuacao(possuiDeficiencia);
        int pontosDesemprego = calcularDesempregoPontuacao(tempoDesemprego);
        int pontosRiscoBairro = calcularRiscoBairroPontuacao(riscoBairro);
        double pontuacaoTotal = calcularPontuacaoTotal(pontosRenda, pontosDependentes, pontosDeficiencia, pontosDesemprego, pontosRiscoBairro);
        if (pontuacaoTotal >= 15) {
            System.out.println("Parabéns! Você é elegível para o programa de auxílio. Sua pontuação total é: " + pontuacaoTotal);
        } else if (pontuacaoTotal >= 10) {
            System.out.println("Você está na fila de espera para o programa de auxílio. Sua pontuação total é: " + pontuacaoTotal);
        } else {
            System.out.println("Infelizmente, você não é elegível para o programa de auxílio. Sua pontuação total é: " + pontuacaoTotal);
      }
   entrada.close();
   }
    public static double calcularRendaPontuacao(double rendaPerCapita) {
        double pontosRenda = 0.0;
        if (rendaPerCapita <= 350.00) {
            pontosRenda = 5.0;
        } else if (rendaPerCapita > 350.00 && rendaPerCapita <= 500.00) {
            pontosRenda = 3.0;
        } else {
            pontosRenda = 0.0;
        }
        return pontosRenda;
    }
    public static int calcularDependentesPontuacao(int numeroDependentes) {
        int pontosDependentes = 0;
        if (numeroDependentes >= 3) {
            pontosDependentes = 5;
        } else if (numeroDependentes == 2) {
            pontosDependentes = 3;
        } else if (numeroDependentes == 1) {
            pontosDependentes = 1;
        }
        return pontosDependentes;
    }
    
    public static int calcularDeficienciaPontuacao(String possuiDeficiencia) {
    int pontosDeficiencia = 0;

    if (possuiDeficiencia.equals("s")) {
        pontosDeficiencia = 5;
    } else if (possuiDeficiencia.equals("n")) {
        pontosDeficiencia = 0;
    }

    return pontosDeficiencia;
    }
    public static int calcularDesempregoPontuacao(int tempoDesemprego) {
        int pontosDesemprego = 0;
        if (tempoDesemprego > 12) {
            pontosDesemprego = 5;
        } else {
            pontosDesemprego = 0;
        }
        return pontosDesemprego;
    }
    public static int calcularRiscoBairroPontuacao(int riscoBairro) {
        int pontosRiscoBairro = 0;
        if (riscoBairro == 0) {
            pontosRiscoBairro = 0;
        } else if (riscoBairro == 1) {
            pontosRiscoBairro = 3;
        } else if (riscoBairro == 2) {
            pontosRiscoBairro = 5;
        }
        return pontosRiscoBairro;
    }
public static double calcularPontuacaoTotal(double pontosRenda, int pontosDependentes, int pontosDeficiencia, int pontosDesemprego, int pontosRiscoBairro) {
        double pontuacaoTotal = pontosRenda + pontosDependentes + pontosDeficiencia + pontosDesemprego + pontosRiscoBairro;
   
        return pontuacaoTotal;
    }
public static double limitador(double metodo, double fallback) {
    
    Scanner entrada = new Scanner(System.in);
    int i = 1;
   
    while (metodo < 0) {
        System.out.println("O valor deve ser um valor positivo.");
        System.out.print("Digite o valor novamente: ");
        metodo = entrada.nextDouble();
        
        i++;
        if (i == 3 && metodo < 0) {
            metodo = fallback;  // ← usa o fallback passado
            System.out.println("----------------------------------------------------------------");  
            System.out.println("Número máximo de tentativas atingido. Continuando para o próximo campo.");
            System.out.println("----------------------------------------------------------------"); 
        
            break;
            
     }
     entrada.close();    }
     return metodo;  
}
 }
    
