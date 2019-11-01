package com.example.analis23.api;


import com.example.analis23.model.DataModel;
import com.example.analis23.model.ResponsModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by hakiki95 on 4/16/2017.
 */

public interface ApiRequestBiodata {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel> sendBiodata(@Field ("tgl_permohonan") String tgl_permohonan,
                                   @Field ("no_reg")String no_reg,
                                   @Field ("nama_pemohon")String nama_pemohon,
                                   @Field ("nama_panggilan")String nama_panggilan,
                                   @Field ("tempat_lahir")String tempat_lahir,
                                   @Field ("tgl_lahir")String tgl_lahir,
                                   @Field ("jenis_kelamin")String jenis_kelamin,
                                   @Field ("no_ktp")String no_ktp,
                                   @Field ("masa_berlaku_ktp")String masa_berlaku_ktp,
                                   @Field ("alamat_sesuai_ktp")String alamat_sesuai_ktp,
                                   @Field ("nama_ibu_kandung")String nama_ibu_kandung,
                                   @Field ("kode_pos")String kode_pos,
                                   @Field ("pekerjaan_pemohon")String pekerjaan_pemohon,
                                   @Field ("nama_perusahaan")String nama_perusahaan,
                                   @Field ("jabatan")String jabatan,
                                   @Field ("alamat_perusahaan")String alamat_perusahaan,
                                   @Field ("status_pernikahan")String status_pernikahan,
                                   @Field ("jml_tanggungan")String jml_tanggungan,
                                   @Field ("pendidikan_terakhir")String pendidikan_terakhir,
                                   @Field ("status_rumah_tinggal")String status_rumah_tinggal,
                                   @Field ("lama_tinggal")String lama_tinggal,
                                   @Field ("alamat_rumah_tinggal")String alamat_rumah_tinggal,
                                   @Field ("no_telp")String no_telp,
                                   @Field ("no_hp")String no_hp,
                                   @Field ("nama_pasangan")String nama_pasangan,
                                   @Field ("tgl_lahir_pasangan")String tgl_lahir_pasangan,
                                   @Field ("no_ktp_pasangan")String no_ktp_pasangan,
                                   @Field ("masa_berlaku_ktp_pasangan")String masa_berlaku_ktp_pasangan,
                                   @Field ("pekerjaan_pasangan")String pekerjaan_pasangan,
                                   @Field ("tempat_lahir_pasangan")String tempat_lahir_pasangan,
                                   @Field ("alamat_pasangan")String alamat_pasangan,
                                   @Field ("penghasilan_per_bln")String penghasilan_per_bln,
                                   @Field ("penjamin")String penjamin,
                                   @Field ("alamat_penjamin")String alamat_penjamin,
                                   @Field ("tempat_lahir_penjamin")String tempat_lahir_penjamin,
                                   @Field ("tgl_lahir_penjamin")String tgl_lahir_penjamin,
                                   @Field ("no_ktp_penjamin")String no_ktp_penjamin,
                                   @Field ("masa_berlaku_ktp_penjamin")String masa_berlaku_ktp_penjamin,
                                   @Field ("nama_pasangan_penjamin")String nama_pasangan_penjamin,
                                   @Field ("alamat_pasangan_penjamin")String alamat_pasangan_penjamin,
                                   @Field ("tempat_lahir_pasangan_penjamin")String tempat_lahir_pasangan_penjamin,
                                   @Field ("tgl_lahir_pasangan_penjamin")String tgl_lahir_pasangan_penjamin,
                                   @Field ("no_ktp_pasangan_penjamin")String no_ktp_pasangan_penjamin,
                                   @Field ("masa_berlaku_ktp_pasangan_penjamin")String masa_berlaku_ktp_pasangan_penjamin,

                                   //Data Kredit
                                   @Field ("jenis_kredit")String jenis_kredit,
                                   @Field ("sektor_ekonomi")String sektor_ekonomi,
                                   @Field ("fasilitas_ke")String fasilitas_ke,
                                   @Field ("plafond_kredit")String plafond_kredit,
                                   @Field ("jkw")String jkw,
                                   @Field ("bunga")String bunga,
                                   @Field ("type_angsuran")String type_angsuran,
                                   @Field ("periode_pembayaran_pokok")String periode_pembayaran_pokok,
                                   @Field ("jml_angsuran_per_bln")String jml_angsuran_per_bln,
                                   @Field ("angsuran_pokok_pertama")String angsuran_pokok_pertama,
                                   @Field ("angsuran_bunga_pertama")String angsuran_bunga_pertama,
                                   @Field ("provisi")String provisi,
                                   @Field ("administrasi")String administrasi,
                                   @Field ("on_the_spot")String on_the_spot,
                                   @Field ("premi")String premi,
                                   @Field ("nama_asuransi")String nama_asuransi,
                                   @Field ("akad_kredit")String akad_kredit,
                                   @Field ("jenis_penggunaan")String jenis_penggunaan,
                                   @Field ("tujuan_penggunaan")String tujuan_penggunaan,
                                   @Field ("surveyor")String surveyor,

                                   //Aspek Kapasitas
                                   @Field ("rincian_pekerjaan")String rincian_pekerjaan,
                                   @Field ("alamat_usaha")String alamat_usaha,
                                   @Field ("lama_usaha")String lama_usaha,
                                   @Field ("deskripsi_usaha_utama")String deskripsi_usaha_utama,
                                   @Field ("uraian_kegiatan_usaha_lainnya")String uraian_kegiatan_usaha_lainnya,
                                   @Field ("uraian_kegiatan_usaha_lainnya1")String uraian_kegiatan_usaha_lainnya1,
                                   @Field ("deskripsi_usaha_sampingan")String deskripsi_usaha_sampingan,
                                   @Field ("deskripsi_usaha_pasangan")String deskripsi_usaha_pasangan,
                                   @Field ("kondisi_fisik_pemohon")String kondisi_fisik_pemohon,
                                   @Field ("kesimpulan")String kesimpulan,

                                   //Aspek Keuangan
                                   @Field ("kas")String kas,
                                   @Field ("piutang")String piutang,
                                   @Field ("persediaan")String persediaan,
                                   @Field ("inventaris")String inventaris,
                                   @Field ("tanah")String tanah,
                                   @Field ("total_aktiva")String total_aktiva,
                                   @Field ("hutang_dagang")String hutang_dagang,
                                   @Field ("hutang_bank")String hutang_bank,
                                   @Field ("pinjaman")String pinjaman,
                                   @Field ("modal")String modal,
                                   @Field ("laba")String laba,
                                   @Field ("total_pasiva")String total_pasiva,
                                   @Field ("pendapatan_usaha")String pendapatan_usaha,
                                   @Field ("biaya_usaha")String biaya_usaha,
                                   @Field ("laba_usaha")String laba_usaha,
                                   @Field ("pendapatan_lain")String pendapatan_lain,
                                   @Field ("total_pendapatan")String total_pendapatan,
                                   @Field ("biaya_rumah_tangga")String biaya_rumah_tangga,
                                   @Field ("biaya_listrik")String biaya_listrik,
                                   @Field ("biaya_pendidikan")String biaya_pendidikan,
                                   @Field ("biaya_transportasi")String biaya_transportasi,
                                   @Field ("biaya_sosial")String biaya_sosial,
                                   @Field ("angsuran_bank1")String angsuran_bank1,
                                   @Field ("angsuran_bank2")String angsuran_bank2,
                                   @Field ("angsuran_bank3")String angsuran_bank3,
                                   @Field ("angsuran_bank4")String angsuran_bank4,
                                   @Field ("angsuran_bank5")String angsuran_bank5,
                                   @Field ("angsuran_bank6")String angsuran_bank6,
                                   @Field ("biaya_lainnya")String biaya_lainnya,
                                   @Field ("total_biaya")String total_biaya,

                                   //Apek Pemasaran
                                   @Field ("kelola_usaha")String kelola_usaha,
                                   @Field ("persaingan_usaha")String persaingan_usaha,
                                   @Field ("pemasaran_usaha")String pemasaran_usaha,
                                   @Field ("amdal_usaha")String amdal_usaha,
                                   @Field ("prospek_usaha")String prospek_usaha,

                                   //Apek Karakter
                                   @Field ("kondite_kredit_lalu")String kondite_kredit_lalu,
                                   @Field ("referensi")String referensi,
                                   @Field ("info_lingkungan")String info_lingkungan,
                                   @Field ("avalis_kredit")String avalis_kredit,
                                   @Field ("karakter_lainnya")String karakter_lainnya,

                                   //Aspek Hukum
                                   @Field ("dasar_hukum")String dasar_hukum,
                                   @Field ("legalitas_identitas")String legalitas_identitas,

                                   //Analisa Kebutuhan
                                   @Field ("tujuan_modal")String tujuan_modal,
                                   @Field ("tujuan_pelunasan")String tujuan_pelunasan,
                                   @Field ("tujuan_pembelian")String tujuan_pembelian,
                                   @Field ("tujuan_renovasi")String tujuan_renovasi,
                                   @Field ("tujuan_sekolah")String tujuan_sekolah,
                                   @Field ("tujuan_lainnya")String tujuan_lainnya,
                                   @Field ("total_kebutuhan")String total_kebutuhan,
                                   @Field ("kebutuhan_bank")String kebutuhan_bank,

                                   @Field ("dana_angsuran")String dana_angsuran,
                                   @Field ("jkw_x1")String jkw_x1


    );

