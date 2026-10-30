package idea.src.main.java.familia.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalcularRiscoBairro extends Pessoa implements CalculosInterface{


    public CalcularRiscoBairro(double renda, int dependentes, boolean deficiencia, int tempoDesemprego, int riscoBairro) {
        super(renda, dependentes, deficiencia, tempoDesemprego, riscoBairro);
    }

    @Override
    public void calcular() {
        if(getRiscoBairro() == 0){
            setPontoRiscoBairro(0);
        } else if (getRiscoBairro() == 1) {
            setPontoRiscoBairro(3);
        } else if (getRiscoBairro() == 2) {
            setPontoRiscoBairro(5);
        }
    }
}
