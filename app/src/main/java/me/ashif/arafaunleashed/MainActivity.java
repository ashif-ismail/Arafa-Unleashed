package me.ashif.arafaunleashed;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] address = {
            "arfu786@gmail.com"
    };
    private String subject = "An Email to Arafath";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder aboutMeAlert = new AlertDialog.Builder(MainActivity.this);
                aboutMeAlert.setTitle("About Me");
                aboutMeAlert.setMessage("Hi,Iam Arafath Abdulla,a CS UnderGrad from K.V.G College of Engineering and a Native of Kasaragod,"
                        + "I Like Programming and Developing Apps for Android Devices");
                aboutMeAlert.show();
            }
        });

        TextView txtPhone = (TextView) findViewById(R.id.tvNumber1);
        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent makeCallIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+919539234043"));
                    startActivity(makeCallIntent);
                }
                catch (SecurityException ex)
                {
                    Toast.makeText(getApplicationContext(),"Persmission Denied for making a Call,Probably this Happens in Android Version >5.1",Toast.LENGTH_LONG).show();
                }
            }
        });
        TextView txtWhatsapp = (TextView) findViewById(R.id.tvNumber2);
        txtWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("smsto:" + "+919497666789");
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.putExtra("sms_body", " ");
                i.setPackage("com.whatsapp");
                startActivity(i);
            }
        });
        TextView txtEMail = (TextView) findViewById(R.id.tvNumber3);
        txtEMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, address);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        TextView txtFB = (TextView) findViewById(R.id.tvNumber4);
        txtFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.facebook.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        TextView txtHome = (TextView) findViewById(R.id.tvNumber5);
        txtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lat = "12.5050741";
                String lng = "75.0122713";
                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "Arafath's Home" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                startActivity(intent);
            }
        });
        TextView txtColg = (TextView) findViewById(R.id.tvNumber6);
        txtColg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lat = "12.5532368";
                String lng = "75.3823645";
                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "KVG College of Engineering" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                startActivity(intent);
            }
        });
        TextView footerText = (TextView) findViewById(R.id.txtFooter);
        footerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.ashif.me";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
