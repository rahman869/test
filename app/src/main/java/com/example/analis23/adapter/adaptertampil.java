package com.example.analis23.adapter;

import android.content.Context;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TableLayout;
import android.widget.TextView;

import com.example.analis23.R;
import com.example.analis23.model.DataModel;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class adaptertampil extends RecyclerView.Adapter<adaptertampil.HolderData> {


    private List<DataModel> mList;
    private Context ctx;
    private TableLayout a;


    public adaptertampil(Context ctx, List<DataModel> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NotNull
    @Override
    public adaptertampil.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdetail, parent, false);
        adaptertampil.HolderData holder1 = new adaptertampil.HolderData(layout1);
        return holder1;

    }



    @Override
    public void onBindViewHolder(HolderData holder1, int position) {

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");

        DecimalFormat bulan = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        bulan.applyPattern("## Bulan");

        DecimalFormat persen = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        persen.applyPattern("#,## %");

        DecimalFormat persen1 = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        persen1.applyPattern("#,# %");


        DataModel dm = mList.get(position);

        holder1.tgl_permohonan.setText(dm.getTgl_permohonan());
        holder1.no_reg.setText(dm.getNo_reg());
        holder1.nama_pemohon.setText(dm.getNama_pemohon());
        holder1.nama_panggilan.setText(dm.getNama_panggilan());
        holder1.tempat_lahir.setText(dm.getTempat_lahir());
        holder1.tgl_lahir.setText(dm.getTgl_lahir());
        holder1.jenis_kelamin.setText(dm.getJenis_kelamin());
        holder1.no_ktp.setText(dm.getNo_ktp());
        holder1.masa_berlaku_ktp.setText(dm.getMasa_berlaku_ktp());
        holder1.alamat_sesuai_ktp.setText(dm.getAlamat_sesuai_ktp());
        holder1.nama_ibu_kandung.setText(dm.getNama_ibu_kandung());
        holder1.kode_pos.setText(dm.getKode_pos());
        holder1.pekerjaan_pemohon.setText(dm.getPekerjaan_pemohon());
        holder1.nama_perusahaan.setText(dm.getNama_perusahaan());
        holder1.jabatan.setText(dm.getJabatan());
        holder1.alamat_perusahaan.setText(dm.getAlamat_perusahaan());
        holder1.status_pernikahan.setText(dm.getStatus_pernikahan());
        holder1.jml_tanggungan.setText(dm.getJml_tanggungan());
        holder1.pendidikan_terakhir.setText(dm.getPendidikan_terakhir());
        holder1.status_rumah_tinggal.setText(dm.getStatus_rumah_tinggal());
        holder1.lama_tinggal.setText(dm.getLama_tinggal());
        holder1.alamat_rumah_tinggal.setText(dm.getAlamat_rumah_tinggal());
        holder1.no_telp.setText(dm.getNo_telp());
        holder1.no_hp.setText(dm.getNo_hp());
        holder1.nama_pasangan.setText(dm.getNama_pasangan());
        holder1.tgl_lahir_pasangan.setText(dm.getTgl_lahir_pasangan());
        holder1.no_ktp_pasangan.setText(dm.getNo_ktp_pasangan());
        holder1.masa_berlaku_ktp_pasangan.setText(dm.getMasa_berlaku_ktp_pasangan());
        holder1.pekerjaan_pasangan.setText(dm.getPekerjaan_pasangan());
        holder1.tempat_lahir_pasangan.setText(dm.getTempat_lahir_pasangan());
        holder1.alamat_pasangan.setText(dm.getAlamat_pasangan());
        holder1.penghasilan_per_bln.setText(formatter.format(Integer.parseInt(dm.getPenghasilan_per_bln())));
        holder1.penjamin.setText(dm.getPenjamin());
        holder1.alamat_penjamin.setText(dm.getAlamat_penjamin());
        holder1.tempat_lahir_penjamin.setText(dm.getTempat_lahir_penjamin());
        holder1.tgl_lahir_penjamin.setText(dm.getTgl_lahir_penjamin());
        holder1.no_ktp_penjamin.setText(dm.getNo_ktp_penjamin());
        holder1.masa_berlaku_ktp_penjamin.setText(dm.getMasa_berlaku_ktp_penjamin());
        holder1.nama_pasangan_penjamin.setText(dm.getNama_pasangan_penjamin());
        holder1.alamat_pasangan_penjamin.setText(dm.getAlamat_pasangan_penjamin());
        holder1.tempat_lahir_pasangan_penjamin.setText(dm.getTempat_lahir_pasangan_penjamin());
        holder1.tgl_lahir_pasangan_penjamin.setText(dm.getTgl_lahir_pasangan_penjamin());
        holder1.no_ktp_pasangan_penjamin.setText(dm.getNo_ktp_pasangan_penjamin());
        holder1.masa_berlaku_ktp_pasangan_penjamin.setText(dm.getMasa_berlaku_ktp_pasangan_penjamin());
        holder1.jenis_kredit.setText(dm.getJenis_kredit());
        holder1.sektor_ekonomi.setText(dm.getSektor_ekonomi());
        holder1.fasilitas_ke.setText(dm.getFasilitas_ke());
        holder1.plafond_kredit.setText(formatter.format(Integer.parseInt(dm.getPlafond_kredit())));


        holder1.jkw.setText(bulan.format(Integer.parseInt(dm.getJkw())));
        holder1.bunga.setText(dm.getBunga());
        holder1.type_angsuran.setText(dm.getType_angsuran());
        holder1.periode_pembayaran_pokok.setText(formatter.format(Integer.parseInt(dm.getPeriode_pembayaran_pokok())));
        holder1.jml_angsuran_per_bln.setText(formatter.format(Integer.parseInt(dm.getJml_angsuran_per_bln())));
        holder1.angsuran_pokok_pertama.setText(formatter.format(Integer.parseInt(dm.getAngsuran_pokok_pertama())));
        holder1.angsuran_bunga_pertama.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bunga_pertama())));
        holder1.provisi.setText(persen1.format(Double.parseDouble(dm.getProvisi())));
        holder1.administrasi.setText(persen1.format(Double.parseDouble(dm.getAdministrasi())));
        holder1.on_the_spot.setText(persen.format(Double.parseDouble(dm.getOn_the_spot())));
        holder1.premi.setText(formatter.format(Integer.parseInt(dm.getPremi())));
        holder1.nama_asuransi.setText(dm.getNama_asuransi());
        holder1.akad_kredit.setText(dm.getAkad_kredit());
        holder1.jenis_penggunaan.setText(dm.getJenis_penggunaan());
        holder1.tujuan_penggunaan.setText(dm.getTujuan_penggunaan());
        holder1.surveyor.setText(dm.getSurveyor());


        holder1.nama_jaminan_shm1.setText(dm.getNama_jaminan_shm1());
        holder1.jenis_jaminan_shm1.setText(dm.getJenis_jaminan_shm1());
        holder1.atas_nama_shm1.setText(dm.getAtas_nama_shm1());
        holder1.alamat_atas_nama_shm1.setText(dm.getAlamat_atas_nama_shm1());
        holder1.no_ktp_atas_nama_shm1.setText(dm.getNo_ktp_atas_nama_shm1());
        holder1.masa_berlaku_shm1.setText(dm.getMasa_berlaku_shm1());
        holder1.ikatan_shm1.setText(dm.getIkatan_shm1());
        holder1.nilai_ikatan_shm1.setText(dm.getNilai_ikatan_shm1());
        holder1.no_SHM1.setText(dm.getNo_SHM1());
        holder1.no_gs_shm1.setText(dm.getNo_gs_shm1());
        holder1.luas_shm1.setText(dm.getLuas_shm1());
        holder1.lokasi_shm1.setText(dm.getLokasi_shm1());
        holder1.asuransi_shm1.setText(dm.getAsuransi_shm1());
        holder1.nilai_tanah_shm1.setText(formatter.format(Integer.parseInt(dm.getNilai_tanah_shm1())));
        holder1.nilai_bangunan_shm1.setText(formatter.format(Integer.parseInt(dm.getNilai_bangunan_shm1())));
        holder1.total_taksiran_shm1.setText(formatter.format(Integer.parseInt(dm.getTotal_taksiran_shm1())));

        holder1.nama_jaminan_shm2.setText(dm.getNama_jaminan_shm2());
        holder1.jenis_jaminan_shm2.setText(dm.getJenis_jaminan_shm2());
        holder1.atas_nama_shm2.setText(dm.getAtas_nama_shm2());
        holder1.alamat_atas_nama_shm2.setText(dm.getAlamat_atas_nama_shm2());
        holder1.no_ktp_atas_nama_shm2.setText(dm.getNo_ktp_atas_nama_shm2());
        holder1.masa_berlaku_shm2.setText(dm.getMasa_berlaku_shm2());
        holder1.ikatan_shm2.setText(dm.getIkatan_shm2());
        holder1.nilai_ikatan_shm2.setText(dm.getNilai_ikatan_shm2());
        holder1.no_SHM2.setText(dm.getNo_SHM2());
        holder1.no_gs_shm2.setText(dm.getNo_gs_shm2());
        holder1.luas_shm2.setText(dm.getLuas_shm2());
        holder1.lokasi_shm2.setText(dm.getLokasi_shm2());
        holder1.asuransi_shm2.setText(dm.getAsuransi_shm2());
        holder1.nilai_tanah_shm2.setText(formatter.format(Integer.parseInt(dm.getNilai_tanah_shm2())));
        holder1.nilai_bangunan_shm2.setText(formatter.format(Integer.parseInt(dm.getNilai_bangunan_shm2())));
        holder1.total_taksiran_shm2.setText(formatter.format(Integer.parseInt(dm.getTotal_taksiran_shm2())));

        holder1.nama_jaminan_shm3.setText(dm.getNama_jaminan_shm3());
        holder1.jenis_jaminan_shm3.setText(dm.getJenis_jaminan_shm3());
        holder1.atas_nama_shm3.setText(dm.getAtas_nama_shm3());
        holder1.alamat_atas_nama_shm3.setText(dm.getAlamat_atas_nama_shm3());
        holder1.no_ktp_atas_nama_shm3.setText(dm.getNo_ktp_atas_nama_shm3());
        holder1.masa_berlaku_shm3.setText(dm.getMasa_berlaku_shm3());
        holder1.ikatan_shm3.setText(dm.getIkatan_shm3());
        holder1.nilai_ikatan_shm3.setText(dm.getNilai_ikatan_shm3());
        holder1.no_SHM3.setText(dm.getNo_SHM3());
        holder1.no_gs_shm3.setText(dm.getNo_gs_shm3());
        holder1.luas_shm3.setText(dm.getLuas_shm3());
        holder1.lokasi_shm3.setText(dm.getLokasi_shm3());
        holder1.asuransi_shm3.setText(dm.getAsuransi_shm3());
        holder1.nilai_tanah_shm3.setText(formatter.format(Integer.parseInt(dm.getNilai_tanah_shm3())));
        holder1.nilai_bangunan_shm3.setText(formatter.format(Integer.parseInt(dm.getNilai_bangunan_shm3())));
        holder1.total_taksiran_shm3.setText(formatter.format(Integer.parseInt(dm.getTotal_taksiran_shm3())));

        holder1.nama_jaminan_shm4.setText(dm.getNama_jaminan_shm4());
        holder1.jenis_jaminan_shm4.setText(dm.getJenis_jaminan_shm4());
        holder1.atas_nama_shm4.setText(dm.getAtas_nama_shm4());
        holder1.alamat_atas_nama_shm4.setText(dm.getAlamat_atas_nama_shm4());
        holder1.no_ktp_atas_nama_shm4.setText(dm.getNo_ktp_atas_nama_shm4());
        holder1.masa_berlaku_shm4.setText(dm.getMasa_berlaku_shm4());
        holder1.ikatan_shm4.setText(dm.getIkatan_shm4());
        holder1.nilai_ikatan_shm4.setText(dm.getNilai_ikatan_shm4());
        holder1.no_SHM4.setText(dm.getNo_SHM4());
        holder1.no_gs_shm4.setText(dm.getNo_gs_shm4());
        holder1.luas_shm4.setText(dm.getLuas_shm4());
        holder1.lokasi_shm4.setText(dm.getLokasi_shm4());
        holder1.asuransi_shm4.setText(dm.getAsuransi_shm4());
        holder1.nilai_tanah_shm4.setText(formatter.format(Integer.parseInt(dm.getNilai_tanah_shm4())));
        holder1.nilai_bangunan_shm4.setText(formatter.format(Integer.parseInt(dm.getNilai_bangunan_shm4())));
        holder1.total_taksiran_shm4.setText(formatter.format(Integer.parseInt(dm.getTotal_taksiran_shm4())));

        holder1.nama_jaminan_shm5.setText(dm.getNama_jaminan_shm5());
        holder1.jenis_jaminan_shm5.setText(dm.getJenis_jaminan_shm5());
        holder1.atas_nama_shm5.setText(dm.getAtas_nama_shm5());
        holder1.alamat_atas_nama_shm5.setText(dm.getAlamat_atas_nama_shm5());
        holder1.no_ktp_atas_nama_shm5.setText(dm.getNo_ktp_atas_nama_shm5());
        holder1.masa_berlaku_shm5.setText(dm.getMasa_berlaku_shm5());
        holder1.ikatan_shm5.setText(dm.getIkatan_shm5());
        holder1.nilai_ikatan_shm5.setText(dm.getNilai_ikatan_shm5());
        holder1.no_SHM5.setText(dm.getNo_SHM5());
        holder1.no_gs_shm5.setText(dm.getNo_gs_shm5());
        holder1.luas_shm5.setText(dm.getLuas_shm5());
        holder1.lokasi_shm5.setText(dm.getLokasi_shm5());
        holder1.asuransi_shm5.setText(dm.getAsuransi_shm5());
        holder1.nilai_tanah_shm5.setText(formatter.format(Integer.parseInt(dm.getNilai_tanah_shm5())));
        holder1.nilai_bangunan_shm5.setText(formatter.format(Integer.parseInt(dm.getNilai_bangunan_shm5())));
        holder1.total_taksiran_shm5.setText(formatter.format(Integer.parseInt(dm.getTotal_taksiran_shm5())));

        holder1.nama_jaminan_bpkb1.setText(dm.getNama_jaminan_bpkb1());
        holder1.no_bpkb1.setText(dm.getNo_bpkb1());
        holder1.merk_bpkb1.setText(dm.getMerk_bpkb1());
        holder1.tahun_bpkb1.setText(dm.getTahun_bpkb1());
        holder1.no_rangka_bpkb1.setText(dm.getNo_rangka_bpkb1());
        holder1.no_mesin_bpkb1.setText(dm.getNo_mesin_bpkb1());
        holder1.warna_bpkb1.setText(dm.getWarna_bpkb1());
        holder1.nopol_bpkb1.setText(dm.getNopol_bpkb1());
        holder1.atas_nama_bpkb1.setText(dm.getAtas_nama_bpkb1());
        holder1.alamat_bpkb1.setText(dm.getAlamat_bpkb1());
        holder1.ikatan_bpkb1.setText(dm.getIkatan_bpkb1());
        holder1.nilai_fiducia1.setText(dm.getNilai_fiducia1());
        holder1.nilai_taksiran_bpkb1.setText(formatter.format(Integer.parseInt(dm.getNilai_taksiran_bpkb1())));

        holder1.nama_jaminan_bpkb2.setText(dm.getNama_jaminan_bpkb2());
        holder1.no_bpkb2.setText(dm.getNo_bpkb2());
        holder1.merk_bpkb2.setText(dm.getMerk_bpkb2());
        holder1.tahun_bpkb2.setText(dm.getTahun_bpkb2());
        holder1.no_rangka_bpkb2.setText(dm.getNo_rangka_bpkb2());
        holder1.no_mesin_bpkb2.setText(dm.getNo_mesin_bpkb2());
        holder1.warna_bpkb2.setText(dm.getWarna_bpkb2());
        holder1.nopol_bpkb2.setText(dm.getNopol_bpkb2());
        holder1.atas_nama_bpkb2.setText(dm.getAtas_nama_bpkb2());
        holder1.alamat_bpkb2.setText(dm.getAlamat_bpkb2());
        holder1.ikatan_bpkb2.setText(dm.getIkatan_bpkb2());
        holder1.nilai_fiducia2.setText(dm.getNilai_fiducia2());
        holder1.nilai_taksiran_bpkb2.setText(formatter.format(Integer.parseInt(dm.getNilai_taksiran_bpkb2())));

        holder1.nama_jaminan_bpkb3.setText(dm.getNama_jaminan_bpkb3());
        holder1.no_bpkb3.setText(dm.getNo_bpkb3());
        holder1.merk_bpkb3.setText(dm.getMerk_bpkb3());
        holder1.tahun_bpkb3.setText(dm.getTahun_bpkb3());
        holder1.no_rangka_bpkb3.setText(dm.getNo_rangka_bpkb3());
        holder1.no_mesin_bpkb3.setText(dm.getNo_mesin_bpkb3());
        holder1.warna_bpkb3.setText(dm.getWarna_bpkb3());
        holder1.nopol_bpkb3.setText(dm.getNopol_bpkb3());
        holder1.atas_nama_bpkb3.setText(dm.getAtas_nama_bpkb3());
        holder1.alamat_bpkb3.setText(dm.getAlamat_bpkb3());
        holder1.ikatan_bpkb3.setText(dm.getIkatan_bpkb3());
        holder1.nilai_fiducia3.setText(dm.getNilai_fiducia3());
        holder1.nilai_taksiran_bpkb3.setText(formatter.format(Integer.parseInt(dm.getNilai_taksiran_bpkb3())));

        holder1.nama_jaminan_bpkb4.setText(dm.getNama_jaminan_bpkb4());
        holder1.no_bpkb4.setText(dm.getNo_bpkb4());
        holder1.merk_bpkb4.setText(dm.getMerk_bpkb4());
        holder1.tahun_bpkb4.setText(dm.getTahun_bpkb4());
        holder1.no_rangka_bpkb4.setText(dm.getNo_rangka_bpkb4());
        holder1.no_mesin_bpkb4.setText(dm.getNo_mesin_bpkb4());
        holder1.warna_bpkb4.setText(dm.getWarna_bpkb4());
        holder1.nopol_bpkb4.setText(dm.getNopol_bpkb4());
        holder1.atas_nama_bpkb4.setText(dm.getAtas_nama_bpkb4());
        holder1.alamat_bpkb4.setText(dm.getAlamat_bpkb4());
        holder1.ikatan_bpkb4.setText(dm.getIkatan_bpkb4());
        holder1.nilai_fiducia4.setText(dm.getNilai_fiducia4());
        holder1.nilai_taksiran_bpkb4.setText(formatter.format(Integer.parseInt(dm.getNilai_taksiran_bpkb4())));

        holder1.nama_jaminan_bpkb5.setText(dm.getNama_jaminan_bpkb5());
        holder1.no_bpkb5.setText(dm.getNo_bpkb5());
        holder1.merk_bpkb5.setText(dm.getMerk_bpkb5());
        holder1.tahun_bpkb5.setText(dm.getTahun_bpkb5());
        holder1.no_rangka_bpkb5.setText(dm.getNo_rangka_bpkb5());
        holder1.no_mesin_bpkb5.setText(dm.getNo_mesin_bpkb5());
        holder1.warna_bpkb5.setText(dm.getWarna_bpkb5());
        holder1.nopol_bpkb5.setText(dm.getNopol_bpkb5());
        holder1.atas_nama_bpkb5.setText(dm.getAtas_nama_bpkb5());
        holder1.alamat_bpkb5.setText(dm.getAlamat_bpkb5());
        holder1.ikatan_bpkb5.setText(dm.getIkatan_bpkb5());
        holder1.nilai_fiducia5.setText(dm.getNilai_fiducia5());
        holder1.nilai_taksiran_bpkb5.setText(formatter.format(Integer.parseInt(dm.getNilai_taksiran_bpkb5())));

        holder1.nama_jaminand1.setText(dm.getJaminan_bilyet1());
        holder1.nama_deposito1.setText(dm.getAtas_nama_bilyet1());
        holder1.no_bilyet1.setText(dm.getNo_bilyet1());
        holder1.alamatd1.setText(dm.getAlamat_bilyet1());
        holder1.pengikat_jaminand1.setText(dm.getIkatan_bilyet1());
        holder1.deposito1.setText(dm.getNilai_bilyet1());
        holder1.total_nilai_jaminan1.setText(formatter.format(Integer.parseInt(dm.getTotal_nilai_bilyet1())));
        holder1.persen_dari_plafond1.setText(persen.format(Double.parseDouble(dm.getPersen_dari_plafond1())));

        holder1.nama_jaminand2.setText(dm.getJaminan_bilyet2());
        holder1.nama_deposito2.setText(dm.getAtas_nama_bilyet2());
        holder1.no_bilyet2.setText(dm.getNo_bilyet2());
        holder1.alamatd2.setText(dm.getAlamat_bilyet2());
        holder1.pengikat_jaminand2.setText(dm.getIkatan_bilyet2());
        holder1.deposito2.setText(dm.getNilai_bilyet2());
        holder1.total_nilai_jaminan2.setText(formatter.format(Integer.parseInt(dm.getTotal_nilai_bilyet2())));
        holder1.persen_dari_plafond2.setText(dm.getPersen_dari_plafond2());

        holder1.nama_jaminand3.setText(dm.getJaminan_bilyet3());
        holder1.nama_deposito3.setText(dm.getAtas_nama_bilyet3());
        holder1.no_bilyet3.setText(dm.getNo_bilyet3());
        holder1.alamatd3.setText(dm.getAlamat_bilyet3());
        holder1.pengikat_jaminand3.setText(dm.getIkatan_bilyet3());
        holder1.deposito3.setText(dm.getNilai_bilyet3());
        holder1.total_nilai_jaminan3.setText(formatter.format(Integer.parseInt(dm.getTotal_nilai_bilyet3())));
        holder1.persen_dari_plafond3.setText(dm.getPersen_dari_plafond3());

        holder1.pekerjaank.setText(dm.getRincian_pekerjaan());
        holder1.nama_perusahaan1.setText(dm.getNama_perusahaan());
        holder1.alamat_usaha.setText(dm.getAlamat_usaha());
        holder1.lama_usaha.setText(dm.getLama_usaha());
        holder1.uraian_kegiatan_usaha_utama.setText(dm.getDeskripsi_usaha_utama());
        holder1.uraian_kegiatan_usaha_sampingan.setText(dm.getDeskripsi_usaha_sampingan());
        holder1.uraian_kegiatan_usaha_pasangan.setText(dm.getDeskripsi_usaha_pasangan());
        holder1.kondisi_fisik.setText(dm.getKondisi_fisik_pemohon());
        holder1.kesimpulan.setText(dm.getKesimpulan());


        holder1.kas.setText(formatter.format(Integer.parseInt(dm.getKas())));
        holder1.piutang.setText(formatter.format(Integer.parseInt(dm.getPiutang())));
        holder1.persediaan.setText(formatter.format(Integer.parseInt(dm.getPersediaan())));
        holder1.inventaris.setText(formatter.format(Integer.parseInt(dm.getInventaris())));
        holder1.tanah_rumah.setText(formatter.format(Integer.parseInt(dm.getTanah())));
        holder1.total_keuangan.setText(formatter.format(Integer.parseInt(dm.getTotal_aktiva())));
        holder1.hutang_dagang.setText(formatter.format(Integer.parseInt(dm.getHutang_dagang())));
        holder1.hutang_bank.setText(formatter.format(Integer.parseInt(dm.getHutang_bank())));
        holder1.pinjaman.setText(formatter.format(Integer.parseInt(dm.getPinjaman())));

        holder1.modal.setText(formatter.format(Integer.parseInt(dm.getModal())));
        holder1.laba.setText(formatter.format(Integer.parseInt(dm.getLaba())));
        holder1.total_pasiva.setText(formatter.format(Integer.parseInt(dm.getTotal_pasiva())));
        holder1.pendapatan_usaha.setText(formatter.format(Integer.parseInt(dm.getPendapatan_usaha())));
        holder1.biaya_usaha.setText(formatter.format(Integer.parseInt(dm.getBiaya_usaha())));
        holder1.laba_usaha.setText(formatter.format(Integer.parseInt(dm.getLaba_usaha())));
        holder1.pendapatan_lain.setText(formatter.format(Integer.parseInt(dm.getPendapatan_lain())));
        holder1.total_pendapatan.setText(formatter.format(Integer.parseInt(dm.getTotal_pendapatan())));

        holder1.biaya_rumah_tangga.setText(formatter.format(Integer.parseInt((dm.getBiaya_rumah_tangga()))));
        holder1.biaya_listrik.setText(formatter.format(Integer.parseInt(dm.getBiaya_listrik())));
        holder1.biaya_pendidikan.setText(formatter.format(Integer.parseInt(dm.getBiaya_pendidikan())));
        holder1.biaya_transportasi.setText(formatter.format(Integer.parseInt(dm.getBiaya_transportasi())));
        holder1.biaya_sosial.setText(formatter.format(Integer.parseInt(dm.getBiaya_sosial())));
        holder1.angsuran_bank1.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bank1())));
        holder1.angsuran_bank2.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bank2())));
        holder1.angsuran_bank3.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bank3())));
        holder1.angsuran_bank4.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bank4())));
        holder1.angsuran_bank5.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bank5())));
        holder1.angsuran_bank6.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bank6())));
        holder1.biaya_lainnya.setText(formatter.format(Integer.parseInt(dm.getBiaya_lainnya())));
        holder1.total_biaya.setText(formatter.format(Integer.parseInt(dm.getTotal_biaya())));


        //Aspek Pemasaran
        holder1.kelola_usaha.setText(dm.getKelola_usaha());
        holder1.persaingan_usaha.setText(dm.getPersaingan_usaha());
        holder1.pemasaran_usaha.setText(dm.getPemasaran_usaha());
        holder1.amdal_usaha.setText(dm.getAmdal_usaha());
        holder1.prospek_usaha.setText(dm.getProspek_usaha());


        //Aspek Karakter
        holder1.fasilitas_kredit_ke1.setText(dm.getFasilitas_ke());
        holder1.kondite_kredit_lalu.setText(dm.getKondite_kredit_lalu());
        holder1.referensi.setText(dm.getReferensi());
        holder1.info_lingkungan.setText(dm.getInfo_lingkungan());
        holder1.avalis_kredit.setText(dm.getAvalis_kredit());
        holder1.karakter_lainnya.setText(dm.getKarakter_lainnya());


        //Aspek hukum
        holder1.dasar_hukum.setText(dm.getDasar_hukum());
        holder1.nomor_KID.setText(dm.getNo_ktp());
        holder1.legalitas_identitas.setText(dm.getLegalitas_identitas());
        holder1.masa_berlaku_KID.setText(dm.getMasa_berlaku_ktp());
        holder1.akad_kredit1.setText(dm.getAkad_kredit());
        holder1.asuransiii.setText(dm.getNama_asuransi());

        holder1.plafond_kredit1.setText(formatter.format(Integer.parseInt(dm.getPlafond_kredit())));
        holder1.tujuan_penggunaan1.setText(dm.getTujuan_penggunaan());
        holder1.tujuan_modal.setText(formatter.format(Integer.parseInt(dm.getTujuan_modal())));
        holder1.tujuan_pelunasan.setText(formatter.format(Integer.parseInt(dm.getTujuan_pelunasan())));
        holder1.tujuan_pembelian.setText(formatter.format(Integer.parseInt(dm.getTujuan_pembelian())));
        holder1.tujuan_renovasi.setText(formatter.format(Integer.parseInt(dm.getTujuan_renovasi())));
        holder1.tujuan_sekolah.setText(formatter.format(Integer.parseInt(dm.getTujuan_sekolah())));
        holder1.tujuan_lainnya.setText(formatter.format(Integer.parseInt(dm.getTujuan_lainya())));
        holder1.total_kebutuhan.setText(formatter.format(Integer.parseInt(dm.getTotal_kebutuhan())));
        holder1.kas1.setText(formatter.format(Integer.parseInt(dm.getKas())));
        holder1.kebutuhan_bank.setText(formatter.format(Integer.parseInt(dm.getKebutuhan_bank())));
        holder1.dibulatkan_menjadi.setText(formatter.format(Integer.parseInt(dm.getKebutuhan_bank())));

        holder1.plafond_kredit2.setText(formatter.format(Integer.parseInt(dm.getPlafond_kredit())));
        holder1.laba2.setText(formatter.format(Integer.parseInt(dm.getLaba())));
        holder1.angsuran_bunga_pertama2.setText(formatter.format(Integer.parseInt(dm.getAngsuran_bunga_pertama())));
        holder1.dana_angsuran.setText(formatter.format(Double.parseDouble(dm.getDana_angsuran())));
        holder1.jkw_x1.setText(dm.getJkw_x1());
        holder1.jkw2.setText(bulan.format(Integer.parseInt(dm.getJkw())));






        holder1.dm = dm;
    }

    private TableLayout findViewById(int tabLayout_shm1) {
        return null;
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class HolderData extends RecyclerView.ViewHolder {
        TextView tgl_permohonan, no_reg, nama_pemohon, nama_panggilan, tempat_lahir, tgl_lahir, jenis_kelamin, no_ktp,
                masa_berlaku_ktp, alamat_sesuai_ktp, nama_ibu_kandung, kode_pos, pekerjaan_pemohon, nama_perusahaan, jabatan,
                alamat_perusahaan,status_pernikahan, jml_tanggungan, pendidikan_terakhir, status_rumah_tinggal, lama_tinggal,
                alamat_rumah_tinggal, no_telp, no_hp, nama_pasangan, tgl_lahir_pasangan, no_ktp_pasangan, masa_berlaku_ktp_pasangan,
                pekerjaan_pasangan, tempat_lahir_pasangan, alamat_pasangan, penghasilan_per_bln, penjamin, alamat_penjamin,
                tempat_lahir_penjamin, tgl_lahir_penjamin, no_ktp_penjamin, masa_berlaku_ktp_penjamin,
                nama_pasangan_penjamin, alamat_pasangan_penjamin, tempat_lahir_pasangan_penjamin, tgl_lahir_pasangan_penjamin,
                no_ktp_pasangan_penjamin, masa_berlaku_ktp_pasangan_penjamin,

                //Data_kredit
                jenis_kredit, sektor_ekonomi, fasilitas_ke,  plafond_kredit,  jkw,  bunga,  type_angsuran,  periode_pembayaran_pokok,
                jml_angsuran_per_bln, angsuran_pokok_pertama,  angsuran_bunga_pertama,  provisi, administrasi,
                on_the_spot,  premi,  nama_asuransi, akad_kredit,  jenis_penggunaan, tujuan_penggunaan, surveyor,

        tabLayout_shm1, nama_jaminan_shm1, jenis_jaminan_shm1, atas_nama_shm1, alamat_atas_nama_shm1, no_ktp_atas_nama_shm1, masa_berlaku_shm1,
                ikatan_shm1, nilai_ikatan_shm1, no_SHM1, no_gs_shm1, luas_shm1, lokasi_shm1, asuransi_shm1, nilai_tanah_shm1,
                nilai_bangunan_shm1, total_taksiran_shm1,

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
                nama_jaminan_bpkb1, no_bpkb1, merk_bpkb1, tahun_bpkb1, no_rangka_bpkb1, no_mesin_bpkb1, warna_bpkb1, nopol_bpkb1,
                atas_nama_bpkb1, alamat_bpkb1,
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
                nama_jaminand1, nama_deposito1, no_bilyet1, alamatd1, pengikat_jaminand1, deposito1, total_nilai_jaminan1,
                persen_dari_plafond1,

        //Aspek Jaminan BILYET Deposito 2
                nama_jaminand2, nama_deposito2, no_bilyet2, alamatd2, pengikat_jaminand2, deposito2, total_nilai_jaminan2, persen_dari_plafond2,

        //Aspek Jaminan BILYET Deposito 3
                nama_jaminand3, nama_deposito3, no_bilyet3, alamatd3, pengikat_jaminand3, deposito3, total_nilai_jaminan3, persen_dari_plafond3,

        //Aspek Kapasitas
                pekerjaank, nama_perusahaan1, alamat_usaha, lama_usaha, uraian_kegiatan_usaha_utama,uraian_kegiatan_usaha_lainnya, uraian_kegiatan_usaha_lainnya1, uraian_kegiatan_usaha_sampingan,
                uraian_kegiatan_usaha_pasangan, kondisi_fisik, kesimpulan,

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
                plafond_kredit2, laba2, angsuran_bunga_pertama2, dana_angsuran, jkw_x1, jkw2 ;

        DataModel dm;

        public HolderData(View v) {
            super(v);


            nama_pemohon = v.findViewById(R.id.tvNama_pemohon);
            tgl_permohonan = v.findViewById(R.id.tvtgl_permohonan);
            no_reg = v.findViewById(R.id.tvNo_reg);
            nama_panggilan = v.findViewById(R.id.tvNama_panggilan);
            tempat_lahir = v.findViewById(R.id.tvTempat_lahir);
            tgl_lahir = v.findViewById(R.id.tvTgl_lahir);
            jenis_kelamin = v.findViewById(R.id.tvJenis_kelamin);
            no_ktp = v.findViewById(R.id.tvNo_ktp);
            masa_berlaku_ktp = v.findViewById(R.id.tvMasa_berlaku_ktp);
            alamat_sesuai_ktp = v.findViewById(R.id.tvAlamat_sesuai_ktp);
            nama_ibu_kandung = v.findViewById(R.id.tvNama_ibu_kandung);
            kode_pos = v.findViewById(R.id.tvKode_pos);
            pekerjaan_pemohon = v.findViewById(R.id.tvPekerjaan_pemohon);
            nama_perusahaan = v.findViewById(R.id.tvNama_perusahaan);
            jabatan = v.findViewById(R.id.tvJabatan);
            alamat_perusahaan = v.findViewById(R.id.tvAlamat_perusahaan);
            status_pernikahan = v.findViewById(R.id.tvStatus_pernikahaan);
            jml_tanggungan = v.findViewById(R.id.tvjml_tanggungan);
            pendidikan_terakhir = v.findViewById(R.id.tvPendidikan_terakhir);
            status_rumah_tinggal = v.findViewById(R.id.tvStatus_rumah_tinggal);
            lama_tinggal = v.findViewById(R.id.tvLama_tinggal);
            alamat_rumah_tinggal = v.findViewById(R.id.tvAlamat_rumah_tinggal);
            no_telp = v.findViewById(R.id.tvNo_telp);
            no_hp = v.findViewById(R.id.tvNo_HP);
            nama_pasangan = v.findViewById(R.id.tvNama_pasangan);
            tgl_lahir_pasangan = v.findViewById(R.id.tvTgl_lahir_pasangan);
            no_ktp_pasangan = v.findViewById(R.id.tvNo_ktp_pasangan);
            masa_berlaku_ktp_pasangan = v.findViewById(R.id.tvMasa_berlaku_ktp_pasangan);
            pekerjaan_pasangan = v.findViewById(R.id.tvPekerjaan_pasangan);
            tempat_lahir_pasangan = v.findViewById(R.id.tvTempat_lahir_pasangan);
            alamat_pasangan = v.findViewById(R.id.tvAlamat_pasangan);
            penghasilan_per_bln = v.findViewById(R.id.tvPenghasilan_per_bulan);
            penjamin = v.findViewById(R.id.tvPenjamin);
            alamat_penjamin = v.findViewById(R.id.tvAlamat_penjamin);
            tempat_lahir_penjamin = v.findViewById(R.id.tvTempat_lahir_penjamin);
            tgl_lahir_penjamin = v.findViewById(R.id.tvTgl_lahir_penjamin);
            no_ktp_penjamin = v.findViewById(R.id.tvNo_ktp_penjamin);
            masa_berlaku_ktp_penjamin = v.findViewById(R.id.tvMasa_berlaku_ktp_penjamin);
            nama_pasangan_penjamin = v.findViewById(R.id.tvNama_pasangan_penjamin);
            alamat_pasangan_penjamin = v.findViewById(R.id.tvAlamat_pasangan_penjamin);
            tempat_lahir_pasangan_penjamin = v.findViewById(R.id.tvTempat_lahir_pasangan_penjamin);
            tgl_lahir_pasangan_penjamin = v.findViewById(R.id.tvTgl_lahir_pasangan_penjamin);
            no_ktp_pasangan_penjamin = v.findViewById(R.id.tvNo_ktp_pasangan_penjamin);
            masa_berlaku_ktp_pasangan_penjamin = v.findViewById(R.id.tvMasa_berlaku_ktp_pasangan_penjamin);

            jenis_kredit = v.findViewById(R.id.tvJenis_kredit);
            sektor_ekonomi = v.findViewById(R.id.tvSektor_ekonomi);
            fasilitas_ke = v.findViewById(R.id.tvFasilitas_ke);
            plafond_kredit = v.findViewById(R.id.tvPlafond_kredit);
            jkw = v.findViewById(R.id.tvJkw);
            bunga = v.findViewById(R.id.tvBunga);
            type_angsuran = v.findViewById(R.id.tvType_angsuran);
            periode_pembayaran_pokok = v.findViewById(R.id.tvPeriode_pembayaran_pokok);
            jml_angsuran_per_bln = v.findViewById(R.id.tvJml_angsuran_per_bulan);
            angsuran_pokok_pertama = v.findViewById(R.id.tvAngsuran_pokok_pertama);
            angsuran_bunga_pertama = v.findViewById(R.id.tvAngsuran_bunga_pertama);
            provisi = v.findViewById(R.id.tvProvisi);
            administrasi = v.findViewById(R.id.tvAdministrasi);
            on_the_spot = v.findViewById(R.id.tvOn_the_spot);
            premi = v.findViewById(R.id.tvPremi);
            nama_asuransi = v.findViewById(R.id.tvNama_asuransi);
            akad_kredit = v.findViewById(R.id.tvAkad_kredit);
            jenis_penggunaan = v.findViewById(R.id.tvJenis_penggunaan);
            tujuan_penggunaan = v.findViewById(R.id.tvTujuan_Penggunaan);
            surveyor = v.findViewById(R.id.tvSuveyor);





               //tabLayout_shm1 = v.findViewById(R.id.tabLayout_shm1);
                //tabLayout_shm1.setVisibility(View.GONE);
                nama_jaminan_shm1 = v.findViewById(R.id.tvNama_jaminan1);
                jenis_jaminan_shm1 = v.findViewById(R.id.tvjenis_jaminan1);
                atas_nama_shm1 = v.findViewById(R.id.tvatas_nama_jaminan1);
                alamat_atas_nama_shm1 = v.findViewById(R.id.tvAlamat_atas_nama_shm1);
                no_ktp_atas_nama_shm1 = v.findViewById(R.id.tvno_ktp_atas_nama_shm1);
                masa_berlaku_shm1 = v.findViewById(R.id.tvmasa_berlaku_shm1);
                ikatan_shm1 = v.findViewById(R.id.tvpengikat_jaminan_shm1);
                nilai_ikatan_shm1 = v.findViewById(R.id.tvhak_tanggungan1);
                no_SHM1 = v.findViewById(R.id.tvno_shm1);
                no_gs_shm1 = v.findViewById(R.id.tvno_gs1);
                luas_shm1 = v.findViewById(R.id.tvluas1);
                lokasi_shm1 = v.findViewById(R.id.tvlokasi1);
                asuransi_shm1 = v.findViewById(R.id.tvasuransi1);
                nilai_tanah_shm1 = v.findViewById(R.id.tvharga_tanah1);
                nilai_bangunan_shm1 = v.findViewById(R.id.tvharga_bangunan1);
                total_taksiran_shm1 = v.findViewById(R.id.tvtotal_taksiran1);

            /*String stanah = nama_jaminan_shm1.getText().toString();
            if(stanah != "") {
                TableLayout a = v.findViewById(R.id.tabLayout_shm1);
                a.setVisibility(View.GONE);
            } else {
                TableLayout a = v.findViewById(R.id.tabLayout_shm1);
                a.setVisibility(View.VISIBLE);
            }

             */




            nama_jaminan_shm2 = v.findViewById(R.id.tvNama_jaminan2);
            jenis_jaminan_shm2 = v.findViewById(R.id.tvjenis_jaminan2);
            atas_nama_shm2 = v.findViewById(R.id.tvatas_nama_jaminan2);
            alamat_atas_nama_shm2 = v.findViewById(R.id.tvAlamat_atas_nama_shm2);
            no_ktp_atas_nama_shm2 = v.findViewById(R.id.tvno_ktp_atas_nama_shm2);
            masa_berlaku_shm2 = v.findViewById(R.id.tvmasa_berlaku_shm2);
            ikatan_shm2 = v.findViewById(R.id.tvpengikat_jaminan_shm2);
            nilai_ikatan_shm2 = v.findViewById(R.id.tvhak_tanggungan2);
            no_SHM2 = v.findViewById(R.id.tvno_shm2);
            no_gs_shm2 = v.findViewById(R.id.tvno_gs2);
            luas_shm2 = v.findViewById(R.id.tvluas2);
            lokasi_shm2 = v.findViewById(R.id.tvlokasi2);
            asuransi_shm2 = v.findViewById(R.id.tvasuransi2);
            nilai_tanah_shm2 = v.findViewById(R.id.tvharga_tanah2);
            nilai_bangunan_shm2 = v.findViewById(R.id.tvharga_bangunan2);
            total_taksiran_shm2 = v.findViewById(R.id.tvtotal_taksiran2);


            nama_jaminan_shm3 = v.findViewById(R.id.tvNama_jaminan3);
            jenis_jaminan_shm3 = v.findViewById(R.id.tvjenis_jaminan3);
            atas_nama_shm3 = v.findViewById(R.id.tvatas_nama_jaminan3);
            alamat_atas_nama_shm3 = v.findViewById(R.id.tvAlamat_atas_nama_shm3);
            no_ktp_atas_nama_shm3 = v.findViewById(R.id.tvno_ktp_atas_nama_shm3);
            masa_berlaku_shm3 = v.findViewById(R.id.tvmasa_berlaku_shm3);
            ikatan_shm3 = v.findViewById(R.id.tvpengikat_jaminan_shm3);
            nilai_ikatan_shm3 = v.findViewById(R.id.tvhak_tanggungan3);
            no_SHM3 = v.findViewById(R.id.tvno_shm3);
            no_gs_shm3 = v.findViewById(R.id.tvno_gs3);
            luas_shm3 = v.findViewById(R.id.tvluas3);
            lokasi_shm3 = v.findViewById(R.id.tvlokasi3);
            asuransi_shm3 = v.findViewById(R.id.tvasuransi3);
            nilai_tanah_shm3 = v.findViewById(R.id.tvharga_tanah3);
            nilai_bangunan_shm3 = v.findViewById(R.id.tvharga_bangunan3);
            total_taksiran_shm3 = v.findViewById(R.id.tvtotal_taksiran3);

            nama_jaminan_shm4 = v.findViewById(R.id.tvNama_jaminan4);
            jenis_jaminan_shm4 = v.findViewById(R.id.tvjenis_jaminan4);
            atas_nama_shm4 = v.findViewById(R.id.tvatas_nama_jaminan4);
            alamat_atas_nama_shm4 = v.findViewById(R.id.tvAlamat_atas_nama_shm4);
            no_ktp_atas_nama_shm4 = v.findViewById(R.id.tvno_ktp_atas_nama_shm4);
            masa_berlaku_shm4 = v.findViewById(R.id.tvmasa_berlaku_shm4);
            ikatan_shm4 = v.findViewById(R.id.tvpengikat_jaminan_shm4);
            nilai_ikatan_shm4 = v.findViewById(R.id.tvhak_tanggungan4);
            no_SHM4 = v.findViewById(R.id.tvno_shm4);
            no_gs_shm4 = v.findViewById(R.id.tvno_gs4);
            luas_shm4 = v.findViewById(R.id.tvluas4);
            lokasi_shm4 = v.findViewById(R.id.tvlokasi4);
            asuransi_shm4 = v.findViewById(R.id.tvasuransi4);
            nilai_tanah_shm4 = v.findViewById(R.id.tvharga_tanah4);
            nilai_bangunan_shm4 = v.findViewById(R.id.tvharga_bangunan4);
            total_taksiran_shm4 = v.findViewById(R.id.tvtotal_taksiran4);

            nama_jaminan_shm5 = v.findViewById(R.id.tvNama_jaminan5);
            jenis_jaminan_shm5 = v.findViewById(R.id.tvjenis_jaminan5);
            atas_nama_shm5 = v.findViewById(R.id.tvatas_nama_jaminan5);
            alamat_atas_nama_shm5 = v.findViewById(R.id.tvAlamat_atas_nama_shm5);
            no_ktp_atas_nama_shm5 = v.findViewById(R.id.tvno_ktp_atas_nama_shm5);
            masa_berlaku_shm5 = v.findViewById(R.id.tvmasa_berlaku_shm5);
            ikatan_shm5 = v.findViewById(R.id.tvpengikat_jaminan_shm5);
            nilai_ikatan_shm5 = v.findViewById(R.id.tvhak_tanggungan5);
            no_SHM5 = v.findViewById(R.id.tvno_shm5);
            no_gs_shm5 = v.findViewById(R.id.tvno_gs5);
            luas_shm5 = v.findViewById(R.id.tvluas5);
            lokasi_shm5 = v.findViewById(R.id.tvlokasi5);
            asuransi_shm5 = v.findViewById(R.id.tvasuransi5);
            nilai_tanah_shm5 = v.findViewById(R.id.tvharga_tanah5);
            nilai_bangunan_shm5 = v.findViewById(R.id.tvharga_bangunan5);
            total_taksiran_shm5 = v.findViewById(R.id.tvtotal_taksiran5);

            //BPKB
            nama_jaminan_bpkb1 = v.findViewById(R.id.tvNama_jaminan_bpkb1);
            no_bpkb1 = v.findViewById(R.id.tvno_bpkb1);
            merk_bpkb1 = v.findViewById(R.id.tvMerk1);
            tahun_bpkb1 = v.findViewById(R.id.tvtahun1);
            no_rangka_bpkb1 = v.findViewById(R.id.tvno_rangka1);
            no_mesin_bpkb1 = v.findViewById(R.id.tvno_mesin1);
            warna_bpkb1 = v.findViewById(R.id.tvwarna1);
            nopol_bpkb1 = v.findViewById(R.id.tvno_polisi1);
            atas_nama_bpkb1 = v.findViewById(R.id.tvatas_nama_bpkb1);
            alamat_bpkb1 = v.findViewById(R.id.tvalamat_bpkb1);
            ikatan_bpkb1 = v.findViewById(R.id.tvpengikat_jaminan_bpkb1);
            nilai_fiducia1 = v.findViewById(R.id.tvnilai_fiducia1);
            nilai_taksiran_bpkb1 = v.findViewById(R.id.tvtaksiran_harga_motor1);


            //BPKB
            nama_jaminan_bpkb2 = v.findViewById(R.id.tvNama_jaminan_bpkb2);
            no_bpkb2 = v.findViewById(R.id.tvno_bpkb2);
            merk_bpkb2 = v.findViewById(R.id.tvMerk2);
            tahun_bpkb2 = v.findViewById(R.id.tvtahun2);
            no_rangka_bpkb2 = v.findViewById(R.id.tvno_rangka2);
            no_mesin_bpkb2 = v.findViewById(R.id.tvno_mesin2);
            warna_bpkb2 = v.findViewById(R.id.tvwarna2);
            nopol_bpkb2 = v.findViewById(R.id.tvno_polisi2);
            atas_nama_bpkb2 = v.findViewById(R.id.tvatas_nama_bpkb2);
            alamat_bpkb2 = v.findViewById(R.id.tvalamat_bpkb2);
            ikatan_bpkb2 = v.findViewById(R.id.tvpengikat_jaminan_bpkb2);
            nilai_fiducia2 = v.findViewById(R.id.tvnilai_fiducia2);
            nilai_taksiran_bpkb2 = v.findViewById(R.id.tvtaksiran_harga_motor2);

            //BPKB
            nama_jaminan_bpkb3 = v.findViewById(R.id.tvNama_jaminan_bpkb3);
            no_bpkb3 = v.findViewById(R.id.tvno_bpkb3);
            merk_bpkb3 = v.findViewById(R.id.tvMerk3);
            tahun_bpkb3 = v.findViewById(R.id.tvtahun3);
            no_rangka_bpkb3 = v.findViewById(R.id.tvno_rangka3);
            no_mesin_bpkb3 = v.findViewById(R.id.tvno_mesin3);
            warna_bpkb3 = v.findViewById(R.id.tvwarna3);
            nopol_bpkb3 = v.findViewById(R.id.tvno_polisi3);
            atas_nama_bpkb3 = v.findViewById(R.id.tvatas_nama_bpkb3);
            alamat_bpkb3 = v.findViewById(R.id.tvalamat_bpkb3);
            ikatan_bpkb3 = v.findViewById(R.id.tvpengikat_jaminan_bpkb3);
            nilai_fiducia3 = v.findViewById(R.id.tvnilai_fiducia3);
            nilai_taksiran_bpkb3 = v.findViewById(R.id.tvtaksiran_harga_motor_bpkb3);

            //BPKB
            nama_jaminan_bpkb4 = v.findViewById(R.id.tvNama_jaminan_bpkb4);
            no_bpkb4 = v.findViewById(R.id.tvno_bpkb4);
            merk_bpkb4 = v.findViewById(R.id.tvMerk4);
            tahun_bpkb4 = v.findViewById(R.id.tvtahun4);
            no_rangka_bpkb4 = v.findViewById(R.id.tvno_rangka4);
            no_mesin_bpkb4 = v.findViewById(R.id.tvno_mesin4);
            warna_bpkb4 = v.findViewById(R.id.tvwarna4);
            nopol_bpkb4 = v.findViewById(R.id.tvno_polisi4);
            atas_nama_bpkb4 = v.findViewById(R.id.tvatas_nama_bpkb4);
            alamat_bpkb4 = v.findViewById(R.id.tvalamat_bpkb4);
            ikatan_bpkb4 = v.findViewById(R.id.tvpengikat_jaminan_bpkb4);
            nilai_fiducia4 = v.findViewById(R.id.tvnilai_fiducia4);
            nilai_taksiran_bpkb4 = v.findViewById(R.id.tvtaksiran_harga_motor4);

            //BPKB
            nama_jaminan_bpkb5 = v.findViewById(R.id.tvNama_jaminan_bpkb5);
            no_bpkb5 = v.findViewById(R.id.tvno_bpkb5);
            merk_bpkb5 = v.findViewById(R.id.tvMerk5);
            tahun_bpkb5 = v.findViewById(R.id.tvtahun5);
            no_rangka_bpkb5 = v.findViewById(R.id.tvno_rangka5);
            no_mesin_bpkb5 = v.findViewById(R.id.tvno_mesin5);
            warna_bpkb5 = v.findViewById(R.id.tvwarna5);
            nopol_bpkb5 = v.findViewById(R.id.tvno_polisi5);
            atas_nama_bpkb5 = v.findViewById(R.id.tvatas_nama_bpkb5);
            alamat_bpkb5 = v.findViewById(R.id.tvalamat_bpkb5);
            ikatan_bpkb5 = v.findViewById(R.id.tvpengikat_jaminan_bpkb5);
            nilai_fiducia5 = v.findViewById(R.id.tvnilai_fiducia5);
            nilai_taksiran_bpkb5 = v.findViewById(R.id.tvtaksiran_harga_motor5);

            //Deposito
            nama_jaminand1 = v.findViewById(R.id.tvdeposito_berjangka1);
            nama_deposito1 = v.findViewById(R.id.tvatas_nama1);
            no_bilyet1 = v.findViewById(R.id.tvno_bilyet1);
            alamatd1 = v.findViewById(R.id.tvalamat_deposito1);
            pengikat_jaminand1 = v.findViewById(R.id.tvpengikat_jaminan_deposito1);
            deposito1 = v.findViewById(R.id.tvbesar_deposito1);
            total_nilai_jaminan1 = v.findViewById(R.id.tvtotal_nilai_jaminan1);
            persen_dari_plafond1 = v.findViewById(R.id.tvdari_palfond1);

            //Deposito 2
            nama_jaminand2 = v.findViewById(R.id.tvdeposito_berjangka_deposito2);
            nama_deposito2 = v.findViewById(R.id.tvatas_nama_deposito2);
            no_bilyet2 = v.findViewById(R.id.tvno_bilyet_deposito2);
            alamatd2 = v.findViewById(R.id.tvalamat_deposito2);
            pengikat_jaminand2 = v.findViewById(R.id.tvpengikat_jaminan_deposito2);
            deposito2 = v.findViewById(R.id.tvbesar_deposito2);
            total_nilai_jaminan2 = v.findViewById(R.id.tvtotal_nilai_jaminan_deposito2);
            persen_dari_plafond2 = v.findViewById(R.id.tvdari_palfond_deposito2);

            //Deposito 2
            nama_jaminand3 = v.findViewById(R.id.tvdeposito_berjangka_deposito3);
            nama_deposito3 = v.findViewById(R.id.tvatas_nama_deposito3);
            no_bilyet3 = v.findViewById(R.id.tvno_bilyet_deposito3);
            alamatd3 = v.findViewById(R.id.tvalamat_deposito3);
            pengikat_jaminand3 = v.findViewById(R.id.tvpengikat_jaminan_deposito3);
            deposito3 = v.findViewById(R.id.tvbesar_deposito3);
            total_nilai_jaminan3 = v.findViewById(R.id.tvtotal_nilai_jaminan_deposito3);
            persen_dari_plafond3 = v.findViewById(R.id.tvdari_palfond_deposito3);

            //Aspek Kapasitaas
            pekerjaank = v.findViewById(R.id.tvpekerjaan);
            nama_perusahaan1 = v.findViewById(R.id.tvnama_perusahaan);
            alamat_usaha = v.findViewById(R.id.tvalamat_usaha);
            lama_usaha = v.findViewById(R.id.tvlama_usaha);
            uraian_kegiatan_usaha_utama = v.findViewById(R.id.tvuraian_kegiatan_usaha_utama);
            uraian_kegiatan_usaha_lainnya = v.findViewById(R.id.tvuraian_kegiatan_usaha_lainnya);
            uraian_kegiatan_usaha_lainnya1 = v.findViewById(R.id.tvuraian_kegiatan_usaha_lainnya1);
            uraian_kegiatan_usaha_sampingan = v.findViewById(R.id.tvuraian_kegiatan_sampingan);
            uraian_kegiatan_usaha_pasangan = v.findViewById(R.id.tvuraian_kegiatan_usaha_pasangan);
            kondisi_fisik = v.findViewById(R.id.tvkondisi);
            kesimpulan = v.findViewById(R.id.tvkesimpulan);

            //Aspek Keuangan
            kas = v.findViewById(R.id.tvKas);
            piutang = v.findViewById(R.id.tvpiutang);
            persediaan = v.findViewById(R.id.tvpersediaan);
            inventaris = v.findViewById(R.id.tvinventasi);
            tanah_rumah = v.findViewById(R.id.tvtanah_rumah);
            total_keuangan = v.findViewById(R.id.tvtotal_aktiva);
            hutang_dagang = v.findViewById(R.id.tvhutang_dagang);
            hutang_bank = v.findViewById(R.id.tvhutang_bank);
            pinjaman = v.findViewById(R.id.tvpinjaman);
            modal = v.findViewById(R.id.tvmodal);
            laba = v.findViewById(R.id.tvlaba_usaha);

            total_pasiva = v.findViewById(R.id.tvtotal_pasiva);
            pendapatan_usaha = v.findViewById(R.id.tvpendapatan_usaha_pertanian);
            biaya_usaha = v.findViewById(R.id.tvbiaya_usaha);
            laba_usaha = v.findViewById(R.id.tvlaba_usaha1);
            pendapatan_lain = v.findViewById(R.id.tvpendapatan_lain);
            total_pendapatan = v.findViewById(R.id.tvtotal_pendapatan);
            biaya_rumah_tangga = v.findViewById(R.id.tvbiaya_rumah_tangga);
            biaya_listrik = v.findViewById(R.id.tvbiaya_listrik);
            biaya_pendidikan = v.findViewById(R.id.tvbiaya_pendidikan);
            biaya_transportasi = v.findViewById(R.id.tvbiaya_transportasi);
            biaya_sosial = v.findViewById(R.id.tvbiaya_sosial);

            angsuran_bank1 = v.findViewById(R.id.tvangsuran_bank1);
            angsuran_bank2 = v.findViewById(R.id.tvangsuran_bank2);
            angsuran_bank3 = v.findViewById(R.id.tvangsuran_bank3);
            angsuran_bank4 = v.findViewById(R.id.tvangsuran_bank4);
            angsuran_bank5 = v.findViewById(R.id.tvangsuran_bank5);
            angsuran_bank6 = v.findViewById(R.id.tvangsuran_bank6);
            biaya_lainnya = v.findViewById(R.id.tvbiaya_lainnya);
            total_biaya = v.findViewById(R.id.tvtotal_biaya);

            //Pemasaran
            kelola_usaha = v.findViewById(R.id.tvkelola_usaha);
            persaingan_usaha = v.findViewById(R.id.tvpersaingan_usaha);
            pemasaran_usaha = v.findViewById(R.id.tvpemasaran_usaha);
            amdal_usaha = v.findViewById(R.id.tvamdal_usaha);
            prospek_usaha = v.findViewById(R.id.tvprospek_usaha);

            // Aspek Karakter
            fasilitas_kredit_ke1 = v.findViewById(R.id.tvpeminjam_kredit);
            kondite_kredit_lalu = v.findViewById(R.id.tvkondite_kredit_yang_lalu);
            referensi = v.findViewById(R.id.tvreferensi_dari);
            info_lingkungan = v.findViewById(R.id.tvinfo_lingkungan);
            avalis_kredit = v.findViewById(R.id.tvavalis_kredit);
            karakter_lainnya = v.findViewById(R.id.tvlainnya);

            //Aspek Hukum
            dasar_hukum = v.findViewById(R.id.tvdasar_kartu_identitas);
            nomor_KID = v.findViewById(R.id.tvnomor_kid);
            legalitas_identitas = v.findViewById(R.id.tvlegalitas_kid);
            masa_berlaku_KID = v.findViewById(R.id.tvmasa_berlaku_kid);
            akad_kredit1 = v.findViewById(R.id.tvakad_kredit);
            asuransiii = v.findViewById(R.id.tvasuransi);

            // Analisa Kebutuhan
            plafond_kredit1 = v.findViewById(R.id.tvPlafond_kredit1);
            tujuan_penggunaan1 = v.findViewById(R.id.tvtujuan_penggunaan);
            tujuan_modal = v.findViewById(R.id.tvtujuan_modal);
            tujuan_pelunasan = v.findViewById(R.id.tvtujuan_pelunasan);
            tujuan_pembelian = v.findViewById(R.id.tvtujuan_pembelian);
            tujuan_renovasi = v.findViewById(R.id.tvtujuan_renovasi);
            tujuan_sekolah = v.findViewById(R.id.tvtujuan_sekolah);
            tujuan_lainnya = v.findViewById(R.id.tvtujuan_lainnya);
            total_kebutuhan = v.findViewById(R.id.tvtotal_kebutuhan);
            kas1 = v.findViewById(R.id.tvkas1);
            kebutuhan_bank = v.findViewById(R.id.tvkebutuhan_bank);
            dibulatkan_menjadi = v.findViewById(R.id.tvdibulatkan_menjadi);

            //Analisa Jangka Waktu
            plafond_kredit2 = v.findViewById(R.id.tvrencana_plafond_kredit);
            laba2 = v.findViewById(R.id.tvpendapatan_bersih_perbulan);
            angsuran_bunga_pertama2 = v.findViewById(R.id.tvbeban_bunga_maksimal);
            dana_angsuran = v.findViewById(R.id.tvdana_untuk_angsuran_pokok_kredit);
            jkw_x1 = v.findViewById(R.id.tvjkw_x1);
            jkw2 = v.findViewById(R.id.tvjkw_dibulatkan_menjadi);






        }

    }
}