    @FormUrlEncoded
    @POST("insert1.php")
    Call<ResponsModel> sendBiodataa( @Field ("no_reg1")String no_reg1,
                                     @Field ("nama_jaminan_shm1")String nama_jaminan_shm1,
                                     @Field ("jenis_jaminan_shm1")String jenis_jaminan_shm1,
                                     @Field ("atas_nama_shm1")String atas_nama_shm1,
                                     @Field ("alamat_atas_nama_shm1")String alamat_atas_nama_shm1,
                                     @Field ("no_ktp_atas_nama_shm1")String no_ktp_atas_nama_shm1,
                                     @Field ("masa_berlaku_shm1")String masa_berlaku_shm1,
                                     @Field ("ikatan_shm1")String ikatan_shm1,
                                     @Field ("nilai_ikatan_shm1")String nilai_ikatan_shm1,
                                     @Field ("no_SHM1")String no_SHM1,
                                     @Field ("no_gs_shm1")String no_gs_shm1,
                                     @Field ("luas_shm1")String luas_shm1,
                                     @Field ("lokasi_shm1")String lokasi_shm1,
                                     @Field ("asuransi_shm1")String asuransi_shm1,
                                     @Field ("nilai_tanah_shm1")String nilai_tanah_shm1,
                                     @Field ("nilai_bangunan_shm1")String nilai_bangunan_shm1,
                                     @Field ("total_taksiran_shm1")String total_taksiran_shm1,

                                     //Aspek Jaminan SHM 2
                                     @Field ("nama_jaminan_shm2")String nama_jaminan_shm2,
                                     @Field ("jenis_jaminan_shm2")String jenis_jaminan_shm2,
                                     @Field ("atas_nama_shm2")String atas_nama_shm2,
                                     @Field ("alamat_atas_nama_shm2")String alamat_atas_nama_shm2,
                                     @Field ("no_ktp_atas_nama_shm2")String no_ktp_atas_nama_shm2,
                                     @Field ("masa_berlaku_shm2")String masa_berlaku_shm2,
                                     @Field ("ikatan_shm2")String ikatan_shm2,
                                     @Field ("nilai_ikatan_shm2")String nilai_ikatan_shm2,
                                     @Field ("no_SHM2")String no_SHM2,
                                     @Field ("no_gs_shm2")String no_gs_shm2,
                                     @Field ("luas_shm2")String luas_shm2,
                                     @Field ("lokasi_shm2")String lokasi_shm2,
                                     @Field ("asuransi_shm2")String asuransi_shm2,
                                     @Field ("nilai_tanah_shm2")String nilai_tanah_shm2,
                                     @Field ("nilai_bangunan_shm2")String nilai_bangunan_shm2,
                                     @Field ("total_taksiran_shm2")String total_taksiran_shm2,

                                     //Aspek Jaminan 3
                                     @Field ("nama_jaminan_shm3")String nama_jaminan_shm3,
                                     @Field ("jenis_jaminan_shm3")String jenis_jaminan_shm3,
                                     @Field ("atas_nama_shm3")String atas_nama_shm3,
                                     @Field ("alamat_atas_nama_shm3")String alamat_atas_nama_shm3,
                                     @Field ("no_ktp_atas_nama_shm3")String no_ktp_atas_nama_shm3,
                                     @Field ("masa_berlaku_shm3")String masa_berlaku_shm3,
                                     @Field ("ikatan_shm3")String ikatan_shm3,
                                     @Field ("nilai_ikatan_shm3")String nilai_ikatan_shm3,
                                     @Field ("no_SHM3")String no_SHM3,
                                     @Field ("no_gs_shm3")String no_gs_shm3,
                                     @Field ("luas_shm3")String luas_shm3,
                                     @Field ("lokasi_shm3")String lokasi_shm3,
                                     @Field ("asuransi_shm3")String asuransi_shm3,
                                     @Field ("nilai_tanah_shm3")String nilai_tanah_shm3,
                                     @Field ("nilai_bangunan_shm3")String nilai_bangunan_shm3,
                                     @Field ("total_taksiran_shm3")String total_taksiran_shm3,

                                     //Aspek Jaminan 4
                                     @Field ("nama_jaminan_shm4")String nama_jaminan_shm4,
                                     @Field ("jenis_jaminan_shm4")String jenis_jaminan_shm4,
                                     @Field ("atas_nama_shm4")String atas_nama_shm4,
                                     @Field ("alamat_atas_nama_shm4")String alamat_atas_nama_shm4,
                                     @Field ("no_ktp_atas_nama_shm4")String no_ktp_atas_nama_shm4,
                                     @Field ("masa_berlaku_shm4")String masa_berlaku_shm4,
                                     @Field ("ikatan_shm4")String ikatan_shm4,
                                     @Field ("nilai_ikatan_shm4")String nilai_ikatan_shm4,
                                     @Field ("no_SHM4")String no_SHM4,
                                     @Field ("no_gs_shm4")String no_gs_shm4,
                                     @Field ("luas_shm4")String luas_shm4,
                                     @Field ("lokasi_shm4")String lokasi_shm4,
                                     @Field ("asuransi_shm4")String asuransi_shm4,
                                     @Field ("nilai_tanah_shm4")String nilai_tanah_shm4,
                                     @Field ("nilai_bangunan_shm4")String nilai_bangunan_shm4,
                                     @Field ("total_taksiran_shm4")String total_taksiran_shm4,

                                     //Aspek Jaminan 5
                                     @Field ("nama_jaminan_shm5")String nama_jaminan_shm5,
                                     @Field ("jenis_jaminan_shm5")String jenis_jaminan_shm5,
                                     @Field ("atas_nama_shm5")String atas_nama_shm5,
                                     @Field ("alamat_atas_nama_shm5")String alamat_atas_nama_shm5,
                                     @Field ("no_ktp_atas_nama_shm5")String no_ktp_atas_nama_shm5,
                                     @Field ("masa_berlaku_shm5")String masa_berlaku_shm5,
                                     @Field ("ikatan_shm5")String ikatan_shm5,
                                     @Field ("nilai_ikatan_shm5")String nilai_ikatan_shm5,
                                     @Field ("no_SHM5")String no_SHM5,
                                     @Field ("no_gs_shm5")String no_gs_shm5,
                                     @Field ("luas_shm5")String luas_shm5,
                                     @Field ("lokasi_shm5")String lokasi_shm5,
                                     @Field ("asuransi_shm5")String asuransi_shm5,
                                     @Field ("nilai_tanah_shm5")String nilai_tanah_shm5,
                                     @Field ("nilai_bangunan_shm5")String nilai_bangunan_shm5,
                                     @Field ("total_taksiran_shm5")String total_taksiran_shm5,

                                     //Aspek Jaminan BPKB 1
                                     @Field ("nama_jaminan_bpkb1")String nama_jaminan_bpkb1,
                                     @Field ("no_bpkb1")String no_bpkb1,
                                     @Field ("merk_bpkb1")String merk_bpkb1,
                                     @Field ("tahun_bpkb1")String tahun_bpkb1,
                                     @Field ("no_rangka_bpkb1")String no_rangka_bpkb1,
                                     @Field ("no_mesin_bpkb1")String no_mesin_bpkb1,
                                     @Field ("warna_bpkb1")String warna_bpkb1,
                                     @Field ("nopol_bpkb1")String nopol_bpkb1,
                                     @Field ("atas_nama_bpkb1")String atas_nama_bpkb1,
                                     @Field ("alamat_bpkb1")String alamat_bpkb1,
                                     @Field ("ikatan_bpkb1")String ikatan_bpkb1,
                                     @Field ("nilai_fiducia1")String nilai_fiducia1,
                                     @Field ("nilai_taksiran_bpkb1")String nilai_taksiran_bpkb1,

                                     //Aspek Jaminan BPKB 2
                                     @Field ("nama_jaminan_bpkb2")String nama_jaminan_bpkb2,
                                     @Field ("no_bpkb2")String no_bpkb2,
                                     @Field ("merk_bpkb2")String merk_bpkb2,
                                     @Field ("tahun_bpkb2")String tahun_bpkb2,
                                     @Field ("no_rangka_bpkb2")String no_rangka_bpkb2,
                                     @Field ("no_mesin_bpkb2")String no_mesin_bpkb2,
                                     @Field ("warna_bpkb2")String warna_bpkb2,
                                     @Field ("nopol_bpkb2")String nopol_bpkb2,
                                     @Field ("atas_nama_bpkb2")String atas_nama_bpkb2,
                                     @Field ("alamat_bpkb2")String alamat_bpkb2,
                                     @Field ("ikatan_bpkb2")String ikatan_bpkb2,
                                     @Field ("nilai_fiducia2")String nilai_fiducia2,
                                     @Field ("nilai_taksiran_bpkb2")String nilai_taksiran_bpkb2,

                                     //Aspek Jaminan BPKB 3
                                     @Field ("nama_jaminan_bpkb3")String nama_jaminan_bpkb3,
                                     @Field ("no_bpkb3")String no_bpkb3,
                                     @Field ("merk_bpkb3")String merk_bpkb3,
                                     @Field ("tahun_bpkb3")String tahun_bpkb3,
                                     @Field ("no_rangka_bpkb3")String no_rangka_bpkb3,
                                     @Field ("no_mesin_bpkb3")String no_mesin_bpkb3,
                                     @Field ("warna_bpkb3")String warna_bpkb3,
                                     @Field ("nopol_bpkb3")String nopol_bpkb3,
                                     @Field ("atas_nama_bpkb3")String atas_nama_bpkb3,
                                     @Field ("alamat_bpkb3")String alamat_bpkb3,
                                     @Field ("ikatan_bpkb3")String ikatan_bpkb3,
                                     @Field ("nilai_fiducia3")String nilai_fiducia3,
                                     @Field ("nilai_taksiran_bpkb3")String nilai_taksiran_bpkb3,

                                     //Aspek Jaminan BPKB 4
                                     @Field ("nama_jaminan_bpkb4")String nama_jaminan_bpkb4,
                                     @Field ("no_bpkb4")String no_bpkb4,
                                     @Field ("merk_bpkb4")String merk_bpkb4,
                                     @Field ("tahun_bpkb4")String tahun_bpkb4,
                                     @Field ("no_rangka_bpkb4")String no_rangka_bpkb4,
                                     @Field ("no_mesin_bpkb4")String no_mesin_bpkb4,
                                     @Field ("warna_bpkb4")String warna_bpkb4,
                                     @Field ("nopol_bpkb4")String nopol_bpkb4,
                                     @Field ("atas_nama_bpkb4")String atas_nama_bpkb4,
                                     @Field ("alamat_bpkb4")String alamat_bpkb4,
                                     @Field ("ikatan_bpkb4")String ikatan_bpkb4,
                                     @Field ("nilai_fiducia4")String nilai_fiducia4,
                                     @Field ("nilai_taksiran_bpkb4")String nilai_taksiran_bpkb4,

                                     //Aspek Jaminan BPKB 5
                                     @Field ("nama_jaminan_bpkb5")String nama_jaminan_bpkb5,
                                     @Field ("no_bpkb5")String no_bpkb5,
                                     @Field ("merk_bpkb5")String merk_bpkb5,
                                     @Field ("tahun_bpkb5")String tahun_bpkb5,
                                     @Field ("no_rangka_bpkb5")String no_rangka_bpkb5,
                                     @Field ("no_mesin_bpkb5")String no_mesin_bpkb5,
                                     @Field ("warna_bpkb5")String warna_bpkb5,
                                     @Field ("nopol_bpkb5")String nopol_bpkb5,
                                     @Field ("atas_nama_bpkb5")String atas_nama_bpkb5,
                                     @Field ("alamat_bpkb5")String alamat_bpkb5,
                                     @Field ("ikatan_bpkb5")String ikatan_bpkb5,
                                     @Field ("nilai_fiducia5")String nilai_fiducia5,
                                     @Field ("nilai_taksiran_bpkb5")String nilai_taksiran_bpkb5,

                                     //Aspek Jaminan Bilyet Deposito 1
                                     @Field ("jaminan_bilyet1")String jaminan_bilyet1,
                                     @Field ("atas_nama_bilyet1")String atas_nama_bilyet1,
                                     @Field ("no_bilyet1")String no_bilyet1,
                                     @Field ("alamat_bilyet1")String alamat_bilyet1,
                                     @Field ("ikatan_bilyet1")String ikatan_bilyet1,
                                     @Field ("nilai_bilyet1")String nilai_bilyet1,
                                     @Field ("total_nilai_bilyet1")String total_nilai_bilyet1,
                                     @Field ("persen_dari_plafond1")String persen_dari_plafond1,

                                     //Aspek Jaminan Bilyet Deposito 2
                                     @Field ("jaminan_bilyet2")String jaminan_bilyet2,
                                     @Field ("atas_nama_bilyet2")String atas_nama_bilyet2,
                                     @Field ("no_bilyet2")String no_bilyet2,
                                     @Field ("alamat_bilyet2")String alamat_bilyet2,
                                     @Field ("ikatan_bilyet2")String ikatan_bilyet2,
                                     @Field ("nilai_bilyet2")String nilai_bilyet2,
                                     @Field ("total_nilai_bilyet2")String total_nilai_bilyet2,
                                     @Field ("persen_dari_plafond2")String persen_dari_plafond2,

                                     //Aspek Jaminan Bilyet Deposito 3
                                     @Field ("jaminan_bilyet3")String jaminan_bilyet3,
                                     @Field ("atas_nama_bilyet3")String atas_nama_bilyet3,
                                     @Field ("no_bilyet3")String no_bilyet3,
                                     @Field ("alamat_bilyet3")String alamat_bilyet3,
                                     @Field ("ikatan_bilyet3")String ikatan_bilyet3,
                                     @Field ("nilai_bilyet3")String nilai_bilyet3,
                                     @Field ("total_nilai_bilyet3")String total_nilai_bilyet3,
                                     @Field ("persen_dari_plafond3")String persen_dari_plafond3);





