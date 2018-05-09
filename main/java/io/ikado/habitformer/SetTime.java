package io.ikado.habitformer;

import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

/** This class allows an EditText widget to function as a TimePicker
 *
 */
public class SetTime implements View.OnFocusChangeListener, TimePickerDialog.OnTimeSetListener {

    private EditText editText;
    private Calendar calendar;
    private Context context;

    // Constructor
    public SetTime(EditText editText, Context context) {
        this.editText = editText;
        this.editText.setOnFocusChangeListener(this);
        this.calendar = Calendar.getInstance();
        this.context = context;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            new TimePickerDialog(context, this, hour, minute, true).show();
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.editText.setText(hourOfDay + ":" + minute);
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
