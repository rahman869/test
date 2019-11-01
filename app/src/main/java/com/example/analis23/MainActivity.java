package com.example.analis23;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import com.example.analis23.adapter.AdapterData;
import com.example.analis23.api.ApiRequestBiodata;
import com.example.analis23.api.Retroserver;
import com.example.analis23.model.ResponsModel;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.analis23.UmurActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ExpandableLayout expandableLayout1;

    ExpandableLayout expandableLayout2;

    ExpandableLayout expandableLayout3;
    ExpandableLayout expandableLayout31;
    ExpandableLayout expandableLayout3111;
    ExpandableLayout expandableLayout32;
    ExpandableLayout expandableLayout33;
    ExpandableLayout expandableLayout34;
    ExpandableLayout expandableLayout35;

    ExpandableLayout expandableLayout4;
    ExpandableLayout expandableLayout41;
    ExpandableLayout expandableLayout42;
    ExpandableLayout expandableLayout43;
    ExpandableLayout expandableLayout44;
    ExpandableLayout expandableLayout45;

    ExpandableLayout expandableLayout5;
    ExpandableLayout expandableLayout51;
    ExpandableLayout expandableLayout52;
    ExpandableLayout expandableLayout53;

    ExpandableLayout expandableLayout6;

    ExpandableLayout expandableLayout7;
    ExpandableLayout expandableLayout8;

    ExpandableLayout expandableLayout9;
    ExpandableLayout expandableLayout10;
    ExpandableLayout expandableLayout11;
    ExpandableLayout expandableLayout12;

    ExpandableLayout expandableLayout1121;

    private EditText tgl_lahir, premi, txtumur;

     EditText tgl_permohonan, no_reg, nama_pemohon, nama_panggilan, tempat_lahir, jenis_kelamin, no_ktp, masa_berlaku_ktp, alamat_sesuai_ktp,
            nama_ibu_kandung, kode_pos, pekerjaan_pemohon, nama_perusahaan, jabatan, alamat_perusahaan, status_pernikahan, jml_tanggungan, pendidikan_terakhir,
            status_rumah_tinggal, lama_tinggal, alamat_rumah_tinggal, no_telp, no_hp, nama_pasangan, tgl_lahir_pasangan, no_ktp_pasangan, masa_berlaku_ktp_pasangan,
            pekerjaan_pasangan, tempat_lahir_pasangan, alamat_pasangan, penghasilan_per_bln, penjamin, alamat_penjamin, tempat_lahir_penjamin,
            tgl_lahir_penjamin, no_ktp_penjamin, masa_berlaku_ktp_penjamin, nama_pasangan_penjamin, alamat_pasangan_penjamin, tempat_lahir_pasangan_penjamin,
            tgl_lahir_pasangan_penjamin, no_ktp_pasangan_penjamin, masa_berlaku_ktp_pasangan_penjamin,

    //Data_kredit
    jenis_kredit, sektor_ekonomi, fasilitas_ke,  plafond_kredit,  jkw,  bunga,  type_angsuran,  periode_pembayaran_pokok, jml_angsuran_per_bln,
            angsuran_pokok_pertama,  angsuran_bunga_pertama,  provisi, administrasi, on_the_spot,  nama_asuransi, akad_kredit,  jenis_penggunaan,
            tujuan_penggunaan, surveyor,

    no_reg1, nama_jaminan_shm1, jenis_jaminan_shm1, atas_nama_shm1, alamat_atas_nama_shm1, no_ktp_atas_nama_shm1, masa_berlaku_shm1,
            ikatan_shm1, nilai_ikatan_shm1, no_SHM1, no_gs_shm1, luas_shm1, lokasi_shm1, asuransi_shm1, nilai_tanah_shm1, nilai_bangunan_shm1, total_taksiran_shm1,

    nama_jaminan_shm2, jenis_jaminan_shm2, atas_nama_shm2, alamat_atas_nama_shm2, no_ktp_atas_nama_shm2, masa_berlaku_shm2,
            ikatan_shm2, nilai_ikatan_shm2, no_SHM2, no_gs_shm2, luas_shm2, lokasi_shm2, asuransi_shm2,
            nilai_tanah_shm2, nilai_bangunan_shm2, total_taksiran_shm2,

    nama_jaminan_shm3, jenis_jaminan_shm3, atas_nama_shm3, alamat_atas_nama_shm3, no_ktp_atas_nama_shm3, masa_berlaku_shm3,
            ikatan_shm3, nilai_ikatan_shm3, no_SHM3, no_gs_shm3, luas_shm3, lokasi_shm3, asuransi_shm3, nilai_tanah_shm3, nilai_bangunan_shm3, total_taksiran_shm3,

    nama_jaminan_shm4, jenis_jaminan_shm4, atas_nama_shm4, alamat_atas_nama_shm4, no_ktp_atas_nama_shm4, masa_berlaku_shm4,
            ikatan_shm4, nilai_ikatan_shm4, no_SHM4, no_gs_shm4, luas_shm4, lokasi_shm4, asuransi_shm4, nilai_tanah_shm4, nilai_bangunan_shm4, total_taksiran_shm4,

    nama_jaminan_shm5, jenis_jaminan_shm5, atas_nama_shm5, alamat_atas_nama_shm5, no_ktp_atas_nama_shm5, masa_berlaku_shm5,
            ikatan_shm5, nilai_ikatan_shm5, no_SHM5, no_gs_shm5, luas_shm5, lokasi_shm5, asuransi_shm5, nilai_tanah_shm5, nilai_bangunan_shm5, total_taksiran_shm5,

    //Aspek Jaminan BPKB 1
    nama_jaminan_bpkb1, no_bpkb1, merk_bpkb1, tahun_bpkb1, no_rangka_bpkb1, no_mesin_bpkb1, warna_bpkb1, nopol_bpkb1, atas_nama_bpkb1, alamat_bpkb1,
            ikatan_bpkb1, nilai_fiducia1, nilai_taksiran_bpkb1,

    //Aspek Jaminan BPKB 2
    nama_jaminan_bpkb2, no_bpkb2, merk_bpkb2, tahun_bpkb2, no_rangka_bpkb2, no_mesin_bpkb2, warna_bpkb2, nopol_bpkb2, atas_nama_bpkb2, alamat_bpkb2,
            ikatan_bpkb2, nilai_fiducia2, nilai_taksiran_bpkb2,

    //Aspek Jaminan BPKB 3
    nama_jaminan_bpkb3, no_bpkb3, merk_bpkb3, tahun_bpkb3, no_rangka_bpkb3, no_mesin_bpkb3, warna_bpkb3, nopol_bpkb3, atas_nama_bpkb3, alamat_bpkb3,
            ikatan_bpkb3, nilai_fiducia3, nilai_taksiran_bpkb3,

    //Aspek Jaminan BPKB 4
    nama_jaminan_bpkb4, no_bpkb4, merk_bpkb4, tahun_bpkb4, no_rangka_bpkb4, no_mesin_bpkb4, warna_bpkb4, nopol_bpkb4, atas_nama_bpkb4, alamat_bpkb4,
            ikatan_bpkb4, nilai_fiducia4, nilai_taksiran_bpkb4,

    //Aspek Jaminan BPKB 5
    nama_jaminan_bpkb5, no_bpkb5, merk_bpkb5, tahun_bpkb5, no_rangka_bpkb5, no_mesin_bpkb5, warna_bpkb5, nopol_bpkb5, atas_nama_bpkb5, alamat_bpkb5,
            ikatan_bpkb5, nilai_fiducia5, nilai_taksiran_bpkb5,

    //Aspek Jaminan BILYET Deposito 1
    nama_jaminand1, nama_deposito1, no_bilyet1, alamatd1, pengikat_jaminand1, deposito1, total_nilai_jaminan1, persen_dari_plafond1,

    //Aspek Jaminan BILYET Deposito 2
    nama_jaminand2, nama_deposito2, no_bilyet2, alamatd2, pengikat_jaminand2, deposito2, total_nilai_jaminan2, persen_dari_plafond2,

    //Aspek Jaminan BILYET Deposito 3
    nama_jaminand3, nama_deposito3, no_bilyet3, alamatd3, pengikat_jaminand3, deposito3, total_nilai_jaminan3, persen_dari_plafond3,

    //Aspek Kapasitas
    pekerjaank, nama_perusahaan1, alamat_usaha, lama_usaha, uraian_kegiatan_usaha_utama, uraian_kegiatan_usaha_lainnya,uraian_kegiatan_usaha_lainnya1,
    uraian_kegiatan_usaha_sampingan,  uraian_kegiatan_usaha_pasangan, kondisi_fisik, kesimpulan,

    //Aspek Keuangan
    kas, piutang, persediaan, inventaris, tanah_rumah, total_keuangan, hutang_dagang, hutang_bank, pinjaman, modal,
            laba, total_pasiva, pendapatan_usaha, biaya_usaha, laba_usaha, pendapatan_lain, total_pendapatan,
            biaya_rumah_tangga, biaya_listrik, biaya_pendidikan, biaya_transportasi, biaya_sosial, angsuran_bank1, angsuran_bank2, angsuran_bank3, angsuran_bank4,
            angsuran_bank5, angsuran_bank6, biaya_lainnya, total_biaya,

    //Aspek Pemasaran
    kelola_usaha, persaingan_usaha, pemasaran_usaha, amdal_usaha, prospek_usaha,

    //Aspek Karakter
    fasilitas_kredit_ke1, kondite_kredit_lalu, referensi, info_lingkungan, avalis_kredit, karakter_lainnya,

    //Aspek Hukum
    dasar_hukum, nomor_KID, legalitas_identitas, masa_berlaku_KID, akad_kredit1, asuransiii,

    //Aspek Hukum
    plafond_kredit1, tujuan_penggunaan1, tujuan_modal, tujuan_pelunasan, tujuan_pembelian, tujuan_renovasi,
            tujuan_sekolah, tujuan_lainnya, total_kebutuhan, kas1, kebutuhan_bank, dibulatkan_menjadi,

    //Aspek Hukum
    plafond_kredit2, laba2, angsuran_bunga_pertama2, dana_angsuran, jkw_x1, jkw2;


    String sno_regg, stanah, sbangunan, stotal, stanah1, sbangunan1, stotal1, stanah2, sbangunan2, stotal2, stanah3,
            sbangunan3, stotal3, stanah4, sbangunan4, stotal4, stotal5, splafond, stotal6, sno_shm1, sno_shm, snama,
            sfasilitas, sno_ktp1, smasa_berlaku1, sakad_kredit1, snama_asuransi, spenggunaan, stotal_kebutuhan,skebutuhan_bank, sdibulatkan,
            slaba, sangsuran_bunga, sdana, sjkw_x1, sjkww, umur, spremi;

    int jjangka_waktu;
    int iumur;
    int iplafond;
    boolean ipremi;

    double nilai_jaminan1, nilai_jaminan2, nilai_jaminan3, nilai_jaminan4, nilai_jaminan5 ;

    //Button btnsave, btnTampildata, btnupdate, btndelete;
    DatePickerDialog fromDatePickerDialog;
    SimpleDateFormat dateFormatter;



    public TextView tjumlah_angsuran_perbulan;
    public  Double Plafond_kredit;
    public  Integer Plafond_kreditt;
    public  Boolean Plafond_kredittt;
    public  Double Jangka_waktu;
    public double sJangka_waktu;
    public double sPeriode_pembayaran;
    public double ssuku_bunga;
    public  Double sumPokok;
    public  Double sumAngsuran;
    public  Double Bunga;
    double mpokok;
    double mbunga;
    double mjumlah_angsuran;
    long mangsuran_pokok_pertama;
    public  Double mangsuran;
    public  Double Periode_pembayaran;
    public  Double Angsuran_pokok_pertama;
    public  String Jumlah_angsuran_perbulan;
    private  String iplafond_kredit, ijangka_waktu, itype_bunga;
    public  String spokok, pokok, ibunga, sbunga, iangsuran, sangsuran, vangsuran_pokok_pertama, jangka, periode, type,
            vsuku_bunga;
    public int mke;

    double dplafond;
    double djangka_waktu;
    double dbunga;
    long dtotal;

    String ssuku_bunga_per_tahun, sanguran_per_bulan,
            sprovisi, sadministrasi, son_the_spot, stotal_pokok, stotal_bunga, sjumlah_angsuran;

    Double dsuku_bunga_per_tahun;
    long dangsuran_perbulan;
    long dprovisi;
    long dadministrasi;
    long don_the_spot;
    public static long djangka;


    //ASPEK JAMINAN


    double dtanah;
    double dbangunan;
    long dtotal11;

    double dtanah1;
    double dbangunan1;
    long dtotal1;

    double dtanah2;
    double dbangunan2;
    long dtotal2;

    double dtanah3;
    double dbangunan3;
    long dtotal3;

    double dtanah4;
    double dbangunan4;
    long dtotal4;

    double dtotal_nilai_jaminan1;
    double dpersen_dari_plafond1;
    double dno_shm, dno_shm1;
    double dtotal5;
    double dtotal6;

    double total1;
    double total2;
    double total3;
    double total4;
    double total5;

    long dnama;

    String skas, spiutang, spersediaan, sinventaris, stanah_rumah, stotal_aktiva, shutang_dagang, shutang_bank, spinjaman, smodal, slaba_usaha,
            stotal_pasiva, stotal_modal, stotal_laba, stotal_laba_usaha, stotal_pendapatan, stotal_biaya;

    double dkas;
    double dpiutang;
    double dpersediaan;
    double dinventaris;
    double dtanah_rumah;
    double dtotal_aktiva;

    //hutangdagang
    double dhutang_dagang;
    double dhutang_bank;
    double dpinjaman;
    double dmodal;
    double dlaba;
    double dtotal_pasiva;
    double dlaba1;
    double dmodal1;

    //pendapatan
    double dpendapatan_usaha;
    double dbiaya_usaha;
    double dlaba_usaha;
    double dlaba_usaha1;
    double dpendapatan_lain;
    double dtotal_pendapatan;

    //biaya
    double dbiaya_rumah;
    double dbiaya_listrik;
    double dbiaya_pendidikan;
    double dbiaya_transportasi;
    double dbiaya_sosial;
    double dangsruran_bank1;
    double dangsruran_bank2;
    double dangsruran_bank3;
    double dangsruran_bank4;
    double dangsruran_bank5;
    double dangsruran_bank6;
    double dbiaya_lainnya;
    double dtotal_biaya;


    double dtujuan_modal;
    double dtujuan_pelunasan;
    double dtujuan_pembelian;
    double dtujuan_renovasi;
    double dtujuan_sekolah;
    double dtujuan_lainnya;
    double dtotal_kebutuhan;
    double dkebutuhan_bank;

    double ddana;
    double djkw_1;

    DatePickerDialog fromDatePickerDialog1;
    SimpleDateFormat dateFormatter1;

    DatePickerDialog fromDatePickerDialog2;
    SimpleDateFormat dateFormatter2;

    DatePickerDialog fromDatePickerDialog3;
    SimpleDateFormat dateFormatter3;

    DatePickerDialog fromDatePickerDialog4;
    SimpleDateFormat dateFormatter4;

    ImageButton imgBtnID;
    private AdapterData mAdapter;

    SwipeRefreshLayout swipe;

    Button btnsave, btnTampildata, btnupdate,btndelete;
    TableLayout tab1;


    Button btnUpload, btnGalery;
    ImageView imgHolder;
    String part_image;
    ProgressDialog pd;
    final int REQUEST_GALLERY = 9544;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");

        //Data permohonan
        expandableLayout1 = findViewById(R.id.expandableLayout1);

        //Data kredit
        expandableLayout2 = findViewById(R.id.expandableLayout2);

        //Sertifikat
        expandableLayout3 = findViewById(R.id.expandableLayout3);
        expandableLayout31 = findViewById(R.id.expandableLayout31);
        expandableLayout3111 = findViewById(R.id.expandableLayout3111);
        expandableLayout32 = findViewById(R.id.expandableLayout32);
        expandableLayout33 = findViewById(R.id.expandableLayout33);
        expandableLayout34 = findViewById(R.id.expandableLayout34);
        expandableLayout35 = findViewById(R.id.expandableLayout35);

        //BPKB
        expandableLayout4 = findViewById(R.id.expandableLayout4);
        expandableLayout41 = findViewById(R.id.expandableLayout41);
        expandableLayout42 = findViewById(R.id.expandableLayout42);
        expandableLayout43 = findViewById(R.id.expandableLayout43);
        expandableLayout44 = findViewById(R.id.expandableLayout44);
        expandableLayout45 = findViewById(R.id.expandableLayout45);

        //BILYET DEPOSITO
        expandableLayout5 = findViewById(R.id.expandableLayout5);
        expandableLayout51 = findViewById(R.id.expandableLayout51);
        expandableLayout52 = findViewById(R.id.expandableLayout52);
        expandableLayout53 = findViewById(R.id.expandableLayout53);

        //Aspek Kapasitas
        expandableLayout6 = findViewById(R.id.expandableLayout6);

        expandableLayout7 = findViewById(R.id.expandableLayout7);

        expandableLayout8 = findViewById(R.id.expandableLayout8);

        expandableLayout9 = findViewById(R.id.expandableLayout9);

        expandableLayout10 = findViewById(R.id.expandableLayout10);

        expandableLayout11 = findViewById(R.id.expandableLayout11);

        expandableLayout12 = findViewById(R.id.expandableLayout12);

        expandableLayout1121 = findViewById(R.id.expandableLayout1121);


        //Data Permohonan
        findViewById(R.id.expandableButton1).setOnClickListener(this);

        //Data Kredit
        findViewById(R.id.expandableButton2).setOnClickListener(this);

        //Sertifikat
        findViewById(R.id.expandableButton3).setOnClickListener(this);
        findViewById(R.id.expandableButton3111).setOnClickListener(this);
        findViewById(R.id.expandableButton31).setOnClickListener(this);
        findViewById(R.id.expandableButton32).setOnClickListener(this);
        findViewById(R.id.expandableButton33).setOnClickListener(this);
        findViewById(R.id.expandableButton34).setOnClickListener(this);
        findViewById(R.id.expandableButton35).setOnClickListener(this);

        //BPKB
        findViewById(R.id.expandableButton4).setOnClickListener(this);
        findViewById(R.id.expandableButton41).setOnClickListener(this);
        findViewById(R.id.expandableButton42).setOnClickListener(this);
        findViewById(R.id.expandableButton43).setOnClickListener(this);
        findViewById(R.id.expandableButton44).setOnClickListener(this);
        findViewById(R.id.expandableButton45).setOnClickListener(this);

        //BILYET DEPOSITO
        findViewById(R.id.expandableButton5).setOnClickListener(this);
        findViewById(R.id.expandableButton51).setOnClickListener(this);
        findViewById(R.id.expandableButton52).setOnClickListener(this);
        findViewById(R.id.expandableButton53).setOnClickListener(this);

        //Aspek Kapasitas
        findViewById(R.id.expandableButton6).setOnClickListener(this);

        //Aspek Keuangan
        findViewById(R.id.expandableButton7).setOnClickListener(this);

        //Aspek Pemasaran
        findViewById(R.id.expandableButton8).setOnClickListener(this);

        //Aspek Karakter
        findViewById(R.id.expandableButton9).setOnClickListener(this);

        //Aspek Hukum
        findViewById(R.id.expandableButton10).setOnClickListener(this);

        //Analisa Kebutuhan
        findViewById(R.id.expandableButton11).setOnClickListener(this);

        findViewById(R.id.expandableButton12).setOnClickListener(this);

        findViewById(R.id.expandableButton1121).setOnClickListener(this);


        imgBtnID = (ImageButton) findViewById(R.id.imgBtnID);

        // DATA PERMOHONAN
        jenis_kelamin = (EditText) findViewById(R.id.edt_jenis_kelamin);
        jenis_kelamin.setOnClickListener(this);

        pekerjaan_pemohon = (EditText) findViewById(R.id.edt_pekerjaan_pemohon);
        pekerjaan_pemohon.setOnClickListener(this);

        status_pernikahan = (EditText) findViewById(R.id.edt_status_pernikahan);
        status_pernikahan.setOnClickListener(this);

        pendidikan_terakhir = (EditText) findViewById(R.id.edt_pendidikan_terakhir);
        pendidikan_terakhir.setOnClickListener(this);

        status_rumah_tinggal = (EditText) findViewById(R.id.edt_status_rumah_tinggal);
        status_rumah_tinggal.setOnClickListener(this);

        pekerjaan_pasangan = (EditText) findViewById(R.id.edt_pekerjaan_pasangan);
        pekerjaan_pasangan.setOnClickListener(this);


        btnUpload = (Button) findViewById(R.id.btnupload);
        btnGalery= (Button) findViewById(R.id.btngallery);
        imgHolder = (ImageView) findViewById(R.id.imgHolder);
        pd = new ProgressDialog(this);
        pd.setMessage("loading ... ");

        btnGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"open gallery"),REQUEST_GALLERY);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.show();
                File imagefile = new File(part_image);
                RequestBody reqBody = RequestBody.create(MediaType.parse("multipart/form-file"),imagefile);
                MultipartBody.Part partImage = MultipartBody.Part.createFormData("imageupload", imagefile.getName(),reqBody);

                ApiRequestBiodata api =  Retroserver.getApiServices();
                Call<ResponsModel> upload = api.uploadImage(partImage);
                upload.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        pd.dismiss();
                        Log.d("RETRO", "ON RESPONSE  : " + response.body().toString());

                        if(response.body().getKode().equals("1"))
                        {
                            Toast.makeText(MainActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(MainActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        Log.d("RETRO", "ON FAILURE : " + t.getMessage());
                        pd.dismiss();
                    }
                });

            }
        });


        //Perintah EDIT Text
        dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tgl_permohonan = (EditText) findViewById(R.id.edt_tgl_permohonan);
        tgl_permohonan.setInputType(InputType.TYPE_NULL);
        tgl_permohonan.requestFocus();
        no_reg = (EditText) findViewById(R.id.edt_no_reg);
        no_reg.addTextChangedListener(TextWatcher);
        nama_pemohon = (EditText) findViewById(R.id.edt_nama_pemohon);
        nama_panggilan = (EditText) findViewById(R.id.edt_nama_panggilan);
        tempat_lahir = (EditText) findViewById(R.id.edt_tempat_lahir);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tgl_lahir = (EditText) findViewById(R.id.edt_tgl_lahir);
        tgl_lahir.setInputType(InputType.TYPE_NULL);
        tgl_lahir.addTextChangedListener(TextWatcher);
        no_ktp = (EditText) findViewById(R.id.edt_no_ktp);
        no_ktp.addTextChangedListener(TextWatcher);
        masa_berlaku_ktp = (EditText) findViewById(R.id.edt_masa_berlaku_ktp);
        masa_berlaku_ktp.addTextChangedListener(TextWatcher);
        alamat_sesuai_ktp = (EditText) findViewById(R.id.edt_alamat_sesuai_ktp);
        nama_ibu_kandung = (EditText) findViewById(R.id.edt_nama_ibu_kandung);
        kode_pos = (EditText) findViewById(R.id.edt_kode_pos);
        nama_perusahaan = (EditText) findViewById(R.id.edt_nama_perusahaan);
        nama_perusahaan.addTextChangedListener(TextWatcher);
        jabatan = (EditText) findViewById(R.id.edt_jabatan);
        alamat_perusahaan = (EditText) findViewById(R.id.edt_alamat_perusahaan);
        jml_tanggungan = (EditText) findViewById(R.id.edt_jml_tanggungan);
        lama_tinggal = (EditText) findViewById(R.id.edt_lama_tinggal);
        alamat_rumah_tinggal = (EditText) findViewById(R.id.edt_alamat_rumah_tinggal);
        no_telp = (EditText) findViewById(R.id.edt_no_telp);
        no_hp = (EditText) findViewById(R.id.edt_no_hp);
        nama_pasangan = (EditText) findViewById(R.id.edt_nama_pasangan);

        dateFormatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tgl_lahir_pasangan = (EditText) findViewById(R.id.edt_tgl_lahir_pasangan);
        tgl_lahir_pasangan.setInputType(InputType.TYPE_NULL);
        no_ktp_pasangan = (EditText) findViewById(R.id.edt_no_KTP_pasangan);
        masa_berlaku_ktp_pasangan = (EditText) findViewById(R.id.edt_masa_berlaku_ktp_pasangan);
        tempat_lahir_pasangan = (EditText) findViewById(R.id.edt_tempat_lahir_pasangan);
        alamat_pasangan = (EditText) findViewById(R.id.edt_alamat_pasangan);
        penghasilan_per_bln = (EditText) findViewById(R.id.edt_penghasilan_perbulan);
        penghasilan_per_bln.addTextChangedListener(TextWatcher);
        penjamin = (EditText) findViewById(R.id.edt_penjamin);
        alamat_penjamin = (EditText) findViewById(R.id.edt_alamat_penjamin);
        tempat_lahir_penjamin = (EditText) findViewById(R.id.edt_tempat_lahir_penjamin);

        dateFormatter3 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tgl_lahir_penjamin = (EditText) findViewById(R.id.edt_tgl_lahir_penjamin);
        tgl_lahir_penjamin.setInputType(InputType.TYPE_NULL);
        no_ktp_penjamin = (EditText) findViewById(R.id.edt_no_ktp_penjamin);
        masa_berlaku_ktp_penjamin = (EditText) findViewById(R.id.edt_masa_berlaku_ktp_penjamin);
        nama_pasangan_penjamin = (EditText) findViewById(R.id.edt_nama_pasangan_penjamin);
        alamat_pasangan_penjamin = (EditText) findViewById(R.id.edt_alamat_pasangan_penjamin);
        tempat_lahir_pasangan_penjamin = (EditText) findViewById(R.id.edt_tempat_lahir_pasangan_penjamin);

        dateFormatter4 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tgl_lahir_pasangan_penjamin = (EditText) findViewById(R.id.edt_tgl_lahir_pasangan_penjamin);
        tgl_lahir_pasangan_penjamin.setInputType(InputType.TYPE_NULL);
        no_ktp_pasangan_penjamin = (EditText) findViewById(R.id.edt_no_ktp_pasangan_penjamin);
        masa_berlaku_ktp_pasangan_penjamin = findViewById(R.id.edt_masa_berlaku_ktp_pasangan_penjamin);

        //DATA KREDIT

        periode_pembayaran_pokok = (EditText) findViewById(R.id.edt_periode_pembayaran_pokok);
        periode_pembayaran_pokok.setOnClickListener(this);

        type_angsuran = (EditText) findViewById(R.id.edt_type_bunga);
        type_angsuran.setOnClickListener(this);

        bunga = (EditText) findViewById(R.id.edt_bunga);
        bunga.setOnClickListener(this);

        jenis_kredit = (EditText) findViewById(R.id.edt_jenis_kredit);
        jenis_kredit.setOnClickListener(this);

        sektor_ekonomi = (EditText) findViewById(R.id.edt_sektor);
        sektor_ekonomi.setOnClickListener(this);

        surveyor = (EditText) findViewById(R.id.edt_surveyor);
        surveyor.setOnClickListener(this);

        jenis_penggunaan = (EditText) findViewById(R.id.edt_jenis_penggunaan);
        jenis_penggunaan.setOnClickListener(this);

        nama_asuransi = (EditText) findViewById(R.id.edt_asuransi);
        nama_asuransi.setOnClickListener(this);


        //Perintah EDIT Text

        fasilitas_ke = (EditText) findViewById(R.id.edt_fasilitas_kredit_ke);
        fasilitas_ke.addTextChangedListener(TextWatcher);

        plafond_kredit = (EditText) findViewById(R.id.edt_plafond_kredit);
        plafond_kredit.addTextChangedListener(TextWatcher);

        jkw = (EditText) findViewById(R.id.edt_jangka_waktu);

        jml_angsuran_per_bln = (EditText) findViewById(R.id.edt_jumlah_angsuran_perbulan);

        angsuran_pokok_pertama = (EditText) findViewById(R.id.edt_angsuran_pokok_pertama);
        angsuran_pokok_pertama.addTextChangedListener(TextWatcher);

        angsuran_bunga_pertama = (EditText) findViewById(R.id.edt_angsuran_bunga_pertama);

        provisi = (EditText) findViewById(R.id.edt_provisi);
        provisi.addTextChangedListener(TextWatcher);

        administrasi = (EditText) findViewById(R.id.edt_administrasi);
        administrasi.addTextChangedListener(TextWatcher);

        on_the_spot = (EditText) findViewById(R.id.edt_on_the_spot);
        on_the_spot.addTextChangedListener(TextWatcher);

        premi = (EditText) findViewById(R.id.edt_premi);
        premi.addTextChangedListener(TextWatcher);

        akad_kredit = (EditText) findViewById(R.id.edt_akad_kredit);
        akad_kredit.addTextChangedListener(TextWatcher);

        tujuan_penggunaan = (EditText) findViewById(R.id.edt_penggunaan);
        tujuan_penggunaan.addTextChangedListener(TextWatcher);

        //ASPEK JAMINAN

        //Aspek Jaminan 1

        ikatan_shm1 = (EditText) findViewById(R.id.edt_pengikat_jaminan);
        ikatan_shm1.setOnClickListener(this);
        asuransi_shm1 = (EditText) findViewById(R.id.edt_asuransii);
        asuransi_shm1.setOnClickListener(this);

        //Edit Text

        no_reg1 = (EditText) findViewById(R.id.edt_no_reg1);

        nama_jaminan_shm1 = (EditText) findViewById(R.id.edt_nama_jaminan);
        jenis_jaminan_shm1 = (EditText) findViewById(R.id.edt_jenis_jaminan);
        jenis_jaminan_shm1.setOnClickListener(this);
        atas_nama_shm1 = (EditText) findViewById(R.id.edt_atas_nama_jaminan);
        alamat_atas_nama_shm1 = (EditText) findViewById(R.id.edt_alamat_sesuai_ktp1);
        no_ktp_atas_nama_shm1 = (EditText) findViewById(R.id.edt_no_ktp1);
        masa_berlaku_shm1 = (EditText) findViewById(R.id.edt_berlaku_hingga1);
        nilai_ikatan_shm1 = (EditText) findViewById(R.id.edt_hak_tanggungan);
        no_SHM1 = (EditText) findViewById(R.id.edt_no_SHM1);
        no_SHM1.addTextChangedListener(TextWatcher);

        no_gs_shm1 = (EditText) findViewById(R.id.edt_no_GS);
        luas_shm1 = (EditText) findViewById(R.id.edt_luas);
        lokasi_shm1 = (EditText) findViewById(R.id.edt_lokasi);
        nilai_tanah_shm1 = (EditText) findViewById(R.id.edt_tanah);
        nilai_tanah_shm1.addTextChangedListener(TextWatcher);

        nilai_bangunan_shm1 = (EditText) findViewById(R.id.edt_bangunan);
        nilai_bangunan_shm1.addTextChangedListener(TextWatcher);
        total_taksiran_shm1 = (EditText) findViewById(R.id.edt_total_taksiran);
        total_taksiran_shm1.addTextChangedListener(TextWatcher);


        //Aspek Jaminan 2

        ikatan_shm2 = (EditText) findViewById(R.id.edt_pengikat_jaminan1);
        ikatan_shm2.setOnClickListener(this);
        asuransi_shm2 = (EditText) findViewById(R.id.edt_asuransi1);
        asuransi_shm2.setOnClickListener(this);

        //Edit Text
        nama_jaminan_shm2 = (EditText) findViewById(R.id.edt_nama_jaminan1);
        jenis_jaminan_shm2 = (EditText) findViewById(R.id.edt_jenis_jaminan1);
        jenis_jaminan_shm2.setOnClickListener(this);

        atas_nama_shm2 = (EditText) findViewById(R.id.edt_atas_nama_jaminan1);
        alamat_atas_nama_shm2 = (EditText) findViewById(R.id.edt_alamat_sesuai_ktp2);
        no_ktp_atas_nama_shm2 = (EditText) findViewById(R.id.edt_no_ktp2);
        masa_berlaku_shm2 = (EditText) findViewById(R.id.edt_berlaku_hingga2);
        nilai_ikatan_shm2 = (EditText) findViewById(R.id.edt_hak_tanggungan1);
        no_SHM2 = (EditText) findViewById(R.id.edt_no_SHM2);
        no_gs_shm2 = (EditText) findViewById(R.id.edt_no_GS1);
        luas_shm2 = (EditText) findViewById(R.id.edt_luas1);
        lokasi_shm2 = (EditText) findViewById(R.id.edt_lokasi1);
        nilai_tanah_shm2 = (EditText) findViewById(R.id.edt_tanah1);
        nilai_bangunan_shm2 = (EditText) findViewById(R.id.edt_bangunan1);
        total_taksiran_shm2 = (EditText) findViewById(R.id.edt_total_taksiran1);

        no_SHM2.addTextChangedListener(TextWatcher);
        nilai_tanah_shm2.addTextChangedListener(TextWatcher);
        nilai_bangunan_shm2.addTextChangedListener(TextWatcher);
        total_taksiran_shm2.addTextChangedListener(TextWatcher);

        //Aspek Jaminan 3

        ikatan_shm3 = (EditText) findViewById(R.id.edt_pengikat_jaminan2);
        ikatan_shm3.setOnClickListener(this);
        asuransi_shm3 = (EditText) findViewById(R.id.edt_asuransi2);
        asuransi_shm3.setOnClickListener(this);

        //Edit Text
        nama_jaminan_shm3 = (EditText) findViewById(R.id.edt_nama_jaminan2);
        jenis_jaminan_shm3 = (EditText) findViewById(R.id.edt_jenis_jaminan2);
        jenis_jaminan_shm3.setOnClickListener(this);
        atas_nama_shm3 = (EditText) findViewById(R.id.edt_atas_nama_jaminan2);

        alamat_atas_nama_shm3 = (EditText) findViewById(R.id.edt_alamat_sesuai_ktp3);
        no_ktp_atas_nama_shm3 = (EditText) findViewById(R.id.edt_no_ktp3);
        masa_berlaku_shm3 = (EditText) findViewById(R.id.edt_berlaku_hingga3);

        nilai_ikatan_shm3 = (EditText) findViewById(R.id.edt_hak_tanggungan2);
        no_SHM3 = (EditText) findViewById(R.id.edt_no_SHM3);
        no_gs_shm3 = (EditText) findViewById(R.id.edt_no_GS2);
        luas_shm3 = (EditText) findViewById(R.id.edt_luas2);
        lokasi_shm3 = (EditText) findViewById(R.id.edt_lokasi2);
        nilai_tanah_shm3 = (EditText) findViewById(R.id.edt_tanah2);
        nilai_bangunan_shm3 = (EditText) findViewById(R.id.edt_bangunan2);
        total_taksiran_shm3 = (EditText) findViewById(R.id.edt_total_taksiran2);

        no_SHM3.addTextChangedListener(TextWatcher);
        nilai_tanah_shm3.addTextChangedListener(TextWatcher);
        nilai_bangunan_shm3.addTextChangedListener(TextWatcher);
        total_taksiran_shm3.addTextChangedListener(TextWatcher);

        //Aspek Jaminan 4

        ikatan_shm4 = (EditText) findViewById(R.id.edt_pengikat_jaminan3);
        ikatan_shm4.setOnClickListener(this);
        asuransi_shm4 = (EditText) findViewById(R.id.edt_asuransi3);
        asuransi_shm4.setOnClickListener(this);

        //Edit Text
        nama_jaminan_shm4 = (EditText) findViewById(R.id.edt_nama_jaminan3);
        jenis_jaminan_shm4 = (EditText) findViewById(R.id.edt_jenis_jaminan3);
        jenis_jaminan_shm4.setOnClickListener(this);
        atas_nama_shm4 = (EditText) findViewById(R.id.edt_atas_nama_jaminan3);

        alamat_atas_nama_shm4 = (EditText) findViewById(R.id.edt_alamat_sesuai_ktp4);
        no_ktp_atas_nama_shm4 = (EditText) findViewById(R.id.edt_no_ktp4);
        masa_berlaku_shm4 = (EditText) findViewById(R.id.edt_berlaku_hingga4);

        nilai_ikatan_shm4 = (EditText) findViewById(R.id.edt_hak_tanggungan3);
        no_SHM4 = (EditText) findViewById(R.id.edt_no_SHM4);
        no_gs_shm4 = (EditText) findViewById(R.id.edt_no_GS3);
        luas_shm4 = (EditText) findViewById(R.id.edt_luas3);
        lokasi_shm4 = (EditText) findViewById(R.id.edt_lokasi3);
        nilai_tanah_shm4 = (EditText) findViewById(R.id.edt_tanah3);
        nilai_bangunan_shm4 = (EditText) findViewById(R.id.edt_bangunan3);
        total_taksiran_shm4 = (EditText) findViewById(R.id.edt_total_taksiran3);

        no_SHM4.addTextChangedListener(TextWatcher);
        nilai_tanah_shm4.addTextChangedListener(TextWatcher);
        nilai_bangunan_shm4.addTextChangedListener(TextWatcher);
        total_taksiran_shm4.addTextChangedListener(TextWatcher);

        //Aspek Jaminan 5

        ikatan_shm5 = (EditText) findViewById(R.id.edt_pengikat_jaminan4);
        ikatan_shm5.setOnClickListener(this);
        asuransi_shm5 = (EditText) findViewById(R.id.edt_asuransi4);
        asuransi_shm5.setOnClickListener(this);

        //Edit Text
        nama_jaminan_shm5 = (EditText) findViewById(R.id.edt_nama_jaminan4);
        jenis_jaminan_shm5 = (EditText) findViewById(R.id.edt_jenis_jaminan4);
        jenis_jaminan_shm5.setOnClickListener(this);
        atas_nama_shm5 = (EditText) findViewById(R.id.edt_atas_nama_jaminan4);

        alamat_atas_nama_shm5 = (EditText) findViewById(R.id.edt_alamat_sesuai_ktp5);
        no_ktp_atas_nama_shm5 = (EditText) findViewById(R.id.edt_no_ktp5);
        masa_berlaku_shm5 = (EditText) findViewById(R.id.edt_berlaku_hingga5);

        nilai_ikatan_shm5 = (EditText) findViewById(R.id.edt_hak_tanggungan4);
        no_SHM5 = (EditText) findViewById(R.id.edt_no_SHM5);
        no_gs_shm5 = (EditText) findViewById(R.id.edt_no_GS4);
        luas_shm5 = (EditText) findViewById(R.id.edt_luas4);
        lokasi_shm5 = (EditText) findViewById(R.id.edt_lokasi4);
        nilai_tanah_shm5 = (EditText) findViewById(R.id.edt_tanah4);
        nilai_bangunan_shm5 = (EditText) findViewById(R.id.edt_bangunan4);
        total_taksiran_shm5 = (EditText) findViewById(R.id.edt_total_taksiran4);

        no_SHM5.addTextChangedListener(TextWatcher);
        nilai_tanah_shm5.addTextChangedListener(TextWatcher);
        nilai_bangunan_shm5.addTextChangedListener(TextWatcher);
        total_taksiran_shm5.addTextChangedListener(TextWatcher);

        //Aspek Jaminan BPKB 1

        ikatan_bpkb1 = (EditText) findViewById(R.id.edt_pengikat_jaminanb1);
        ikatan_bpkb1.setOnClickListener(this);

        nama_jaminan_bpkb1 = (EditText) findViewById(R.id.edt_nama_jaminanb1);
        no_bpkb1 = (EditText) findViewById(R.id.edt_no_bpkb1);
        merk_bpkb1 = (EditText) findViewById(R.id.edt_merk1);

        tahun_bpkb1 = (EditText) findViewById(R.id.edt_tahun1);
        no_rangka_bpkb1 = (EditText) findViewById(R.id.edt_no_rangka1);
        no_mesin_bpkb1 = (EditText) findViewById(R.id.edt_no_mesin1);

        warna_bpkb1 = (EditText) findViewById(R.id.edt_warna1);
        nopol_bpkb1 = (EditText) findViewById(R.id.edt_no_polisi1);
        atas_nama_bpkb1 = (EditText) findViewById(R.id.edt_atas_nama_bpkb1);
        alamat_bpkb1 = (EditText) findViewById(R.id.edt_alamat1);
        nilai_fiducia1 = (EditText) findViewById(R.id.edt_nilai_fiducia1);
        nilai_fiducia1.addTextChangedListener(TextWatcher);
        nilai_taksiran_bpkb1 = (EditText) findViewById(R.id.edt_taksiran_harga_motor1);
        nilai_taksiran_bpkb1.addTextChangedListener(TextWatcher);


        //Aspek Jaminan BPKB 2

        ikatan_bpkb2 = (EditText) findViewById(R.id.edt_pengikat_jaminanb2);
        ikatan_bpkb2.setOnClickListener(this);

        nama_jaminan_bpkb2 = (EditText) findViewById(R.id.edt_nama_jaminanb2);
        no_bpkb2 = (EditText) findViewById(R.id.edt_no_bpkb2);
        merk_bpkb2 = (EditText) findViewById(R.id.edt_merk2);

        tahun_bpkb2 = (EditText) findViewById(R.id.edt_tahun2);
        no_rangka_bpkb2 = (EditText) findViewById(R.id.edt_no_rangka2);
        no_mesin_bpkb2 = (EditText) findViewById(R.id.edt_no_mesin2);

        warna_bpkb2 = (EditText) findViewById(R.id.edt_warna2);
        nopol_bpkb2 = (EditText) findViewById(R.id.edt_no_polisi2);
        atas_nama_bpkb2 = (EditText) findViewById(R.id.edt_atas_nama_bpkb2);
        alamat_bpkb2 = (EditText) findViewById(R.id.edt_alamat2);
        nilai_fiducia2 = (EditText) findViewById(R.id.edt_nilai_fiducia2);
        nilai_fiducia2.addTextChangedListener(TextWatcher);
        nilai_taksiran_bpkb2 = (EditText) findViewById(R.id.edt_taksiran_harga_motor2);
        nilai_taksiran_bpkb2.addTextChangedListener(TextWatcher);

        //Aspek Jaminan BPKB 3

        ikatan_bpkb3 = (EditText) findViewById(R.id.edt_pengikat_jaminanb3);
        ikatan_bpkb3.setOnClickListener(this);

        nama_jaminan_bpkb3 = (EditText) findViewById(R.id.edt_nama_jaminanb3);
        no_bpkb3 = (EditText) findViewById(R.id.edt_no_bpkb3);
        merk_bpkb3 = (EditText) findViewById(R.id.edt_merk3);

        tahun_bpkb3 = (EditText) findViewById(R.id.edt_tahun3);
        no_rangka_bpkb3 = (EditText) findViewById(R.id.edt_no_rangka3);
        no_mesin_bpkb3 = (EditText) findViewById(R.id.edt_no_mesin3);

        warna_bpkb3 = (EditText) findViewById(R.id.edt_warna3);
        nopol_bpkb3 = (EditText) findViewById(R.id.edt_no_polisi3);
        atas_nama_bpkb3 = (EditText) findViewById(R.id.edt_atas_nama_bpkb3);
        alamat_bpkb3 = (EditText) findViewById(R.id.edt_alamat3);
        nilai_fiducia3 = (EditText) findViewById(R.id.edt_nilai_fiducia3);
        nilai_fiducia3.addTextChangedListener(TextWatcher);
        nilai_taksiran_bpkb3 = (EditText) findViewById(R.id.edt_taksiran_harga_motor3);
        nilai_taksiran_bpkb3.addTextChangedListener(TextWatcher);

        //Aspek Jaminan BPKB 4

        ikatan_bpkb4 = (EditText) findViewById(R.id.edt_pengikat_jaminanb4);
        ikatan_bpkb4.setOnClickListener(this);

        nama_jaminan_bpkb4 = (EditText) findViewById(R.id.edt_nama_jaminanb4);
        no_bpkb4 = (EditText) findViewById(R.id.edt_no_bpkb4);
        merk_bpkb4 = (EditText) findViewById(R.id.edt_merk4);

        tahun_bpkb4 = (EditText) findViewById(R.id.edt_tahun4);
        no_rangka_bpkb4 = (EditText) findViewById(R.id.edt_no_rangka4);
        no_mesin_bpkb4 = (EditText) findViewById(R.id.edt_no_mesin4);

        warna_bpkb4 = (EditText) findViewById(R.id.edt_warna4);
        nopol_bpkb4 = (EditText) findViewById(R.id.edt_no_polisi4);
        atas_nama_bpkb4 = (EditText) findViewById(R.id.edt_atas_nama_bpkb4);
        alamat_bpkb4 = (EditText) findViewById(R.id.edt_alamat4);
        nilai_fiducia4 = (EditText) findViewById(R.id.edt_nilai_fiducia4);
        nilai_fiducia4.addTextChangedListener(TextWatcher);
        nilai_taksiran_bpkb4 = (EditText) findViewById(R.id.edt_taksiran_harga_motor4);
        nilai_taksiran_bpkb4.addTextChangedListener(TextWatcher);

        //Aspek Jaminan BPKB 5
        ikatan_bpkb5 = (EditText) findViewById(R.id.edt_pengikat_jaminanb5);
        ikatan_bpkb5.setOnClickListener(this);

        nama_jaminan_bpkb5 = (EditText) findViewById(R.id.edt_nama_jaminanb5);
        no_bpkb5 = (EditText) findViewById(R.id.edt_no_bpkb5);
        merk_bpkb5 = (EditText) findViewById(R.id.edt_merk5);

        tahun_bpkb5 = (EditText) findViewById(R.id.edt_tahun5);
        no_rangka_bpkb5 = (EditText) findViewById(R.id.edt_no_rangka5);
        no_mesin_bpkb5 = (EditText) findViewById(R.id.edt_no_mesin5);

        warna_bpkb5 = (EditText) findViewById(R.id.edt_warna5);
        nopol_bpkb5 = (EditText) findViewById(R.id.edt_no_polisi5);
        atas_nama_bpkb5 = (EditText) findViewById(R.id.edt_atas_nama_bpkb5);
        alamat_bpkb5 = (EditText) findViewById(R.id.edt_alamat5);
        nilai_fiducia5 = (EditText) findViewById(R.id.edt_nilai_fiducia5);
        nilai_fiducia5.addTextChangedListener(TextWatcher);
        nilai_taksiran_bpkb5 = (EditText) findViewById(R.id.edt_taksiran_harga_motor5);
        nilai_taksiran_bpkb5.addTextChangedListener(TextWatcher);

        //Aspek Jaminan BILYET DEPOSITO 1
        pengikat_jaminand1 = (EditText) findViewById(R.id.edt_pengikat_jaminand1);
        pengikat_jaminand1.setOnClickListener(this);
        nama_jaminand1 = (EditText) findViewById(R.id.edt_nama_jaminand1);
        nama_deposito1 = (EditText) findViewById(R.id.edt_nama_deposito1);
        no_bilyet1 = (EditText) findViewById(R.id.edt_no_bilyet1);
        alamatd1 = (EditText) findViewById(R.id.edt_alamatd1);
        deposito1 = (EditText) findViewById(R.id.edt_deposito1);
        total_nilai_jaminan1 = (EditText) findViewById(R.id.edt_total_nilai_jaminan1);
        persen_dari_plafond1 = (EditText) findViewById(R.id.edt_dari_palfond1);

        total_nilai_jaminan1.addTextChangedListener(TextWatcher);
        persen_dari_plafond1.addTextChangedListener(TextWatcher);


        //Aspek Jaminan BILYET DEPOSITO 2
        pengikat_jaminand2 = (EditText) findViewById(R.id.edt_pengikat_jaminand2);
        pengikat_jaminand2.setOnClickListener(this);
        nama_jaminand2 = (EditText) findViewById(R.id.edt_nama_jaminand2);
        nama_deposito2 = (EditText) findViewById(R.id.edt_nama_deposito2);
        no_bilyet2 = (EditText) findViewById(R.id.edt_no_bilyet2);
        alamatd2 = (EditText) findViewById(R.id.edt_alamatd2);
        deposito2 = (EditText) findViewById(R.id.edt_deposito2);
        total_nilai_jaminan2 = (EditText) findViewById(R.id.edt_total_nilai_jaminan2);
        persen_dari_plafond2 = (EditText) findViewById(R.id.edt_dari_palfond2);

        total_nilai_jaminan2.addTextChangedListener(TextWatcher);
        persen_dari_plafond2.addTextChangedListener(TextWatcher);

        //Aspek Jaminan BILYET DEPOSITO 3
        pengikat_jaminand3 = (EditText) findViewById(R.id.edt_pengikat_jaminand3);
        pengikat_jaminand3.setOnClickListener(this);
        nama_jaminand3 = (EditText) findViewById(R.id.edt_nama_jaminand3);
        nama_deposito3 = (EditText) findViewById(R.id.edt_nama_deposito3);
        no_bilyet3 = (EditText) findViewById(R.id.edt_no_bilyet3);
        alamatd3 = (EditText) findViewById(R.id.edt_alamatd3);
        deposito3 = (EditText) findViewById(R.id.edt_deposito3);
        total_nilai_jaminan3 = (EditText) findViewById(R.id.edt_total_nilai_jaminan3);
        persen_dari_plafond3 = (EditText) findViewById(R.id.edt_dari_palfond3);

        total_nilai_jaminan3.addTextChangedListener(TextWatcher);
        persen_dari_plafond3.addTextChangedListener(TextWatcher);



        pekerjaank = (EditText) findViewById(R.id.edt_pekerjaank);
        nama_perusahaan1 = (EditText) findViewById(R.id.edt_nama_perusahaan1);
        alamat_usaha = (EditText) findViewById(R.id.edt_alamat_usaha);
        lama_usaha = (EditText) findViewById(R.id.edt_lama_usaha);
        uraian_kegiatan_usaha_utama = (EditText) findViewById(R.id.edt_kegiatan_utama);
        uraian_kegiatan_usaha_lainnya = (EditText) findViewById(R.id.edt_kegiatan_usaha_lainnya);
        uraian_kegiatan_usaha_lainnya1 = (EditText) findViewById(R.id.edt_kegiatan_usaha_lainnya1);
        uraian_kegiatan_usaha_sampingan = (EditText) findViewById(R.id.edt_kegiatan_sampingan);
        uraian_kegiatan_usaha_pasangan = (EditText) findViewById(R.id.edt_kegiatan_pasangan);
        kondisi_fisik = (EditText) findViewById(R.id.edt_kondisi_fisik);
        kesimpulan = (EditText) findViewById(R.id.edt_kesimpulan);


        kas = (EditText) findViewById(R.id.edt_kas);
        kas.addTextChangedListener(TextWatcher);

        piutang = (EditText) findViewById(R.id.edt_piutang);
        piutang.addTextChangedListener(TextWatcher);

        persediaan = (EditText) findViewById(R.id.edt_persediaan);
        persediaan.addTextChangedListener(TextWatcher);

        inventaris = (EditText) findViewById(R.id.edt_inventaris);
        inventaris.addTextChangedListener(TextWatcher);

        tanah_rumah = (EditText) findViewById(R.id.edt_tanah_rumah);
        tanah_rumah.addTextChangedListener(TextWatcher);

        total_keuangan = (EditText) findViewById(R.id.edt_total_keuangan);
        total_keuangan.addTextChangedListener(TextWatcher);

        hutang_dagang = (EditText) findViewById(R.id.edt_hutang_dagang);
        hutang_dagang.addTextChangedListener(TextWatcher);

        hutang_bank = (EditText) findViewById(R.id.edt_hutang_bank);
        hutang_bank.addTextChangedListener(TextWatcher);

        pinjaman = (EditText) findViewById(R.id.edt_pinjaman);
        pinjaman.addTextChangedListener(TextWatcher);

        modal = (EditText) findViewById(R.id.edt_modal);
        modal.addTextChangedListener(TextWatcher);

        laba = (EditText) findViewById(R.id.edt_laba);
        laba.addTextChangedListener(TextWatcher);

        total_pasiva = (EditText) findViewById(R.id.edt_total_pasiva);
        total_pasiva.addTextChangedListener(TextWatcher);

        //pendapatan save
        pendapatan_usaha = (EditText) findViewById(R.id.edt_pendapatan_usaha);
        pendapatan_usaha.addTextChangedListener(TextWatcher);

        biaya_usaha = (EditText) findViewById(R.id.edt_biaya_usaha);
        biaya_usaha.addTextChangedListener(TextWatcher);

        laba_usaha = (EditText) findViewById(R.id.edt_laba_usaha);
        laba_usaha.addTextChangedListener(TextWatcher);

        pendapatan_lain = (EditText) findViewById(R.id.edt_pendapatan_lain);
        pendapatan_lain.addTextChangedListener(TextWatcher);

        total_pendapatan = (EditText) findViewById(R.id.edt_total_pendapatan);
        total_pendapatan.addTextChangedListener(TextWatcher);

        //biaya save
        biaya_rumah_tangga = (EditText) findViewById(R.id.edt_biaya_rumah_tangga);
        biaya_rumah_tangga.addTextChangedListener(TextWatcher);

        biaya_listrik = (EditText) findViewById(R.id.edt_biaya_listrik);
        biaya_listrik.addTextChangedListener(TextWatcher);

        biaya_pendidikan = (EditText) findViewById(R.id.edt_biaya_pendidikan);
        biaya_pendidikan.addTextChangedListener(TextWatcher);

        biaya_transportasi = (EditText) findViewById(R.id.edt_biaya_transportasi);
        biaya_transportasi.addTextChangedListener(TextWatcher);

        biaya_sosial = (EditText) findViewById(R.id.edt_biaya_sosial);
        biaya_sosial.addTextChangedListener(TextWatcher);

        angsuran_bank1 = (EditText) findViewById(R.id.edt_angsuran_bank1);
        angsuran_bank1.addTextChangedListener(TextWatcher);

        angsuran_bank2 = (EditText) findViewById(R.id.edt_angsuran_bank2);
        angsuran_bank2.addTextChangedListener(TextWatcher);

        angsuran_bank3 = (EditText) findViewById(R.id.edt_angsuran_bank3);
        angsuran_bank3.addTextChangedListener(TextWatcher);

        angsuran_bank4 = (EditText) findViewById(R.id.edt_angsuran_bank4);
        angsuran_bank4.addTextChangedListener(TextWatcher);

        angsuran_bank5 = (EditText) findViewById(R.id.edt_angsuran_bank5);
        angsuran_bank5.addTextChangedListener(TextWatcher);

        angsuran_bank6 = (EditText) findViewById(R.id.edt_angsuran_bank6);
        angsuran_bank6.addTextChangedListener(TextWatcher);

        biaya_lainnya = (EditText) findViewById(R.id.edt_biaya_lainnya);
        biaya_lainnya.addTextChangedListener(TextWatcher);

        total_biaya = (EditText) findViewById(R.id.edt_total_biaya);
        total_biaya.addTextChangedListener(TextWatcher);

        //Aspek Pemasaran
        kelola_usaha = (EditText) findViewById(R.id.edt_kelola_usaha);
        persaingan_usaha = (EditText) findViewById(R.id.edt_persaingan_usaha);
        pemasaran_usaha = (EditText) findViewById(R.id.edt_pemasaran_usaha);
        amdal_usaha = (EditText) findViewById(R.id.edt_amdal_usaha);
        prospek_usaha = (EditText) findViewById(R.id.edt_prospek_usaha);

        //Aspek Karakter
        fasilitas_kredit_ke1 = (EditText) findViewById(R.id.edt_fasalitas_kredit_ke1);
        kondite_kredit_lalu = (EditText) findViewById(R.id.edt_kondite_kredit);
        referensi = (EditText) findViewById(R.id.edt_referensi);
        info_lingkungan = (EditText) findViewById(R.id.edt_info_lingkungan);
        avalis_kredit = (EditText) findViewById(R.id.edt_avalis_kredit);
        karakter_lainnya = (EditText) findViewById(R.id.edt_karakter_lainnya);

        //Aspek Hukum
        dasar_hukum = (EditText) findViewById(R.id.edt_dasar_hukum);
        nomor_KID = (EditText) findViewById(R.id.edt_nomor_KID);
        legalitas_identitas = (EditText) findViewById(R.id.edt_legalitas_KID);
        masa_berlaku_KID = (EditText) findViewById(R.id.edt_masa_berlaku_KID);
        akad_kredit1 = (EditText) findViewById(R.id.edt_akad_kredit1);
        asuransiii = (EditText) findViewById(R.id.edt_Asuransiii);

        //Analisa Kebutuhan
        plafond_kredit1 = (EditText) findViewById(R.id.edt_plafond_kredit1);
        tujuan_penggunaan1 = (EditText) findViewById(R.id.edt_tujuan_penggunaan1);
        tujuan_modal = (EditText) findViewById(R.id.edt_tujuan_modal);
        tujuan_modal.addTextChangedListener(TextWatcher);
        tujuan_pelunasan = (EditText) findViewById(R.id.edt_tujuan_pelunasan);
        tujuan_pembelian = (EditText) findViewById(R.id.edt_tujuan_pembelian);
        tujuan_renovasi = (EditText) findViewById(R.id.edt_tujuan_renovasi);
        tujuan_sekolah = (EditText) findViewById(R.id.edt_tujuan_sekolah);
        tujuan_lainnya = (EditText) findViewById(R.id.edt_tujuan_lainnya);
        total_kebutuhan = (EditText) findViewById(R.id.edt_total_kebutuhan);
        kas1 = (EditText) findViewById(R.id.edt_kas1);
        kebutuhan_bank = (EditText) findViewById(R.id.edt_kebutuhan_bank);
        dibulatkan_menjadi = (EditText) findViewById(R.id.edt_dibulatan_menjadi);

        plafond_kredit2 = (EditText) findViewById(R.id.edt_plafond_kredit2);
        laba2 = (EditText) findViewById(R.id.edt_laba1);
        angsuran_bunga_pertama2 = (EditText) findViewById(R.id.edt_angsuran_bunga_pertama1);
        dana_angsuran = (EditText) findViewById(R.id.edt_dana_angsuran_pokok);
        jkw_x1 = (EditText) findViewById(R.id.edt_jkw_x1);
        jkw2 = (EditText) findViewById(R.id.edt_jkw1);



        setDateTimeField();

        setDateTimeField1();

        setDateTimeField2();
        setDateTimeField3();
        setDateTimeField4();

        btnTampildata = (Button) findViewById(R.id.btntampildata);
        btnupdate =(Button) findViewById(R.id.btnUpdate);
        btnsave = (Button) findViewById(R.id.btn_insertdata);
        btndelete=(Button) findViewById(R.id.btnhapus);
        btndelete=(Button) findViewById(R.id.btnhapus);



        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata != null) {

            btnsave.setVisibility(View.GONE);
            btnTampildata.setVisibility(View.GONE);
            btnupdate.setVisibility(View.VISIBLE);
            btndelete.setVisibility(View.VISIBLE);

            //DATA PERMOHONAN

            tgl_permohonan.setText(data.getStringExtra("tgl_permohonan"));
            no_reg.setText(data.getStringExtra("no_reg"));
            nama_pemohon.setText(data.getStringExtra("nama_pemohon"));
            nama_panggilan.setText(data.getStringExtra("nama_panggilan"));
            tempat_lahir.setText(data.getStringExtra("tempat_lahir"));
            tgl_lahir.setText(data.getStringExtra("tgl_lahir"));
            jenis_kelamin.setText(data.getStringExtra("jenis_kelamin"));
            no_ktp.setText(data.getStringExtra("no_ktp"));
            masa_berlaku_ktp.setText(data.getStringExtra("masa_berlaku_ktp"));
            alamat_sesuai_ktp.setText(data.getStringExtra("alamat_sesuai_ktp"));
            nama_ibu_kandung.setText(data.getStringExtra("nama_ibu_kandung"));

            kode_pos.setText(data.getStringExtra("kode_pos"));
            pekerjaan_pemohon.setText(data.getStringExtra("pekerjaan_pemohon"));
            nama_perusahaan.setText(data.getStringExtra("nama_perusahaan"));
            jabatan.setText(data.getStringExtra("jabatan"));
            alamat_perusahaan.setText(data.getStringExtra("alamat_perusahaan"));
            status_pernikahan.setText(data.getStringExtra("status_pernikahan"));
            jml_tanggungan.setText(data.getStringExtra("jml_tanggungan"));
            pendidikan_terakhir.setText(data.getStringExtra("pendidikan_terakhir"));
            status_rumah_tinggal.setText(data.getStringExtra("status_rumah_tinggal"));
            lama_tinggal.setText(data.getStringExtra("lama_tinggal"));
            alamat_rumah_tinggal.setText(data.getStringExtra("alamat_rumah_tinggal"));
            no_telp.setText(data.getStringExtra("no_telp"));
            no_hp.setText(data.getStringExtra("no_hp"));

            nama_pasangan.setText(data.getStringExtra("nama_pasangan"));
            tgl_lahir_pasangan.setText(data.getStringExtra("tgl_lahir_pasangan"));
            no_ktp_pasangan.setText(data.getStringExtra("no_ktp_pasangan"));
            masa_berlaku_ktp_pasangan.setText(data.getStringExtra("masa_berlaku_ktp_pasangan"));
            pekerjaan_pasangan.setText(data.getStringExtra("pekerjaan_pasangan"));
            tempat_lahir_pasangan.setText(data.getStringExtra("tempat_lahir_pasangan"));
            alamat_pasangan.setText(data.getStringExtra("alamat_pasangan"));

            penghasilan_per_bln.setText(data.getStringExtra("penghasilan_per_bln"));
            penjamin.setText(data.getStringExtra("penjamin"));
            alamat_penjamin.setText(data.getStringExtra("alamat_penjamin"));
            tempat_lahir_penjamin.setText(data.getStringExtra("tempat_lahir_penjamin"));
            tgl_lahir_penjamin.setText(data.getStringExtra("tgl_lahir_penjamin"));
            no_ktp_penjamin.setText(data.getStringExtra("no_ktp_penjamin"));
            masa_berlaku_ktp_penjamin.setText(data.getStringExtra("masa_berlaku_ktp_penjamin"));
            nama_pasangan_penjamin.setText(data.getStringExtra("nama_pasangan_penjamin"));
            alamat_pasangan_penjamin.setText(data.getStringExtra("alamat_pasangan_penjamin"));
            tempat_lahir_pasangan_penjamin.setText(data.getStringExtra("tempat_lahir_pasangan_penjamin"));
            tgl_lahir_pasangan_penjamin.setText(data.getStringExtra("tgl_lahir_pasangan_penjamin"));
            no_ktp_pasangan_penjamin.setText(data.getStringExtra("no_ktp_pasangan_penjamin"));
            masa_berlaku_ktp_pasangan_penjamin.setText(data.getStringExtra("masa_berlaku_ktp_pasangan_penjamin"));

            //DATA KREDIT

            jenis_kredit.setText(data.getStringExtra("jenis_kredit"));
            sektor_ekonomi.setText(data.getStringExtra("sektor_ekonomi"));
            fasilitas_ke.setText(data.getStringExtra("fasilitas_ke"));
            plafond_kredit.setText(data.getStringExtra("plafond_kredit"));
            jkw.setText(data.getStringExtra("jkw"));
            bunga.setText(data.getStringExtra("bunga"));
            type_angsuran.setText(data.getStringExtra("type_angsuran"));
            periode_pembayaran_pokok.setText(data.getStringExtra("periode_pembayaran_pokok"));
            jml_angsuran_per_bln.setText(data.getStringExtra("jml_angsuran_per_bln"));
            angsuran_pokok_pertama.setText(data.getStringExtra("angsuran_pokok_pertama"));
            angsuran_bunga_pertama.setText(data.getStringExtra("angsuran_bunga_pertama"));
            provisi.setText(data.getStringExtra("provisi"));
            administrasi.setText(data.getStringExtra("administrasi"));
            on_the_spot.setText(data.getStringExtra("on_the_spot"));
            premi.setText(data.getStringExtra("premi"));
            nama_asuransi.setText(data.getStringExtra("nama_asuransi"));
            akad_kredit.setText(data.getStringExtra("akad_kredit"));
            jenis_penggunaan.setText(data.getStringExtra("jenis_penggunaan"));
            tujuan_penggunaan.setText(data.getStringExtra("tujuan_penggunaan"));
            surveyor.setText(data.getStringExtra("surveyor"));

            //ASPEK JAMINAN

            //Aspek Jaminan 1



                no_reg1.setText(data.getStringExtra("no_reg1"));
                nama_jaminan_shm1.setText(data.getStringExtra("nama_jaminan_shm1"));
                jenis_jaminan_shm1.setText(data.getStringExtra("jenis_jaminan_shm1"));
                atas_nama_shm1.setText(data.getStringExtra("atas_nama_shm1"));
                alamat_atas_nama_shm1.setText(data.getStringExtra("alamat_atas_nama_shm1"));
                no_ktp_atas_nama_shm1.setText(data.getStringExtra("no_ktp_atas_nama_shm1"));
                masa_berlaku_shm1.setText(data.getStringExtra("masa_berlaku_shm1"));
                ikatan_shm1.setText(data.getStringExtra("ikatan_shm1"));
                nilai_ikatan_shm1.setText(data.getStringExtra("nilai_ikatan_shm1"));
                no_SHM1.setText(data.getStringExtra("no_SHM1"));
                no_gs_shm1.setText(data.getStringExtra("no_gs_shm1"));
                luas_shm1.setText(data.getStringExtra("luas_shm1"));
                lokasi_shm1.setText(data.getStringExtra("lokasi_shm1"));
                asuransi_shm1.setText(data.getStringExtra("asuransi_shm1"));
                nilai_tanah_shm1.setText(data.getStringExtra("nilai_tanah_shm1"));
                nilai_bangunan_shm1.setText(data.getStringExtra("nilai_bangunan_shm1"));
                total_taksiran_shm1.setText(data.getStringExtra("total_taksiran_shm1"));





            //Aspek Jaminan 2
            nama_jaminan_shm2.setText(data.getStringExtra("nama_jaminan_shm2"));
            jenis_jaminan_shm2.setText(data.getStringExtra("jenis_jaminan_shm2"));
            atas_nama_shm2.setText(data.getStringExtra("atas_nama_shm2"));
            alamat_atas_nama_shm2.setText(data.getStringExtra("alamat_atas_nama_shm2"));
            no_ktp_atas_nama_shm2.setText(data.getStringExtra("no_ktp_atas_nama_shm2"));
            masa_berlaku_shm2.setText(data.getStringExtra("masa_berlaku_shm2"));
            ikatan_shm2.setText(data.getStringExtra("ikatan_shm2"));
            nilai_ikatan_shm2.setText(data.getStringExtra("nilai_ikatan_shm2"));
            no_SHM2.setText(data.getStringExtra("no_SHM2"));
            no_gs_shm2.setText(data.getStringExtra("no_gs_shm2"));
            luas_shm2.setText(data.getStringExtra("luas_shm2"));
            lokasi_shm2.setText(data.getStringExtra("lokasi_shm2"));
            asuransi_shm2.setText(data.getStringExtra("asuransi_shm2"));
            nilai_tanah_shm2.setText(data.getStringExtra("nilai_tanah_shm2"));
            nilai_bangunan_shm2.setText(data.getStringExtra("nilai_bangunan_shm2"));
            total_taksiran_shm2.setText(data.getStringExtra("total_taksiran_shm2"));

            //Aspek Jaminan 3
            nama_jaminan_shm3.setText(data.getStringExtra("nama_jaminan_shm3"));
            jenis_jaminan_shm3.setText(data.getStringExtra("jenis_jaminan_shm3"));
            atas_nama_shm3.setText(data.getStringExtra("atas_nama_shm3"));
            alamat_atas_nama_shm3.setText(data.getStringExtra("alamat_atas_nama_shm3"));
            no_ktp_atas_nama_shm3.setText(data.getStringExtra("no_ktp_atas_nama_shm3"));
            masa_berlaku_shm3.setText(data.getStringExtra("masa_berlaku_shm3"));
            ikatan_shm3.setText(data.getStringExtra("ikatan_shm3"));
            nilai_ikatan_shm3.setText(data.getStringExtra("nilai_ikatan_shm3"));
            no_SHM3.setText(data.getStringExtra("no_SHM3"));
            no_gs_shm3.setText(data.getStringExtra("no_gs_shm3"));
            luas_shm3.setText(data.getStringExtra("luas_shm3"));
            lokasi_shm3.setText(data.getStringExtra("lokasi_shm3"));
            asuransi_shm3.setText(data.getStringExtra("asuransi_shm3"));
            nilai_tanah_shm3.setText(data.getStringExtra("nilai_tanah_shm3"));
            nilai_bangunan_shm3.setText(data.getStringExtra("nilai_bangunan_shm3"));
            total_taksiran_shm3.setText(data.getStringExtra("total_taksiran_shm3"));


            //Aspek Jaminan 4
            nama_jaminan_shm4.setText(data.getStringExtra("nama_jaminan_shm4"));
            jenis_jaminan_shm4.setText(data.getStringExtra("jenis_jaminan_shm4"));
            atas_nama_shm4.setText(data.getStringExtra("atas_nama_shm4"));
            alamat_atas_nama_shm4.setText(data.getStringExtra("alamat_atas_nama_shm4"));
            no_ktp_atas_nama_shm4.setText(data.getStringExtra("no_ktp_atas_nama_shm4"));
            masa_berlaku_shm4.setText(data.getStringExtra("masa_berlaku_shm4"));
            ikatan_shm4.setText(data.getStringExtra("ikatan_shm4"));
            nilai_ikatan_shm4.setText(data.getStringExtra("nilai_ikatan_shm4"));
            no_SHM4.setText(data.getStringExtra("no_SHM4"));
            no_gs_shm4.setText(data.getStringExtra("no_gs_shm4"));
            luas_shm4.setText(data.getStringExtra("luas_shm4"));
            lokasi_shm4.setText(data.getStringExtra("lokasi_shm4"));
            asuransi_shm4.setText(data.getStringExtra("asuransi_shm4"));
            nilai_tanah_shm4.setText(data.getStringExtra("nilai_tanah_shm4"));
            nilai_bangunan_shm4.setText(data.getStringExtra("nilai_bangunan_shm4"));
            total_taksiran_shm4.setText(data.getStringExtra("total_taksiran_shm4"));


            //Aspek Jaminan 5
            nama_jaminan_shm5.setText(data.getStringExtra("nama_jaminan_shm5"));
            jenis_jaminan_shm5.setText(data.getStringExtra("jenis_jaminan_shm5"));
            atas_nama_shm5.setText(data.getStringExtra("atas_nama_shm5"));
            alamat_atas_nama_shm5.setText(data.getStringExtra("alamat_atas_nama_shm5"));
            no_ktp_atas_nama_shm5.setText(data.getStringExtra("no_ktp_atas_nama_shm5"));
            masa_berlaku_shm5.setText(data.getStringExtra("masa_berlaku_shm5"));
            ikatan_shm5.setText(data.getStringExtra("ikatan_shm5"));
            nilai_ikatan_shm5.setText(data.getStringExtra("nilai_ikatan_shm5"));
            no_SHM5.setText(data.getStringExtra("no_SHM5"));
            no_gs_shm5.setText(data.getStringExtra("no_gs_shm5"));
            luas_shm5.setText(data.getStringExtra("luas_shm5"));
            lokasi_shm5.setText(data.getStringExtra("lokasi_shm5"));
            asuransi_shm5.setText(data.getStringExtra("asuransi_shm5"));
            nilai_tanah_shm5.setText(data.getStringExtra("nilai_tanah_shm5"));
            nilai_bangunan_shm5.setText(data.getStringExtra("nilai_bangunan_shm5"));
            total_taksiran_shm5.setText(data.getStringExtra("total_taksiran_shm5"));


            //Aspek Jaminan BPKB 1
            nama_jaminan_bpkb1.setText(data.getStringExtra("nama_jaminan_bpkb1"));
            no_bpkb1.setText(data.getStringExtra("no_bpkb1"));
            merk_bpkb1.setText(data.getStringExtra("merk_bpkb1"));

            tahun_bpkb1.setText(data.getStringExtra("tahun_bpkb1"));
            no_rangka_bpkb1.setText(data.getStringExtra("no_rangka_bpkb1"));
            no_mesin_bpkb1.setText(data.getStringExtra("no_mesin_bpkb1"));

            warna_bpkb1.setText(data.getStringExtra("warna_bpkb1"));
            nopol_bpkb1.setText(data.getStringExtra("nopol_bpkb1"));
            atas_nama_bpkb1.setText(data.getStringExtra("atas_nama_bpkb1"));
            alamat_bpkb1.setText(data.getStringExtra("alamat_bpkb1"));
            ikatan_bpkb1.setText(data.getStringExtra("ikatan_bpkb1"));
            nilai_taksiran_bpkb1.setText(data.getStringExtra("nilai_taksiran_bpkb1"));


            //Aspek Jaminan BPKB 2
            nama_jaminan_bpkb2.setText(data.getStringExtra("nama_jaminan_bpkb2"));
            no_bpkb2.setText(data.getStringExtra("no_bpkb2"));
            merk_bpkb2.setText(data.getStringExtra("merk_bpkb2"));

            tahun_bpkb2.setText(data.getStringExtra("tahun_bpkb2"));
            no_rangka_bpkb2.setText(data.getStringExtra("no_rangka_bpkb2"));
            no_mesin_bpkb2.setText(data.getStringExtra("no_mesin_bpkb2"));

            warna_bpkb2.setText(data.getStringExtra("warna_bpkb2"));
            nopol_bpkb2.setText(data.getStringExtra("nopol_bpkb2"));
            atas_nama_bpkb2.setText(data.getStringExtra("atas_nama_bpkb2"));
            alamat_bpkb2.setText(data.getStringExtra("alamat_bpkb2"));
            ikatan_bpkb2.setText(data.getStringExtra("ikatan_bpkb2"));
            nilai_taksiran_bpkb2.setText(data.getStringExtra("nilai_taksiran_bpkb2"));


            //Aspek Jaminan BPKB 3
            nama_jaminan_bpkb3.setText(data.getStringExtra("nama_jaminan_bpkb3"));
            no_bpkb3.setText(data.getStringExtra("no_bpkb3"));
            merk_bpkb3.setText(data.getStringExtra("merk_bpkb3"));

            tahun_bpkb3.setText(data.getStringExtra("tahun_bpkb3"));
            no_rangka_bpkb3.setText(data.getStringExtra("no_rangka_bpkb3"));
            no_mesin_bpkb3.setText(data.getStringExtra("no_mesin_bpkb3"));

            warna_bpkb3.setText(data.getStringExtra("warna_bpkb3"));
            nopol_bpkb3.setText(data.getStringExtra("nopol_bpkb3"));
            atas_nama_bpkb3.setText(data.getStringExtra("atas_nama_bpkb3"));
            alamat_bpkb3.setText(data.getStringExtra("alamat_bpkb3"));
            ikatan_bpkb3.setText(data.getStringExtra("ikatan_bpkb3"));
            nilai_taksiran_bpkb3.setText(data.getStringExtra("nilai_taksiran_bpkb3"));


            //Aspek Jaminan BPKB 4
            nama_jaminan_bpkb4.setText(data.getStringExtra("nama_jaminan_bpkb4"));
            no_bpkb4.setText(data.getStringExtra("no_bpkb4"));
            merk_bpkb4.setText(data.getStringExtra("merk_bpkb4"));

            tahun_bpkb4.setText(data.getStringExtra("tahun_bpkb4"));
            no_rangka_bpkb4.setText(data.getStringExtra("no_rangka_bpkb4"));
            no_mesin_bpkb4.setText(data.getStringExtra("no_mesin_bpkb4"));

            warna_bpkb4.setText(data.getStringExtra("warna_bpkb4"));
            nopol_bpkb4.setText(data.getStringExtra("nopol_bpkb4"));
            atas_nama_bpkb4.setText(data.getStringExtra("atas_nama_bpkb4"));
            alamat_bpkb4.setText(data.getStringExtra("alamat_bpkb4"));
            ikatan_bpkb4.setText(data.getStringExtra("ikatan_bpkb4"));
            nilai_taksiran_bpkb4.setText(data.getStringExtra("nilai_taksiran_bpkb4"));

            //Aspek Jaminan BPKB 5
            nama_jaminan_bpkb5.setText(data.getStringExtra("nama_jaminan_bpkb5"));
            no_bpkb5.setText(data.getStringExtra("no_bpkb5"));
            merk_bpkb5.setText(data.getStringExtra("merk_bpkb5"));

            tahun_bpkb5.setText(data.getStringExtra("tahun_bpkb5"));
            no_rangka_bpkb5.setText(data.getStringExtra("no_rangka_bpkb5"));
            no_mesin_bpkb5.setText(data.getStringExtra("no_mesin_bpkb5"));

            warna_bpkb5.setText(data.getStringExtra("warna_bpkb5"));
            nopol_bpkb5.setText(data.getStringExtra("nopol_bpkb5"));
            atas_nama_bpkb5.setText(data.getStringExtra("atas_nama_bpkb5"));
            alamat_bpkb5.setText(data.getStringExtra("alamat_bpkb5"));
            ikatan_bpkb5.setText(data.getStringExtra("ikatan_bpkb5"));
            nilai_taksiran_bpkb5.setText(data.getStringExtra("nilai_taksiran_bpkb5"));

            //Aspek Jaminan bilyet deposito 1
            nama_jaminand1.setText(data.getStringExtra("jaminan_bilyet1"));
            nama_deposito1.setText(data.getStringExtra("atas_nama_bilyet1"));
            no_bilyet1.setText(data.getStringExtra("no_bilyet1"));

            alamatd1.setText(data.getStringExtra("alamat_bilyet1"));
            pengikat_jaminand1.setText(data.getStringExtra("ikatan_bilyet1"));
            deposito1.setText(data.getStringExtra("nilai_bilyet1"));

            total_nilai_jaminan1.setText(data.getStringExtra("total_nilai_bilyet1"));
            persen_dari_plafond1.setText(data.getStringExtra("persen_dari_plafond1"));

            //Aspek Jaminan bilyet deposito 2
            nama_jaminand2.setText(data.getStringExtra("jaminan_bilyet2"));
            nama_deposito2.setText(data.getStringExtra("atas_nama_bilyet2"));
            no_bilyet2.setText(data.getStringExtra("no_bilyet2"));

            alamatd2.setText(data.getStringExtra("alamat_bilyet2"));
            pengikat_jaminand2.setText(data.getStringExtra("ikatan_bilyet2"));
            deposito2.setText(data.getStringExtra("nilai_bilyet2"));

            total_nilai_jaminan2.setText(data.getStringExtra("total_nilai_bilyet2"));
            persen_dari_plafond2.setText(data.getStringExtra("persen_dari_plafond2"));


            //Aspek Jaminan bilyet deposito 3
            nama_jaminand3.setText(data.getStringExtra("jaminan_bilyet3"));
            nama_deposito3.setText(data.getStringExtra("atas_nama_bilyet3"));
            no_bilyet3.setText(data.getStringExtra("no_bilyet3"));

            alamatd3.setText(data.getStringExtra("alamat_bilyet3"));
            pengikat_jaminand3.setText(data.getStringExtra("ikatan_bilyet3"));
            deposito3.setText(data.getStringExtra("nilai_bilyet3"));

            total_nilai_jaminan3.setText(data.getStringExtra("total_nilai_bilyet3"));
            persen_dari_plafond3.setText(data.getStringExtra("persen_dari_plafond3"));


            //Aspek Kapasitas
            pekerjaank.setText(data.getStringExtra("rincian_pekerjaan"));
            alamat_usaha.setText(data.getStringExtra("alamat_usaha"));
            lama_usaha.setText(data.getStringExtra("lama_usaha"));
            uraian_kegiatan_usaha_utama.setText(data.getStringExtra("deskripsi_usaha_utama"));
            uraian_kegiatan_usaha_lainnya.setText(data.getStringExtra("uraian_kegiatan_usaha_lainnya"));
            uraian_kegiatan_usaha_lainnya1.setText(data.getStringExtra("uraian_kegiatan_usaha_lainnya1"));
            uraian_kegiatan_usaha_sampingan.setText(data.getStringExtra("deskripsi_usaha_sampingan"));
            uraian_kegiatan_usaha_pasangan.setText(data.getStringExtra("deskripsi_usaha_pasangan"));
            kondisi_fisik.setText(data.getStringExtra("kondisi_fisik_pemohon"));
            kesimpulan.setText(data.getStringExtra("kesimpulan"));

            //Aspek Keuangan
            kas.setText(data.getStringExtra("kas"));
            piutang.setText(data.getStringExtra("piutang"));
            persediaan.setText(data.getStringExtra("persediaan"));
            inventaris.setText(data.getStringExtra("inventaris"));
            tanah_rumah.setText(data.getStringExtra("tanah"));
            total_keuangan.setText(data.getStringExtra("total_aktiva"));

            hutang_dagang.setText(data.getStringExtra("hutang_dagang"));
            hutang_bank.setText(data.getStringExtra("hutang_bank"));
            pinjaman.setText(data.getStringExtra("pinjaman"));
            modal.setText(data.getStringExtra("modal"));
            laba.setText(data.getStringExtra("laba"));
            total_pasiva.setText(data.getStringExtra("total_pasiva"));

            pendapatan_usaha.setText(data.getStringExtra("pendapatan_usaha"));
            biaya_usaha.setText(data.getStringExtra("biaya_usaha"));
            laba_usaha.setText(data.getStringExtra("laba_usaha"));
            pendapatan_lain.setText(data.getStringExtra("pendapatan_lain"));
            total_pendapatan.setText(data.getStringExtra("total_pendapatan"));

            biaya_rumah_tangga.setText(data.getStringExtra("biaya_rumah_tangga"));
            biaya_listrik.setText(data.getStringExtra("biaya_listrik"));
            biaya_pendidikan.setText(data.getStringExtra("biaya_pendidikan"));
            biaya_transportasi.setText(data.getStringExtra("biaya_transportasi"));
            biaya_sosial.setText(data.getStringExtra("biaya_sosial"));

            angsuran_bank1.setText(data.getStringExtra("angsuran_bank1"));
            angsuran_bank2.setText(data.getStringExtra("angsuran_bank2"));
            angsuran_bank3.setText(data.getStringExtra("angsuran_bank3"));
            angsuran_bank4.setText(data.getStringExtra("angsuran_bank4"));
            angsuran_bank5.setText(data.getStringExtra("angsuran_bank5"));
            angsuran_bank6.setText(data.getStringExtra("angsuran_bank6"));
            biaya_lainnya.setText(data.getStringExtra("biaya_lainnya"));
            total_biaya.setText(data.getStringExtra("total_biaya"));

            //Aspek Pemasaran
            kelola_usaha.setText(data.getStringExtra("kelola_usaha"));
            persaingan_usaha.setText(data.getStringExtra("persaingan_usaha"));
            pemasaran_usaha.setText(data.getStringExtra("pemasaran_usaha"));
            amdal_usaha.setText(data.getStringExtra("amdal_usaha"));
            prospek_usaha.setText(data.getStringExtra("prospek_usaha"));

            //Aspek Karakter
            kondite_kredit_lalu.setText(data.getStringExtra("kondite_kredit_lalu"));
            referensi.setText(data.getStringExtra("referensi"));
            info_lingkungan.setText(data.getStringExtra("info_lingkungan"));
            avalis_kredit.setText(data.getStringExtra("avalis_kredit"));
            karakter_lainnya.setText(data.getStringExtra("karakter_lainnya"));

            //Aspek hukum
            dasar_hukum.setText(data.getStringExtra("dasar_hukum"));
            legalitas_identitas.setText(data.getStringExtra("legalitas_identitas"));

            //Analis Kebutuhan
            tujuan_modal.setText(data.getStringExtra("tujuan_modal"));
            tujuan_pelunasan.setText(data.getStringExtra("tujuan_pelunasan"));
            tujuan_pembelian.setText(data.getStringExtra("tujuan_pembelian"));
            tujuan_pelunasan.setText(data.getStringExtra("tujuan_pelunasan"));
            tujuan_sekolah.setText(data.getStringExtra("tujuan_sekolah"));
            tujuan_lainnya.setText(data.getStringExtra("tujuan_lainnya"));
            total_kebutuhan.setText(data.getStringExtra("total_kebutuhan"));
            kebutuhan_bank.setText(data.getStringExtra("kebutuhan_bank"));

            dana_angsuran.setText(data.getStringExtra("dana_angsuran"));
            jkw_x1.setText(data.getStringExtra("jkw_x1"));



        }



        pd = new ProgressDialog(this);



        btnTampildata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata = new Intent(MainActivity.this, TampilData.class);
                startActivity(godata);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Loading Hapus ...");
                pd.setCancelable(false);
                pd.show();

                String sno_reg = no_reg.getText().toString();

                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
                Call<ResponsModel> del  = api.deleteData(sno_reg);
                del.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "onResponse");
                        Toast.makeText(MainActivity.this, response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        Intent gotampil = new Intent(MainActivity.this,TampilData.class);
                        startActivity(gotampil);

                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("update ....");
                pd.setCancelable(false);
                pd.show();

                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
                Call<ResponsModel>  update = api.updateData(iddata, tgl_permohonan.getText().toString(), no_reg.getText().toString(), nama_pemohon.getText().toString(),
                        nama_panggilan.getText().toString(), tempat_lahir.getText().toString(), tgl_lahir.getText().toString(), no_ktp.getText().toString(),
                        masa_berlaku_ktp.getText().toString(), alamat_sesuai_ktp.getText().toString(), nama_ibu_kandung.getText().toString(), kode_pos.getText().toString(),
                        pekerjaan_pemohon.getText().toString(), nama_perusahaan.getText().toString(), jabatan.getText().toString(), alamat_perusahaan.getText().toString(),
                        status_pernikahan.getText().toString(), jml_tanggungan.getText().toString(), pendidikan_terakhir.getText().toString(),
                        status_rumah_tinggal.getText().toString(), lama_tinggal.getText().toString(), alamat_rumah_tinggal.getText().toString(), no_telp.getText().toString(),
                        no_hp.getText().toString(), nama_pasangan.getText().toString(), tgl_lahir_pasangan.getText().toString(), no_ktp_pasangan.getText().toString(),
                        masa_berlaku_ktp_pasangan.getText().toString(), pekerjaan_pasangan.getText().toString(), tempat_lahir_pasangan.getText().toString(),
                        alamat_pasangan.getText().toString(), penghasilan_per_bln.getText().toString().replaceAll(",", ""), penjamin.getText().toString(), alamat_penjamin.getText().toString(),
                        tempat_lahir_penjamin.getText().toString(), tgl_lahir_penjamin.getText().toString(), no_ktp_penjamin.getText().toString(),
                        masa_berlaku_ktp_penjamin.getText().toString(), nama_pasangan_penjamin.getText().toString(), alamat_pasangan_penjamin.getText().toString(),
                        tempat_lahir_pasangan_penjamin.getText().toString(), tgl_lahir_pasangan_penjamin.getText().toString(),
                        no_ktp_pasangan_penjamin.getText().toString(), masa_berlaku_ktp_pasangan_penjamin.getText().toString(),

                        //Data Kredit
                        jenis_kredit.getText().toString(), sektor_ekonomi.getText().toString(), fasilitas_ke.getText().toString(),
                        plafond_kredit.getText().toString().replaceAll(",", ""), jkw.getText().toString(), bunga.getText().toString(), type_angsuran.getText().toString(),
                        periode_pembayaran_pokok.getText().toString(), jml_angsuran_per_bln.getText().toString().replaceAll(",", ""), angsuran_pokok_pertama.getText().toString().replaceAll(",", ""),
                        angsuran_bunga_pertama.getText().toString().replaceAll(",", ""), provisi.getText().toString().replaceAll(",", ""), administrasi.getText().toString().replaceAll(",", ""),
                        on_the_spot.getText().toString().replaceAll(",", ""), premi.getText().toString().replaceAll(",", ""), nama_asuransi.getText().toString(),
                        akad_kredit.getText().toString(), jenis_penggunaan.getText().toString(), tujuan_penggunaan.getText().toString(),
                        surveyor.getText().toString(),

                        pekerjaank.getText().toString(),alamat_usaha.getText().toString(),lama_usaha.getText().toString(),
                        uraian_kegiatan_usaha_utama.getText().toString(), uraian_kegiatan_usaha_lainnya.getText().toString(),
                        uraian_kegiatan_usaha_lainnya1.getText().toString(), uraian_kegiatan_usaha_sampingan.getText().toString(),
                        uraian_kegiatan_usaha_pasangan.getText().toString(), kondisi_fisik.getText().toString(),
                        kesimpulan.getText().toString(),

                        //Aspek Keuangan
                        kas.getText().toString().replaceAll(",", ""), piutang.getText().toString().replaceAll(",", ""),
                        persediaan.getText().toString().replaceAll(",", ""),
                        inventaris.getText().toString().replaceAll(",", ""), tanah_rumah.getText().toString().replaceAll(",", ""),
                        total_keuangan.getText().toString().replaceAll(",", ""), hutang_dagang.getText().toString().replaceAll(",", ""),
                        hutang_bank.getText().toString().replaceAll(",", ""), pinjaman.getText().toString().replaceAll(",", ""),
                        modal.getText().toString().replaceAll(",", ""), laba.getText().toString().replaceAll(",", "").replaceAll(",", ""),
                        total_pasiva.getText().toString().replaceAll(",", ""), pendapatan_usaha.getText().toString().replaceAll(",", ""),
                        biaya_usaha.getText().toString().replaceAll(",", ""), laba_usaha.getText().toString().replaceAll(",", ""),
                        pendapatan_lain.getText().toString().replaceAll(",", ""), total_pendapatan.getText().toString().replaceAll(",", ""),
                        biaya_rumah_tangga.getText().toString().replaceAll(",", ""), biaya_listrik.getText().toString().replaceAll(",", ""),
                        biaya_pendidikan.getText().toString().replaceAll(",", ""),  biaya_transportasi.getText().toString().replaceAll(",", ""),
                        biaya_sosial.getText().toString().replaceAll(",", ""), angsuran_bank1.getText().toString().replaceAll(",", ""),
                        angsuran_bank2.getText().toString().replaceAll(",", ""), angsuran_bank3.getText().toString().replaceAll(",", ""),
                        angsuran_bank4.getText().toString().replaceAll(",", ""), angsuran_bank5.getText().toString().replaceAll(",", ""),
                        angsuran_bank6.getText().toString().replaceAll(",", ""), biaya_lainnya.getText().toString().replaceAll(",", ""),
                        total_biaya.getText().toString().replaceAll(",", ""),

                        //Aspek Pemasaran
                        kelola_usaha.getText().toString(), persaingan_usaha.getText().toString(), pemasaran_usaha.getText().toString(),
                        amdal_usaha.getText().toString(), prospek_usaha.getText().toString(),

                        //Aspek Karakter
                        kondite_kredit_lalu.getText().toString(), referensi.getText().toString(),
                        info_lingkungan.getText().toString(), avalis_kredit.getText().toString(),
                        karakter_lainnya.getText().toString(),

                        //Aspek Hukum
                        dasar_hukum.getText().toString(), legalitas_identitas.getText().toString(),

                        //Analisa Kebutuhan
                        tujuan_modal.getText().toString().replaceAll(",", ""), tujuan_pelunasan.getText().toString().replaceAll(",", ""),
                        tujuan_pembelian.getText().toString().replaceAll(",", ""), tujuan_renovasi.getText().toString().replaceAll(",", ""),
                        tujuan_sekolah.getText().toString().replaceAll(",", ""), tujuan_lainnya.getText().toString().replaceAll(",", ""),
                        total_kebutuhan.getText().toString().replaceAll(",", ""), kebutuhan_bank.getText().toString().replaceAll(",", ""),

                        dana_angsuran.getText().toString(), jkw_x1.getText().toString().replaceAll(",", "")
                );
                update.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "Response");
                        Toast.makeText(MainActivity.this,response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        Intent godata = new Intent(MainActivity.this, TampilData.class);
                        startActivity(godata);
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "OnFailure");

                    }
                });

                Call<ResponsModel> updatee;
                updatee = api.updateDataa(iddata,  no_reg1.getText().toString(),nama_jaminan_shm1.getText().toString(),
                        jenis_jaminan_shm1.getText().toString(), atas_nama_shm1.getText().toString(), alamat_atas_nama_shm1.getText().toString(),
                        no_ktp_atas_nama_shm1.getText().toString(),
                        masa_berlaku_shm1.getText().toString(), ikatan_shm1.getText().toString(), nilai_ikatan_shm1.getText().toString(),
                        no_SHM1.getText().toString(), no_gs_shm1.getText().toString(), luas_shm1.getText().toString(),
                        lokasi_shm1.getText().toString(), asuransi_shm1.getText().toString(), nilai_tanah_shm1.getText().toString().replaceAll(",", ""),
                        nilai_bangunan_shm1.getText().toString().replaceAll(",", ""), total_taksiran_shm1.getText().toString().replaceAll(",", ""),

                        nama_jaminan_shm2.getText().toString(),
                        jenis_jaminan_shm2.getText().toString(), atas_nama_shm2.getText().toString(), alamat_atas_nama_shm2.getText().toString(),
                        no_ktp_atas_nama_shm2.getText().toString(),
                        masa_berlaku_shm2.getText().toString(), ikatan_shm2.getText().toString(), nilai_ikatan_shm2.getText().toString(),
                        no_SHM2.getText().toString(), no_gs_shm2.getText().toString(), luas_shm2.getText().toString(),
                        lokasi_shm2.getText().toString(), asuransi_shm2.getText().toString(), nilai_tanah_shm2.getText().toString().replaceAll(",", ""),
                        nilai_bangunan_shm2.getText().toString().replaceAll(",", ""), total_taksiran_shm2.getText().toString().replaceAll(",", ""),

                        nama_jaminan_shm3.getText().toString(),
                        jenis_jaminan_shm3.getText().toString(), atas_nama_shm3.getText().toString(), alamat_atas_nama_shm3.getText().toString(),
                        no_ktp_atas_nama_shm3.getText().toString(),
                        masa_berlaku_shm3.getText().toString(), ikatan_shm3.getText().toString(), nilai_ikatan_shm3.getText().toString(),
                        no_SHM3.getText().toString(), no_gs_shm3.getText().toString(), luas_shm3.getText().toString(),
                        lokasi_shm3.getText().toString(), asuransi_shm3.getText().toString(), nilai_tanah_shm3.getText().toString().replaceAll(",", ""),
                        nilai_bangunan_shm3.getText().toString().replaceAll(",", ""), total_taksiran_shm3.getText().toString().replaceAll(",", ""),

                        nama_jaminan_shm4.getText().toString(),
                        jenis_jaminan_shm4.getText().toString(), atas_nama_shm4.getText().toString(), alamat_atas_nama_shm4.getText().toString(),
                        no_ktp_atas_nama_shm4.getText().toString(),
                        masa_berlaku_shm4.getText().toString(), ikatan_shm4.getText().toString(), nilai_ikatan_shm4.getText().toString(),
                        no_SHM4.getText().toString(), no_gs_shm4.getText().toString(), luas_shm4.getText().toString(),
                        lokasi_shm4.getText().toString(), asuransi_shm4.getText().toString(), nilai_tanah_shm4.getText().toString().replaceAll(",", ""),
                        nilai_bangunan_shm4.getText().toString().replaceAll(",", ""), total_taksiran_shm4.getText().toString().replaceAll(",", ""),

                        nama_jaminan_shm5.getText().toString(),
                        jenis_jaminan_shm5.getText().toString(), atas_nama_shm5.getText().toString(), alamat_atas_nama_shm5.getText().toString(),
                        no_ktp_atas_nama_shm5.getText().toString(),
                        masa_berlaku_shm5.getText().toString(), ikatan_shm5.getText().toString(), nilai_ikatan_shm5.getText().toString(),
                        no_SHM5.getText().toString(), no_gs_shm5.getText().toString(), luas_shm5.getText().toString(),
                        lokasi_shm5.getText().toString(), asuransi_shm5.getText().toString(), nilai_tanah_shm5.getText().toString().replaceAll(",", ""),
                        nilai_bangunan_shm5.getText().toString().replaceAll(",", ""), total_taksiran_shm5.getText().toString().replaceAll(",", ""),

                        nama_jaminan_bpkb1.getText().toString(),
                        no_bpkb1.getText().toString(), merk_bpkb1.getText().toString(), tahun_bpkb1.getText().toString(),
                        no_rangka_bpkb1.getText().toString(), no_mesin_bpkb1.getText().toString(), warna_bpkb1.getText().toString(),
                        nopol_bpkb1.getText().toString(), atas_nama_bpkb1.getText().toString(), alamat_bpkb1.getText().toString(),
                        ikatan_bpkb1.getText().toString(), nilai_fiducia1.getText().toString().replaceAll(",", ""),
                        nilai_taksiran_bpkb1.getText().toString().replaceAll(",", ""),

                        nama_jaminan_bpkb2.getText().toString(),
                        no_bpkb2.getText().toString(), merk_bpkb2.getText().toString(), tahun_bpkb2.getText().toString(),
                        no_rangka_bpkb2.getText().toString(), no_mesin_bpkb2.getText().toString(), warna_bpkb2.getText().toString(),
                        nopol_bpkb2.getText().toString(), atas_nama_bpkb2.getText().toString(), alamat_bpkb2.getText().toString(),
                        ikatan_bpkb2.getText().toString(), nilai_fiducia2.getText().toString().replaceAll(",", ""),
                        nilai_taksiran_bpkb2.getText().toString().replaceAll(",", ""),

                        nama_jaminan_bpkb3.getText().toString(),
                        no_bpkb3.getText().toString(), merk_bpkb3.getText().toString(), tahun_bpkb3.getText().toString(),
                        no_rangka_bpkb3.getText().toString(), no_mesin_bpkb3.getText().toString(), warna_bpkb3.getText().toString(),
                        nopol_bpkb3.getText().toString(), atas_nama_bpkb3.getText().toString(), alamat_bpkb3.getText().toString(),
                        ikatan_bpkb3.getText().toString(), nilai_fiducia3.getText().toString().replaceAll(",", ""),
                        nilai_taksiran_bpkb3.getText().toString().replaceAll(",", ""),

                        nama_jaminan_bpkb4.getText().toString(),
                        no_bpkb4.getText().toString(), merk_bpkb4.getText().toString(), tahun_bpkb4.getText().toString(),
                        no_rangka_bpkb4.getText().toString(), no_mesin_bpkb4.getText().toString(), warna_bpkb4.getText().toString(),
                        nopol_bpkb4.getText().toString(), atas_nama_bpkb4.getText().toString(), alamat_bpkb4.getText().toString(),
                        ikatan_bpkb4.getText().toString(), nilai_fiducia4.getText().toString().replaceAll(",", ""),
                        nilai_taksiran_bpkb4.getText().toString().replaceAll(",", ""),

                        nama_jaminan_bpkb5.getText().toString(),
                        no_bpkb5.getText().toString(), merk_bpkb5.getText().toString(), tahun_bpkb5.getText().toString(),
                        no_rangka_bpkb5.getText().toString(), no_mesin_bpkb5.getText().toString(), warna_bpkb5.getText().toString(),
                        nopol_bpkb5.getText().toString(), atas_nama_bpkb5.getText().toString(), alamat_bpkb5.getText().toString(),
                        ikatan_bpkb5.getText().toString(), nilai_fiducia5.getText().toString().replaceAll(",", ""),
                        nilai_taksiran_bpkb5.getText().toString().replaceAll(",", ""),

                        nama_jaminand1.getText().toString(),
                        nama_deposito1.getText().toString(), no_bilyet1.getText().toString(), alamatd1.getText().toString(),
                        pengikat_jaminand1.getText().toString(), deposito1.getText().toString(), total_nilai_jaminan1.getText().toString().replaceAll(",", ""),
                        persen_dari_plafond1.getText().toString().replaceAll(",", ""),

                        nama_jaminand2.getText().toString(),
                        nama_deposito2.getText().toString(), no_bilyet2.getText().toString(), alamatd2.getText().toString(),
                        pengikat_jaminand2.getText().toString(), deposito2.getText().toString(), total_nilai_jaminan2.getText().toString().replaceAll(",", ""),
                        persen_dari_plafond2.getText().toString().replaceAll(",", ""),

                        nama_jaminand3.getText().toString(),
                        nama_deposito3.getText().toString(), no_bilyet3.getText().toString(), alamatd3.getText().toString(),
                        pengikat_jaminand3.getText().toString(), deposito3.getText().toString(), total_nilai_jaminan3.getText().toString().replaceAll(",", ""),
                        persen_dari_plafond3.getText().toString().replaceAll(",", "") );


                updatee.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "Response");
                        Toast.makeText(MainActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();

                        Intent godata = new Intent(MainActivity.this, TampilData.class);
                        startActivity(godata);
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "OnFailure");

                    }
                });

            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("send data ... ");
                pd.setCancelable(false);
                pd.show();

                String stgl_permohonan = tgl_permohonan.getText().toString();
                String sno_reg = no_reg.getText().toString();
                String snama_pemohon = nama_pemohon.getText().toString();
                String snama_panggilan = nama_panggilan.getText().toString();
                String stempat_lahir = tempat_lahir.getText().toString();
                String stgl_lahir = tgl_lahir.getText().toString();
                String sjenis_kelamin = jenis_kelamin.getText().toString();
                String sno_ktp = no_ktp.getText().toString();
                String smasa_berlaku_ktp = masa_berlaku_ktp.getText().toString();
                String salamat_sesuai_ktp = alamat_sesuai_ktp.getText().toString();
                String snama_ibu_kandung = nama_ibu_kandung.getText().toString();
                String skode_pos = kode_pos.getText().toString();
                String spekerjaan_pemohon = pekerjaan_pemohon.getText().toString();
                String snama_perusahaan = nama_perusahaan.getText().toString();
                String sjabatan = jabatan.getText().toString();
                String salamat_perusahaan = alamat_perusahaan.getText().toString();
                String sstatus_pernikahan = status_pernikahan.getText().toString();
                String sjml_tanggungan = jml_tanggungan.getText().toString();
                String spendidikan_terakhir = pendidikan_terakhir.getText().toString();
                String sstatus_rumah_tinggal = status_rumah_tinggal.getText().toString();
                String slama_tinggal = lama_tinggal.getText().toString();
                String salamat_rumah_tinggal = alamat_rumah_tinggal.getText().toString();
                String sno_telp = no_telp.getText().toString();
                String sno_hp = no_hp.getText().toString();
                String snama_pasangan = nama_pasangan.getText().toString();
                String stgl_lahir_pasangan = tgl_lahir_pasangan.getText().toString();
                String sno_ktp_pasangan = no_ktp_pasangan.getText().toString();
                String smasa_berlaku_ktp_pasangan = masa_berlaku_ktp_pasangan.getText().toString();
                String spekerjaan_pasangan = pekerjaan_pasangan.getText().toString();
                String stempat_lahir_pasangan = tempat_lahir_pasangan.getText().toString();
                String salamat_pasangan = alamat_pasangan.getText().toString();
                String spenghasilan_per_bln = penghasilan_per_bln.getText().toString().replaceAll(",", "");
                String spenjamin = penjamin.getText().toString();
                String salamat_penjamin = alamat_penjamin.getText().toString();
                String stempat_lahir_penjamin = tempat_lahir_penjamin.getText().toString();
                String stgl_lahir_penjamin = tgl_lahir_penjamin.getText().toString();
                String sno_ktp_penjamin = no_ktp_penjamin.getText().toString();
                String smasa_berlaku_ktp_penjamin = masa_berlaku_ktp_penjamin.getText().toString();
                String snama_pasangan_penjamin = nama_pasangan_penjamin.getText().toString();
                String salamat_pasangan_penjamin = alamat_pasangan_penjamin.getText().toString();
                String stempat_lahir_pasangan_penjamin = tempat_lahir_pasangan_penjamin.getText().toString();
                String stgl_lahir_pasangan_penjamin = tgl_lahir_pasangan_penjamin.getText().toString();
                String sno_ktp_pasangan_penjamin = no_ktp_pasangan_penjamin.getText().toString();
                String smasa_berlaku_ktp_pasangan_penjamin = masa_berlaku_ktp_pasangan_penjamin.getText().toString();

                //Data Kredit
                String sjenis_kredit = jenis_kredit.getText().toString();
                String ssektor = sektor_ekonomi.getText().toString();
                String sfasilitas_kredit_ke = fasilitas_ke.getText().toString();
                String splafond_kredit = plafond_kredit.getText().toString().replaceAll(",", "");
                String sjangka_waktu = jkw.getText().toString().replaceAll(",", "");
                String sbunga = bunga.getText().toString().replaceAll(",", ".");
                String stype_bunga = type_angsuran.getText().toString();
                String speriode_pembayaran_pokok = periode_pembayaran_pokok.getText().toString().replaceAll(",", "");
                String sjumlah_angsuran_perbulan = jml_angsuran_per_bln.getText().toString().replaceAll(",", "");

                String sangsuran_pokok_pertama = angsuran_pokok_pertama.getText().toString().replaceAll(",", "");
                String sangsuran_bunga_pertama = angsuran_bunga_pertama.getText().toString().replaceAll(",", "");
                String sprovisi = provisi.getText().toString().replaceAll(",", "");
                String sadministrasi = administrasi.getText().toString().replaceAll(",", "");
                String son_the_spot = on_the_spot.getText().toString().replaceAll(",", "");
                String spremi = premi.getText().toString().replaceAll(",", "");
                String sasuransi = nama_asuransi.getText().toString();
                String sakad_kredit = akad_kredit.getText().toString();
                String sjenis_penggunaan = jenis_penggunaan.getText().toString();
                String spenggunaan = tujuan_penggunaan.getText().toString();
                String ssuveyor = surveyor.getText().toString();

                //Aspek Kapasitas
                String spekerjaank = pekerjaank.getText().toString();
                String salamat_usaha = alamat_usaha.getText().toString();
                String slama_usaha = lama_usaha.getText().toString();
                String suraian_kegiatan_usaha_utama = uraian_kegiatan_usaha_utama.getText().toString();
                String suraian_kegiatan_usaha_lainnya = uraian_kegiatan_usaha_lainnya.getText().toString();
                String suraian_kegiatan_usaha_lainnya1 = uraian_kegiatan_usaha_lainnya1.getText().toString();
                String suraian_kegiatan_usaha_sampingan = uraian_kegiatan_usaha_sampingan.getText().toString();
                String suraian_kegiatan_usaha_pasangan = uraian_kegiatan_usaha_pasangan.getText().toString();
                String skondisi_fisik = kondisi_fisik.getText().toString();
                String skesimpulan = kesimpulan.getText().toString();

                //Aspek Keuangan
                String skas = kas.getText().toString().replaceAll(",", "");
                String spiutang = piutang.getText().toString().replaceAll(",", "");
                String spersediaan = persediaan.getText().toString().replaceAll(",", "");
                String sinventaris = inventaris.getText().toString().replaceAll(",", "");
                String stanah_rumah = tanah_rumah.getText().toString().replaceAll(",", "");
                String stotal_keuangan = total_keuangan.getText().toString().replaceAll(",", "");

                String shutang_dagang = hutang_dagang.getText().toString().replaceAll(",", "");
                String shutang_bank = hutang_bank.getText().toString().replaceAll(",", "");
                String spinjaman = pinjaman.getText().toString().replaceAll(",", "");
                String smodal = modal.getText().toString().replaceAll(",", "");
                String slaba = laba.getText().toString().replaceAll(",", "");
                String stotal_pasiva = total_pasiva.getText().toString().replaceAll(",", "");

                String spendapatan_usaha = pendapatan_usaha.getText().toString().replaceAll(",", "");
                String sbiaya_usaha = biaya_usaha.getText().toString().replaceAll(",", "");
                String slaba_usaha = laba_usaha.getText().toString().replaceAll(",", "");
                String spendapatan_lain = pendapatan_lain.getText().toString().replaceAll(",", "");
                String stotal_pendapatan = total_pendapatan.getText().toString().replaceAll(",", "");

                String sbiaya_rumah = biaya_rumah_tangga.getText().toString().replaceAll(",", "");
                String sbiaya_listrik = biaya_listrik.getText().toString().replaceAll(",", "");
                String sbiaya_pendidikan = biaya_pendidikan.getText().toString().replaceAll(",", "");
                String sbiaya_transportasi = biaya_transportasi.getText().toString().replaceAll(",", "");
                String sbiaya_sosial = biaya_sosial.getText().toString().replaceAll(",", "");

                String sangsuran_bank1 = angsuran_bank1.getText().toString().replaceAll(",", "");
                String sangsuran_bank2 = angsuran_bank2.getText().toString().replaceAll(",", "");
                String sangsuran_bank3 = angsuran_bank3.getText().toString().replaceAll(",", "");
                String sangsuran_bank4 = angsuran_bank4.getText().toString().replaceAll(",", "");
                String sangsuran_bank5 = angsuran_bank5.getText().toString().replaceAll(",", "");
                String sangsuran_bank6 = angsuran_bank6.getText().toString().replaceAll(",", "");
                String sbiaya_lainnya = biaya_lainnya.getText().toString().replaceAll(",", "");
                String stotal_biaya = total_biaya.getText().toString().replaceAll(",", "");

                //Aspek Pemasaran
                String skelola_usaha = kelola_usaha.getText().toString();
                String spersaingan_usaha = persaingan_usaha.getText().toString();
                String spemasaran_usaha = pemasaran_usaha.getText().toString();
                String samdal_usaha = amdal_usaha.getText().toString();
                String sprospek_usaha = prospek_usaha.getText().toString();

                //Aspek Karakter
                String skondite = kondite_kredit_lalu.getText().toString();
                String sreferensi = referensi.getText().toString();
                String sinfo_lingkungan = info_lingkungan.getText().toString();
                String savalis_kredit = avalis_kredit.getText().toString();
                String skarakter = karakter_lainnya.getText().toString();

                //Aspek Hukum
                String sdasar_hukum = dasar_hukum.getText().toString();
                String slegalitas = legalitas_identitas.getText().toString();

                //Analisa Kebutuhan
                String stujuan_modal = tujuan_modal.getText().toString().replaceAll(",", "");
                String stujuan_pelunasan = tujuan_pelunasan.getText().toString().replaceAll(",", "");
                String stujuan_pembelian = tujuan_pembelian.getText().toString().replaceAll(",", "");
                String stujuan_renovasi = tujuan_renovasi.getText().toString().replaceAll(",", "");
                String stujuan_sekolah = tujuan_sekolah.getText().toString().replaceAll(",", "");
                String stujuan_lainnya = tujuan_lainnya.getText().toString().replaceAll(",", "");
                String stotal_kebutuhan = total_kebutuhan.getText().toString().replaceAll(",", "");
                String skebutuhan_bank = kebutuhan_bank.getText().toString().replaceAll(",", "");
                String sdana_angsuran = dana_angsuran.getText().toString();
                String sjkw_x1 = jkw_x1.getText().toString().replaceAll(",", "");

                {

                }

                {
                    ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);

                    Call<ResponsModel> sendbio = api.sendBiodata(stgl_permohonan, sno_reg, snama_pemohon, snama_panggilan, stempat_lahir,
                            stgl_lahir, sjenis_kelamin, sno_ktp, smasa_berlaku_ktp, salamat_sesuai_ktp, snama_ibu_kandung, skode_pos, spekerjaan_pemohon,
                            snama_perusahaan, sjabatan, salamat_perusahaan, sstatus_pernikahan, sjml_tanggungan, spendidikan_terakhir, sstatus_rumah_tinggal,
                            slama_tinggal, salamat_rumah_tinggal, sno_telp, sno_hp, snama_pasangan,
                            stgl_lahir_pasangan, sno_ktp_pasangan, smasa_berlaku_ktp_pasangan, spekerjaan_pasangan, stempat_lahir_pasangan, salamat_pasangan,
                            spenghasilan_per_bln, spenjamin, salamat_penjamin, stempat_lahir_penjamin, stgl_lahir_penjamin, sno_ktp_penjamin, smasa_berlaku_ktp_penjamin,
                            snama_pasangan_penjamin, salamat_pasangan_penjamin, stempat_lahir_pasangan_penjamin,
                            stgl_lahir_pasangan_penjamin, sno_ktp_pasangan_penjamin, smasa_berlaku_ktp_pasangan_penjamin,

                            //Data Kredit
                            sjenis_kredit, ssektor, sfasilitas_kredit_ke, splafond_kredit, sjangka_waktu, sbunga, stype_bunga, speriode_pembayaran_pokok,
                            sjumlah_angsuran_perbulan, sangsuran_pokok_pertama, sangsuran_bunga_pertama, sprovisi, sadministrasi, son_the_spot, spremi,
                            sasuransi, sakad_kredit, sjenis_penggunaan, spenggunaan, ssuveyor,

                            //Aspek Kapasitas
                            spekerjaank, salamat_usaha, slama_usaha, suraian_kegiatan_usaha_utama, suraian_kegiatan_usaha_lainnya, suraian_kegiatan_usaha_lainnya1,
                            suraian_kegiatan_usaha_sampingan,  suraian_kegiatan_usaha_pasangan, skondisi_fisik, skesimpulan,

                            //Aspek Keuangan
                            skas, spiutang, spersediaan, sinventaris, stanah_rumah, stotal_keuangan, shutang_dagang, shutang_bank,spinjaman,
                            smodal, slaba, stotal_pasiva, spendapatan_usaha, sbiaya_usaha, slaba_usaha, spendapatan_lain, stotal_pendapatan, sbiaya_rumah, sbiaya_listrik, sbiaya_pendidikan,
                            sbiaya_transportasi, sbiaya_sosial, sangsuran_bank1, sangsuran_bank2, sangsuran_bank3, sangsuran_bank4, sangsuran_bank5, sangsuran_bank6, sbiaya_lainnya,
                            stotal_biaya,

                            //Aspek Pemasaran
                            skelola_usaha, spersaingan_usaha, spemasaran_usaha, samdal_usaha, sprospek_usaha,
                            skondite, sreferensi, sinfo_lingkungan, savalis_kredit, skarakter,
                            sdasar_hukum, slegalitas,

                            stujuan_modal, stujuan_pelunasan, stujuan_pembelian, stujuan_renovasi, stujuan_sekolah, stujuan_lainnya,
                            stotal_kebutuhan, skebutuhan_bank, sdana_angsuran, sjkw_x1
                    );

                    sendbio.enqueue(new Callback<ResponsModel>() {
                        @Override
                        public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                            pd.hide();
                            Log.d("RETRO", "response : " + response.body().toString());
                            String kode = response.body().getKode();

                            if (kode.equals("1")) {
                                Toast.makeText(MainActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                                Intent godata = new Intent(MainActivity.this, TampilData.class);
                                startActivity(godata);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<ResponsModel> call, Throwable t) {
                            pd.hide();
                            Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                        }
                    });

                    //Aspek Jaminan
                    String sno_reg1 = no_reg1.getText().toString();
                    String snama_jaminan = nama_jaminan_shm1.getText().toString();
                    String sjenis_jaminan = jenis_jaminan_shm1.getText().toString();
                    String satas_nama_jaminan = atas_nama_shm1.getText().toString();

                    String salamat_sesuai_ktp1 = alamat_atas_nama_shm1.getText().toString();
                    String sno_ktp1 = no_ktp_atas_nama_shm1.getText().toString();
                    String sberlaku_hingga1 = masa_berlaku_shm1.getText().toString();

                    String spengikat_jaminan = ikatan_shm1.getText().toString();
                    String shak_tanggungan = nilai_ikatan_shm1.getText().toString().replaceAll(",", "");
                    String sno_SHM1 = no_SHM1.getText().toString();
                    String sno_GS = no_gs_shm1.getText().toString();
                    String sluas = luas_shm1.getText().toString();
                    String slokasi = lokasi_shm1.getText().toString();
                    String sasuransii = asuransi_shm1.getText().toString();
                    String stanah = nilai_tanah_shm1.getText().toString().replaceAll(",", "");
                    String sbangunan = nilai_bangunan_shm1.getText().toString().replaceAll(",", "");
                    String stotal_taksiran = total_taksiran_shm1.getText().toString().replaceAll(",", "");


                    //Aspek Jaminan 2
                    String snama_jaminan1 = nama_jaminan_shm2.getText().toString();
                    String sjenis_jaminan1 = jenis_jaminan_shm2.getText().toString();
                    String satas_nama_jaminan1 = atas_nama_shm2.getText().toString();

                    String salamat_sesuai_ktp2 = alamat_atas_nama_shm2.getText().toString();
                    String sno_ktp2 = no_ktp_atas_nama_shm2.getText().toString();
                    String sberlaku_hingga2 = masa_berlaku_shm2.getText().toString();

                    String spengikat_jaminan1 = ikatan_shm2.getText().toString();
                    String shak_tanggungan1 = nilai_ikatan_shm2.getText().toString().replaceAll(",", "");
                    String sno_SHM2 = no_SHM2.getText().toString();
                    String sno_GS1 = no_gs_shm2.getText().toString();
                    String sluas1 = luas_shm2.getText().toString();
                    String slokasi1 = lokasi_shm2.getText().toString();
                    String sasuransi1 = asuransi_shm2.getText().toString();
                    String stanah1 = nilai_tanah_shm2.getText().toString().replaceAll(",", "");
                    String sbangunan1 = nilai_bangunan_shm2.getText().toString().replaceAll(",", "");
                    String stotal_taksiran1 = total_taksiran_shm2.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan 3
                    String snama_jaminan2 = nama_jaminan_shm3.getText().toString();
                    String sjenis_jaminan2 = jenis_jaminan_shm3.getText().toString();
                    String satas_nama_jaminan2 = atas_nama_shm3.getText().toString();

                    String salamat_sesuai_ktp3 = alamat_atas_nama_shm3.getText().toString();
                    String sno_ktp3 = no_ktp_atas_nama_shm3.getText().toString();
                    String sberlaku_hingga3 = masa_berlaku_shm3.getText().toString();

                    String spengikat_jaminan2 = ikatan_shm3.getText().toString();
                    String shak_tanggungan2 = nilai_ikatan_shm3.getText().toString().replaceAll(",", "");
                    String sno_SHM3 = no_SHM3.getText().toString();
                    String sno_GS2 = no_gs_shm3.getText().toString();
                    String sluas2 = luas_shm3.getText().toString();
                    String slokasi2 = lokasi_shm3.getText().toString();
                    String sasuransi2 = asuransi_shm3.getText().toString();
                    String stanah2 = nilai_tanah_shm3.getText().toString().replaceAll(",", "");
                    String sbangunan2 = nilai_bangunan_shm3.getText().toString().replaceAll(",", "");
                    String stotal_taksiran2 = total_taksiran_shm3.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan 4
                    String snama_jaminan3 = nama_jaminan_shm4.getText().toString();
                    String sjenis_jaminan3 = jenis_jaminan_shm4.getText().toString();
                    String satas_nama_jaminan3 = atas_nama_shm4.getText().toString();

                    String salamat_sesuai_ktp4 = alamat_atas_nama_shm4.getText().toString();
                    String sno_ktp4 = no_ktp_atas_nama_shm4.getText().toString();
                    String sberlaku_hingga4 = masa_berlaku_shm4.getText().toString();

                    String spengikat_jaminan3 = ikatan_shm4.getText().toString();
                    String shak_tanggungan3 = nilai_ikatan_shm4.getText().toString().replaceAll(",", "");
                    String sno_SHM4 = no_SHM4.getText().toString();
                    String sno_GS3 = no_gs_shm4.getText().toString();
                    String sluas3 = luas_shm4.getText().toString();
                    String slokasi3 = lokasi_shm4.getText().toString();
                    String sasuransi3 = asuransi_shm4.getText().toString();
                    String stanah3 = nilai_tanah_shm4.getText().toString().replaceAll(",", "");
                    String sbangunan3 = nilai_bangunan_shm4.getText().toString().replaceAll(",", "");
                    String stotal_taksiran3 = total_taksiran_shm4.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan 5
                    String snama_jaminan4 = nama_jaminan_shm5.getText().toString();
                    String sjenis_jaminan4 = jenis_jaminan_shm5.getText().toString();
                    String satas_nama_jaminan4 = atas_nama_shm5.getText().toString();

                    String salamat_sesuai_ktp5 = alamat_atas_nama_shm5.getText().toString();
                    String sno_ktp5 = no_ktp_atas_nama_shm5.getText().toString();
                    String sberlaku_hingga5 = masa_berlaku_shm5.getText().toString();

                    String spengikat_jaminan4 = ikatan_shm5.getText().toString();
                    String shak_tanggungan4 = nilai_ikatan_shm5.getText().toString().replaceAll(",", "");
                    String sno_SHM5 = no_SHM5.getText().toString();
                    String sno_GS4 = no_gs_shm5.getText().toString();
                    String sluas4 = luas_shm5.getText().toString();
                    String slokasi4 = lokasi_shm5.getText().toString();
                    String sasuransi4 = asuransi_shm5.getText().toString();
                    String stanah4 = nilai_tanah_shm5.getText().toString().replaceAll(",", "");
                    String sbangunan4 = nilai_bangunan_shm5.getText().toString().replaceAll(",", "");
                    String stotal_taksiran4 = total_taksiran_shm5.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan BPKB 1
                    String snama_jaminanb1 = nama_jaminan_bpkb1.getText().toString();
                    String sno_bpkb1 = no_bpkb1.getText().toString();
                    String smerk1 = merk_bpkb1.getText().toString();

                    String stahun1 = tahun_bpkb1.getText().toString();
                    String sno_rangka1 = no_rangka_bpkb1.getText().toString();
                    String sno_mesin1 = no_mesin_bpkb1.getText().toString();

                    String swarna1 = warna_bpkb1.getText().toString();
                    String sno_polisi1 = nopol_bpkb1.getText().toString();
                    String satas_nama_bpkb1 = atas_nama_bpkb1.getText().toString();
                    String salamat1 = alamat_bpkb1.getText().toString();
                    String spengikat_jaminanb1 = ikatan_bpkb1.getText().toString();
                    String snilai_fiducia1 = nilai_fiducia1.getText().toString().replaceAll(",", "");
                    String staksiran_harga_motor1 = nilai_taksiran_bpkb1.getText().toString().replaceAll(",", "");


                    //Aspek Jaminan BPKB 2
                    String snama_jaminanb2 = nama_jaminan_bpkb2.getText().toString();
                    String sno_bpkb2 = no_bpkb2.getText().toString();
                    String smerk2 = merk_bpkb2.getText().toString();

                    String stahun2 = tahun_bpkb2.getText().toString();
                    String sno_rangka2 = no_rangka_bpkb2.getText().toString();
                    String sno_mesin2 = no_mesin_bpkb2.getText().toString();

                    String swarna2 = warna_bpkb2.getText().toString();
                    String sno_polisi2 = nopol_bpkb2.getText().toString();
                    String satas_nama_bpkb2 = atas_nama_bpkb2.getText().toString();
                    String salamat2 = alamat_bpkb2.getText().toString();
                    String spengikat_jaminanb2 = ikatan_bpkb2.getText().toString();
                    String snilai_fiducia2 = nilai_fiducia2.getText().toString().replaceAll(",", "");
                    String staksiran_harga_motor2 = nilai_taksiran_bpkb2.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan BPKB 3
                    String snama_jaminanb3 = nama_jaminan_bpkb3.getText().toString();
                    String sno_bpkb3 = no_bpkb3.getText().toString();
                    String smerk3 = merk_bpkb3.getText().toString();

                    String stahun3 = tahun_bpkb3.getText().toString();
                    String sno_rangka3 = no_rangka_bpkb3.getText().toString();
                    String sno_mesin3 = no_mesin_bpkb3.getText().toString();

                    String swarna3 = warna_bpkb3.getText().toString();
                    String sno_polisi3 = nopol_bpkb3.getText().toString();
                    String satas_nama_bpkb3 = atas_nama_bpkb3.getText().toString();
                    String salamat3 = alamat_bpkb3.getText().toString();
                    String spengikat_jaminanb3 = ikatan_bpkb3.getText().toString();
                    String snilai_fiducia3 = nilai_fiducia3.getText().toString().replaceAll(",", "");
                    String staksiran_harga_motor3 = nilai_taksiran_bpkb3.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan BPKB 4
                    String snama_jaminanb4 = nama_jaminan_bpkb4.getText().toString();
                    String sno_bpkb4 = no_bpkb4.getText().toString();
                    String smerk4 = merk_bpkb4.getText().toString();

                    String stahun4 = tahun_bpkb4.getText().toString();
                    String sno_rangka4 = no_rangka_bpkb4.getText().toString();
                    String sno_mesin4 = no_mesin_bpkb4.getText().toString();

                    String swarna4 = warna_bpkb4.getText().toString();
                    String sno_polisi4 = nopol_bpkb4.getText().toString();
                    String satas_nama_bpkb4 = atas_nama_bpkb4.getText().toString();
                    String salamat4 = alamat_bpkb4.getText().toString();
                    String spengikat_jaminanb4 = ikatan_bpkb4.getText().toString();
                    String snilai_fiducia4 = nilai_fiducia4.getText().toString().replaceAll(",", "");
                    String staksiran_harga_motor4 = nilai_taksiran_bpkb4.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan BPKB 5
                    String snama_jaminanb5 = nama_jaminan_bpkb5.getText().toString();
                    String sno_bpkb5 = no_bpkb5.getText().toString();
                    String smerk5 = merk_bpkb5.getText().toString();

                    String stahun5 = tahun_bpkb5.getText().toString();
                    String sno_rangka5 = no_rangka_bpkb5.getText().toString();
                    String sno_mesin5 = no_mesin_bpkb5.getText().toString();

                    String swarna5 = warna_bpkb5.getText().toString();
                    String sno_polisi5 = nopol_bpkb5.getText().toString();
                    String satas_nama_bpkb5 = atas_nama_bpkb5.getText().toString();
                    String salamat5 = alamat_bpkb5.getText().toString();
                    String spengikat_jaminanb5 = ikatan_bpkb5.getText().toString();
                    String snilai_fiducia5 = nilai_fiducia5.getText().toString().replaceAll(",", "");
                    String staksiran_harga_motor5 = nilai_taksiran_bpkb5.getText().toString().replaceAll(",", "");

                    //Aspek Jaminan bilyet deposito 1
                    String snama_jaminand1 = nama_jaminand1.getText().toString();
                    String snama_deposito1 = nama_deposito1.getText().toString();
                    String sno_bilyet1 = no_bilyet1.getText().toString();
                    String salamatd1 = alamatd1.getText().toString();
                    String spengikat_jaminand1 = pengikat_jaminand1.getText().toString();
                    String sdeposito1 = deposito1.getText().toString().replaceAll(",", "");
                    String stotal_nilai_jaminan1 = total_nilai_jaminan1.getText().toString().replaceAll(",", "");
                    String spersen_dari_plafond1 = persen_dari_plafond1.getText().toString();

                    //Aspek Jaminan bilyet deposito 2
                    String snama_jaminand2 = nama_jaminand2.getText().toString();
                    String snama_deposito2 = nama_deposito2.getText().toString();
                    String sno_bilyet2 = no_bilyet2.getText().toString();
                    String salamatd2 = alamatd2.getText().toString();
                    String spengikat_jaminand2 = pengikat_jaminand2.getText().toString();
                    String sdeposito2 = deposito2.getText().toString().replaceAll(",", "");
                    String stotal_nilai_jaminan2 = total_nilai_jaminan2.getText().toString().replaceAll(",", "");
                    String spersen_dari_plafond2 = persen_dari_plafond2.getText().toString();

                    //Aspek Jaminan bilyet deposito 3
                    String snama_jaminand3 = nama_jaminand3.getText().toString();
                    String snama_deposito3 = nama_deposito3.getText().toString();
                    String sno_bilyet3 = no_bilyet3.getText().toString();
                    String salamatd3 = alamatd3.getText().toString();
                    String spengikat_jaminand3 = pengikat_jaminand3.getText().toString();
                    String sdeposito3 = deposito3.getText().toString().replaceAll(",", "");
                    String stotal_nilai_jaminan3 = total_nilai_jaminan3.getText().toString().replaceAll(",", "");
                    String spersen_dari_plafond3 = persen_dari_plafond3.getText().toString();

                    {

                        Call<ResponsModel> sendbioo = api.sendBiodataa(sno_reg1, snama_jaminan, sjenis_jaminan, satas_nama_jaminan,
                                salamat_sesuai_ktp1, sno_ktp1, sberlaku_hingga1, spengikat_jaminan,
                                shak_tanggungan, sno_SHM1, sno_GS, sluas, slokasi, sasuransii, stanah, sbangunan, stotal_taksiran,

                                snama_jaminan1, sjenis_jaminan1, satas_nama_jaminan1, salamat_sesuai_ktp2, sno_ktp2, sberlaku_hingga2, spengikat_jaminan1,
                                shak_tanggungan1, sno_SHM2, sno_GS1, sluas1, slokasi1, sasuransi1, stanah1, sbangunan1, stotal_taksiran1,

                                snama_jaminan2, sjenis_jaminan2, satas_nama_jaminan2, salamat_sesuai_ktp3, sno_ktp3, sberlaku_hingga3, spengikat_jaminan2,
                                shak_tanggungan2, sno_SHM3, sno_GS2, sluas2, slokasi2, sasuransi2, stanah2, sbangunan2, stotal_taksiran2,

                                snama_jaminan3, sjenis_jaminan3, satas_nama_jaminan3, salamat_sesuai_ktp4, sno_ktp4, sberlaku_hingga4, spengikat_jaminan3,
                                shak_tanggungan3, sno_SHM4, sno_GS3, sluas3, slokasi3, sasuransi3, stanah3, sbangunan3, stotal_taksiran3,

                                snama_jaminan4, sjenis_jaminan4, satas_nama_jaminan4, salamat_sesuai_ktp5, sno_ktp5, sberlaku_hingga5, spengikat_jaminan4,
                                shak_tanggungan4, sno_SHM5, sno_GS4, sluas4, slokasi4, sasuransi4, stanah4, sbangunan4, stotal_taksiran4,

                                // Aspek Jaminan BPKB
                                snama_jaminanb1, sno_bpkb1, smerk1, stahun1, sno_rangka1, sno_mesin1, swarna1,
                                sno_polisi1, satas_nama_bpkb1, salamat1, spengikat_jaminanb1, snilai_fiducia1, staksiran_harga_motor1,

                                snama_jaminanb2, sno_bpkb2, smerk2, stahun2, sno_rangka2, sno_mesin2, swarna2,
                                sno_polisi2, satas_nama_bpkb2, salamat2, spengikat_jaminanb2, snilai_fiducia2, staksiran_harga_motor2,

                                snama_jaminanb3, sno_bpkb3, smerk3, stahun3, sno_rangka3, sno_mesin3, swarna3,
                                sno_polisi3, satas_nama_bpkb3, salamat3, spengikat_jaminanb3, snilai_fiducia3, staksiran_harga_motor3,

                                snama_jaminanb4, sno_bpkb4, smerk4, stahun4, sno_rangka4, sno_mesin4, swarna4,
                                sno_polisi4, satas_nama_bpkb4, salamat4, spengikat_jaminanb4, snilai_fiducia4, staksiran_harga_motor4,

                                snama_jaminanb5, sno_bpkb5, smerk5, stahun5, sno_rangka5, sno_mesin5, swarna5,
                                sno_polisi5, satas_nama_bpkb5, salamat5, spengikat_jaminanb5, snilai_fiducia5, staksiran_harga_motor5,

                                //Bilyet Deposito
                                snama_jaminand1, snama_deposito1, sno_bilyet1, salamatd1, spengikat_jaminand1, sdeposito1, stotal_nilai_jaminan1,
                                spersen_dari_plafond1,

                                snama_jaminand2, snama_deposito2, sno_bilyet2, salamatd2, spengikat_jaminand2, sdeposito2, stotal_nilai_jaminan2,
                                spersen_dari_plafond2,

                                snama_jaminand3, snama_deposito3, sno_bilyet3, salamatd3, spengikat_jaminand3, sdeposito3, stotal_nilai_jaminan3,
                                spersen_dari_plafond3);

                        sendbioo.enqueue(new Callback<ResponsModel>() {
                            @Override
                            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
/*
                        pd.setVisibility(View.GONE);
*/
                                Log.d("RETRO", "response : " + Objects.requireNonNull(response.body()).toString());
                                String kode = response.body().getKode();

                                if (kode.equals("1")) {
                                    Toast.makeText(MainActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, TampilData.class));

                                } else {
                                    Toast.makeText(MainActivity.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                                }

                            }

                            @Override
                            public void onFailure( Call<ResponsModel> call, Throwable t) {
/*
                        pd.setVisibility(View.GONE);
*/
                                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                            }
                        });
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            if(requestCode == REQUEST_GALLERY)
            {
                Uri dataimage = data.getData();
                String[] imageprojection = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(dataimage,imageprojection,null,null,null);

                if (cursor != null)
                {
                    cursor.moveToFirst();
                    int indexImage = cursor.getColumnIndex(imageprojection[0]);
                    part_image = cursor.getString(indexImage);

                    if(part_image != null)
                    {
                        File image = new File(part_image);
                        imgHolder.setImageBitmap(BitmapFactory.decodeFile(image.getAbsolutePath()));
                    }
                }
            }
        }
    }


    private void setDateTimeField() {
        tgl_permohonan.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog = new DatePickerDialog(Objects.requireNonNull(this), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newtgl_permohonan = Calendar.getInstance();
                newtgl_permohonan.set(year, monthOfYear, dayOfMonth);
                tgl_permohonan.setText(dateFormatter.format(newtgl_permohonan.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void setDateTimeField1() {
        tgl_lahir.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog1 = new DatePickerDialog(Objects.requireNonNull(this), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newtgl_lahir = Calendar.getInstance();
                newtgl_lahir.set(year, month, dayOfMonth);
                tgl_lahir.setText(dateFormatter1.format(newtgl_lahir.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void setDateTimeField2() {
        tgl_lahir_pasangan.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog2 = new DatePickerDialog(Objects.requireNonNull(this), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newtgl_lahir = Calendar.getInstance();
                newtgl_lahir.set(year, month, dayOfMonth);
                tgl_lahir_pasangan.setText(dateFormatter2.format(newtgl_lahir.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void setDateTimeField3() {
        tgl_lahir_penjamin.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog3 = new DatePickerDialog(Objects.requireNonNull(this), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newtgl_lahir = Calendar.getInstance();
                newtgl_lahir.set(year, month, dayOfMonth);
                tgl_lahir_penjamin.setText(dateFormatter3.format(newtgl_lahir.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void setDateTimeField4() {
        tgl_lahir_pasangan_penjamin.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog4 = new DatePickerDialog(Objects.requireNonNull(this), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newtgl_lahir = Calendar.getInstance();
                newtgl_lahir.set(year, month, dayOfMonth);
                tgl_lahir_pasangan_penjamin.setText(dateFormatter4.format(newtgl_lahir.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }



    @Override
    public void onClick(View view) {

        //DATA PERMOHONAN
        if (view == tgl_permohonan) {
            fromDatePickerDialog.show();
        }
        if (view == tgl_lahir) {
            fromDatePickerDialog1.show();
        }
        if (view == jenis_kelamin) {
            final CharSequence[] items = {
                    "LAKI-LAKI", "PEREMPUAN"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this));
            builder.setTitle("JENIS KELAMIN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    jenis_kelamin.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == pekerjaan_pemohon) {
            final CharSequence[] items = {
                    "Pelajar/Mahasiswa", "Peg Negeri", "Ibu Rumah Tangga", "Karyawan/Peg Swasta", "Pegawai Negeri Sipil", "TNI/Polri",
                    "Pejabat Negara", "Pensiun", "Pengusaha Pabrikan", "Pengusaha Jasa", "Pedagang", "Dokter", "Pengacara", "Akuntan",
                    "Wartawan", "Seniman", "Notaris", "Profesional Lainnya", "Wiraswasta", "Honorer", "Buruh", "Lainnya"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this));
            builder.setTitle("PEKERJAAN PEMOHON");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    pekerjaan_pemohon.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == status_pernikahan) {
            final CharSequence[] items = {
                    "MENIKAH", "LAJANG", "JANDA", "DUDA"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this));
            builder.setTitle("STATUS PERNIKAHAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    status_pernikahan.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if (view == pendidikan_terakhir) {
            final CharSequence[] items = {
                    "SD", "SLTP", "SMU/SMK", "D1", "D3", "S1"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this));
            builder.setTitle("PENDIDIKAN TERAKHIR");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    pendidikan_terakhir.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if (view == status_rumah_tinggal) {
            final CharSequence[] items = {
                    "MILIK SENDIRI", "MILIK ORANG TUA", "KONTRAK", "MILIK SAUDARA", "LAINNYA"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this));
            builder.setTitle("STATUS RUMAH TINGGAL");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    status_rumah_tinggal.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        if (view == tgl_lahir_pasangan) {
            fromDatePickerDialog2.show();
        }

        if (view == pekerjaan_pasangan) {
            final CharSequence[] items = {
                    "Pelajar/Mahasiswa", "Peg Negeri", "Ibu Rumah Tangga", "Karyawan/Peg Swasta", "Pegawai Negeri Sipil", "TNI/Polri",
                    "Pejabat Negara", "Pensiun", "Pengusaha Pabrikan", "Pengusaha Jasa", "Pedagang", "Dokter", "Pengacara", "Akuntan",
                    "Wartawan", "Seniman", "Notaris", "Profesional Lainnya", "Wiraswasta", "Honorer", "Buruh", "Lainnya"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(this));
            builder.setTitle("PEKERJAAN PASANGAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    pekerjaan_pasangan.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == tgl_lahir_penjamin) {
            fromDatePickerDialog3.show();

        }
        if (view == tgl_lahir_pasangan_penjamin) {
            fromDatePickerDialog4.show();
        }

        //DATA KREDIT
        if (view == jenis_kredit) {
            final CharSequence[] items = {
                    "Multiguna", "Karyawan", "Investasi", "Modal Kerja", "Konsumtif"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("jenis_kredit");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    jenis_kredit.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }

        if (view == sektor_ekonomi) {
            final CharSequence[] items = {
                    "Pertanian, Perburuan dan Kehutanan", "Perikanan", "Pertambangan dan Penggalian", "Industri Pengolahan", "Listrik, Gas dan Air",
                    "Konstruksi", "Perdagangan Besar dan Eceran", "Penyediaan Akomodasi dan Penyediaan Makan Minum", "Transportasi, Pergudangan dan Komunikasi",
                    "Perantara Keuangan", "Real Estate", "Administrasi Pemerintahan, Pertanahan dan Jaminan Sosial Wajib", "Jasa Pendidikan", "Jasa Kesehatan dan Kegiatan Sosial",
                    "Jasa Kemasyarakatan, Sosial Budaya, Hiburan dan Perorangan Lainnya", "Jasa Perorangan yang Melayani Rumah Tangga", "Kegiatan Usaha yang Belum Jelas Batasannya",
                    "Bukan Lapangan Usaha - Rumah Tangga", "Bukan Lapangan Usaha - Lainnya"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("sektor");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    sektor_ekonomi.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == bunga) {
            final CharSequence[] items = {
                    "1,84", "1,88", "1,2", "1,25", "1,3", "1,50", "1,4", "1,45", "1,5", "1,75", "1,67", "2"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("bunga");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    bunga.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == type_angsuran) {
            final CharSequence[] items = {
                    "FLAT", "MENURUN", "MUSIMAN", "EFEKTIF"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("type_bunga");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    type_angsuran.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == periode_pembayaran_pokok) {
            final CharSequence[] items = {
                    "1 ", "3 ", "6 ", "12 "
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("periode_pembayaran_pokok");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    periode_pembayaran_pokok.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }

        if (view == nama_asuransi) {
            final CharSequence[] items = {
                    "Jamkrida Jateng Wan Prestasi", "Jamkrida Jateng Jiwa Menurun", "MaiBRO"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Asuransi");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    nama_asuransi.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        if (view == jenis_penggunaan) {
            final CharSequence[] items = {
                    "Modal Kerja", "Investasi", "Konsumsi", "Lainnya"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("jenis_penggunaan");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    jenis_penggunaan.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if (view == surveyor) {
            final CharSequence[] items = {
                    "Rizkie Dyca Rachmatdianto,S.IKom", "Teddy Irawan Cahyadi", "Anggid Ridianto, ST", "Azis Widodo, S.Si", "M. Arsyad"
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("surveyor");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    surveyor.setText(items[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        //Aspek Jaminan 1
        if (view == ikatan_shm1) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_shm1.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == asuransi_shm1) {
            final CharSequence[] items = {
                    "YA", "TIDAK"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("ASURANSI");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    asuransi_shm1.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        //Aspek Jaminan 2

        if (view == ikatan_shm2) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_shm2.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == asuransi_shm2) {
            final CharSequence[] items = {
                    "YA", "TIDAK"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("ASURANSI");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    asuransi_shm2.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        //Aspek Jaminan 3

        if (view == ikatan_shm3) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_shm3.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == asuransi_shm3) {
            final CharSequence[] items = {
                    "YA", "TIDAK"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("ASURANSI");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    asuransi_shm3.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan 4

        if (view == ikatan_shm4) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_shm4.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == asuransi_shm4) {
            final CharSequence[] items = {
                    "YA", "TIDAK"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("ASURANSI");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    asuransi_shm4.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan 5

        if (view == ikatan_shm5) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_shm5.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }
        if (view == asuransi_shm5) {
            final CharSequence[] items = {
                    "YA", "TIDAK"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("ASURANSI");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    asuransi_shm5.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan BPKB 1

        if (view == ikatan_bpkb1) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_bpkb1.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan BPKB 2

        if (view == ikatan_bpkb2) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_bpkb2.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan BPKB 3

        if (view == ikatan_bpkb3) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_bpkb3.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan BPKB 4

        if (view == ikatan_bpkb4) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_bpkb4.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        //Aspek Jaminan BPKB 5

        if (view == ikatan_bpkb5) {
            final CharSequence[] items = {
                    "APHT", "Notaris SKMHT", "Kuasa Fiducia", "Fiducia Terdaftar", "Dibawah Tangan", "Tanpa Ikatan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("PENGIKAT JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    ikatan_bpkb5.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        if (view == jenis_jaminan_shm1) {
            final CharSequence[] items = {
                    "Sertifikat Hak Milik", "Sertifikat Hak Guna Bangunan"
            };

            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("JENIS JAMINAN");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    // Do something with the selection
                    jenis_jaminan_shm1.setText(items[item]);
                }
            });
            android.app.AlertDialog alert = builder.create();
            alert.show();

        }

        if (view.getId() == R.id.expandableButton1) {
            expandableLayout1.toggle();
            expandableLayout2.collapse();


        }
        if (view.getId() == R.id.expandableButton2) {
            expandableLayout2.toggle();
            expandableLayout1.collapse();

        }

        if (view.getId() == R.id.expandableButton3) {
            expandableLayout3.toggle();

        }
        if (view.getId() == R.id.expandableButton3111) {
            expandableLayout3111.toggle();
            expandableLayout31.collapse();
            expandableLayout32.collapse();
            expandableLayout33.collapse();
            expandableLayout34.collapse();
            expandableLayout35.collapse();
        }


        if (view.getId() == R.id.expandableButton31) {
            expandableLayout31.toggle();
            expandableLayout32.collapse();
            expandableLayout33.collapse();
            expandableLayout34.collapse();
            expandableLayout35.collapse();

        }
        if (view.getId() == R.id.expandableButton32) {
            expandableLayout32.toggle();
            expandableLayout31.collapse();
            expandableLayout33.collapse();
            expandableLayout34.collapse();
            expandableLayout35.collapse();

        }
        if (view.getId() == R.id.expandableButton33) {
            expandableLayout33.toggle();
            expandableLayout31.collapse();
            expandableLayout32.collapse();
            expandableLayout34.collapse();
            expandableLayout35.collapse();

        }
        if (view.getId() == R.id.expandableButton34) {
            expandableLayout34.toggle();
            expandableLayout31.collapse();
            expandableLayout33.collapse();
            expandableLayout33.collapse();
            expandableLayout35.collapse();

        }
        if (view.getId() == R.id.expandableButton35) {
            expandableLayout35.toggle();
            expandableLayout31.collapse();
            expandableLayout32.collapse();
            expandableLayout33.collapse();
            expandableLayout34.collapse();

        }
        if (view.getId() == R.id.expandableButton4) {
            expandableLayout4.toggle();
            expandableLayout41.collapse();

        }
        if (view.getId() == R.id.expandableButton41) {
            expandableLayout41.toggle();
            expandableLayout42.collapse();
            expandableLayout43.collapse();
            expandableLayout44.collapse();
            expandableLayout45.collapse();
        }
        if (view.getId() == R.id.expandableButton42) {
            expandableLayout42.toggle();
            expandableLayout41.collapse();
            expandableLayout43.collapse();
            expandableLayout44.collapse();
            expandableLayout45.collapse();
        }
        if (view.getId() == R.id.expandableButton43) {
            expandableLayout43.toggle();
            expandableLayout41.collapse();
            expandableLayout42.collapse();
            expandableLayout44.collapse();
            expandableLayout45.collapse();
        }
        if (view.getId() == R.id.expandableButton44) {
            expandableLayout44.toggle();
            expandableLayout41.collapse();
            expandableLayout42.collapse();
            expandableLayout43.collapse();
            expandableLayout45.collapse();

        }
        if (view.getId() == R.id.expandableButton45) {
            expandableLayout45.toggle();
            expandableLayout41.collapse();
            expandableLayout42.collapse();
            expandableLayout43.collapse();
            expandableLayout44.collapse();
        }
        if (view.getId() == R.id.expandableButton5) {
            expandableLayout5.toggle();
            expandableLayout51.collapse();
            expandableLayout52.collapse();
            expandableLayout53.collapse();

        }
        if (view.getId() == R.id.expandableButton51) {
            expandableLayout51.toggle();
            expandableLayout52.collapse();
            expandableLayout53.collapse();

        }
        if (view.getId() == R.id.expandableButton52) {
            expandableLayout52.toggle();
            expandableLayout51.collapse();
            expandableLayout53.collapse();

        }
        if (view.getId() == R.id.expandableButton53) {
            expandableLayout53.toggle();
            expandableLayout51.collapse();
            expandableLayout52.collapse();
        }
        if (view.getId() == R.id.expandableButton6) {
            expandableLayout6.toggle();
            expandableLayout5.collapse();

        }
        if (view.getId() == R.id.expandableButton7) {
            expandableLayout7.toggle();
            expandableLayout6.collapse();
        }
        if (view.getId() == R.id.expandableButton8) {
            expandableLayout8.toggle();
            expandableLayout7.collapse();
        }

        if (view.getId() == R.id.expandableButton9) {
            expandableLayout9.toggle();
            expandableLayout8.collapse();
        }
        if (view.getId() == R.id.expandableButton10) {
            expandableLayout10.toggle();
            expandableLayout9.collapse();
        }

        if (view.getId() == R.id.expandableButton11) {
            expandableLayout11.toggle();
            expandableLayout10.collapse();
        }

        if (view.getId() == R.id.expandableButton12) {
            expandableLayout12.toggle();
            expandableLayout11.collapse();
        }


        if (view.getId() == R.id.expandableButton1121) {
            expandableLayout1121.toggle();
        }

    }

    private final android.text.TextWatcher TextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        @Override
        public void afterTextChanged(Editable s) {



            no_reg.removeTextChangedListener(this);
            no_reg1.removeTextChangedListener(this);
            try {

                sno_regg= no_reg.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            no_reg1.setText(sno_regg);

            no_reg.addTextChangedListener(this);
            no_reg1.addTextChangedListener(this);

            jkw.removeTextChangedListener(this);
            jkw2.removeTextChangedListener(this);
            try {

                sjkww= jkw.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            jkw2.setText(sjkww);

            jkw.addTextChangedListener(this);
            jkw2.addTextChangedListener(this);

            angsuran_bunga_pertama.removeTextChangedListener(this);
            angsuran_bunga_pertama2.removeTextChangedListener(this);
            try {

                sangsuran_bunga= angsuran_bunga_pertama.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            angsuran_bunga_pertama2.setText(sangsuran_bunga);

            angsuran_bunga_pertama.addTextChangedListener(this);
            angsuran_bunga_pertama2.addTextChangedListener(this);


            laba.removeTextChangedListener(this);

            try {

                String originalString25 = laba.getText().toString();

                Long longval;
                if (originalString25.contains(",")) {
                    originalString25 = originalString25.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString25);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");


                String formattedString = formatter7.format(longval);

                //setting text after format to EditText
                laba.setText(formattedString);
                laba.setSelection(laba.getText().length());

                laba2.setText(formattedString);



            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            laba.addTextChangedListener(this);


            tujuan_penggunaan.removeTextChangedListener(this);
            tujuan_penggunaan1.removeTextChangedListener(this);
            try {

                spenggunaan= tujuan_penggunaan.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            tujuan_penggunaan1.setText(spenggunaan);

            tujuan_penggunaan.addTextChangedListener(this);
            tujuan_penggunaan1.addTextChangedListener(this);


            nama_asuransi.removeTextChangedListener(this);
            asuransiii.removeTextChangedListener(this);
            try {

                snama_asuransi= nama_asuransi.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            asuransiii.setText(snama_asuransi);

            nama_asuransi.addTextChangedListener(this);
            asuransiii.addTextChangedListener(this);

            akad_kredit.removeTextChangedListener(this);
            akad_kredit1.removeTextChangedListener(this);
            try {

                sakad_kredit1 = akad_kredit.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            akad_kredit1.setText(sakad_kredit1);

            akad_kredit.addTextChangedListener(this);
            akad_kredit1.addTextChangedListener(this);

            masa_berlaku_ktp.removeTextChangedListener(this);
            masa_berlaku_KID.removeTextChangedListener(this);
            try {

                smasa_berlaku1 = masa_berlaku_ktp.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            masa_berlaku_KID.setText(smasa_berlaku1);

            masa_berlaku_ktp.addTextChangedListener(this);
            masa_berlaku_KID.addTextChangedListener(this);

            no_ktp.removeTextChangedListener(this);
            nomor_KID.removeTextChangedListener(this);
            try {

                sno_ktp1 = no_ktp.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            nomor_KID.setText(sno_ktp1);

            no_ktp.addTextChangedListener(this);
            nomor_KID.addTextChangedListener(this);



            fasilitas_ke.removeTextChangedListener(this);
            fasilitas_kredit_ke1.removeTextChangedListener(this);
            try {

                sfasilitas = fasilitas_ke.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            fasilitas_kredit_ke1.setText(sfasilitas);

            fasilitas_ke.addTextChangedListener(this);
            fasilitas_kredit_ke1.addTextChangedListener(this);


            nama_perusahaan.removeTextChangedListener(this);
            nama_perusahaan1.removeTextChangedListener(this);
            try {

                snama = nama_perusahaan.getText().toString();


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }
            nama_perusahaan1.setText(snama);

            nama_perusahaan.addTextChangedListener(this);
            nama_perusahaan1.addTextChangedListener(this);


            plafond_kredit.removeTextChangedListener(this);


            try {

                String originalString = plafond_kredit.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                //setting text after format to EditText
                plafond_kredit.setText(formattedString);
                plafond_kredit.setSelection(plafond_kredit.getText().length());

                plafond_kredit1.setText(formattedString);
                plafond_kredit2.setText(formattedString);



            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            plafond_kredit.addTextChangedListener(this);



            provisi.removeTextChangedListener(this);

            try {
                String originalString = provisi.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,#");


                String formattedString = formatter.format(longval);

                provisi.setText(formattedString);
                provisi.setSelection(provisi.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            provisi.addTextChangedListener(this);

            penghasilan_per_bln.removeTextChangedListener(this);

            try {
                String originalString = penghasilan_per_bln.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                penghasilan_per_bln.setText(formattedString);
                penghasilan_per_bln.setSelection(penghasilan_per_bln.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            penghasilan_per_bln.addTextChangedListener(this);

            premi.removeTextChangedListener(this);

            try {
                String originalString = premi.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                premi.setText(formattedString);
                premi.setSelection(premi.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            premi.addTextChangedListener(this);

            nilai_taksiran_bpkb1.removeTextChangedListener(this);

            try {
                String originalString = nilai_taksiran_bpkb1.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                nilai_taksiran_bpkb1.setText(formattedString);
                nilai_taksiran_bpkb1.setSelection(nilai_taksiran_bpkb1.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            nilai_taksiran_bpkb1.addTextChangedListener(this);

            nilai_taksiran_bpkb2.removeTextChangedListener(this);

            try {
                String originalString = nilai_taksiran_bpkb2.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                nilai_taksiran_bpkb2.setText(formattedString);
                nilai_taksiran_bpkb2.setSelection(nilai_taksiran_bpkb2.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            nilai_taksiran_bpkb2.addTextChangedListener(this);

            nilai_taksiran_bpkb3.removeTextChangedListener(this);

            try {
                String originalString = nilai_taksiran_bpkb3.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                nilai_taksiran_bpkb3.setText(formattedString);
                nilai_taksiran_bpkb3.setSelection(nilai_taksiran_bpkb3.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            nilai_taksiran_bpkb3.addTextChangedListener(this);

            nilai_taksiran_bpkb4.removeTextChangedListener(this);

            try {
                String originalString = nilai_taksiran_bpkb4.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                nilai_taksiran_bpkb4.setText(formattedString);
                nilai_taksiran_bpkb4.setSelection(nilai_taksiran_bpkb4.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            nilai_taksiran_bpkb4.addTextChangedListener(this);

            nilai_taksiran_bpkb5.removeTextChangedListener(this);

            try {
                String originalString = nilai_taksiran_bpkb5.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");


                String formattedString = formatter.format(longval);

                nilai_taksiran_bpkb5.setText(formattedString);
                nilai_taksiran_bpkb5.setSelection(nilai_taksiran_bpkb5.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            nilai_taksiran_bpkb5.addTextChangedListener(this);


            administrasi.removeTextChangedListener(this);

            try {
                String originalString = administrasi.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,##");


                String formattedString = formatter.format(longval);
                administrasi.setText(formattedString);
                administrasi.setSelection(administrasi.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            administrasi.addTextChangedListener(this);


         /*   premi.removeTextChangedListener(this);
            plafond_kredit.removeTextChangedListener(this);
            jkw.removeTextChangedListener(this);
            nama_asuransi.removeTextChangedListener(this);


            if (nama_asuransi.getText().toString().equals("Jamkrida Jateng Jiwa Menurun")){

                try {
                    String originalString = premi.getText().toString();

                    Long longval;
                    if (originalString.contains(",")) {
                        originalString = originalString.replaceAll(",", "");
                    }
                    longval = Long.parseLong(originalString);
                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                    formatter.applyPattern("#,###,###,###");


                    String formattedString = formatter.format(longval);

                    premi.setText(formattedString);
                    premi.setSelection(premi.getText().length());


                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

                String originalString = plafond_kredit.getText().toString();

            Long longval;
            if (originalString.contains(",")) {
                originalString = originalString.replaceAll(",", "");
            }
            longval = Long.parseLong(originalString);
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter.applyPattern("#,###,###,###");
            String formattedString = formatter.format(longval);

            //setting text after format to EditText
            plafond_kredit.setText(formattedString);
            plafond_kredit.setSelection(plafond_kredit.getText().length());

            String jangka = jkw.getText().toString();


            jangka = jangka.replaceAll(",", ".");

            Plafond_kredit = Double.parseDouble(originalString);
            Jangka_waktu = Double.parseDouble(jangka);

                int mpremi = (int) Math.round((Jangka_waktu / 12)-Plafond_kredit * 254/10000);
                spokok = formatter.format(mpremi);

                premi.setText((spokok));

        }
            plafond_kredit.addTextChangedListener(this);
            jkw.addTextChangedListener(this);
            nama_asuransi.addTextChangedListener(this);
            premi.addTextChangedListener(this);

          */


            plafond_kredit.removeTextChangedListener(this);
            jkw.removeTextChangedListener(this);
            bunga.removeTextChangedListener(this);
            periode_pembayaran_pokok.removeTextChangedListener(this);
            angsuran_pokok_pertama.removeTextChangedListener(this);
            angsuran_bunga_pertama.removeTextChangedListener(this);
            jml_angsuran_per_bln.removeTextChangedListener(this);
            type_angsuran.removeTextChangedListener(this);

            if (type_angsuran.getText().toString().equals("FLAT")) {


                sumPokok = 0.00;
                int sumAngsuran = 0;

                String originalString = plafond_kredit.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String formattedString = formatter.format(longval);

                //setting text after format to EditText
                plafond_kredit.setText(formattedString);
                plafond_kredit.setSelection(plafond_kredit.getText().length());

                String jangka = jkw.getText().toString();

                String suku_bunga = bunga.getText().toString();


                suku_bunga = suku_bunga.replaceAll(",", ".");
                jangka = jangka.replaceAll(",", ".");


                Bunga = Double.parseDouble(suku_bunga);
                Plafond_kredit = Double.parseDouble(originalString);
                Jangka_waktu = Double.parseDouble(jangka);

                for (int i = 0; i < Jangka_waktu; i++) {

                    int mpokok = (int) Math.round(Plafond_kredit / Jangka_waktu);
                    spokok = formatter.format(mpokok);
                    pokok = spokok;

                    sumPokok = (sumPokok + mpokok);

                    int mbunga = (int) Math.round((Plafond_kredit * Bunga) / 100);
                    sbunga = formatter.format(mbunga);
                    ibunga = sbunga;

                    sumAngsuran = (mpokok + mbunga);
                    sangsuran = formatter.format(sumAngsuran);
                    iangsuran = sangsuran;

                    angsuran_pokok_pertama.setText((spokok));

                    angsuran_bunga_pertama.setText((sbunga));

                    jml_angsuran_per_bln.setText((sangsuran));
                }
            } else if (type_angsuran.getText().toString().equals("MENURUN")) {


                sumPokok = 0.00;
                int sumAngsuran = 0;

                String originalString = plafond_kredit.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String formattedString = formatter.format(longval);

                //setting text after format to EditText
                plafond_kredit.setText(formattedString);
                plafond_kredit.setSelection(plafond_kredit.getText().length());

                String jangka = jkw.getText().toString();

                String suku_bunga = bunga.getText().toString();


                suku_bunga = suku_bunga.replaceAll(",", ".");
                jangka = jangka.replaceAll(",", ".");


                Bunga = Double.parseDouble(suku_bunga);
                Plafond_kredit = Double.parseDouble(originalString);
                Jangka_waktu = Double.parseDouble(jangka);


                for (int i = 0; i < Jangka_waktu; i++) {

                    int mpokok = (int) Math.round(Plafond_kredit / Jangka_waktu);
                    spokok = formatter.format(mpokok);
                    pokok = spokok;

                    sumPokok = (sumPokok + mpokok);

                    int mbunga = (int) Math.round((Plafond_kredit * Bunga) / 100);
                    sbunga = formatter.format(mbunga);
                    ibunga = sbunga;

                    sumAngsuran = (mpokok + mbunga);
                    sangsuran = formatter.format(sumAngsuran);
                    iangsuran = sangsuran;

                    angsuran_pokok_pertama.setText((spokok));

                    angsuran_bunga_pertama.setText((sbunga));

                    jml_angsuran_per_bln.setText((sangsuran));
                }
            } else if (type_angsuran.getText().toString().equals("MUSIMAN")) {


                sumPokok = 0.00;
                int sumAngsuran = 0;

                String originalString = plafond_kredit.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String formattedString = formatter.format(longval);

                //setting text after format to EditText
                plafond_kredit.setText(formattedString);
                plafond_kredit.setSelection(plafond_kredit.getText().length());

                String jangka = jkw.getText().toString();
                String suku_bunga = bunga.getText().toString();
                String periode = periode_pembayaran_pokok.getText().toString();


                jangka = jangka.replace(",", ".");
                suku_bunga = suku_bunga.replace(",", ".");
                periode = periode.replace(",", "");

                Bunga = Double.parseDouble(suku_bunga);
                Plafond_kredit = Double.parseDouble(originalString);
                Jangka_waktu = Double.parseDouble(jangka);
                Periode_pembayaran = Double.parseDouble(periode);

                for (int i = 0; i < Jangka_waktu; i++) {

                    int mpokok = (int) Math.round((Plafond_kredit / Jangka_waktu) * Periode_pembayaran);
                    spokok = formatter.format(mpokok);
                    pokok = spokok;

                    int mbunga = (int) Math.round((Plafond_kredit - sumPokok) * Bunga / 100);
                    sbunga = formatter.format(mbunga);
                    ibunga = sbunga;

                    sumAngsuran = (mpokok + mbunga);
                    sangsuran = formatter.format(sumAngsuran);
                    iangsuran = sangsuran;

                    angsuran_pokok_pertama.setText((spokok));

                    angsuran_bunga_pertama.setText((sbunga));

                    jml_angsuran_per_bln.setText((sangsuran));

                }

            } else if (type_angsuran.getText().toString().equals("EFEKTIF")) {


                sumPokok = 0.00;

                String originalString = plafond_kredit.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String formattedString = formatter.format(longval);

                //setting text after format to EditText
                plafond_kredit.setText(formattedString);
                plafond_kredit.setSelection(plafond_kredit.getText().length());

                String jangka = jkw.getText().toString();
                String suku_bunga = bunga.getText().toString();


                jangka = jangka.replace(",", ".");
                suku_bunga = suku_bunga.replace(",", ".");

                Bunga = Double.parseDouble(suku_bunga);
                Plafond_kredit = Double.parseDouble(originalString);
                Jangka_waktu = Double.parseDouble(jangka);

                double x = Math.pow(1 + Bunga / 100, Jangka_waktu);
                double y = Math.pow(1 + Bunga / 100, Jangka_waktu) - 1;
                int sumAngsuran = (int) Math.round(Bunga / 100 * Plafond_kredit * x / y);

                for (int i = 0; i < Jangka_waktu; i++) {

                    sangsuran = formatter.format(sumAngsuran);
                    iangsuran = sangsuran;

                    int mbunga = (int) Math.round((Plafond_kredit * Bunga) / 100);
                    sbunga = formatter.format(mbunga);
                    ibunga = sbunga;

                    int mpokok = Math.round(sumAngsuran - mbunga);
                    spokok = formatter.format(mpokok);
                    pokok = spokok;

                    sumPokok = (sumPokok + mpokok);

                    angsuran_pokok_pertama.setText((spokok));

                    angsuran_bunga_pertama.setText((sbunga));

                    jml_angsuran_per_bln.setText((sangsuran));
                }
            }

            plafond_kredit.addTextChangedListener(this);
            jkw.addTextChangedListener(this);
            bunga.addTextChangedListener(this);
            type_angsuran.addTextChangedListener(this);
            angsuran_pokok_pertama.addTextChangedListener(this);
            periode_pembayaran_pokok.addTextChangedListener(this);
            angsuran_bunga_pertama.addTextChangedListener(this);
            jml_angsuran_per_bln.addTextChangedListener(this);


            // Jaminan 1
            nilai_tanah_shm1.removeTextChangedListener(this);
            nilai_bangunan_shm1.removeTextChangedListener(this);
            total_taksiran_shm1.removeTextChangedListener(this);

            sbangunan = nilai_bangunan_shm1.getText().toString();


            try {
                String originalString = nilai_tanah_shm1.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String formattedString = formatter.format(longval);
                nilai_tanah_shm1.setText(formattedString);
                nilai_tanah_shm1.setSelection(nilai_tanah_shm1.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString1 = nilai_bangunan_shm1.getText().toString();

                Long longval;
                if (originalString1.contains(",")) {
                    originalString1 = originalString1.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString1);
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String formattedString = formatter.format(longval);
                nilai_bangunan_shm1.setText(formattedString);
                nilai_bangunan_shm1.setSelection(nilai_bangunan_shm1.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }


            try {
                DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter.applyPattern("#,###,###,###");
                String originalString = nilai_tanah_shm1.getText().toString();
                String originalString1 = nilai_bangunan_shm1.getText().toString();

                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }

                if (originalString1.contains(",")) {
                    originalString1 = originalString1.replaceAll(",", "");
                }

                dtanah = Long.parseLong(originalString);
                dbangunan = Long.parseLong(originalString1);

                dtotal = Math.round(dtanah + dbangunan);


            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter.applyPattern("#,###,###,###");

            stotal = String.valueOf(formatter.format(dtotal));

            total_taksiran_shm1.setText(stotal);


            nilai_tanah_shm1.addTextChangedListener(this);
            nilai_bangunan_shm1.addTextChangedListener(this);
            total_taksiran_shm1.addTextChangedListener(this);


            // Jaminan 2
            nilai_tanah_shm2.removeTextChangedListener(this);
            nilai_bangunan_shm2.removeTextChangedListener(this);
            total_taksiran_shm2.removeTextChangedListener(this);

            sbangunan1 = nilai_bangunan_shm2.getText().toString().replaceAll(",", "");

            try {
                String originalString11 = nilai_tanah_shm2.getText().toString();

                Long longval;
                if (originalString11.contains(",")) {
                    originalString11 = originalString11.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString11);
                DecimalFormat formatter1 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter1.applyPattern("#,###,###,###");
                String formattedString = formatter1.format(longval);
                nilai_tanah_shm2.setText(formattedString);
                nilai_tanah_shm2.setSelection(nilai_tanah_shm2.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString21 = nilai_bangunan_shm2.getText().toString();

                Long longval;
                if (originalString21.contains(",")) {
                    originalString21 = originalString21.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString21);
                DecimalFormat formatter1 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter1.applyPattern("#,###,###,###");
                String formattedString = formatter1.format(longval);
                nilai_bangunan_shm2.setText(formattedString);
                nilai_bangunan_shm2.setSelection(nilai_bangunan_shm2.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter1 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter1.applyPattern("#,###,###,###");
                String originalString11 = nilai_tanah_shm2.getText().toString();
                String originalString21 = nilai_bangunan_shm2.getText().toString();
                if (originalString11.contains(",")) {
                    originalString11 = originalString11.replaceAll(",", "");
                }
                if (originalString21.contains(",")) {
                    originalString21 = originalString21.replaceAll(",", "");
                }

                dtanah1 = Long.parseLong(originalString11);
                dbangunan1 = Long.parseLong(originalString21);

                dtotal1 = Math.round(dtanah1 + dbangunan1);

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter1 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter1.applyPattern("#,###,###,###");

            stotal1 = String.valueOf(formatter.format(dtotal1));
            total_taksiran_shm2.setText(stotal1);


            nilai_tanah_shm2.addTextChangedListener(this);
            nilai_bangunan_shm2.addTextChangedListener(this);
            total_taksiran_shm2.addTextChangedListener(this);

            // Jaminan 3
            nilai_tanah_shm3.removeTextChangedListener(this);
            nilai_bangunan_shm3.removeTextChangedListener(this);
            total_taksiran_shm3.removeTextChangedListener(this);

            sbangunan2 = nilai_bangunan_shm3.getText().toString().replaceAll(",", "");

            try {
                String originalString12 = nilai_tanah_shm3.getText().toString();

                Long longval;
                if (originalString12.contains(",")) {
                    originalString12 = originalString12.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString12);
                DecimalFormat formatter2 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter2.applyPattern("#,###,###,###");
                String formattedString = formatter2.format(longval);
                nilai_tanah_shm3.setText(formattedString);
                nilai_tanah_shm3.setSelection(nilai_tanah_shm3.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString22 = nilai_bangunan_shm3.getText().toString();

                Long longval;
                if (originalString22.contains(",")) {
                    originalString22 = originalString22.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString22);
                DecimalFormat formatter2 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter2.applyPattern("#,###,###,###");
                String formattedString = formatter2.format(longval);
                nilai_bangunan_shm3.setText(formattedString);
                nilai_bangunan_shm3.setSelection(nilai_bangunan_shm3.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter2 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter2.applyPattern("#,###,###,###");
                String originalString12 = nilai_tanah_shm3.getText().toString();
                String originalString22 = nilai_bangunan_shm3.getText().toString();
                if (originalString12.contains(",")) {
                    originalString12 = originalString12.replaceAll(",", "");
                }
                if (originalString22.contains(",")) {
                    originalString22 = originalString22.replaceAll(",", "");
                }

                dtanah2 = Long.parseLong(originalString12);
                dbangunan2 = Long.parseLong(originalString22);

                dtotal2 = Math.round(dtanah2 + dbangunan2);

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter2 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter2.applyPattern("#,###,###,###");

            stotal2 = String.valueOf(formatter.format(dtotal2));
            total_taksiran_shm3.setText(stotal2);


            nilai_tanah_shm3.addTextChangedListener(this);
            nilai_bangunan_shm3.addTextChangedListener(this);
            total_taksiran_shm3.addTextChangedListener(this);

            // Jaminan 4
            nilai_tanah_shm4.removeTextChangedListener(this);
            nilai_bangunan_shm4.removeTextChangedListener(this);
            total_taksiran_shm4.removeTextChangedListener(this);

            sbangunan3 = nilai_bangunan_shm4.getText().toString().replaceAll(",", "");

            try {
                String originalString13 = nilai_tanah_shm4.getText().toString();

                Long longval;
                if (originalString13.contains(",")) {
                    originalString13 = originalString13.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString13);
                DecimalFormat formatter3 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter3.applyPattern("#,###,###,###");
                String formattedString = formatter3.format(longval);
                nilai_tanah_shm4.setText(formattedString);
                nilai_tanah_shm4.setSelection(nilai_tanah_shm4.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString23 = nilai_bangunan_shm4.getText().toString();

                Long longval;
                if (originalString23.contains(",")) {
                    originalString23 = originalString23.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString23);
                DecimalFormat formatter3 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter3.applyPattern("#,###,###,###");
                String formattedString = formatter2.format(longval);
                nilai_bangunan_shm4.setText(formattedString);
                nilai_bangunan_shm4.setSelection(nilai_bangunan_shm4.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter3 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter3.applyPattern("#,###,###,###");
                String originalString13 = nilai_tanah_shm4.getText().toString();
                String originalString23 = nilai_bangunan_shm4.getText().toString();
                if (originalString13.contains(",")) {
                    originalString13 = originalString13.replaceAll(",", "");
                }
                if (originalString23.contains(",")) {
                    originalString23 = originalString23.replaceAll(",", "");
                }

                dtanah3 = Long.parseLong(originalString13);
                dbangunan3 = Long.parseLong(originalString23);

                dtotal3 = Math.round(dtanah3 + dbangunan3);

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter3 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter3.applyPattern("#,###,###,###");

            stotal3 = String.valueOf(formatter3.format(dtotal3));
            total_taksiran_shm4.setText(stotal3);


            nilai_tanah_shm4.addTextChangedListener(this);
            nilai_bangunan_shm4.addTextChangedListener(this);
            total_taksiran_shm4.addTextChangedListener(this);


            // Jaminan 5
            nilai_tanah_shm5.removeTextChangedListener(this);
            nilai_bangunan_shm5.removeTextChangedListener(this);
            total_taksiran_shm5.removeTextChangedListener(this);

            sbangunan4 = nilai_bangunan_shm5.getText().toString().replaceAll(",", "");

            try {
                String originalString14 = nilai_tanah_shm5.getText().toString();

                Long longval;
                if (originalString14.contains(",")) {
                    originalString14 = originalString14.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString14);
                DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter4.applyPattern("#,###,###,###");
                String formattedString = formatter4.format(longval);
                nilai_tanah_shm5.setText(formattedString);
                nilai_tanah_shm5.setSelection(nilai_tanah_shm5.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString24 = nilai_bangunan_shm5.getText().toString();

                Long longval;
                if (originalString24.contains(",")) {
                    originalString24 = originalString24.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString24);
                DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter4.applyPattern("#,###,###,###");
                String formattedString = formatter4.format(longval);
                nilai_bangunan_shm5.setText(formattedString);
                nilai_bangunan_shm5.setSelection(nilai_bangunan_shm5.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter4.applyPattern("#,###,###,###");
                String originalString14 = nilai_tanah_shm5.getText().toString();
                String originalString24 = nilai_bangunan_shm5.getText().toString();
                if (originalString14.contains(",")) {
                    originalString14 = originalString14.replaceAll(",", "");
                }
                if (originalString24.contains(",")) {
                    originalString24 = originalString24.replaceAll(",", "");
                }

                dtanah4 = Long.parseLong(originalString14);
                dbangunan4 = Long.parseLong(originalString24);

                dtotal4 = Math.round(dtanah4 + dbangunan4);

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter4 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter4.applyPattern("#,###,###,###");

            stotal4 = String.valueOf(formatter.format(dtotal4));
            total_taksiran_shm5.setText(stotal4);

            nilai_tanah_shm5.addTextChangedListener(this);
            nilai_bangunan_shm5.addTextChangedListener(this);
            total_taksiran_shm5.addTextChangedListener(this);


            //bilyet Deposito

            total_taksiran_shm1.removeTextChangedListener(this);
            total_taksiran_shm2.removeTextChangedListener(this);
            total_taksiran_shm3.removeTextChangedListener(this);
            total_taksiran_shm4.removeTextChangedListener(this);
            total_taksiran_shm5.removeTextChangedListener(this);

            no_SHM1.removeTextChangedListener(this);
            no_SHM2.removeTextChangedListener(this);
            no_SHM3.removeTextChangedListener(this);
            no_SHM4.removeTextChangedListener(this);
            no_SHM5.removeTextChangedListener(this);

            total_nilai_jaminan1.removeTextChangedListener(this);
            persen_dari_plafond1.removeTextChangedListener(this);

            try {
                DecimalFormat formatter5 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter5.applyPattern("#,###,###,###");
                String originalString15 = total_taksiran_shm1.getText().toString();
                String originalString25 = total_taksiran_shm2.getText().toString();
                String originalString26 = total_taksiran_shm3.getText().toString();
                String originalString27 = total_taksiran_shm4.getText().toString();
                String originalString28 = total_taksiran_shm5.getText().toString();
                if (originalString15.contains(",")) {
                    originalString15 = originalString15.replaceAll(",", "");
                }
                if (originalString25.contains(",")) {
                    originalString25 = originalString25.replaceAll(",", "");
                }
                if (originalString26.contains(",")) {
                    originalString26 = originalString26.replaceAll(",", "");

                }
                if (originalString27.contains(",")) {
                    originalString27 = originalString27.replaceAll(",", "");

                }
                if (originalString28.contains(",")) {
                    originalString28 = originalString28.replaceAll(",", "");
                }

                String plafond = plafond_kredit.getText().toString();
                plafond = plafond.replace(",", "");
                Plafond_kredit = Double.parseDouble(plafond);

                nilai_jaminan1 = Long.parseLong(originalString15);
                nilai_jaminan2 = Long.parseLong(originalString25);
                nilai_jaminan3 = Long.parseLong(originalString26);
                nilai_jaminan4 = Long.parseLong(originalString27);
                nilai_jaminan5 = Long.parseLong(originalString28);

                if (no_SHM1.getText().toString().isEmpty()) {
                    nilai_jaminan1 = Long.parseLong("0");
                }
                if (no_SHM2.getText().toString().isEmpty()) {
                    nilai_jaminan2 = Long.parseLong("0");
                }
                if (no_SHM3.getText().toString().isEmpty()) {
                    nilai_jaminan3 = Long.parseLong("0");
                }
                if (no_SHM4.getText().toString().isEmpty()) {
                    nilai_jaminan4 = Long.parseLong("0");
                }
                if (no_SHM5.getText().toString().isEmpty()) {
                    nilai_jaminan5 = Long.parseLong("0");
                }

                dtotal5 = (nilai_jaminan1 + nilai_jaminan2 + nilai_jaminan3 + nilai_jaminan4 + nilai_jaminan5);
                dtotal6 = (dtotal5 / Plafond_kredit) * 100;

                stotal5 = String.valueOf(formatter.format(dtotal5));
                stotal6 = String.valueOf(formatter.format(dtotal6));
                total_nilai_jaminan1.setText(stotal5);
                persen_dari_plafond1.setText(stotal6);

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            total_taksiran_shm1.addTextChangedListener(this);
            total_taksiran_shm2.addTextChangedListener(this);
            total_taksiran_shm3.addTextChangedListener(this);
            total_taksiran_shm4.addTextChangedListener(this);
            total_taksiran_shm5.addTextChangedListener(this);

            no_SHM1.addTextChangedListener(this);
            no_SHM2.addTextChangedListener(this);
            no_SHM3.addTextChangedListener(this);
            no_SHM4.addTextChangedListener(this);
            no_SHM5.addTextChangedListener(this);

            total_nilai_jaminan1.addTextChangedListener(this);
            persen_dari_plafond1.addTextChangedListener(this);




            // Keuangan

            kas.removeTextChangedListener(this);

            piutang.removeTextChangedListener(this);
            persediaan.removeTextChangedListener(this);
            inventaris.removeTextChangedListener(this);
            tanah_rumah.removeTextChangedListener(this);
            total_keuangan.removeTextChangedListener(this);

            try {
                String originalString = kas.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String formattedString = formatter6.format(longval);
                kas.setText(formattedString);
                kas.setSelection(kas.getText().length());

                kas1.setText(formattedString);


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString1 = piutang.getText().toString();

                Long longval;
                if (originalString1.contains(",")) {
                    originalString1 = originalString1.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString1);
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String formattedString = formatter6.format(longval);
                piutang.setText(formattedString);
                piutang.setSelection(piutang.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString12 = persediaan.getText().toString();

                Long longval;
                if (originalString12.contains(",")) {
                    originalString12 = originalString12.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString12);
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String formattedString = formatter6.format(longval);
                persediaan.setText(formattedString);
                persediaan.setSelection(persediaan.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString13 = inventaris.getText().toString();

                Long longval;
                if (originalString13.contains(",")) {
                    originalString13 = originalString13.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString13);
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String formattedString = formatter6.format(longval);
                inventaris.setText(formattedString);
                inventaris.setSelection(inventaris.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString14 = tanah_rumah.getText().toString();

                Long longval;
                if (originalString14.contains(",")) {
                    originalString14 = originalString14.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString14);
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String formattedString = formatter6.format(longval);
                tanah_rumah.setText(formattedString);
                tanah_rumah.setSelection(tanah_rumah.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString15 = total_keuangan.getText().toString();

                Long longval;
                if (originalString15.contains(",")) {
                    originalString15 = originalString15.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString15);
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String formattedString = formatter6.format(longval);
                total_keuangan.setText(formattedString);
                total_keuangan.setSelection(total_keuangan.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter6.applyPattern("#,###,###,###");
                String originalString = kas.getText().toString();
                String originalString1 = piutang.getText().toString();
                String originalString12 = persediaan.getText().toString();
                String originalString13 = inventaris.getText().toString();
                String originalString14 = tanah_rumah.getText().toString();
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }

                if (originalString1.contains(",")) {
                    originalString1 = originalString1.replaceAll(",", "");
                }
                if (originalString12.contains(",")) {
                    originalString12 = originalString12.replaceAll(",", "");
                }
                if (originalString13.contains(",")) {
                    originalString13 = originalString13.replaceAll(",", "");
                }
                if (originalString14.contains(",")) {
                    originalString14 = originalString14.replaceAll(",", "");
                }

                dkas = Long.parseLong(originalString);
                dpiutang = Long.parseLong(originalString1);
                dpersediaan = Long.parseLong(originalString12);
                dinventaris = Long.parseLong(originalString13);
                dtanah_rumah = Long.parseLong(originalString14);

                dtotal_aktiva = Math.round(dkas + dpiutang + dpersediaan + dinventaris + dtanah_rumah);

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter6 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter6.applyPattern("#,###,###,###");

            stotal_aktiva = String.valueOf(formatter6.format(dtotal_aktiva));
            total_keuangan.setText(stotal_aktiva);

            kas.addTextChangedListener(this);
            piutang.addTextChangedListener(this);
            persediaan.addTextChangedListener(this);
            inventaris.addTextChangedListener(this);
            tanah_rumah.addTextChangedListener(this);
            total_keuangan.addTextChangedListener(this);
// _________________________________________________________________________________________________//

            //PASIVA
            hutang_dagang.removeTextChangedListener(this);
            hutang_bank.removeTextChangedListener(this);
            pinjaman.removeTextChangedListener(this);
            modal.removeTextChangedListener(this);
            laba.removeTextChangedListener(this);
            laba2.removeTextChangedListener(this);
            total_pasiva.removeTextChangedListener(this);

            pendapatan_usaha.removeTextChangedListener(this);
            biaya_usaha.removeTextChangedListener(this);
            laba_usaha.removeTextChangedListener(this);
            pendapatan_lain.removeTextChangedListener(this);
            total_pendapatan.removeTextChangedListener(this);


            biaya_rumah_tangga.removeTextChangedListener(this);
            biaya_listrik.removeTextChangedListener(this);
            biaya_pendidikan.removeTextChangedListener(this);
            biaya_transportasi.removeTextChangedListener(this);
            biaya_sosial.removeTextChangedListener(this);
            angsuran_bank1.removeTextChangedListener(this);
            angsuran_bank2.removeTextChangedListener(this);
            angsuran_bank3.removeTextChangedListener(this);
            angsuran_bank4.removeTextChangedListener(this);
            angsuran_bank5.removeTextChangedListener(this);
            angsuran_bank6.removeTextChangedListener(this);
            biaya_lainnya.removeTextChangedListener(this);
            total_biaya.removeTextChangedListener(this);



            try {
                String originalString21 = hutang_dagang.getText().toString();

                Long longval;
                if (originalString21.contains(",")) {
                    originalString21 = originalString21.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString21);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                hutang_dagang.setText(formattedString);
                hutang_dagang.setSelection(hutang_dagang.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString22 = hutang_bank.getText().toString();

                Long longval;
                if (originalString22.contains(",")) {
                    originalString22 = originalString22.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString22);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                hutang_bank.setText(formattedString);
                hutang_bank.setSelection(hutang_bank.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString23 = pinjaman.getText().toString();

                Long longval;
                if (originalString23.contains(",")) {
                    originalString23 = originalString23.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString23);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                pinjaman.setText(formattedString);
                pinjaman.setSelection(pinjaman.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString24 = modal.getText().toString();

                Long longval;
                if (originalString24.contains(",")) {
                    originalString24 = originalString24.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString24);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                modal.setText(formattedString);
                modal.setSelection(modal.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }


            try {
                String originalString26 = total_pasiva.getText().toString();

                Long longval;
                if (originalString26.contains(",")) {
                    originalString26 = originalString26.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString26);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                total_pasiva.setText(formattedString);
                total_pasiva.setSelection(total_pasiva.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }


            try {
                String originalString31 = pendapatan_usaha.getText().toString();

                Long longval;
                if (originalString31.contains(",")) {
                    originalString31 = originalString31.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString31);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                pendapatan_usaha.setText(formattedString);
                pendapatan_usaha.setSelection(pendapatan_usaha.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString32 = biaya_usaha.getText().toString();

                Long longval;
                if (originalString32.contains(",")) {
                    originalString32 = originalString32.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString32);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_usaha.setText(formattedString);
                biaya_usaha.setSelection(biaya_usaha.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString33 = laba_usaha.getText().toString();

                Long longval;
                if (originalString33.contains(",")) {
                    originalString33 = originalString33.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString33);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                laba_usaha.setText(formattedString);
                laba_usaha.setSelection(laba_usaha.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString34 = pendapatan_lain.getText().toString();

                Long longval;
                if (originalString34.contains(",")) {
                    originalString34 = originalString34.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString34);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                pendapatan_lain.setText(formattedString);
                pendapatan_lain.setSelection(pendapatan_lain.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }


            try {
                String originalString35 = total_pendapatan.getText().toString();

                Long longval;
                if (originalString35.contains(",")) {
                    originalString35 = originalString35.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString35);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                total_pendapatan.setText(formattedString);
                total_pendapatan.setSelection(total_pendapatan.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString41 = biaya_rumah_tangga.getText().toString();

                Long longval;
                if (originalString41.contains(",")) {
                    originalString41 = originalString41.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString41);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_rumah_tangga.setText(formattedString);
                biaya_rumah_tangga.setSelection(biaya_rumah_tangga.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString42 = biaya_listrik.getText().toString();

                Long longval;
                if (originalString42.contains(",")) {
                    originalString42 = originalString42.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString42);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_listrik.setText(formattedString);
                biaya_listrik.setSelection(biaya_listrik.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString43 = biaya_pendidikan.getText().toString();

                Long longval;
                if (originalString43.contains(",")) {
                    originalString43 = originalString43.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString43);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_pendidikan.setText(formattedString);
                biaya_pendidikan.setSelection(biaya_pendidikan.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString44 = biaya_transportasi.getText().toString();

                Long longval;
                if (originalString44.contains(",")) {
                    originalString44 = originalString44.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString44);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_transportasi.setText(formattedString);
                biaya_transportasi.setSelection(biaya_transportasi.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString45 = biaya_sosial.getText().toString();

                Long longval;
                if (originalString45.contains(",")) {
                    originalString45 = originalString45.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString45);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_sosial.setText(formattedString);
                biaya_sosial.setSelection(biaya_sosial.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString46 = angsuran_bank1.getText().toString();

                Long longval;
                if (originalString46.contains(",")) {
                    originalString46 = originalString46.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString46);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                angsuran_bank1.setText(formattedString);
                angsuran_bank1.setSelection(angsuran_bank1.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString47 = angsuran_bank2.getText().toString();

                Long longval;
                if (originalString47.contains(",")) {
                    originalString47 = originalString47.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString47);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                angsuran_bank2.setText(formattedString);
                angsuran_bank2.setSelection(angsuran_bank2.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString48 = angsuran_bank3.getText().toString();

                Long longval;
                if (originalString48.contains(",")) {
                    originalString48 = originalString48.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString48);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                angsuran_bank3.setText(formattedString);
                angsuran_bank3.setSelection(angsuran_bank3.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString49 = angsuran_bank4.getText().toString();

                Long longval;
                if (originalString49.contains(",")) {
                    originalString49 = originalString49.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString49);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                angsuran_bank4.setText(formattedString);
                angsuran_bank4.setSelection(angsuran_bank4.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString50 = angsuran_bank5.getText().toString();

                Long longval;
                if (originalString50.contains(",")) {
                    originalString50 = originalString50.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString50);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                angsuran_bank5.setText(formattedString);
                angsuran_bank5.setSelection(angsuran_bank5.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString51 = angsuran_bank6.getText().toString();

                Long longval;
                if (originalString51.contains(",")) {
                    originalString51 = originalString51.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString51);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                angsuran_bank6.setText(formattedString);
                angsuran_bank6.setSelection(angsuran_bank6.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString52 = biaya_lainnya.getText().toString();

                Long longval;
                if (originalString52.contains(",")) {
                    originalString52 = originalString52.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString52);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                biaya_lainnya.setText(formattedString);
                biaya_lainnya.setSelection(biaya_lainnya.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString53 = total_biaya.getText().toString();

                Long longval;
                if (originalString53.contains(",")) {
                    originalString53 = originalString53.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString53);
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");
                String formattedString = formatter7.format(longval);
                total_biaya.setText(formattedString);
                total_biaya.setSelection(total_biaya.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter7.applyPattern("#,###,###,###");

                String originalString21 = hutang_dagang.getText().toString();
                String originalString22 = hutang_bank.getText().toString();
                String originalString23 = pinjaman.getText().toString();

                String originalString24 = modal.getText().toString();

                String originalString31 = pendapatan_usaha.getText().toString();
                String originalString32 = biaya_usaha.getText().toString();
                String originalString33 = laba_usaha.getText().toString();
                String originalString34 = pendapatan_lain.getText().toString();


                String originalString41 = biaya_rumah_tangga.getText().toString();
                String originalString42 = biaya_listrik.getText().toString();
                String originalString43 = biaya_pendidikan.getText().toString();
                String originalString44 = biaya_transportasi.getText().toString();
                String originalString45 = biaya_sosial.getText().toString();
                String originalString46 = angsuran_bank1.getText().toString();
                String originalString47 = angsuran_bank2.getText().toString();
                String originalString48 = angsuran_bank3.getText().toString();
                String originalString49 = angsuran_bank4.getText().toString();
                String originalString50 = angsuran_bank5.getText().toString();
                String originalString51 = angsuran_bank6.getText().toString();
                String originalString52 = biaya_lainnya.getText().toString();



                if (originalString21.contains(",")) {
                    originalString21 = originalString21.replaceAll(",", "");
                }

                if (originalString22.contains(",")) {
                    originalString22 = originalString22.replaceAll(",", "");
                }
                if (originalString23.contains(",")) {
                    originalString23 = originalString23.replaceAll(",", "");
                }
                if (originalString24.contains(",")) {
                    originalString24 = originalString24.replaceAll(",", "");
                }


                if (originalString31.contains(",")) {
                    originalString31 = originalString31.replaceAll(",", "");
                }
                if (originalString32.contains(",")) {
                    originalString32 = originalString32.replaceAll(",", "");
                }
                if (originalString33.contains(",")) {
                    originalString33 = originalString33.replaceAll(",", "");
                }
                if (originalString34.contains(",")) {
                    originalString34 = originalString34.replaceAll(",", "");
                }

                if (originalString41.contains(",")) {
                    originalString41 = originalString41.replaceAll(",", "");
                }
                if (originalString42.contains(",")) {
                    originalString42 = originalString42.replaceAll(",", "");
                }
                if (originalString43.contains(",")) {
                    originalString43 = originalString43.replaceAll(",", "");
                }
                if (originalString44.contains(",")) {
                    originalString44 = originalString44.replaceAll(",", "");
                }
                if (originalString45.contains(",")) {
                    originalString45 = originalString45.replaceAll(",", "");
                }
                if (originalString46.contains(",")) {
                    originalString46 = originalString46.replaceAll(",", "");
                }
                if (originalString47.contains(",")) {
                    originalString47 = originalString47.replaceAll(",", "");
                }
                if (originalString48.contains(",")) {
                    originalString48 = originalString48.replaceAll(",", "");
                }
                if (originalString49.contains(",")) {
                    originalString49 = originalString49.replaceAll(",", "");
                }
                if (originalString50.contains(",")) {
                    originalString50 = originalString50.replaceAll(",", "");
                }

                if (originalString51.contains(",")) {
                    originalString51 = originalString51.replaceAll(",", "");
                }
                if (originalString52.contains(",")) {
                    originalString52 = originalString52.replaceAll(",", "");
                }

                dhutang_dagang = Long.parseLong(originalString21);
                dpinjaman = Long.parseLong(originalString23);

                dbiaya_rumah = Long.parseLong(originalString41);
                dbiaya_listrik = Long.parseLong(originalString42);
                dbiaya_pendidikan = Long.parseLong(originalString43);
                dbiaya_transportasi = Long.parseLong(originalString44);
                dbiaya_sosial = Long.parseLong(originalString45);
                dangsruran_bank1 = Long.parseLong(originalString46);
                dangsruran_bank2 = Long.parseLong(originalString47);
                dangsruran_bank3 = Long.parseLong(originalString48);
                dangsruran_bank4 = Long.parseLong(originalString49);
                dangsruran_bank5 = Long.parseLong(originalString50);
                dangsruran_bank6 = Long.parseLong(originalString51);
                dbiaya_lainnya = Long.parseLong(originalString52);

                dhutang_bank = Long.parseLong(originalString22);
                dmodal = Long.parseLong(originalString24);



                dpendapatan_usaha = Long.parseLong(originalString31);
                dbiaya_usaha = Long.parseLong(originalString32);

                dlaba_usaha = Long.parseLong(originalString33);
                dlaba_usaha1 = Math.round(dpendapatan_usaha - dbiaya_usaha);

                dpendapatan_lain = Long.parseLong(originalString34);
                dtotal_pendapatan = Math.round(dlaba_usaha1 + dpendapatan_lain);


                dtotal_biaya = Math.round(dbiaya_rumah + dbiaya_listrik + dbiaya_pendidikan + dbiaya_transportasi +
                        dbiaya_sosial + dangsruran_bank1 + dangsruran_bank2 + dangsruran_bank3 +
                        dangsruran_bank4 + dangsruran_bank5 + dangsruran_bank6 + dbiaya_lainnya);

                dlaba1 =  Math.round(dtotal_pendapatan - dtotal_biaya);

                dmodal1 = Math.round(dtotal_aktiva - dhutang_bank - dlaba1);
                dtotal_pasiva = Math.round (dhutang_dagang + dhutang_bank + dpinjaman + dmodal1 + dlaba1);



            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter7 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter7.applyPattern("#,###,###,###");


            stotal_modal = String.valueOf(formatter7.format(dmodal1));
            modal.setText(stotal_modal);

            stotal_pasiva = String.valueOf(formatter7.format(dtotal_pasiva));
            total_pasiva.setText(stotal_pasiva);

            stotal_laba_usaha = String.valueOf(formatter7.format(dlaba_usaha1));
            laba_usaha.setText(stotal_laba_usaha);

            stotal_pendapatan = String.valueOf(formatter7.format(dtotal_pendapatan));
            total_pendapatan.setText(stotal_pendapatan);

            stotal_biaya = String.valueOf(formatter7.format(dtotal_biaya));
            total_biaya.setText(stotal_biaya);

            stotal_laba = String.valueOf(formatter7.format(dlaba1));
            laba.setText(stotal_laba);
            laba2.setText(stotal_laba);


            hutang_dagang.addTextChangedListener(this);
            hutang_bank.addTextChangedListener(this);
            pinjaman.addTextChangedListener(this);
            modal.addTextChangedListener(this);
            laba.addTextChangedListener(this);
            laba2.addTextChangedListener(this);
            total_pasiva.addTextChangedListener(this);

            pendapatan_usaha.addTextChangedListener(this);
            biaya_usaha.addTextChangedListener(this);
            laba_usaha.addTextChangedListener(this);
            pendapatan_lain.addTextChangedListener(this);
            total_pendapatan.addTextChangedListener(this);

            biaya_rumah_tangga.addTextChangedListener(this);
            biaya_listrik.addTextChangedListener(this);
            biaya_pendidikan.addTextChangedListener(this);
            biaya_transportasi.addTextChangedListener(this);
            biaya_sosial.addTextChangedListener(this);
            angsuran_bank1.addTextChangedListener(this);
            angsuran_bank2.addTextChangedListener(this);
            angsuran_bank3.addTextChangedListener(this);
            angsuran_bank4.addTextChangedListener(this);
            angsuran_bank5.addTextChangedListener(this);
            angsuran_bank6.addTextChangedListener(this);
            biaya_lainnya.addTextChangedListener(this);
            total_biaya.addTextChangedListener(this);

            //-----------------------------------------------------------------------------------//

            tujuan_modal.removeTextChangedListener(this);
            tujuan_pelunasan.removeTextChangedListener(this);
            tujuan_pembelian.removeTextChangedListener(this);
            tujuan_renovasi.removeTextChangedListener(this);
            tujuan_sekolah.removeTextChangedListener(this);
            tujuan_lainnya.removeTextChangedListener(this);
            total_kebutuhan.removeTextChangedListener(this);

            try {
                String originalString = tujuan_modal.getText().toString();

                Long longval;
                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                tujuan_modal.setText(formattedString);
                tujuan_modal.setSelection(tujuan_modal.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString1 = tujuan_pelunasan.getText().toString();

                Long longval;
                if (originalString1.contains(",")) {
                    originalString1 = originalString1.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString1);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                tujuan_pelunasan.setText(formattedString);
                tujuan_pelunasan.setSelection(tujuan_pelunasan.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString12 = tujuan_pembelian.getText().toString();

                Long longval;
                if (originalString12.contains(",")) {
                    originalString12 = originalString12.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString12);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                tujuan_pembelian.setText(formattedString);
                tujuan_pembelian.setSelection(tujuan_pembelian.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString13 = tujuan_renovasi.getText().toString();

                Long longval;
                if (originalString13.contains(",")) {
                    originalString13 = originalString13.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString13);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                tujuan_renovasi.setText(formattedString);
                tujuan_renovasi.setSelection(tujuan_renovasi.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString14 = tujuan_sekolah.getText().toString();

                Long longval;
                if (originalString14.contains(",")) {
                    originalString14 = originalString14.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString14);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                tujuan_sekolah.setText(formattedString);
                tujuan_sekolah.setSelection(tujuan_sekolah.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString15 = tujuan_lainnya.getText().toString();

                Long longval;
                if (originalString15.contains(",")) {
                    originalString15 = originalString15.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString15);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                tujuan_lainnya.setText(formattedString);
                tujuan_lainnya.setSelection(tujuan_lainnya.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                String originalString16 = total_kebutuhan.getText().toString();

                Long longval;
                if (originalString16.contains(",")) {
                    originalString16 = originalString16.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString16);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                total_kebutuhan.setText(formattedString);
                total_kebutuhan.setSelection(total_kebutuhan.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                String originalString17 = kebutuhan_bank.getText().toString();

                Long longval;
                if (originalString17.contains(",")) {
                    originalString17 = originalString17.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString17);
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String formattedString = formatter8.format(longval);
                kebutuhan_bank.setText(formattedString);
                kebutuhan_bank.setSelection(kebutuhan_bank.getText().length());


            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }


            try {
                DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter8.applyPattern("#,###,###,###");
                String originalString = tujuan_modal.getText().toString();
                String originalString1 = tujuan_pelunasan.getText().toString();
                String originalString12 = tujuan_pembelian.getText().toString();
                String originalString13 = tujuan_renovasi.getText().toString();
                String originalString14 = tujuan_sekolah.getText().toString();
                String originalString15 = tujuan_lainnya.getText().toString();
                String originalString17 = kebutuhan_bank.getText().toString();


                if (originalString.contains(",")) {
                    originalString = originalString.replaceAll(",", "");
                }

                if (originalString1.contains(",")) {
                    originalString1 = originalString1.replaceAll(",", "");
                }
                if (originalString12.contains(",")) {
                    originalString12 = originalString12.replaceAll(",", "");
                }
                if (originalString13.contains(",")) {
                    originalString13 = originalString13.replaceAll(",", "");
                }
                if (originalString14.contains(",")) {
                    originalString14 = originalString14.replaceAll(",", "");
                }
                if (originalString15.contains(",")) {
                    originalString15 = originalString15.replaceAll(",", "");
                }
                if (originalString17.contains(",")) {
                    originalString17 = originalString17.replaceAll(",", "");
                }

                dtujuan_modal = Long.parseLong(originalString);
                dtujuan_pelunasan = Long.parseLong(originalString1);
                dtujuan_pembelian = Long.parseLong(originalString12);
                dtujuan_renovasi = Long.parseLong(originalString13);
                dtujuan_sekolah = Long.parseLong(originalString14);
                dtujuan_lainnya = Long.parseLong(originalString15);
                dkebutuhan_bank = Long.parseLong(originalString17);

                dtotal_kebutuhan = Math.round(dtujuan_modal + dtujuan_pelunasan + dtujuan_pembelian + dtujuan_renovasi
                        + dtujuan_sekolah + dtujuan_lainnya);

                dkebutuhan_bank = Long.parseLong(originalString17);
                dkebutuhan_bank = dtotal_kebutuhan - dkas;

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter8 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter8.applyPattern("#,###,###,###");

            stotal_kebutuhan = String.valueOf(formatter8.format(dtotal_kebutuhan));
            total_kebutuhan.setText(stotal_kebutuhan);

            skebutuhan_bank = String.valueOf(formatter8.format(dkebutuhan_bank));
            kebutuhan_bank.setText(skebutuhan_bank);

            dibulatkan_menjadi.setText(skebutuhan_bank);

            tujuan_modal.addTextChangedListener(this);
            tujuan_pelunasan.addTextChangedListener(this);
            tujuan_pembelian.addTextChangedListener(this);
            tujuan_renovasi.addTextChangedListener(this);
            tujuan_sekolah.addTextChangedListener(this);
            tujuan_lainnya.addTextChangedListener(this);
            total_kebutuhan.addTextChangedListener(this);


            plafond_kredit2.removeTextChangedListener(this);
            angsuran_bunga_pertama2.removeTextChangedListener(this);
            laba2.removeTextChangedListener(this);
            dana_angsuran.removeTextChangedListener(this);
            jkw_x1.removeTextChangedListener(this);



            try {

                String originalString999 = plafond_kredit2.getText().toString();

                Long longval;
                if (originalString999.contains(",")) {
                    originalString999 = originalString999.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString999);
                DecimalFormat formatter10 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter10.applyPattern("#,###,###,###");


                String formattedString = formatter10.format(longval);

                //setting text after format to EditText
                plafond_kredit2.setText(formattedString);
                plafond_kredit2.setSelection(plafond_kredit2.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {

                String originalString999 = jkw_x1.getText().toString();

                Long longval;
                if (originalString999.contains(",")) {
                    originalString999 = originalString999.replaceAll(",", "");
                }
                longval = Long.parseLong(originalString999);
                DecimalFormat formatter10 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter10.applyPattern("#,###,###,###");


                String formattedString = formatter10.format(longval);

                //setting text after format to EditText
                jkw_x1.setText(formattedString);
                jkw_x1.setSelection(jkw_x1.getText().length());

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            try {
                DecimalFormat formatter10 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                formatter10.applyPattern("#,###,###,###");
                String originalString999 = plafond_kredit2.getText().toString();
                String originalString199 = laba2.getText().toString();
                String originalString95 = angsuran_bunga_pertama2.getText().toString();
                String originalString96 = dana_angsuran.getText().toString();

                if (originalString999.contains(",")) {
                    originalString999 = originalString999.replaceAll(",", "");
                }

                if (originalString199.contains(",")) {
                    originalString199 = originalString199.replaceAll(",", "");
                }
                if (originalString95.contains(",")) {
                    originalString95 = originalString95.replaceAll(",", "");
                }
                if (originalString96.contains(",")) {
                    originalString96 = originalString96.replaceAll(",", "");
                }


                dlaba = Long.parseLong(originalString199);
                dangsuran_perbulan = Long.parseLong(originalString95);

                ddana = Long.parseLong(originalString96);
                ddana = ((dlaba - dangsuran_perbulan)-3);

                dplafond = Long.parseLong(originalString999);
                djkw_1 = dplafond / ddana;

            } catch (NumberFormatException e) {

            }
            DecimalFormat formatter10 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter10.applyPattern("#,###,###,###");

            sdana = String.valueOf(formatter10.format(ddana));
            dana_angsuran.setText(sdana);

            sjkw_x1 = String.valueOf(formatter10.format(djkw_1));
            jkw_x1.setText(sjkw_x1);

            dana_angsuran.addTextChangedListener(this);
            jkw_x1.addTextChangedListener(this);



        }


    };




}
