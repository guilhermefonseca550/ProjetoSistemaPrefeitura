package idea.src.main.java.familia.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalcularRenda extends Pessoa{


    public CalcularRenda(double renda, int dependentes, boolean deficiencia, int tempoDesemprego, int riscoBairro) {
        super(renda, dependentes, deficiencia, tempoDesemprego, riscoBairro);
    }

    @Override
    public void calcular() {
        if (getRenda() <= 350.00) {
            setPontosRenda(5);
        } else if (getRenda() > 350.00 && getRenda() <= 500.00) {
            setPontosRenda(3);
        } else {
            setPontosRenda(0);
        }
        System.out.println("sua renda é  " + getRenda());
    }
}
