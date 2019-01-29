package beyondtechnology.indicemassa;

import android.graphics.Color;

/**
 * Created by rodrigo on 18/11/2017.
 */
public class ImcRange {
    private double minimo;
    private double maximo;
    private String descricao;
    private int cor;

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
}
