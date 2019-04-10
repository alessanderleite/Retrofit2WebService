package br.com.alessanderleite.retrofit2webservice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.alessanderleite.retrofit2webservice.R;
import br.com.alessanderleite.retrofit2webservice.adapter.NoticeAdapter;
import br.com.alessanderleite.retrofit2webservice.model.Notice;
import br.com.alessanderleite.retrofit2webservice.model.NoticeList;
import br.com.alessanderleite.retrofit2webservice.my_interface.GetNoticeDataService;
import br.com.alessanderleite.retrofit2webservice.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private NoticeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        Call<NoticeList> call = service.getNoticeData();

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                generateNoticeList(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong... Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateNoticeList(ArrayList<Notice> noticeArrayList) {
        recyclerView = findViewById(R.id.recycler_view_notice_list);
        adapter = new NoticeAdapter(noticeArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
