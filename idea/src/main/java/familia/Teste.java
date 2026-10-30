package idea.src.main.java.familia;

import idea.src.main.java.prefeitura.AvaliadorAuxilio;

import java.util.Scanner;

public class Teste {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        AvaliadorAuxilio avaliador = new AvaliadorAuxilio();
        Pessoa pessoa = new Pessoa(1, 20, true, 500, 2);
        System.out.println(avaliador.avaliar(pessoa));
    }

}
