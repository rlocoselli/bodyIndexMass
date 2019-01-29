package beyondtechnology.indicemassa;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by rodrigo on 18/11/2017.
 */
public class Imc {

    public ImcRange getRange(double ret){
        for(ImcRange k : getImcRange()){
            if(k.getMinimo() <= ret && k.getMaximo() >= ret){
                return k;
            }
        }

        return null;
    }

    public ArrayList<ImcRange> getImcRange(){
        ImcRange a = new ImcRange();
        a.setMinimo(0);
        a.setMaximo(17);
        a.setDescricao("Muito Abaixo do Peso");
        a.setCor(Color.RED);

        ImcRange b = new ImcRange();
        b.setMinimo(17.01);
        b.setMaximo(18.49);
        b.setDescricao("Abaixo do Peso");
        b.setCor(Color.RED);

        ImcRange c = new ImcRange();
        c.setMinimo(18.5);
        c.setMaximo(24.99);
        c.setDescricao("Peso Normal");
        c.setCor(Color.GREEN);

        ImcRange d = new ImcRange();
        d.setMinimo(25);
        d.setMaximo(29.99);
        d.setDescricao("Acima do Peso");
        d.setCor(Color.MAGENTA);

        ImcRange e = new ImcRange();
        e.setMinimo(30);
        e.setMaximo(34.99);
        e.setDescricao("Obesidade I");
        e.setCor(Color.RED);

        ImcRange f = new ImcRange();
        f.setMinimo(35);
        f.setMaximo(39.99);
        f.setDescricao("Obesidade II (Severa)");
        f.setCor(Color.RED);

        ImcRange g = new ImcRange();
        g.setMinimo(40);
        g.setMaximo(999);
        g.setDescricao("Obesidade III (Mórbida)");
        g.setCor(Color.RED);

        ArrayList<ImcRange> list = new ArrayList<>();

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);

        return list;
    }
}
