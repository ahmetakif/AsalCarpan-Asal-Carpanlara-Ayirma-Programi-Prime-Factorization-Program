package cf.tashimasu.asalcarpan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import cf.tashimasu.asalcarpan.R;

public class MainActivity extends AppCompatActivity {

    private Button butonAyir;
    private EditText girdi;
    private TextView sonuc;

    AdView mAdview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-1597449049593763~1133754861");
        mAdview = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        butonAyir = (Button) findViewById(R.id.button_ayir);
        girdi = (EditText) findViewById(R.id.editText_girdi);
        sonuc = (TextView) findViewById(R.id.textView);

        //String text = girdi.getText().toString();
        //if (text != "") {
        //    butonAyir.setEnabled(true);
        //}
        //if (Integer.parseInt(text) == 0) {
        //    sonuc.setText("s");
        //}

        butonAyir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = girdi.getText().toString();
                int a = Integer.parseInt(text);
                int n = 1;
                List<Integer> bol = new ArrayList<Integer>();
                while (a%2 == 0) {
                    a = a/2;
                    bol.add(2);
                }
                while (n == 1) {
                    float koka1 = (float) Math.pow(a, 0.5);
                    int koka = Math.round(koka1)+2;
                    int b = 0;
                    for (int d = 3; d < koka; d = d+2) {
                        if (a%d == 0) {
                            a = a/d;
                            bol.add(d);
                            b = 1;
                            break;
                        }
                        if (b == 0 & d == koka - 1 || d == koka - 2) {
                            bol.add(Math.round(a));
                            a = 1;
                            break;
                        }
                    }
                    if (a == 1) {
                        break;
                    }
                }
                String finalstring = "";
                for (int i = 0; i < bol.size(); i++) {
                    String text4 = Integer.toString(bol.get(i));
                    finalstring = finalstring + "," + text4;
                }
                sonuc.setText(finalstring);

            }
        });
    }
}