    @GET("read.php")
    Call<ResponsModel> getBiodata(@Query("key") String keyword,
                                      @Query("key2") String keyword2);


    @GET("read1.php")
    Call<List<DataModel>> getBiodataa(@Query("key") String keyword,
                                     @Query("key2") String keyword2);


    @FormUrlEncoded
    @POST("update.php")
    Call<ResponsModel> updateData(@Field("id") String id,
                                  @Field("tgl_permohonan") String tgl_permohonan,
                                  @Field ("no_reg")String no_reg,
                                  @Field ("nama_pemohon")String nama_pemohon,
                                  @Field ("nama_panggilan")String nama_panggilan,
                                  @Field ("tempat_lahir")String tempat_lahir,
                                  @Field ("tgl_lahir")String tgl_lahir,
                                  @Field ("no_ktp")String no_ktp,
                                  @Field ("masa_berlaku_ktp")String masa_berlaku_ktp,
                                  @Field ("alamat_sesuai_ktp")String alamat_sesuai_ktp,
                                  @Field ("nama_ibu_kandung")String nama_ibu_kandung,
                                  @Field ("kode_pos")String kode_pos,
                                  @Field ("pekerjaan_pemohon")String pekerjaan_pemohon,
                                  @Field ("nama_perusahaan")String nama_perusahaan,
                                  @Field ("jabatan")String jabatan,
                                  @Field ("alamat_perusahaan")String alamat_perusahaan,
                                  @Field ("status_pernikahan")String status_pernikahan,
                                  @Field ("jml_tanggungan")String jml_tanggungan,
                                  @Field ("pendidikan_terakhir")String pendidikan_terakhir,
                                  @Field ("status_rumah_tinggal")String status_rumah_tinggal,
                                  @Field ("lama_tinggal")String lama_tinggal,
                                  @Field ("alamat_rumah_tinggal")String alamat_rumah_tinggal,
                                  @Field ("no_telp")String no_telp,
                                  @Field ("no_hp")String no_hp,
                                  @Field ("nama_pasangan")String nama_pasangan,
                                  @Field ("tgl_lahir_pasangan")String tgl_lahir_pasangan,
                                  @Field ("no_ktp_pasangan")String no_ktp_pasangan,
                                  @Field ("masa_berlaku_ktp_pasangan")String masa_berlaku_ktp_pasangan,
                                  @Field ("pekerjaan_pasangan")String pekerjaan_pasangan,
                                  @Field ("tempat_lahir_pasangan")String tempat_lahir_pasangan,
                                  @Field ("alamat_pasangan")String alamat_pasangan,
                                  @Field ("penghasilan_per_bln")String penghasilan_per_bln,
                                  @Field ("penjamin")String penjamin,
                                  @Field ("alamat_penjamin")String alamat_penjamin,
                                  @Field ("tempat_lahir_penjamin")String tempat_lahir_penjamin,
                                  @Field ("tgl_lahir_penjamin")String tgl_lahir_penjamin,
                                  @Field ("no_ktp_penjamin")String no_ktp_penjamin,
                                  @Field ("masa_berlaku_ktp_penjamin")String masa_berlaku_ktp_penjamin,
                                  @Field ("nama_pasangan_penjamin")String nama_pasangan_penjamin,
                                  @Field ("alamat_pasangan_penjamin")String alamat_pasangan_penjamin,
                                  @Field ("tempat_lahir_pasangan_penjamin")String tempat_lahir_pasangan_penjamin,
                                  @Field ("tgl_lahir_pasangan_penjamin")String tgl_lahir_pasangan_penjamin,
                                  @Field ("no_ktp_pasangan_penjamin")String no_ktp_pasangan_penjamin,
                                  @Field ("masa_berlaku_ktp_pasangan_penjamin")String masa_berlaku_ktp_pasangan_penjamin,

                                  //Data Kredit
                                  @Field ("jenis_kredit")String jenis_kredit,
                                  @Field ("sektor_ekonomi")String sektor_ekonomi,
                                  @Field ("fasilitas_ke")String fasilitas_ke,
                                  @Field ("plafond_kredit")String plafond_kredit,
                                  @Field ("jkw")String jkw,
                                  @Field ("bunga")String bunga,
                                  @Field ("type_angsuran")String type_angsuran,
                                  @Field ("periode_pembayaran_pokok")String periode_pembayaran_pokok,
                                  @Field ("jml_angsuran_per_bln")String jml_angsuran_per_bln,
                                  @Field ("angsuran_pokok_pertama")String angsuran_pokok_pertama,
                                  @Field ("angsuran_bunga_pertama")String angsuran_bunga_pertama,
                                  @Field ("provisi")String provisi,
                                  @Field ("administrasi")String administrasi,
                                  @Field ("on_the_spot")String on_the_spot,
                                  @Field ("premi")String premi,
                                  @Field ("nama_asuransi")String nama_asuransi,
                                  @Field ("akad_kredit")String akad_kredit,
                                  @Field ("jenis_penggunaan")String jenis_penggunaan,
                                  @Field ("tujuan_penggunaan")String tujuan_penggunaan,
                                  @Field ("surveyor")String surveyor,

                                  //Aspek Kapasitas
                                  @Field ("rincian_pekerjaan")String rincian_pekerjaan,
                                  @Field ("alamat_usaha")String alamat_usaha,
                                  @Field ("lama_usaha")String lama_usaha,
                                  @Field ("deskripsi_usaha_utama")String deskripsi_usaha_utama,
                                  @Field ("uraian_kegiatan_usaha_lainnya")String uraian_kegiatan_usaha_lainnya,
                                  @Field ("uraian_kegiatan_usaha_lainnya1")String uraian_kegiatan_usaha_lainnya1,
                                  @Field ("deskripsi_usaha_sampingan")String deskripsi_usaha_sampingan,
                                  @Field ("deskripsi_usaha_pasangan")String deskripsi_usaha_pasangan,
                                  @Field ("kondisi_fisik_pemohon")String kondisi_fisik_pemohon,
                                  @Field ("kesimpulan")String kesimpulan,

                                  //Aspek Keuangan
                                  @Field ("kas")String kas,
                                  @Field ("piutang")String piutang,
                                  @Field ("persediaan")String persediaan,
                                  @Field ("inventaris")String inventaris,
                                  @Field ("tanah")String tanah,
                                  @Field ("total_aktiva")String total_aktiva,
                                  @Field ("hutang_dagang")String hutang_dagang,
                                  @Field ("hutang_bank")String hutang_bank,
                                  @Field ("pinjaman")String pinjaman,
                                  @Field ("modal")String modal,
                                  @Field ("laba")String laba,
                                  @Field ("total_pasiva")String total_pasiva,
                                  @Field ("pendapatan_usaha")String pendapatan_usaha,
                                  @Field ("biaya_usaha")String biaya_usaha,
                                  @Field ("laba_usaha")String laba_usaha,
                                  @Field ("pendapatan_lain")String pendapatan_lain,
                                  @Field ("total_pendapatan")String total_pendapatan,
                                  @Field ("biaya_rumah_tangga")String biaya_rumah_tangga,
                                  @Field ("biaya_listrik")String biaya_listrik,
                                  @Field ("biaya_pendidikan")String biaya_pendidikan,
                                  @Field ("biaya_transportasi")String biaya_transportasi,
                                  @Field ("biaya_sosial")String biaya_sosial,
                                  @Field ("angsuran_bank1")String angsuran_bank1,
                                  @Field ("angsuran_bank2")String angsuran_bank2,
                                  @Field ("angsuran_bank3")String angsuran_bank3,
                                  @Field ("angsuran_bank4")String angsuran_bank4,
                                  @Field ("angsuran_bank5")String angsuran_bank5,
                                  @Field ("angsuran_bank6")String angsuran_bank6,
                                  @Field ("biaya_lainnya")String biaya_lainnya,
                                  @Field ("total_biaya")String total_biaya,

                                  //Apek Pemasaran
                                  @Field ("kelola_usaha")String kelola_usaha,
                                  @Field ("persaingan_usaha")String persaingan_usaha,
                                  @Field ("pemasaran_usaha")String pemasaran_usaha,
                                  @Field ("amdal_usaha")String amdal_usaha,
                                  @Field ("prospek_usaha")String prospek_usaha,

                                  //Apek Karakter
                                  @Field ("kondite_kredit_lalu")String kondite_kredit_lalu,
                                  @Field ("referensi")String referensi,
                                  @Field ("info_lingkungan")String info_lingkungan,
                                  @Field ("avalis_kredit")String avalis_kredit,
                                  @Field ("karakter_lainnya")String karakter_lainnya,

                                  //Aspek Hukum
                                  @Field ("dasar_hukum")String dasar_hukum,
                                  @Field ("legalitas_identitas")String legalitas_identitas,

                                  //Analisa Kebutuhan
                                  @Field ("tujuan_modal")String tujuan_modal,
                                  @Field ("tujuan_pelunasan")String tujuan_pelunasan,
                                  @Field ("tujuan_pembelian")String tujuan_pembelian,
                                  @Field ("tujuan_renovasi")String tujuan_renovasi,
                                  @Field ("tujuan_sekolah")String tujuan_sekolah,
                                  @Field ("tujuan_lainnya")String tujuan_lainnya,
                                  @Field ("total_kebutuhan")String total_kebutuhan,
                                  @Field ("kebutuhan_bank")String kebutuhan_bank,

                                  @Field ("dana_angsuran")String dana_angsuran,
                                  @Field ("jkw_x1")String jkw_x1


    );


