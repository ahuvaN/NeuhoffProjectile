package neuhoff.projectile;

import android.content.Intent;
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

    private TextView angle, velocity, time, result;
    private EditText edit_angle, edit_velocity, edit_time;
    private Button calculate;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            image = (ImageView) findViewById(R.id.image);
            Picasso.with(this)
                    .load("http://www.shawneekscvb.com/pages/images/542191Baseball.jpg")
                    .into(image);
            angle = (TextView) findViewById(R.id.angle);
            velocity = (TextView) findViewById(R.id.velocity);
            time = (TextView) findViewById(R.id.time);
            calculate = (Button) findViewById(R.id.calculate);
            result = (TextView) findViewById(R.id.result);
            edit_angle = (EditText) findViewById(R.id.edit_angle);
            edit_velocity = (EditText) findViewById(R.id.edit_velocity);
            edit_time = (EditText) findViewById(R.id.edit_time);


            calculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent;
                    showAnswer();
                }
            });


    }

    private void showAnswer() {
        Intent intent = new Intent(this, AnswerActivity.class);
        double angle = Double.parseDouble(edit_angle.getText().toString());
        double velocity = Double.parseDouble(edit_velocity.getText().toString());
        double time = Double.parseDouble(edit_time.getText().toString());
        intent.putExtra("Angle", angle);
        intent.putExtra("Velocity", velocity);
        intent.putExtra("Time", time);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
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
