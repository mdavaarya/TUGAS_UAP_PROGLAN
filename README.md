# UAP_PROGLAN

## Sistem Manajemen Kalori dengan GUI

Proyek ini adalah aplikasi Java berbasis GUI untuk membantu pengguna mengelola konsumsi kalori harian. Aplikasi ini terdiri dari beberapa frame, termasuk login, input pengguna, dashboard, dan manajemen makanan/minuman.

## Fitur Utama

1. **Login**
   - Pengguna dapat login menggunakan username dan password default.
   - Autentikasi menggunakan kombinasi username dan password (default: username: `admin`, password: `admin`).

2. **Input Data Pengguna**
   - Pengguna memasukkan data usia, berat badan, tinggi badan, dan jenis kelamin.
   - Aplikasi menghitung kebutuhan kalori harian (BMR) berdasarkan data tersebut.

3. **Dashboard**
   - Menampilkan konsumsi kalori harian pengguna dalam bentuk progress bar.
   - Memungkinkan pengguna untuk:
     - Menambahkan makanan/minuman dari database.
     - Mengelola database makanan/minuman (CRUD).
     - Melihat sisa kalori harian.

4. **Database Makanan dan Minuman**
   - Daftar makanan dan minuman disertai informasi kalori.
   - Mendukung operasi CRUD untuk makanan/minuman.

## Struktur Proyek

```
├── Main.java
├── LoginFrame.java
├── UserInputFrame.java
├── DashboardFrame.java
├── FoodDatabase.java
```

### Penjelasan File

1. **Main.java**
   - Entry point aplikasi.
   - Menampilkan `LoginFrame` sebagai frame awal.

2. **LoginFrame.java**
   - Frame untuk login.
   - Mengautentikasi pengguna sebelum melanjutkan ke input data.

3. **UserInputFrame.java**
   - Frame untuk input data pengguna.
   - Menggunakan data usia, berat badan, tinggi badan, dan jenis kelamin untuk menghitung BMR.

4. **DashboardFrame.java**
   - Frame utama untuk pengguna mengelola konsumsi kalori.
   - Fitur:
     - Menambahkan makanan/minuman dari database.
     - Menampilkan progress kalori harian dengan progress bar.
     - Mengelola database makanan/minuman (CRUD).

5. **FoodDatabase.java**
   - Menyediakan database sederhana untuk makanan dan minuman.
   - Mendukung operasi CRUD untuk menambah, menghapus, atau melihat item.

## Cara Menjalankan

1. Pastikan Anda telah menginstal **Java Development Kit (JDK)** di komputer Anda.
2. Clone repository ini atau salin file proyek ke komputer Anda.
3. Buka terminal atau command prompt, arahkan ke direktori proyek, lalu jalankan perintah berikut:

   ```bash
   javac org/example/uap/*.java
   java org.example.uap.Main
   ```

4. Aplikasi akan dimulai dengan tampilan login.

## Persyaratan Sistem

- **Java**: Versi 8 atau lebih baru.
- **OS**: Windows/Mac/Linux.

## Contoh Penggunaan

1. Login dengan username dan password.
2. Masukkan data pengguna (usia, berat badan, tinggi badan, dan jenis kelamin).
3. Lihat kebutuhan kalori harian yang dihitung.
4. Tambahkan makanan/minuman ke daftar konsumsi harian.
5. Pantau konsumsi kalori melalui progress bar di dashboard.
6. Gunakan fitur manajemen database untuk menambah atau menghapus item dari daftar makanan/minuman.

