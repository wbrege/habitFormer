package io.ikado.habitformer;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class RegisterGoalActivity extends AppCompatActivity {

    private SetTime setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_goal);
        EditText timeText = findViewById(R.id.checkInTime);
        setTime = new SetTime(timeText, this);
    }

    /** Creates a new goal/habit for the user using the information in the form when the submit
     * button is pressed.
     */
    public void createGoal(View view) {
        // Get Data
        EditText goalText = findViewById(R.id.enterTargetGoalField);
        String goal = goalText.getText().toString();

        RadioGroup reinforcementGroup = findViewById(R.id.reinforcementRadioGroup);
        RadioButton reinforcementButton = findViewById(reinforcementGroup.getCheckedRadioButtonId());
        String reinforcement = reinforcementButton.getText().toString();

        Calendar time = setTime.getCalendar();

        // Validate input
        if(goal.isEmpty()) {

        }

        // Set the Alarm for the repeating check-in event
        AlarmManager alarmMgr = (AlarmManager)this.getSystemService(this.ALARM_SERVICE);
        Intent intent = new Intent(this, BroadcastReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
    }
}
