package beyondtechnology.indicemassa;

import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String[] tabs = { "Cálculo","Classificação","Histórico" };
    ViewPager view;
    private AdView mAdView;
    private double _resultado = 0;
    private double _peso = 0;
    private double _altura = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        view = (ViewPager)findViewById(R.id.pager);

        view.setAdapter(new TabsPagerAdapter(getSupportFragmentManager()));

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                view.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };

        view.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                actionBar.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Add 3 tabs, specifying the tab's text and TabListener
        for (int i = 0; i < tabs.length; i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(tabs[i]).setTabListener(tabListener));
        }

        MobileAds.initialize(getBaseContext(), "ca-app-pub-6158185990205930/8016124078");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("6B50461B81D11F6F723FB664C78EF788").build();

        mAdView.loadAd(adRequest);
    }

    public void salvar(View view){
        try {
            SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            String datatempo = a.format(new Date());

            if(_resultado == 0) {
                Toast.makeText(this, "Por favor, preencha todos os dados corretamente", Toast.LENGTH_LONG).show();
            }
            else
            {
                DatabaseHandler db = new DatabaseHandler(getBaseContext());
                db.addHistorico(datatempo,_peso,_altura, _resultado);

                Toast.makeText(this, "Dados salvos com sucesso",Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception ex){
            Toast.makeText(this, "Por favor, preencha todos os dados corretamente",Toast.LENGTH_LONG).show();
        }
    }

    public void calcular(View view){
        try {
            TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
            TextView txtResultado2 = (TextView) findViewById(R.id.txtResultado2);
            TextView txtPeso = (TextView) findViewById(R.id.txtPeso);
            TextView txtMetro = (TextView) findViewById(R.id.txtMetros);
            TextView txtCentimetro = (TextView) findViewById(R.id.txtCentimetros);
            double resultado = 0;
            int peso = Integer.parseInt(txtPeso.getText().toString());
            double altura = Double.parseDouble(txtMetro.getText().toString() + "." + txtCentimetro.getText().toString());

            _peso = peso;
            _altura = altura;

            resultado =  peso / Math.pow(altura, 2);

            Imc a = new Imc();

            ImcRange range = a.getRange(UtilHelper.roundNumber(resultado));

            _resultado = resultado;

            txtResultado.setText("Resultado " + String.valueOf(UtilHelper.roundNumber(resultado)));
            txtResultado2.setText(range.getDescricao());
            txtResultado2.setTextColor(range.getCor());
        }
        catch(Exception e){
            Toast.makeText(this, "Por favor, preencha todos os dados corretamente",Toast.LENGTH_LONG).show();
        }
    }
}
