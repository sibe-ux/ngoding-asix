#include <iostream>
using namespace std;
main(){
    char names[50],jabatan;
    int bulan,gaji;
    cout<< "Program pengolahan gaji bersih pegawai perusahaan A\n";
    cout<< "--------------------------------\n"<<endl;
    //saya menggunakan int karena hasil pembagian terhadap pajak dan asuransi tetap berbentuk bilangan bulat//
    cout<<"Masukkan Nama Pegawai : ";
    gets (names);
    cout<<"Jabatan\n"<<"a.OB\n"<<"b.Karyawan\n"<<"c.Direktur\n"<<"Pilih jabatan yang tersedia : ";
    cin >> jabatan;
    cout << "Masukkan lama waktu bekerja pegawai (Dalam Bulan) : ";
    cin >> bulan;
    cout << "--------------------------------\n" << endl;
    if (jabatan=='a'){
        gaji =bulan * (1800000 + 300000 - (0.15*2100000));
        cout <<"Nama Pegawai : "<<" (OB)"<< names<< endl;
    }else if (jabatan=='b'){
        gaji =bulan * (2500000 + 500000 - (0.15*3000000));
        cout <<"Nama Pegawai : "<<" (Karyawan)"<< names<< endl;
    }else if (jabatan=='c'){
        gaji =bulan * (4000000 + 750000 - (0.15*4750000));
        cout <<"Nama Pegawai : "<< names<<" (Direktur)"<< endl;
    }else{
        cout << "ERROR";
    }
    cout <<"Gaji Bersih selama bekerja dalam "<<bulan<<" bulan adalah : Rp."<< gaji << endl; 
}