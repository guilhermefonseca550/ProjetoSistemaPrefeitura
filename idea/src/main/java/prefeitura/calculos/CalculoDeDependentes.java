package idea.src.main.java.familia.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalculoDeDependentes extends Pessoa implements CalculosInterface{


    public CalculoDeDependentes(double renda, int dependentes, boolean deficiencia, int tempoDesemprego, int riscoBairro) {
        super(renda, dependentes, deficiencia, tempoDesemprego, riscoBairro);
    }

    @Override
    public void calcular() {
        if(getDependentes() >= 3){
            setPontosDependentes(5);
        }
        else if(getDependentes() == 2){
            setPontosDependentes(3);
        }
        else {
            setPontosDependentes(0);
        }

    }
    }