    @FormUrlEncoded
    @POST("update1.php")
    Call<ResponsModel> updateDataa(  @Field("id") String id,
                                     @Field ("no_reg1")String no_reg1,
                                      @Field ("nama_jaminan_shm1")String nama_jaminan_shm1,
                                      @Field ("jenis_jaminan_shm1")String jenis_jaminan_shm1,
                                      @Field ("atas_nama_shm1")String atas_nama_shm1,
                                      @Field ("alamat_atas_nama_shm1")String alamat_atas_nama_shm1,
                                      @Field ("no_ktp_atas_nama_shm1")String no_ktp_atas_nama_shm1,
                                      @Field ("masa_berlaku_shm1")String masa_berlaku_shm1,
                                      @Field ("ikatan_shm1")String ikatan_shm1,
                                      @Field ("nilai_ikatan_shm1")String nilai_ikatan_shm1,
                                      @Field ("no_SHM1")String no_SHM1,
                                      @Field ("no_gs_shm1")String no_gs_shm1,
                                      @Field ("luas_shm1")String luas_shm1,
                                      @Field ("lokasi_shm1")String lokasi_shm1,
                                      @Field ("asuransi_shm1")String asuransi_shm1,
                                      @Field ("nilai_tanah_shm1")String nilai_tanah_shm1,
                                      @Field ("nilai_bangunan_shm1")String nilai_bangunan_shm1,
                                      @Field ("total_taksiran_shm1")String total_taksiran_shm1,

                                      //Aspek Jaminan SHM 2
                                      @Field ("nama_jaminan_shm2")String nama_jaminan_shm2,
                                      @Field ("jenis_jaminan_shm2")String jenis_jaminan_shm2,
                                      @Field ("atas_nama_shm2")String atas_nama_shm2,
                                      @Field ("alamat_atas_nama_shm2")String alamat_atas_nama_shm2,
                                      @Field ("no_ktp_atas_nama_shm2")String no_ktp_atas_nama_shm2,
                                      @Field ("masa_berlaku_shm2")String masa_berlaku_shm2,
                                      @Field ("ikatan_shm2")String ikatan_shm2,
                                      @Field ("nilai_ikatan_shm2")String nilai_ikatan_shm2,
                                      @Field ("no_SHM2")String no_SHM2,
                                      @Field ("no_gs_shm2")String no_gs_shm2,
                                      @Field ("luas_shm2")String luas_shm2,
                                      @Field ("lokasi_shm2")String lokasi_shm2,
                                      @Field ("asuransi_shm2")String asuransi_shm2,
                                      @Field ("nilai_tanah_shm2")String nilai_tanah_shm2,
                                      @Field ("nilai_bangunan_shm2")String nilai_bangunan_shm2,
                                      @Field ("total_taksiran_shm2")String total_taksiran_shm2,

                                      //Aspek Jaminan 3
                                      @Field ("nama_jaminan_shm3")String nama_jaminan_shm3,
                                      @Field ("jenis_jaminan_shm3")String jenis_jaminan_shm3,
                                      @Field ("atas_nama_shm3")String atas_nama_shm3,
                                      @Field ("alamat_atas_nama_shm3")String alamat_atas_nama_shm3,
                                      @Field ("no_ktp_atas_nama_shm3")String no_ktp_atas_nama_shm3,
                                      @Field ("masa_berlaku_shm3")String masa_berlaku_shm3,
                                      @Field ("ikatan_shm3")String ikatan_shm3,
                                      @Field ("nilai_ikatan_shm3")String nilai_ikatan_shm3,
                                      @Field ("no_SHM3")String no_SHM3,
                                      @Field ("no_gs_shm3")String no_gs_shm3,
                                      @Field ("luas_shm3")String luas_shm3,
                                      @Field ("lokasi_shm3")String lokasi_shm3,
                                      @Field ("asuransi_shm3")String asuransi_shm3,
                                      @Field ("nilai_tanah_shm3")String nilai_tanah_shm3,
                                      @Field ("nilai_bangunan_shm3")String nilai_bangunan_shm3,
                                      @Field ("total_taksiran_shm3")String total_taksiran_shm3,

                                      //Aspek Jaminan 4
                                      @Field ("nama_jaminan_shm4")String nama_jaminan_shm4,
                                      @Field ("jenis_jaminan_shm4")String jenis_jaminan_shm4,
                                      @Field ("atas_nama_shm4")String atas_nama_shm4,
                                      @Field ("alamat_atas_nama_shm4")String alamat_atas_nama_shm4,
                                      @Field ("no_ktp_atas_nama_shm4")String no_ktp_atas_nama_shm4,
                                      @Field ("masa_berlaku_shm4")String masa_berlaku_shm4,
                                      @Field ("ikatan_shm4")String ikatan_shm4,
                                      @Field ("nilai_ikatan_shm4")String nilai_ikatan_shm4,
                                      @Field ("no_SHM4")String no_SHM4,
                                      @Field ("no_gs_shm4")String no_gs_shm4,
                                      @Field ("luas_shm4")String luas_shm4,
                                      @Field ("lokasi_shm4")String lokasi_shm4,
                                      @Field ("asuransi_shm4")String asuransi_shm4,
                                      @Field ("nilai_tanah_shm4")String nilai_tanah_shm4,
                                      @Field ("nilai_bangunan_shm4")String nilai_bangunan_shm4,
                                      @Field ("total_taksiran_shm4")String total_taksiran_shm4,

                                      //Aspek Jaminan 5
                                      @Field ("nama_jaminan_shm5")String nama_jaminan_shm5,
                                      @Field ("jenis_jaminan_shm5")String jenis_jaminan_shm5,
                                      @Field ("atas_nama_shm5")String atas_nama_shm5,
                                      @Field ("alamat_atas_nama_shm5")String alamat_atas_nama_shm5,
                                      @Field ("no_ktp_atas_nama_shm5")String no_ktp_atas_nama_shm5,
                                      @Field ("masa_berlaku_shm5")String masa_berlaku_shm5,
                                      @Field ("ikatan_shm5")String ikatan_shm5,
                                      @Field ("nilai_ikatan_shm5")String nilai_ikatan_shm5,
                                      @Field ("no_SHM5")String no_SHM5,
                                      @Field ("no_gs_shm5")String no_gs_shm5,
                                      @Field ("luas_shm5")String luas_shm5,
                                      @Field ("lokasi_shm5")String lokasi_shm5,
                                      @Field ("asuransi_shm5")String asuransi_shm5,
                                      @Field ("nilai_tanah_shm5")String nilai_tanah_shm5,
                                      @Field ("nilai_bangunan_shm5")String nilai_bangunan_shm5,
                                      @Field ("total_taksiran_shm5")String total_taksiran_shm5,

                                      //Aspek Jaminan BPKB 1
                                      @Field ("nama_jaminan_bpkb1")String nama_jaminan_bpkb1,
                                      @Field ("no_bpkb1")String no_bpkb1,
                                      @Field ("merk_bpkb1")String merk_bpkb1,
                                      @Field ("tahun_bpkb1")String tahun_bpkb1,
                                      @Field ("no_rangka_bpkb1")String no_rangka_bpkb1,
                                      @Field ("no_mesin_bpkb1")String no_mesin_bpkb1,
                                      @Field ("warna_bpkb1")String warna_bpkb1,
                                      @Field ("nopol_bpkb1")String nopol_bpkb1,
                                      @Field ("atas_nama_bpkb1")String atas_nama_bpkb1,
                                      @Field ("alamat_bpkb1")String alamat_bpkb1,
                                      @Field ("ikatan_bpkb1")String ikatan_bpkb1,
                                      @Field ("nilai_fiducia1")String nilai_fiducia1,
                                      @Field ("nilai_taksiran_bpkb1")String nilai_taksiran_bpkb1,

                                      //Aspek Jaminan BPKB 2
                                      @Field ("nama_jaminan_bpkb2")String nama_jaminan_bpkb2,
                                      @Field ("no_bpkb2")String no_bpkb2,
                                      @Field ("merk_bpkb2")String merk_bpkb2,
                                      @Field ("tahun_bpkb2")String tahun_bpkb2,
                                      @Field ("no_rangka_bpkb2")String no_rangka_bpkb2,
                                      @Field ("no_mesin_bpkb2")String no_mesin_bpkb2,
                                      @Field ("warna_bpkb2")String warna_bpkb2,
                                      @Field ("nopol_bpkb2")String nopol_bpkb2,
                                      @Field ("atas_nama_bpkb2")String atas_nama_bpkb2,
                                      @Field ("alamat_bpkb2")String alamat_bpkb2,
                                      @Field ("ikatan_bpkb2")String ikatan_bpkb2,
                                      @Field ("nilai_fiducia2")String nilai_fiducia2,
                                      @Field ("nilai_taksiran_bpkb2")String nilai_taksiran_bpkb2,

                                      //Aspek Jaminan BPKB 3
                                      @Field ("nama_jaminan_bpkb3")String nama_jaminan_bpkb3,
                                      @Field ("no_bpkb3")String no_bpkb3,
                                      @Field ("merk_bpkb3")String merk_bpkb3,
                                      @Field ("tahun_bpkb3")String tahun_bpkb3,
                                      @Field ("no_rangka_bpkb3")String no_rangka_bpkb3,
                                      @Field ("no_mesin_bpkb3")String no_mesin_bpkb3,
                                      @Field ("warna_bpkb3")String warna_bpkb3,
                                      @Field ("nopol_bpkb3")String nopol_bpkb3,
                                      @Field ("atas_nama_bpkb3")String atas_nama_bpkb3,
                                      @Field ("alamat_bpkb3")String alamat_bpkb3,
                                      @Field ("ikatan_bpkb3")String ikatan_bpkb3,
                                      @Field ("nilai_fiducia3")String nilai_fiducia3,
                                      @Field ("nilai_taksiran_bpkb3")String nilai_taksiran_bpkb3,

                                      //Aspek Jaminan BPKB 4
                                      @Field ("nama_jaminan_bpkb4")String nama_jaminan_bpkb4,
                                      @Field ("no_bpkb4")String no_bpkb4,
                                      @Field ("merk_bpkb4")String merk_bpkb4,
                                      @Field ("tahun_bpkb4")String tahun_bpkb4,
                                      @Field ("no_rangka_bpkb4")String no_rangka_bpkb4,
                                      @Field ("no_mesin_bpkb4")String no_mesin_bpkb4,
                                      @Field ("warna_bpkb4")String warna_bpkb4,
                                      @Field ("nopol_bpkb4")String nopol_bpkb4,
                                      @Field ("atas_nama_bpkb4")String atas_nama_bpkb4,
                                      @Field ("alamat_bpkb4")String alamat_bpkb4,
                                      @Field ("ikatan_bpkb4")String ikatan_bpkb4,
                                      @Field ("nilai_fiducia4")String nilai_fiducia4,
                                      @Field ("nilai_taksiran_bpkb4")String nilai_taksiran_bpkb4,

                                      //Aspek Jaminan BPKB 5
                                      @Field ("nama_jaminan_bpkb5")String nama_jaminan_bpkb5,
                                      @Field ("no_bpkb5")String no_bpkb5,
                                      @Field ("merk_bpkb5")String merk_bpkb5,
                                      @Field ("tahun_bpkb5")String tahun_bpkb5,
                                      @Field ("no_rangka_bpkb5")String no_rangka_bpkb5,
                                      @Field ("no_mesin_bpkb5")String no_mesin_bpkb5,
                                      @Field ("warna_bpkb5")String warna_bpkb5,
                                      @Field ("nopol_bpkb5")String nopol_bpkb5,
                                      @Field ("atas_nama_bpkb5")String atas_nama_bpkb5,
                                      @Field ("alamat_bpkb5")String alamat_bpkb5,
                                      @Field ("ikatan_bpkb5")String ikatan_bpkb5,
                                      @Field ("nilai_fiducia5")String nilai_fiducia5,
                                      @Field ("nilai_taksiran_bpkb5")String nilai_taksiran_bpkb5,

                                      //Aspek Jaminan Bilyet Deposito 1
                                      @Field ("jaminan_bilyet1")String jaminan_bilyet1,
                                      @Field ("atas_nama_bilyet1")String atas_nama_bilyet1,
                                      @Field ("no_bilyet1")String no_bilyet1,
                                      @Field ("alamat_bilyet1")String alamat_bilyet1,
                                      @Field ("ikatan_bilyet1")String ikatan_bilyet1,
                                      @Field ("nilai_bilyet1")String nilai_bilyet1,
                                      @Field ("total_nilai_bilyet1")String total_nilai_bilyet1,
                                      @Field ("persen_dari_plafond1")String persen_dari_plafond1,

                                      //Aspek Jaminan Bilyet Deposito 2
                                      @Field ("jaminan_bilyet2")String jaminan_bilyet2,
                                      @Field ("atas_nama_bilyet2")String atas_nama_bilyet2,
                                      @Field ("no_bilyet2")String no_bilyet2,
                                      @Field ("alamat_bilyet2")String alamat_bilyet2,
                                      @Field ("ikatan_bilyet2")String ikatan_bilyet2,
                                      @Field ("nilai_bilyet2")String nilai_bilyet2,
                                      @Field ("total_nilai_bilyet2")String total_nilai_bilyet2,
                                      @Field ("persen_dari_plafond2")String persen_dari_plafond2,

                                      //Aspek Jaminan Bilyet Deposito 3
                                      @Field ("jaminan_bilyet3")String jaminan_bilyet3,
                                      @Field ("atas_nama_bilyet3")String atas_nama_bilyet3,
                                      @Field ("no_bilyet3")String no_bilyet3,
                                      @Field ("alamat_bilyet3")String alamat_bilyet3,
                                      @Field ("ikatan_bilyet3")String ikatan_bilyet3,
                                      @Field ("nilai_bilyet3")String nilai_bilyet3,
                                      @Field ("total_nilai_bilyet3")String total_nilai_bilyet3,
                                      @Field ("persen_dari_plafond3")String persen_dari_plafond3);


    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponsModel> deleteData(@Field("no_reg") String no_reg);

    @FormUrlEncoded
    @POST("search.php")
    Call<ResponsModel> search(@Field("search") String search);

    String BASE_URL = "http://36.91.39.47:8080/analisdp22/";

    //this is our multipart request
    //we have two parameters on is name and other one is description
    @Multipart
    @POST("Api.php?apicall=upload")
    Call<ResponsModel> uploadImage(@Part("image\"; filename=\"myfile.jpg\" ") RequestBody file, @Part("desc") RequestBody desc);

    @Multipart
    @POST("uploadimage.php")
    Call<ResponsModel> uploadImage (@Part MultipartBody.Part image);

}
