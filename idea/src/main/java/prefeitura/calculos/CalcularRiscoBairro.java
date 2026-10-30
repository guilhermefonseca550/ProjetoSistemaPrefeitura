package idea.src.main.java.prefeitura.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalcularRiscoBairro implements CalculosInterface{


    @Override
    public double calcular(Pessoa pessoa) {
        if(pessoa.getRiscoBairro() == 2){
            return 5;
        }else if(pessoa.getRiscoBairro() == 1){
            return 3;
        }else{
            return 0;
        }
    }
}
