package idea.src.main.java.prefeitura.calculos;

import idea.src.main.java.familia.Pessoa;

public class CalculoDeDependentes implements CalculosInterface{


    @Override
    public double calcular(Pessoa pessoa) {
        if(pessoa.getDependentes() >= 3){
            return 5;
        }else if(pessoa.getDependentes() == 2){
            return 3;
        }else{
            return 1;
        }
    }
}







