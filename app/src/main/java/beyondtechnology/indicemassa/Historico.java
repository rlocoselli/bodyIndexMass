package beyondtechnology.indicemassa;

/**
 * Created by rodrigo on 08/12/2017.
 */
public class Historico {
    private String datatempo;

    public String getDatatempo() {
        return datatempo;
    }

    public void setDatatempo(String datatempo) {
        this.datatempo = datatempo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    private double peso;
    private double resultado;
}
