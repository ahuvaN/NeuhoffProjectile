package neuhoff.projectile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NeuhoffProjectile extends AppCompatActivity {

    private EditText angle, velocity, time;
    private Button calculate;
    private ImageView image;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //needs a name and a mode- restriction
            preferences = this.getSharedPreferences("default", MODE_PRIVATE);

            image = (ImageView) findViewById(R.id.image);
            Picasso.with(this)
                    .load("http://www.shawneekscvb.com/pages/images/542191Baseball.jpg")
                    .into(image);
            calculate = (Button) findViewById(R.id.calculate);
            angle = (EditText) findViewById(R.id.edit_angle);
            velocity = (EditText) findViewById(R.id.edit_velocity);
            time = (EditText) findViewById(R.id.edit_time);


            calculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent;
                    showAnswer();
                }
            });


    }

    @Override
    protected void onPause() {
        super.onPause();
        //first we want to get values in editText to be able to save them
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ANGLE", angle.getText().toString());
        editor.putString("VELOCITY", velocity.getText().toString());
        editor.putString("TIME", time.getText().toString());
        editor.apply();
    }



    private void showAnswer() {
        Intent intent = new Intent(this, AnswerActivity.class);
        double angle = Double.parseDouble(this.angle.getText().toString());
        double velocity = Double.parseDouble(this.velocity.getText().toString());
        double time = Double.parseDouble(this.time.getText().toString());
        intent.putExtra("Angle", angle);
        intent.putExtra("Velocity", velocity);
        intent.putExtra("Time", time);
        startActivity(intent);

    }

    @Override
    protected void onResume() {

        super.onResume();
        angle.setText(preferences.getString("ANGLE", ""));
        velocity.setText(preferences.getString("VELOCITY",""));
        time.setText(preferences.getString("TIME",""));
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
