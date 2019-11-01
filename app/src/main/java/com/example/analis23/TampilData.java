package com.example.analis23;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.analis23.adapter.AdapterData;
import com.example.analis23.api.ApiRequestBiodata;
import com.example.analis23.api.Retroserver;
import com.example.analis23.model.DataModel;
import com.example.analis23.model.ResponsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilData extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataModel> mItems = new ArrayList<>();
    ProgressDialog pd;
    FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Tampil Data");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab = (FloatingActionButton) findViewById(R.id.fab_add);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //here
                startActivity(new Intent(TampilData.this, MainActivity.class));
            }
        });
        pd = new ProgressDialog(this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);
        fetchContact("", "");
    }
    public void fetchContact (String key, String key2) {

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
        Call<ResponsModel> getdata = api.getBiodata(key, key2);
        getdata.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new AdapterData(TampilData.this, mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){

            getMenuInflater().inflate(R.menu.menu, menu);

            MenuItem search = menu.findItem(R.id.search);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
            searchView.setQueryHint("Cari nasabah ....");
            search(searchView);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            return super.onOptionsItemSelected(item);
        }
        private void search (SearchView searchView){

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    fetchContact(newText, newText);
                    return true;
                }
            });

        }



}



