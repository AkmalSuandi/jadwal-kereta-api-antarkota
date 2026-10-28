/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jadwalkeretaapi.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class JalurKereta {
    private Map<String, Stasiun> daftarStasiun;

    public JalurKereta() {
        this.daftarStasiun = new HashMap<>();
        inisialisasiDataAwal();
    }

    public void tambahStasiun(String namaStasiun) {
        daftarStasiun.putIfAbsent(namaStasiun, new Stasiun(namaStasiun));
    }

    public void tambahKoneksi(String asal, String tujuan, int bobot) {
        Stasiun stasiunAsal = daftarStasiun.get(asal);
        Stasiun stasiunTujuan = daftarStasiun.get(tujuan);

        if (stasiunAsal == null || stasiunTujuan == null) {
            throw new IllegalArgumentException("Gagal: Stasiun " + asal + " atau " + tujuan + " belum terdaftar.");
        }

        stasiunAsal.tambahRute(stasiunTujuan, bobot);
        stasiunTujuan.tambahRute(stasiunAsal, bobot);
    }

    public Stasiun getStasiun(String namaStasiun) {
        return daftarStasiun.get(namaStasiun);
    }

    // --- FITUR PROYEK BESAR: ALGORITMA DIJKSTRA ---
    public String cariRuteTercepat(String asal, String tujuan) {
        Stasiun nodeAsal = daftarStasiun.get(asal);
        Stasiun nodeTujuan = daftarStasiun.get(tujuan);

        if (nodeAsal == null || nodeTujuan == null) {
            return "Stasiun asal atau tujuan tidak valid.";
        }

        // Menyimpan jarak terpendek dari asal ke setiap stasiun
        Map<Stasiun, Integer> jarakTerpendek = new HashMap<>();
        // Menyimpan jejak stasiun sebelumnya untuk merekonstruksi rute
        Map<Stasiun, Stasiun> stasiunSebelumnya = new HashMap<>();
        // PriorityQueue untuk memproses stasiun dengan jarak terpendek lebih dulu
        PriorityQueue<Stasiun> antrean = new PriorityQueue<>(Comparator.comparingInt(jarakTerpendek::get));

        // Inisialisasi jarak awal menjadi tak terhingga (Integer.MAX_VALUE)
        for (Stasiun stasiun : daftarStasiun.values()) {
            jarakTerpendek.put(stasiun, Integer.MAX_VALUE);
        }
        
        jarakTerpendek.put(nodeAsal, 0);
        antrean.add(nodeAsal);

        while (!antrean.isEmpty()) {
            Stasiun stasiunSaatIni = antrean.poll();

            // Jika sudah mencapai tujuan, proses bisa dihentikan lebih awal
            if (stasiunSaatIni.equals(nodeTujuan)) break;

            // Evaluasi tetangga dari stasiun saat ini
            for (Map.Entry<Stasiun, Integer> tetangga : stasiunSaatIni.getRuteTerhubung().entrySet()) {
                Stasiun stasiunTetangga = tetangga.getKey();
                int bobotKeTetangga = tetangga.getValue();
                
                int totalJarakBaru = jarakTerpendek.get(stasiunSaatIni) + bobotKeTetangga;

                // Jika ditemukan jalur yang lebih cepat, perbarui jarak dan jejak rutenya
                if (totalJarakBaru < jarakTerpendek.get(stasiunTetangga)) {
                    jarakTerpendek.put(stasiunTetangga, totalJarakBaru);
                    stasiunSebelumnya.put(stasiunTetangga, stasiunSaatIni);
                    
                    // Perbarui posisi di antrean (hapus lalu tambah lagi agar terurut ulang)
                    antrean.remove(stasiunTetangga);
                    antrean.add(stasiunTetangga);
                }
            }
        }

        // Rekonstruksi rute dari tujuan mundur ke asal
        if (jarakTerpendek.get(nodeTujuan) == Integer.MAX_VALUE) {
            return "Tidak ada rute yang tersedia dari " + asal + " ke " + tujuan;
        }

        List<String> ruteLengkap = new ArrayList<>();
        Stasiun step = nodeTujuan;
        while (step != null) {
            ruteLengkap.add(step.getNamaStasiun());
            step = stasiunSebelumnya.get(step);
        }
        
        // Balikkan urutan karena direkonstruksi dari belakang
        Collections.reverse(ruteLengkap);
        
        return "Rute: " + String.join(" -> ", ruteLengkap) + 
               "\nEstimasi Waktu: " + jarakTerpendek.get(nodeTujuan) + " menit";
    }

    private void inisialisasiDataAwal() {
        tambahStasiun("Jakarta");
        tambahStasiun("Bekasi");
        tambahStasiun("Purwakarta");
        tambahStasiun("Bandung");

        tambahKoneksi("Jakarta", "Bekasi", 20);
        tambahKoneksi("Bekasi", "Purwakarta", 50);
        tambahKoneksi("Purwakarta", "Bandung", 70);
    }
}