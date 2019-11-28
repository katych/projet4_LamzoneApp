package com.example.mareu.UI;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.events.DeleteMeetingEvent;
import com.example.mareu.model.Meeting;
import com.example.mareu.services.MeetingApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;



public class ActivityMeetingsList  extends AppCompatActivity {


    private List<Meeting> mMeetings ;
    private RecyclerView mRecyclerView;
    private AdapterListMeeting mAdapter;
    private RecyclerView.LayoutManager mManager;
    private MeetingApiService mApiService ;


    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        mApiService=DI.getMeetingApiService();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        mRecyclerView = findViewById(R.id.meetings_list);
        mRecyclerView.setHasFixedSize(true);
        mManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mManager);

        initList();

         FloatingActionButton btnFab = findViewById(R.id.btnFab);

        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("DEBUG", "onClick:  Open Activity");

                Intent intent = new Intent(ActivityMeetingsList.this , AddMeeting.class);
                startActivity(intent);


            }
        });
    }


    public void initList(){
        mMeetings = mApiService.getMeetingsList();
        mAdapter = new AdapterListMeeting(mMeetings);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filtre_date:
                dateFilter();

                return true;
            case R.id.filtre_heure:

                roomFilter();
                return true;
            case R.id.listeReunion:
                initList();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe

    public void onDeleteMeetingEvent (DeleteMeetingEvent event){
        mApiService.deleteMeeting(event.meeting);
        initList();

    }
    public void dateFilter () {

        Collections.sort(mMeetings, new ComparatorDate());
        mAdapter.notifyDataSetChanged();

    }


    public void roomFilter (){
        Collections.sort(mMeetings, new ComparatorRooms());
        mAdapter.notifyDataSetChanged();

    }

    public class ComparatorRooms implements java.util.Comparator<Meeting> {

        @Override
        public int compare(Meeting meeting, Meeting t1) {
            return meeting.getmRoom().getmNameRoom().compareTo(t1.getmRoom().getmNameRoom());
        }
    }

    public class ComparatorDate implements Comparator<Meeting>{


        @Override
        public int compare(Meeting meeting, Meeting t1) {
            return meeting.getmDate().compareTo(t1.getmDate());
        }
    }

}
