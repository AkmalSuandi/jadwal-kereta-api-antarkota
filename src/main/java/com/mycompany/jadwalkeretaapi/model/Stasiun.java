/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jadwalkeretaapi.model;


import java.util.HashMap;
import java.util.Map;

public class Stasiun {
    private String namaStasiun;
    // Map untuk menyimpan stasiun tetangga yang terhubung langsung dan bobot jarak/waktu
    private Map<Stasiun, Integer> ruteTerhubung;

    public Stasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
        this.ruteTerhubung = new HashMap<>();
    }

    // Menambahkan jalur (edge) ke stasiun lain
    public void tambahRute(Stasiun stasiunTujuan, int bobot) {
        ruteTerhubung.put(stasiunTujuan, bobot);
    }

    public String getNamaStasiun() {
        return namaStasiun;
    }

    public Map<Stasiun, Integer> getRuteTerhubung() {
        return ruteTerhubung;
    }
}
