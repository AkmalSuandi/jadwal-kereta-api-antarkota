/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jadwalkeretaapi.model;


public class MainApp {
    public static void main(String[] args) {
        // 1. Memuat data stasiun dan graf jalur kereta
        JalurKereta sistemKereta = new JalurKereta();

        System.out.println("--- PENGUJIAN SISTEM NAVIGASI KERETA ---");
        System.out.println("Mencari rute tercepat dari Jakarta ke Bandung...\n");

        // 2. Menjalankan algoritma pencarian rute
        String hasilDijkstra = sistemKereta.cariRuteTercepat("Jakarta", "Bandung");

        // 3. Menampilkan hasil ke terminal
        System.out.println(hasilDijkstra);
        
        System.out.println("\n----------------------------------------");
        System.out.println("Mencari rute dari Bekasi ke Purwakarta...\n");
        System.out.println(sistemKereta.cariRuteTercepat("Bekasi", "Purwakarta"));
    }
}