# Jadwal Kereta Api Antarkota 🚆

Aplikasi desktop berbasis JavaFX untuk mengecek dan mengelola jadwal kereta api antarkota. Aplikasi ini memetakan rute perjalanan kereta api yang menghubungkan stasiun-stasiun di wilayah Jakarta, Bekasi, Purwakarta, dan Bandung.

## ✨ Fitur Utama
- **Antarmuka Pengguna (GUI):** Dibangun menggunakan FXML dan dipercantik dengan kustomisasi CSS.
- **Pencarian Rute:** Mengimplementasikan struktur data *Graph* untuk menghubungkan jalur antar stasiun secara logis.
- **Arsitektur Rapi:** Dikembangkan dengan pola desain Model-View-Controller (MVC) agar kode lebih terstruktur dan mudah dikembangkan.

## 🛠️ Teknologi yang Digunakan
- **Bahasa Pemrograman:** Java
- **Framework GUI:** JavaFX
- **IDE:** Apache NetBeans
- **Build Tool:** Maven

## 🚀 Cara Menjalankan Proyek (Lokal)

### Persyaratan Sistem
- Java Development Kit (JDK) 11 atau versi lebih baru.
- Apache NetBeans IDE (disarankan versi terbaru).
- Git.

### Langkah-langkah Menjalankan Aplikasi

1. **Kloning Repositori**
   Buka terminal atau *command prompt*, lalu jalankan perintah Git berikut untuk mengunduh kode sumber ke komputer lokal Anda:
   ```bash
   git clone [https://github.com/username-anda/JadwalKeretaApi.git](https://github.com/username-anda/JadwalKeretaApi.git)

2. **Buka Proyek di Apache NetBeans**
   - Buka aplikasi Apache NetBeans.
   - Klik menu **File** > **Open Project...** (atau tekan `Ctrl + Shift + O`).
   - Navigasikan ke folder proyek hasil kloning tadi, lalu klik **Open Project**.

3. **Sinkronisasi dan Build (Maven)**
   - Pada panel **Projects** di sebelah kiri, klik kanan pada nama proyek Anda.
   - Pilih **Clean and Build**.
   - Tunggu prosesnya selesai. Maven akan secara otomatis membaca file `pom.xml`, mengunduh dependensi JavaFX yang diperlukan, dan merakit proyek hingga muncul pesan `BUILD SUCCESS` berwarna hijau di panel *Output*.

4. **Eksekusi Aplikasi**
   - Setelah proses *build* berhasil, klik kanan kembali pada nama proyek Anda.
   - Pilih **Run** (atau tekan tombol **F6** pada *keyboard*).
   - Jendela antarmuka (GUI) aplikasi navigasi kereta api akan langsung terbuka dan siap digunakan.

  
Berikut Tampilan GUI nya:

<img width="795" height="632" alt="image" src="https://github.com/user-attachments/assets/7d66c512-ecb8-4383-8d5b-2d9b9a838c45" />
