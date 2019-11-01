package com.example.analis23;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class UmurActivity extends AppCompatActivity {

    int hour, minute, mYear,mMonth, mDay;
    static final int TIME_DIALOG_ID = 0;
    static final int DATE_DIALOG_ID = 1;
    private EditText txtDate;
    public  EditText txtUmur;
    private Button btnHitungUmur;
    private String[] arrMonth = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Des"};

    public UmurActivity() {
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premi);

        txtDate = (EditText) findViewById(R.id.edt_tgl_lahir);
        txtUmur = (EditText) findViewById(R.id.edt_umur);
        btnHitungUmur = (Button) findViewById(R.id.btnHitungUmur);

//get current date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        //mMonth = c.get(Calendar.MONTH);
        //mDay = c.get(Calendar.DAY_OF_MONTH);

        txtDate.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
                return true;
            }
        });
        btnHitungUmur.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
//getRequest(txtResult,txtUrl);
                Calendar now = Calendar.getInstance();
                Calendar tanggallahir = Calendar.getInstance();

                tanggallahir.set(mYear,mMonth,mDay);

                int years = now.get(Calendar.YEAR) - tanggallahir.get(Calendar.YEAR);
          //      int months = now.get(Calendar.MONTH) - tanggallahir.get(Calendar.MONTH);
            //    int days = now.get(Calendar.DAY_OF_MONTH) - tanggallahir.get(Calendar.DAY_OF_MONTH);
                if(years < 0){

                }
                String umur = years+" tahun ";
                txtUmur.setText(umur);
            }
        });
    }

    protected Dialog onCreateDialog(int id){
        switch(id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener,mYear,mMonth,mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    String sdate = arrMonth[mMonth] + " " + LPad(mDay + "", "0",2) + ", " + mYear;
                    txtDate.setText(sdate);
// TODO Auto-generated method stub
                }
            };

    private static String LPad(String schar,String spad, int len){
        String sret = schar;
        for(int i = sret.length(); i < len; i++){
            sret = spad + sret;
        }
        return new String(sret);
    }
}