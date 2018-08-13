package com.example.admin.theroots;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {
    Button add_event;
  DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();

    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =inflater.inflate(R.layout.fragment_calendar, container, false);
        MaterialCalendarView materialCalendarView = (MaterialCalendarView) v.findViewById(R.id.calendarView);

        Intent intent = getActivity().getIntent();
        int intValue = intent.getIntExtra("intVariableName", 0);
                  /* FragmentTransaction transaction = getFragmentManager().beginTransaction();
                   transaction.replace(R.id.main_frame,new Add_event_frag());
                   //transaction.addToBackStack(null);
                   transaction.commit();*/
                   Button add_event = (Button) v.findViewById(R.id.add_event);
                   add_event.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {

                           Calendar calendarEvent = Calendar.getInstance();
                           Intent intent = new Intent(Intent.ACTION_EDIT);
                           intent.setType("vnd.android.cursor.item/event");
                           intent.putExtra("beginTime", calendarEvent.getTimeInMillis());
                           intent.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
                           intent.putExtra("title", "Sample Event");
                           intent.putExtra("allDay", true);
                           intent.putExtra("rule", "FREQ=YEARLY");
                           startActivity(intent);

                       }
                   });




         /*  add_event.setOnClickListener(new Button.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
      */


        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(1998, 1, 1))
                .setMaximumDate(CalendarDay.from(2100, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Toast.makeText(getActivity(),""+date ,Toast.LENGTH_SHORT).show();
            }
        });
        return v;


    }



}

