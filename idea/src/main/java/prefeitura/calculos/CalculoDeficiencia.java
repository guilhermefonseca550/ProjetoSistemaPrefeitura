package idea.src.main.java.prefeitura.calculos;

import idea.src.main.java.familia.Pessoa;
import idea.src.main.java.prefeitura.Resultado;

public class CalculoDeficiencia implements CalculosInterface{


    @Override
    public double calcular(Pessoa pessoa) {
        if(pessoa.isDeficiencia()){
            return 5.0;
        }
        else{
            return 0.0;
        }

    }
}
