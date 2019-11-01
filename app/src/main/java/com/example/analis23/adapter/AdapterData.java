package com.example.analis23.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.analis23.MainActivity;
import com.example.analis23.R;
import com.example.analis23.model.DataModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hakiki95 on 4/16/2017.
 */

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<DataModel> mList ;
    private Context ctx;


    public  AdapterData (Context ctx, List<DataModel> mList)
    {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        DataModel dm = mList.get(position);
        holder.tgl_permohonan.setText(dm.getTgl_permohonan());
        holder.nama_pemohon.setText(dm.getNama_pemohon());
        holder.alamat_sesuai_ktp.setText(dm.getAlamat_sesuai_ktp());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    class HolderData extends  RecyclerView.ViewHolder{
        TextView nama_pemohon, tgl_permohonan, alamat_sesuai_ktp;
        DataModel dm;
        public HolderData (View v)
        {
            super(v);

             nama_pemohon =  (TextView) v.findViewById(R.id.tvNama_pemohon);
             tgl_permohonan = (TextView) v.findViewById(R.id.tvtgl_permohonan);
             alamat_sesuai_ktp =  (TextView) v.findViewById(R.id.tvAlamat_sesuai_ktp);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx, MainActivity.class);
                    goInput.putExtra("id", dm.getId());
                    goInput.putExtra("tgl_permohonan", dm.getTgl_permohonan());
                    goInput.putExtra("no_reg", dm.getNo_reg());
                    goInput.putExtra("nama_pemohon", dm.getNama_pemohon());
                    goInput.putExtra("nama_panggilan", dm.getNama_panggilan());
                    goInput.putExtra("tempat_lahir", dm.getTempat_lahir());
                    goInput.putExtra("tgl_lahir", dm.getTgl_lahir());
                    goInput.putExtra("jenis_kelamin", dm.getJenis_kelamin());
                    goInput.putExtra("no_ktp", dm.getNo_ktp());
                    goInput.putExtra("masa_berlaku_ktp", dm.getMasa_berlaku_ktp());
                    goInput.putExtra("alamat_sesuai_ktp", dm.getAlamat_sesuai_ktp());
                    goInput.putExtra("nama_ibu_kandung", dm.getNama_ibu_kandung());
                    goInput.putExtra("kode_pos", dm.getKode_pos());
                    goInput.putExtra("pekerjaan_pemohon", dm.getPekerjaan_pemohon());
                    goInput.putExtra("nama_perusahaan", dm.getNama_perusahaan());
                    goInput.putExtra("jabatan", dm.getJabatan());
                    goInput.putExtra("alamat_perusahaan", dm.getAlamat_perusahaan());
                    goInput.putExtra("status_pernikahan", dm.getStatus_pernikahan());
                    goInput.putExtra("jml_tanggungan", dm.getJml_tanggungan());
                    goInput.putExtra("pendidikan_terakhir", dm.getPendidikan_terakhir());
                    goInput.putExtra("status_rumah_tinggal", dm.getStatus_rumah_tinggal());
                    goInput.putExtra("lama_tinggal", dm.getLama_tinggal());
                    goInput.putExtra("alamat_rumah_tinggal", dm.getAlamat_rumah_tinggal());
                    goInput.putExtra("no_telp", dm.getNo_telp());
                    goInput.putExtra("no_hp", dm.getNo_hp());
                    goInput.putExtra("nama_pasangan", dm.getNama_pasangan());
                    goInput.putExtra("tgl_lahir_pasangan", dm.getTgl_lahir_pasangan());
                    goInput.putExtra("no_ktp_pasangan", dm.getNo_ktp_pasangan());
                    goInput.putExtra("masa_berlaku_ktp_pasangan", dm.getMasa_berlaku_ktp_pasangan());
                    goInput.putExtra("pekerjaan_pasangan", dm.getPekerjaan_pasangan());
                    goInput.putExtra("tempat_lahir_pasangan", dm.getTempat_lahir_pasangan());
                    goInput.putExtra("alamat_pasangan", dm.getAlamat_pasangan());
                    goInput.putExtra("penghasilan_per_bln", dm.getPenghasilan_per_bln());
                    goInput.putExtra("penjamin", dm.getPenjamin());
                    goInput.putExtra("alamat_penjamin", dm.getAlamat_penjamin());
                    goInput.putExtra("tempat_lahir_penjamin", dm.getTempat_lahir_penjamin());
                    goInput.putExtra("tgl_lahir_penjamin", dm.getTgl_lahir_penjamin());
                    goInput.putExtra("no_ktp_penjamin", dm.getNo_ktp_penjamin());
                    goInput.putExtra("masa_berlaku_ktp_penjamin", dm.getMasa_berlaku_ktp_penjamin());
                    goInput.putExtra("nama_pasangan_penjamin", dm.getNama_pasangan_penjamin());
                    goInput.putExtra("alamat_pasangan_penjamin", dm.getAlamat_pasangan_penjamin());
                    goInput.putExtra("tempat_lahir_pasangan_penjamin", dm.getTempat_lahir_pasangan_penjamin());
                    goInput.putExtra("tgl_lahir_pasangan_penjamin", dm.getTgl_lahir_pasangan_penjamin());
                    goInput.putExtra("no_ktp_pasangan_penjamin", dm.getNo_ktp_pasangan_penjamin());
                    goInput.putExtra("masa_berlaku_ktp_pasangan_penjamin", dm.getMasa_berlaku_ktp_pasangan_penjamin());

                    goInput.putExtra("jenis_kredit", dm.getJenis_kredit());
                    goInput.putExtra("sektor_ekonomi", dm.getSektor_ekonomi());
                    goInput.putExtra("fasilitas_ke", dm.getFasilitas_ke());
                    goInput.putExtra("plafond_kredit", dm.getPlafond_kredit());
                    goInput.putExtra("jkw", dm.getJkw());
                    goInput.putExtra("bunga", dm.getBunga());
                    goInput.putExtra("type_angsuran", dm.getType_angsuran());
                    goInput.putExtra("periode_pembayaran_pokok", dm.getPeriode_pembayaran_pokok());
                    goInput.putExtra("jml_angsuran_per_bln", dm.getJml_angsuran_per_bln());
                    goInput.putExtra("angsuran_pokok_pertama", dm.getAngsuran_pokok_pertama());
                    goInput.putExtra("angsuran_bunga_pertama", dm.getAngsuran_bunga_pertama());
                    goInput.putExtra("provisi", dm.getProvisi());
                    goInput.putExtra("administrasi", dm.getAdministrasi());
                    goInput.putExtra("on_the_spot", dm.getOn_the_spot());
                    goInput.putExtra("premi", dm.getPremi());
                    goInput.putExtra("nama_asuransi", dm.getNama_asuransi());
                    goInput.putExtra("akad_kredit", dm.getAkad_kredit());
                    goInput.putExtra("jenis_penggunaan", dm.getJenis_penggunaan());
                    goInput.putExtra("tujuan_penggunaan", dm.getTujuan_penggunaan());
                    goInput.putExtra("surveyor", dm.getSurveyor());

                    goInput.putExtra("no_reg1", dm.getNo_reg1());
                    goInput.putExtra("nama_jaminan_shm1", dm.getNama_jaminan_shm1());
                    goInput.putExtra("jenis_jaminan_shm1", dm.getJenis_jaminan_shm1());
                    goInput.putExtra("atas_nama_shm1", dm.getAtas_nama_shm1());
                    goInput.putExtra("alamat_atas_nama_shm1", dm.getAlamat_atas_nama_shm1());
                    goInput.putExtra("no_ktp_atas_nama_shm1", dm.getNo_ktp_atas_nama_shm1());
                    goInput.putExtra("masa_berlaku_shm1", dm.getMasa_berlaku_shm1());
                    goInput.putExtra("ikatan_shm1", dm.getIkatan_shm1());
                    goInput.putExtra("nilai_ikatan_shm1", dm.getNilai_ikatan_shm1());
                    goInput.putExtra("no_SHM1", dm.getNo_SHM1());
                    goInput.putExtra("no_gs_shm1", dm.getNo_gs_shm1());
                    goInput.putExtra("luas_shm1", dm.getLuas_shm1());
                    goInput.putExtra("lokasi_shm1", dm.getLokasi_shm1());
                    goInput.putExtra("asuransi_shm1", dm.getAsuransi_shm1());
                    goInput.putExtra("nilai_tanah_shm1", dm.getNilai_tanah_shm1());
                    goInput.putExtra("nilai_bangunan_shm1", dm.getNilai_bangunan_shm1());
                    goInput.putExtra("total_taksiran_shm1", dm.getTotal_taksiran_shm1());

                    goInput.putExtra("nama_jaminan_shm2", dm.getNama_jaminan_shm2());
                    goInput.putExtra("jenis_jaminan_shm2", dm.getJenis_jaminan_shm2());
                    goInput.putExtra("atas_nama_shm2", dm.getAtas_nama_shm2());
                    goInput.putExtra("alamat_atas_nama_shm2", dm.getAlamat_atas_nama_shm2());
                    goInput.putExtra("no_ktp_atas_nama_shm2", dm.getNo_ktp_atas_nama_shm2());
                    goInput.putExtra("masa_berlaku_shm2", dm.getMasa_berlaku_shm2());
                    goInput.putExtra("ikatan_shm2", dm.getIkatan_shm2());
                    goInput.putExtra("nilai_ikatan_shm2", dm.getNilai_ikatan_shm2());
                    goInput.putExtra("no_SHM2", dm.getNo_SHM2());
                    goInput.putExtra("no_gs_shm2", dm.getNo_gs_shm2());
                    goInput.putExtra("luas_shm2", dm.getLuas_shm2());
                    goInput.putExtra("lokasi_shm2", dm.getLokasi_shm2());
                    goInput.putExtra("asuransi_shm2", dm.getAsuransi_shm2());
                    goInput.putExtra("nilai_tanah_shm2", dm.getNilai_tanah_shm2());
                    goInput.putExtra("nilai_bangunan_shm2", dm.getNilai_bangunan_shm2());
                    goInput.putExtra("total_taksiran_shm2", dm.getTotal_taksiran_shm2());

                    goInput.putExtra("nama_jaminan_shm3", dm.getNama_jaminan_shm3());
                    goInput.putExtra("jenis_jaminan_shm3", dm.getJenis_jaminan_shm3());
                    goInput.putExtra("atas_nama_shm3", dm.getAtas_nama_shm3());
                    goInput.putExtra("alamat_atas_nama_shm3", dm.getAlamat_atas_nama_shm3());
                    goInput.putExtra("no_ktp_atas_nama_shm3", dm.getNo_ktp_atas_nama_shm3());
                    goInput.putExtra("masa_berlaku_shm3", dm.getMasa_berlaku_shm3());
                    goInput.putExtra("ikatan_shm3", dm.getIkatan_shm3());
                    goInput.putExtra("nilai_ikatan_shm3", dm.getNilai_ikatan_shm3());
                    goInput.putExtra("no_SHM3", dm.getNo_SHM3());
                    goInput.putExtra("no_gs_shm3", dm.getNo_gs_shm3());
                    goInput.putExtra("luas_shm3", dm.getLuas_shm3());
                    goInput.putExtra("lokasi_shm3", dm.getLokasi_shm3());
                    goInput.putExtra("asuransi_shm3", dm.getAsuransi_shm3());
                    goInput.putExtra("nilai_tanah_shm3", dm.getNilai_tanah_shm3());
                    goInput.putExtra("nilai_bangunan_shm3", dm.getNilai_bangunan_shm3());
                    goInput.putExtra("total_taksiran_shm3", dm.getTotal_taksiran_shm3());

                    goInput.putExtra("nama_jaminan_shm4", dm.getNama_jaminan_shm4());
                    goInput.putExtra("jenis_jaminan_shm4", dm.getJenis_jaminan_shm4());
                    goInput.putExtra("atas_nama_shm4", dm.getAtas_nama_shm4());
                    goInput.putExtra("alamat_atas_nama_shm4", dm.getAlamat_atas_nama_shm4());
                    goInput.putExtra("no_ktp_atas_nama_shm4", dm.getNo_ktp_atas_nama_shm4());
                    goInput.putExtra("masa_berlaku_shm4", dm.getMasa_berlaku_shm4());
                    goInput.putExtra("ikatan_shm4", dm.getIkatan_shm4());
                    goInput.putExtra("nilai_ikatan_shm4", dm.getNilai_ikatan_shm4());
                    goInput.putExtra("no_SHM4", dm.getNo_SHM4());
                    goInput.putExtra("no_gs_shm4", dm.getNo_gs_shm4());
                    goInput.putExtra("luas_shm4", dm.getLuas_shm4());
                    goInput.putExtra("lokasi_shm4", dm.getLokasi_shm4());
                    goInput.putExtra("asuransi_shm4", dm.getAsuransi_shm4());
                    goInput.putExtra("nilai_tanah_shm4", dm.getNilai_tanah_shm4());
                    goInput.putExtra("nilai_bangunan_shm4", dm.getNilai_bangunan_shm4());
                    goInput.putExtra("total_taksiran_shm4", dm.getTotal_taksiran_shm4());

                    goInput.putExtra("nama_jaminan_shm5", dm.getNama_jaminan_shm5());
                    goInput.putExtra("jenis_jaminan_shm5", dm.getJenis_jaminan_shm5());
                    goInput.putExtra("atas_nama_shm5", dm.getAtas_nama_shm5());
                    goInput.putExtra("alamat_atas_nama_shm5", dm.getAlamat_atas_nama_shm5());
                    goInput.putExtra("no_ktp_atas_nama_shm5", dm.getNo_ktp_atas_nama_shm5());
                    goInput.putExtra("masa_berlaku_shm5", dm.getMasa_berlaku_shm5());
                    goInput.putExtra("ikatan_shm5", dm.getIkatan_shm5());
                    goInput.putExtra("nilai_ikatan_shm5", dm.getNilai_ikatan_shm5());
                    goInput.putExtra("no_SHM5", dm.getNo_SHM5());
                    goInput.putExtra("no_gs_shm5", dm.getNo_gs_shm5());
                    goInput.putExtra("luas_shm5", dm.getLuas_shm5());
                    goInput.putExtra("lokasi_shm5", dm.getLokasi_shm5());
                    goInput.putExtra("asuransi_shm5", dm.getAsuransi_shm5());
                    goInput.putExtra("nilai_tanah_shm5", dm.getNilai_tanah_shm5());
                    goInput.putExtra("nilai_bangunan_shm5", dm.getNilai_bangunan_shm5());
                    goInput.putExtra("total_taksiran_shm5", dm.getTotal_taksiran_shm5());

                    goInput.putExtra("nama_jaminan_bpkb1", dm.getNama_jaminan_bpkb1());
                    goInput.putExtra("no_bpkb1", dm.getNo_bpkb1());
                    goInput.putExtra("merk_bpkb1", dm.getMerk_bpkb1());
                    goInput.putExtra("tahun_bpkb1", dm.getTahun_bpkb1());
                    goInput.putExtra("no_rangka_bpkb1", dm.getNo_rangka_bpkb1());
                    goInput.putExtra("no_mesin_bpkb1", dm.getNo_mesin_bpkb1());
                    goInput.putExtra("warna_bpkb1", dm.getWarna_bpkb1());
                    goInput.putExtra("nopol_bpkb1", dm.getNopol_bpkb1());
                    goInput.putExtra("atas_nama_bpkb1", dm.getAtas_nama_bpkb1());
                    goInput.putExtra("alamat_bpkb1", dm.getAlamat_bpkb1());
                    goInput.putExtra("ikatan_bpkb1", dm.getIkatan_bpkb1());
                    goInput.putExtra("nilai_fiducia1", dm.getNilai_fiducia1());
                    goInput.putExtra("nilai_taksiran_bpkb1", dm.getNilai_taksiran_bpkb1());

                    goInput.putExtra("nama_jaminan_bpkb2", dm.getNama_jaminan_bpkb2());
                    goInput.putExtra("no_bpkb2", dm.getNo_bpkb2());
                    goInput.putExtra("merk_bpkb2", dm.getMerk_bpkb2());
                    goInput.putExtra("tahun_bpkb2", dm.getTahun_bpkb2());
                    goInput.putExtra("no_rangka_bpkb2", dm.getNo_rangka_bpkb2());
                    goInput.putExtra("no_mesin_bpkb2", dm.getNo_mesin_bpkb2());
                    goInput.putExtra("warna_bpkb2", dm.getWarna_bpkb2());
                    goInput.putExtra("nopol_bpkb2", dm.getNopol_bpkb2());
                    goInput.putExtra("atas_nama_bpkb2", dm.getAtas_nama_bpkb2());
                    goInput.putExtra("alamat_bpkb2", dm.getAlamat_bpkb2());
                    goInput.putExtra("ikatan_bpkb2", dm.getIkatan_bpkb2());
                    goInput.putExtra("nilai_fiducia2", dm.getNilai_fiducia2());
                    goInput.putExtra("nilai_taksiran_bpkb2", dm.getNilai_taksiran_bpkb2());

                    goInput.putExtra("nama_jaminan_bpkb3", dm.getNama_jaminan_bpkb3());
                    goInput.putExtra("no_bpkb3", dm.getNo_bpkb3());
                    goInput.putExtra("merk_bpkb3", dm.getMerk_bpkb3());
                    goInput.putExtra("tahun_bpkb3", dm.getTahun_bpkb3());
                    goInput.putExtra("no_rangka_bpkb3", dm.getNo_rangka_bpkb3());
                    goInput.putExtra("no_mesin_bpkb3", dm.getNo_mesin_bpkb3());
                    goInput.putExtra("warna_bpkb3", dm.getWarna_bpkb3());
                    goInput.putExtra("nopol_bpkb3", dm.getNopol_bpkb3());
                    goInput.putExtra("atas_nama_bpkb3", dm.getAtas_nama_bpkb3());
                    goInput.putExtra("alamat_bpkb3", dm.getAlamat_bpkb3());
                    goInput.putExtra("ikatan_bpkb3", dm.getIkatan_bpkb3());
                    goInput.putExtra("nilai_fiducia3", dm.getNilai_fiducia3());
                    goInput.putExtra("nilai_taksiran_bpkb3", dm.getNilai_taksiran_bpkb3());

                    goInput.putExtra("nama_jaminan_bpkb4", dm.getNama_jaminan_bpkb4());
                    goInput.putExtra("no_bpkb4", dm.getNo_bpkb4());
                    goInput.putExtra("merk_bpkb4", dm.getMerk_bpkb4());
                    goInput.putExtra("tahun_bpkb4", dm.getTahun_bpkb4());
                    goInput.putExtra("no_rangka_bpkb4", dm.getNo_rangka_bpkb4());
                    goInput.putExtra("no_mesin_bpkb4", dm.getNo_mesin_bpkb4());
                    goInput.putExtra("warna_bpkb4", dm.getWarna_bpkb4());
                    goInput.putExtra("nopol_bpkb4", dm.getNopol_bpkb4());
                    goInput.putExtra("atas_nama_bpkb4", dm.getAtas_nama_bpkb4());
                    goInput.putExtra("alamat_bpkb4", dm.getAlamat_bpkb4());
                    goInput.putExtra("ikatan_bpkb4", dm.getIkatan_bpkb4());
                    goInput.putExtra("nilai_fiducia4", dm.getNilai_fiducia4());
                    goInput.putExtra("nilai_taksiran_bpkb4", dm.getNilai_taksiran_bpkb4());

                    goInput.putExtra("nama_jaminan_bpkb5", dm.getNama_jaminan_bpkb5());
                    goInput.putExtra("no_bpkb5", dm.getNo_bpkb5());
                    goInput.putExtra("merk_bpkb5", dm.getMerk_bpkb5());
                    goInput.putExtra("tahun_bpkb5", dm.getTahun_bpkb5());
                    goInput.putExtra("no_rangka_bpkb5", dm.getNo_rangka_bpkb5());
                    goInput.putExtra("no_mesin_bpkb5", dm.getNo_mesin_bpkb5());
                    goInput.putExtra("warna_bpkb5", dm.getWarna_bpkb5());
                    goInput.putExtra("nopol_bpkb5", dm.getNopol_bpkb5());
                    goInput.putExtra("atas_nama_bpkb5", dm.getAtas_nama_bpkb5());
                    goInput.putExtra("alamat_bpkb5", dm.getAlamat_bpkb5());
                    goInput.putExtra("ikatan_bpkb5", dm.getIkatan_bpkb5());
                    goInput.putExtra("nilai_fiducia5", dm.getNilai_fiducia5());
                    goInput.putExtra("nilai_taksiran_bpkb5", dm.getNilai_taksiran_bpkb5());

                    goInput.putExtra("jaminan_bilyet1", dm.getJaminan_bilyet1());
                    goInput.putExtra("atas_nama_bilyet1", dm.getAtas_nama_bilyet1());
                    goInput.putExtra("no_bilyet1", dm.getNo_bilyet1());
                    goInput.putExtra("alamat_bilyet1", dm.getAlamat_bilyet1());
                    goInput.putExtra("ikatan_bilyet1", dm.getIkatan_bilyet1());
                    goInput.putExtra("nilai_bilyet1", dm.getNilai_bilyet1());
                    goInput.putExtra("total_nilai_bilyet1", dm.getTotal_nilai_bilyet1());
                    goInput.putExtra("persen_dari_plafond1", dm.getPersen_dari_plafond1());

                    goInput.putExtra("jaminan_bilyet2", dm.getJaminan_bilyet2());
                    goInput.putExtra("atas_nama_bilyet2", dm.getAtas_nama_bilyet2());
                    goInput.putExtra("no_bilyet2", dm.getNo_bilyet2());
                    goInput.putExtra("alamat_bilyet2", dm.getAlamat_bilyet2());
                    goInput.putExtra("ikatan_bilyet2", dm.getIkatan_bilyet2());
                    goInput.putExtra("nilai_bilyet2", dm.getNilai_bilyet2());
                    goInput.putExtra("total_nilai_bilyet2", dm.getTotal_nilai_bilyet2());
                    goInput.putExtra("persen_dari_plafond2", dm.getPersen_dari_plafond2());

                    goInput.putExtra("jaminan_bilyet3", dm.getJaminan_bilyet3());
                    goInput.putExtra("atas_nama_bilyet3", dm.getAtas_nama_bilyet3());
                    goInput.putExtra("no_bilyet3", dm.getNo_bilyet3());
                    goInput.putExtra("alamat_bilyet3", dm.getAlamat_bilyet3());
                    goInput.putExtra("ikatan_bilyet3", dm.getIkatan_bilyet3());
                    goInput.putExtra("nilai_bilyet3", dm.getNilai_bilyet3());
                    goInput.putExtra("total_nilai_bilyet3", dm.getTotal_nilai_bilyet3());
                    goInput.putExtra("persen_dari_plafond3", dm.getPersen_dari_plafond3());

                    //Aspek Kapasitas
                    goInput.putExtra("rincian_pekerjaan", dm.getRincian_pekerjaan());
                    goInput.putExtra("nama_perusahaan", dm.getNama_perusahaan());
                    goInput.putExtra("alamat_usaha", dm.getAlamat_usaha());
                    goInput.putExtra("lama_usaha", dm.getLama_usaha());
                    goInput.putExtra("deskripsi_usaha_utama", dm.getDeskripsi_usaha_utama());
                    goInput.putExtra("uraian_kegiatan_usaha_lainnya", dm.getUraian_kegiatan_usaha_lainnya());
                    goInput.putExtra("uraian_kegiatan_usaha_lainnya1", dm.getUraian_kegiatan_usaha_lainnya1());

                    goInput.putExtra("deskripsi_usaha_sampingan", dm.getDeskripsi_usaha_sampingan());
                    goInput.putExtra("deskripsi_usaha_pasangan", dm.getDeskripsi_usaha_pasangan());
                    goInput.putExtra("kondisi_fisik_pemohon", dm.getKondisi_fisik_pemohon());
                    goInput.putExtra("kesimpulan", dm.getKesimpulan());

                    goInput.putExtra("kas", dm.getKas());
                    goInput.putExtra("piutang", dm.getPiutang());
                    goInput.putExtra("persediaan", dm.getPersediaan());
                    goInput.putExtra("inventaris", dm.getInventaris());
                    goInput.putExtra("tanah", dm.getTanah());
                    goInput.putExtra("total_aktiva", dm.getTotal_aktiva());
                    goInput.putExtra("hutang_dagang", dm.getHutang_dagang());
                    goInput.putExtra("hutang_bank", dm.getHutang_bank());
                    goInput.putExtra("pinjaman", dm.getPinjaman());

                    goInput.putExtra("modal", dm.getModal());
                    goInput.putExtra("laba", dm.getLaba());
                    goInput.putExtra("total_pasiva", dm.getTotal_pasiva());
                    goInput.putExtra("pendapatan_usaha", dm.getPendapatan_usaha());
                    goInput.putExtra("biaya_usaha", dm.getBiaya_usaha());
                    goInput.putExtra("laba_usaha", dm.getLaba_usaha());
                    goInput.putExtra("pendapatan_lain", dm.getPendapatan_lain());
                    goInput.putExtra("total_pendapatan", dm.getTotal_pendapatan());
                    goInput.putExtra("biaya_rumah_tangga", dm.getBiaya_rumah_tangga());

                    goInput.putExtra("biaya_listrik", dm.getBiaya_listrik());
                    goInput.putExtra("biaya_pendidikan", dm.getBiaya_pendidikan());
                    goInput.putExtra("biaya_transportasi", dm.getBiaya_transportasi());
                    goInput.putExtra("biaya_sosial", dm.getBiaya_sosial());
                    goInput.putExtra("angsuran_bank1", dm.getAngsuran_bank1());
                    goInput.putExtra("angsuran_bank2", dm.getAngsuran_bank2());
                    goInput.putExtra("angsuran_bank3", dm.getAngsuran_bank3());
                    goInput.putExtra("angsuran_bank4", dm.getAngsuran_bank4());
                    goInput.putExtra("angsuran_bank5", dm.getAngsuran_bank5());
                    goInput.putExtra("angsuran_bank6", dm.getAngsuran_bank6());
                    goInput.putExtra("biaya_lainnya", dm.getBiaya_lainnya());
                    goInput.putExtra("total_biaya", dm.getTotal_biaya());

                    //Aspek Pemasaran
                    goInput.putExtra("kelola_usaha", dm.getKelola_usaha());
                    goInput.putExtra("persaingan_usaha", dm.getPersaingan_usaha());
                    goInput.putExtra("pemasaran_usaha", dm.getPemasaran_usaha());
                    goInput.putExtra("amdal_usaha", dm.getAmdal_usaha());
                    goInput.putExtra("prospek_usaha", dm.getProspek_usaha());

                    //Aspek Karakter
                    goInput.putExtra("fasilitas_kredit_ke", dm.getFasilitas_ke());
                    goInput.putExtra("kondite_kredit_lalu", dm.getKondite_kredit_lalu());
                    goInput.putExtra("referensi", dm.getReferensi());
                    goInput.putExtra("info_lingkungan", dm.getInfo_lingkungan());
                    goInput.putExtra("avalis_kredit", dm.getAvalis_kredit());
                    goInput.putExtra("karakter_lainnya", dm.getKarakter_lainnya());

                    //Dasar Hukum
                    goInput.putExtra("dasar_hukum", dm.getDasar_hukum());
                    goInput.putExtra("legalitas_identitas", dm.getLegalitas_identitas());

                    //Analisa Kebutuhan
                    goInput.putExtra("plafond_kredit", dm.getPlafond_kredit());
                    goInput.putExtra("tujuan_penggunaan", dm.getTujuan_penggunaan());
                    goInput.putExtra("tujuan_modal", dm.getTujuan_modal());
                    goInput.putExtra("tujuan_pelunasan", dm.getTujuan_pelunasan());
                    goInput.putExtra("tujuan_pembelian", dm.getTujuan_pembelian());
                    goInput.putExtra("tujuan_renovasi", dm.getTujuan_renovasi());

                    //Dasar Hukum
                    goInput.putExtra("tujuan_sekolah", dm.getTujuan_sekolah());
                    goInput.putExtra("tujuan_lainnya", dm.getTujuan_lainya());
                    goInput.putExtra("total_kebutuhan", dm.getTotal_kebutuhan());
                    goInput.putExtra("kas", dm.getKas());
                    goInput.putExtra("kebutuhan_bank", dm.getKebutuhan_bank());
                    goInput.putExtra("dibulatkan_menjadi", dm.getKebutuhan_bank());

                    goInput.putExtra("dana_angsuran", dm.getDana_angsuran());
                    goInput.putExtra("jkw_x1", dm.getJkw_x1());



                    ctx.startActivity(goInput);
                }
            });


        }
    }
}
