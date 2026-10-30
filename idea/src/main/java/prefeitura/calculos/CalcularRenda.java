package idea.src.main.java.prefeitura.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalcularRenda implements CalculosInterface{


    @Override
    public double calcular(Pessoa pessoa) {
        if (pessoa.getRenda() <= 350.00) {
           return 5;
        } else if (pessoa.getRenda() > 350.00 && pessoa.getRenda() <= 500.00) {
            return 3;
        } else {
            return 0;
        }
    }
}
