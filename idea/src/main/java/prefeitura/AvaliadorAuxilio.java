package idea.src.main.java.prefeitura;

import idea.src.main.java.familia.Pessoa;
import idea.src.main.java.prefeitura.calculos.*;

import java.util.ArrayList;
import java.util.List;

public class AvaliadorAuxilio {

    public Resultado avaliar(Pessoa pessoa){
        int dependentes = pessoa.getDependentes();
       double renda = pessoa.getRenda();
       int riscoBairro = pessoa.getRiscoBairro();
       int tempoDesemprego = pessoa.getTempoDesemprego();
       boolean deficiencia = pessoa.isDeficiencia();

       double pontuacaoTotal = 0;
        List<CalculosInterface> regras = new ArrayList<>();
        regras.add(new CalculoDeficiencia());
        regras.add(new CalculoDeDependentes());
        regras.add(new CalcularRenda());
        regras.add(new CalculoDeficiencia());

        for(CalculosInterface regra : regras){
            pontuacaoTotal += regra.calcular(pessoa);
        }


        String status = "";
        if(pontuacaoTotal >= 15){
            status = "Elegível para o programa de auxílio";
        }else if(pontuacaoTotal >= 10){
            status = "Na fila de espera!";
        }else{
            status = "Não elegível";
        }

        return new Resultado(pontuacaoTotal, status);

    }



}
