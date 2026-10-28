package com.mycompany.jadwalkeretaapi;

import com.mycompany.jadwalkeretaapi.model.JalurKereta; // Sesuaikan jika package model Anda berbeda
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PrimaryController {

    // Menghubungkan variabel ini dengan fx:id di Scene Builder
    @FXML
    private Button btnJakarta;
    @FXML
    private Button btnBekasi;
    @FXML
    private Button btnPurwakarta;
    @FXML
    private Button btnBandung;
    @FXML
    private TextArea areaOutput;

    // Objek untuk memanggil algoritma pencarian rute
    private JalurKereta sistemKereta;
    // Variabel untuk menyimpan stasiun klik pertama
    private String stasiunAsal = "";

    // Method ini otomatis dijalankan pertama kali saat aplikasi terbuka
    @FXML
    public void initialize() {
        sistemKereta = new JalurKereta();
        areaOutput.setText("Sistem Navigasi Kereta Antar Kota Siap.\nSilakan klik stasiun keberangkatan Anda.");
    }

    // Method ini dijalankan setiap kali salah satu dari 4 tombol stasiun diklik
    @FXML
    private void handlePilihStasiun(ActionEvent event) {
        // Mendeteksi tombol spesifik mana yang sedang diklik
        Button tombolDitekan = (Button) event.getSource();
        
        // Mengambil nama stasiun dari teks yang tertulis di tombol (misal: "Jakarta")
        String namaStasiun = tombolDitekan.getText(); 

        if (stasiunAsal.isEmpty()) {
            // KLIK PERTAMA: Set sebagai stasiun keberangkatan
            stasiunAsal = namaStasiun;
            areaOutput.setText("Stasiun Keberangkatan: " + stasiunAsal + "\nSilakan klik stasiun tujuan Anda.");
        } else {
            // KLIK KEDUA: Set sebagai stasiun tujuan dan lakukan perhitungan
            String stasiunTujuan = namaStasiun;
            
            // Validasi jika pengguna mengklik stasiun yang sama dua kali
            if (stasiunAsal.equals(stasiunTujuan)) {
                areaOutput.setText("Stasiun asal dan tujuan tidak boleh sama.\nSilakan klik stasiun tujuan yang lain.");
                return;
            }

            areaOutput.setText("Mencari rute tercepat dari " + stasiunAsal + " ke " + stasiunTujuan + "...\n\n");
            
            // Memanggil algoritma Dijkstra dari backend
            String hasilRute = sistemKereta.cariRuteTercepat(stasiunAsal, stasiunTujuan);
            
            // Menampilkan hasil ke layar TextArea
            areaOutput.appendText(hasilRute + "\n\n--- Pencarian Selesai ---\nSilakan klik stasiun baru untuk mencari rute lain.");
            
            // Mengosongkan stasiun asal agar siap untuk pencarian rute berikutnya
            stasiunAsal = "";
        }
    }
}