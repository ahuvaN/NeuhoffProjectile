package neuhoff.projectile;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity{

    private TextView answer;
    private double radians, getX, getY;
    private StringBuilder string ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answer = (TextView) findViewById(R.id.answer);

        Intent intent = getIntent();
        double angle = intent.getDoubleExtra("Angle", 0.0);
        double velocity = intent.getDoubleExtra("Velocity", 0.0);
        double time = intent.getDoubleExtra("Time", 0.0);


        radians = Math.toRadians(angle);
        getX = Math.sin(radians) * velocity * time;
        getY = Math.cos(radians) * velocity * time - (.5 * 9.8 * time * time);

        string = new StringBuilder();
        string.append("x= ");
        string.append(getX);
        string.append("\ny= ");
        string.append(getY);
        answer.setText(string);

    }
}
