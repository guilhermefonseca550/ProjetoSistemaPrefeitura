package familia;
public class Pessoa {

    private double renda;
    private int dependentes;
    private boolean deficiencia;
    private int tempoDesemprego;
    private int riscoBairro;

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