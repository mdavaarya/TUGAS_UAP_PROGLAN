# UAP_PROGLAN

# Sistem Manajemen Kalori dengan GUI

Proyek ini adalah aplikasi Java berbasis GUI untuk mengelola konsumsi kalori harian. Aplikasi ini terdiri dari beberapa frame, termasuk login, input pengguna, dashboard, dan manajemen makanan/minuman.

## Fitur Utama

1. **Login**: Pengguna dapat login menggunakan username dan password.
2. **Input Data Pengguna**: Pengguna dapat memasukkan usia, berat badan, dan tinggi badan untuk menghitung kebutuhan kalori harian (BMR).
3. **Dashboard**: Menampilkan konsumsi kalori harian pengguna, memungkinkan pengguna menambahkan makanan/minuman, serta menampilkan sisa kalori.
4. **Database Makanan dan Minuman**: Terdapat daftar makanan dan minuman beserta jumlah kalorinya.

## Struktur Proyek

```

├── Main.java
├── LoginFrame.java
├── UserInputFrame.java
├── DashboardFrame.java
├── FoodDatabase.java
```

### Penjelasan Kode

1. **Main.java**
   - Entry point aplikasi.
   - Memulai aplikasi dengan memunculkan `LoginFrame`.

2. **LoginFrame.java**
   - Frame untuk login.
   - Mengautentikasi username dan password (username: `admin`, password: `admin`).

3. **UserInputFrame.java**
   - Frame untuk input data pengguna.
   - Pengguna memasukkan usia, berat badan, dan tinggi badan untuk menghitung BMR.

4. **DashboardFrame.java**
   - Frame utama untuk mengelola konsumsi kalori.
   - Menampilkan progres konsumsi kalori dengan progress bar.
   - Menyediakan fitur untuk menambahkan makanan dan minuman dari database.

5. **FoodDatabase.java**
   - Database sederhana untuk makanan dan minuman.
   - Menyediakan informasi kalori untuk berbagai item.

## Cara Menjalankan

1. Pastikan Anda memiliki **Java Development Kit (JDK)** terinstal di komputer Anda.
2. Clone repository ini atau salin file proyek ke komputer Anda.
3. Buka terminal, arahkan ke direktori proyek, dan jalankan perintah berikut:

   ```bash
   javac org/example/uap/*.java
   java org.example.uap.Main
   ```

4. Aplikasi akan dimulai dengan tampilan login.

## Persyaratan Sistem

- **Java**: Versi 8 atau lebih baru
- **OS**: Windows/Mac/Linux


