package neuhoff.projectile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NeuhoffProjectile extends AppCompatActivity {

    private TextView angle, velocity, time, result;
    private EditText edit_angle, edit_velocity, edit_time;
    private Button calculate;
    private double angleVar, velocityVar, timeVar, radians, getX, getY;
    private StringBuilder string ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                angleVar = Double.parseDouble(edit_angle.getText().toString());
                velocityVar = Double.parseDouble(edit_velocity.getText().toString());
                timeVar = Double.parseDouble(edit_time.getText().toString());
                radians = Math.toRadians(angleVar);
                getX = Math.sin(radians) * velocityVar * timeVar;
                getY = Math.cos(radians) * velocityVar * timeVar - (.5 * 9.8 * timeVar * timeVar);

                string = new StringBuilder();
                string.append("x= ");
                string.append(getX);
                string.append("\ny= ");
                string.append(getY);
                result.setText(string.toString());
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        radians = Math.toRadians(angleVar);
        getX = Math.sin(radians) * velocityVar * timeVar;
        getY = Math.cos(radians) * velocityVar * timeVar - (.5 * 9.8 * timeVar * timeVar);
        result.setText(string);
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
