package idea.src.main.java.familia;

import idea.src.main.java.prefeitura.calculos.CalculosInterface;

public class Pessoa {

    private double renda;

    private int dependentes;
    private int pontosDepententes;
    private boolean deficiencia;
    private int pontosDeficiencia;
    private int tempoDesemprego;
    private int pontosDesemprego;
    private int riscoBairro;


    public Pessoa(double renda, int dependentes, boolean deficiencia, int tempoDesemprego,  int riscoBairro) {
        this.renda = renda;

        this.dependentes = dependentes;

        this.deficiencia = deficiencia;

        this.tempoDesemprego = tempoDesemprego;

        this.riscoBairro = riscoBairro;

    }



    public int getPontosDepententes() {
        return pontosDepententes;
    }

    public void setPontosDependentes(int pontosDepententes) {
        this.pontosDepententes = pontosDepententes;
    }

    public int getPontosDeficiencia() {
        return pontosDeficiencia;
    }

    public void setPontosDeficiencia(int pontosDeficiencia) {
        this.pontosDeficiencia = pontosDeficiencia;
    }

    public int getPontosDesemprego() {
        return pontosDesemprego;
    }

    public void setPontosDesemprego(int pontosDesemprego) {
        this.pontosDesemprego = pontosDesemprego;
    }


    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public boolean isDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(boolean deficiencia) {
        this.deficiencia = deficiencia;
    }

    public int getTempoDesemprego() {
        return tempoDesemprego;
    }

    public void setTempoDesemprego(int tempoDesemprego) {
        this.tempoDesemprego = tempoDesemprego;
    }

    public int getRiscoBairro() {
        return riscoBairro;
    }

    public void setRiscoBairro(int riscoBairro) {
        this.riscoBairro = riscoBairro;
    }


}