package idea.src.main.java.familia.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalculoDeficiencia extends Pessoa implements CalculosInterface{


    public CalculoDeficiencia(double renda, int dependentes, boolean deficiencia, int tempoDesemprego, int riscoBairro) {
        super(renda, dependentes, deficiencia, tempoDesemprego, riscoBairro);
    }

    @Override
    public void calcular() {
        if(isDeficiencia()){
         setPontosDeficiencia(getPontosDeficiencia() + 1);
        }
        else{
            setPontosDeficiencia(0);
        }
    }
}
