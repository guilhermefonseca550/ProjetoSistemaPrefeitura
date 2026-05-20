import java.util.Scanner;
public class SistemaPrefeitura {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite sua renda per capita: ");
        double rendaPerCapita = entrada.nextDouble();
        int i = 1;
        while (rendaPerCapita < 0) {
            System.out.println("A renda per capita deve ser um valor positivo.");
            System.out.print("Digite sua renda per capita novamente: ");
            rendaPerCapita = entrada.nextDouble();
            i++;
            if (i == 3 && rendaPerCapita < 0) {
            rendaPerCapita = Double.MAX_VALUE; 
}
            if (i == 3) {
                System.out.println("----------------------------------------------------------------");  
                System.out.println("Número máximo de tentativas atingido. Continuando para o próximo campo.");
                System.out.println("----------------------------------------------------------------"); 
                break;
            }
            
        }
        System.out.print("Digite o número de dependentes: ");
        int numeroDependentes = entrada.nextInt(); 
        while (numeroDependentes < 0) {
            
            System.out.println("O número de dependentes deve ser um valor positivo.");
            System.out.print("Digite o número de dependentes novamente: ");
            numeroDependentes = entrada.nextInt();
        }
        System.out.println("Possui deficiência? Sim ou nao");
        String possuiDeficiencia = entrada.next();
        possuiDeficiencia = possuiDeficiencia.replace("não", "nao");
        while (!possuiDeficiencia.equalsIgnoreCase(possuiDeficiencia.replace("não", "nao")) && !possuiDeficiencia.equalsIgnoreCase("nao")) {
            System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'nao'.");
            System.out.println("Possui deficiência? Sim ou nao");
            possuiDeficiencia = entrada.next();
        }
        System.out.println("Qual o tempo de desemprego em meses? ");
        int tempoDesemprego = entrada.nextInt();
            while (tempoDesemprego < 0) {
                System.out.println("O tempo de desemprego deve ser um valor positivo.");
                System.out.println("Qual o tempo de desemprego em meses? ");
                tempoDesemprego = entrada.nextInt();
            }
        System.out.println("Digite o risco do seu bairro (Alto, Médio ou Baixo): ");
        String riscoBairro = entrada.next();
    
        while (!riscoBairro.equalsIgnoreCase("Alto") && !riscoBairro.equalsIgnoreCase("Medio") && !riscoBairro.equalsIgnoreCase("Baixo")) {
            System.out.println("Resposta inválida. Por favor, digite 'Alto', 'Medio' ou 'Baixo'.");
            System.out.println("Digite o risco do seu bairro (Alto, Medio ou Baixo): ");
            riscoBairro = entrada.next();
        }

        entrada.close();

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
        possuiDeficiencia = possuiDeficiencia.trim(); // Remove espaços em branco
        possuiDeficiencia = possuiDeficiencia.toLowerCase(); // Converte para minúsculas
        possuiDeficiencia = possuiDeficiencia.replace("não", "nao").replace("sim", "sim"); // Normaliza os valores
        if (possuiDeficiencia.equalsIgnoreCase("sim")) {
            pontosDeficiencia = 5;
        } else if (possuiDeficiencia.equalsIgnoreCase("nao")) {
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
    public static int calcularRiscoBairroPontuacao(String riscoBairro) {
        int pontosRiscoBairro = 0;
        riscoBairro = riscoBairro.trim(); // Remove espaços em branco
        riscoBairro = riscoBairro.toLowerCase(); // Converte para minúsculas
        riscoBairro = riscoBairro.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o"); // Remove acentos, se necessário
        if (riscoBairro.equalsIgnoreCase("Alto")) {
            pontosRiscoBairro = 5;
        } else if (riscoBairro.equalsIgnoreCase("Medio")) {
            pontosRiscoBairro = 3;
        } else if (riscoBairro.equalsIgnoreCase("Baixo")) {
            pontosRiscoBairro = 0;
        }
        return pontosRiscoBairro;
    }
public static double calcularPontuacaoTotal(double pontosRenda, int pontosDependentes, int pontosDeficiencia, int pontosDesemprego, int pontosRiscoBairro) {
        double pontuacaoTotal = pontosRenda + pontosDependentes + pontosDeficiencia + pontosDesemprego + pontosRiscoBairro;
        if (pontuacaoTotal >= 15) {
            System.out.println("Você faz parte da fila prioritária para o programa de auxílio. Sua pontuação total é: " + pontuacaoTotal);
        } else if (pontuacaoTotal >= 8) {
            System.out.println("Você está na fila de espera para o programa de auxílio. Sua pontuação total é: " + pontuacaoTotal);
        } else {
            System.out.println("Infelizmente, você não é elegível para o programa de auxílio. Sua pontuação total é: " + pontuacaoTotal);
        }
        return pontuacaoTotal;
    }
}