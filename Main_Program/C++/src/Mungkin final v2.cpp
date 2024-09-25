#include <iostream>
using namespace std;

int banyak_lantai;
int orang_max;

int arah_gerak=1; // naik=1 / turun=0
int posisi_lift=1;

int lift_bergerak=0; // jalan=1 / berhenti=0

int muatan=0; // muatan lift saat ini

int temp_turun=0; // variabel kondisi penjemputan pengguna turun
int temp_naik=0;  // variabel kondisi penjemputan pengguna naik
int tujuan=0;   // variabel kondisi ada tidaknya jemputan naik maupun turun


int gerak_naik (int naik[], int keluar[], int antrian_turun, int tujuan);
int gerak_turun (int turun[], int keluar[], int antrian_naik, int tujuan);
int cek_tombol(int * naik, int * turun) ;
int penentuan_arah(int naikTurun, int * naik, int * turun, int * keluar, int temp_check);
void banyak_naik(int * naik, int * keluar);
void banyak_turun(int * turun, int * keluar);
void bongkar_muat(int * naik, int * turun, int * keluar);

int main(){

	int hslArah=-100;
	int cek_naik=0;
	int cek_turun=0;
	cout << " "<<endl;
	cout << " "<<endl;
	cout << " SELAMAT DATANG DI PROGRAM LIFT      "<<endl;
	cout << " "<<endl;
	cout << " "<<endl<<endl;

	cout<<"Silahkan masukan jumlah lantai: ";
	cin>>banyak_lantai;

	cout<<"Masukkan kapasitas maksimum lift (orang) : ";
	cin>>orang_max;
	cout << " "<< endl;

	// Deklarasi array
	int naik[banyak_lantai+1], turun[banyak_lantai+1], keluar[banyak_lantai+1];

	int i=0;
	while (i<=banyak_lantai) {
        naik[i]=0;
		turun[i]=0;
		keluar[i]=0;
		i++;
	}
	int hasilTombolLuar=0;

	while(0<1) {
		// Infinity loop cek ada tombol yang tertekan atau tidak
		while(0<1){
			hasilTombolLuar=cek_tombol(naik,turun);   //memangggil fungsi pengecekan tombol luar , disimpan dalam variabel
			if(hasilTombolLuar==-999) return 0;       //Jika kembalian -999, maka keluar program
			else if(hasilTombolLuar==0) break;        //Looping pengecekan tombol luar berhenti jika kembalian 0
		}
		if(lift_bergerak==1 && lift_bergerak!=0) {                         //keadaan lift sedang bergerak
			// JIKA ARAH NAIK
			if(arah_gerak==1 && arah_gerak!=0) {
				//JIKA KEMBALIAN 0 LANJUTKAN NAIK
				if(cek_naik==0 && cek_naik!=1) {

					if(tujuan==0 && tujuan!=1)
						cek_naik=gerak_naik(naik,keluar,0,0);

					else
						cek_naik=gerak_naik(naik,keluar,1,tujuan);
				}
				else
					{
						if(naik[posisi_lift]>0 || turun[posisi_lift]>0)
							lift_bergerak=0;
					}

			}

			else {
				//JIKA KEMBALIAN 0 LANJUTKAN TURUN
				if(cek_turun==0 && cek_turun!=1) {
					if(tujuan==0 && tujuan!=1)
						cek_turun=gerak_turun(turun,keluar,0,0);
					else
						cek_turun=gerak_turun(turun,keluar,1,tujuan);
				}
				else {
					if(naik[posisi_lift]>0 || turun[posisi_lift]>0) lift_bergerak=0;
				}
			}
		}

		if(lift_bergerak==0 && lift_bergerak!=1) {                         //ketika lift diam dapat dilakukan bongkar muat pengguna
			bongkar_muat(naik,turun,keluar);
			hslArah=penentuan_arah(arah_gerak,naik,turun,keluar,0);
			if(hslArah==4) {                            //kembalian 4 menandakan lift harus balik arah dan kembali memuat
				if(arah_gerak==1) {
					arah_gerak=0;
					bongkar_muat(naik,turun,keluar);
				}
				else {
					arah_gerak=1;
					bongkar_muat(naik,turun,keluar);
				}
				hslArah=penentuan_arah(arah_gerak,naik,turun,keluar,0);
			}
			if(hslArah!=-1) {
                    cek_naik=0;
				cek_turun=0;
				lift_bergerak=1;}
			else {


				//jika tidak ada penggilan lift tetap diam
				cout<<endl<<"LIFT BERADA DI LANTAI "<<posisi_lift << endl<<endl;
			}
		}
	}

	return 0;
}

int gerak_naik(int naik[], int keluar[], int antrian_turun = 0, int tujuan = 0) {
	if(posisi_lift>=banyak_lantai) {
		arah_gerak=0;
		//jika sudah berada di lantai paling atas
		//Lift berbalik arah
		return 4;
        }

	else {
		posisi_lift+=1;

		if(antrian_turun!=0) {

			//Jika ada yang mau turun di lantai atas

			// cek untuk memastikann benar-benar tidak yang ingin naik atau keluar.
			if(naik[posisi_lift]>0 || keluar[posisi_lift]>0) {
				lift_bergerak = 0;  //lift berhenti jika jika ada
				cout<<endl<<"LANTAI "<<posisi_lift<<" ^^^"<<endl<<endl;
				return 2;
			}
			else if(tujuan==posisi_lift) {  //lift menjemput sudah sampai di lantai pengguna
				lift_bergerak = 0;
				cout<<endl<<"LANTAI "<<posisi_lift<<" vvv"<<endl<<endl;
				arah_gerak = 0;
				return 1;
			}
			else {
				lift_bergerak = 1;  //jika belum sampai, jalan terus
				cout<<endl<<"LANTAI "<<posisi_lift<<" ^^^"<<endl<<endl;
				return 0;
			}

		}
		else { //Percabangan jika ada yang mau naik di lantai atas

			if(naik[posisi_lift]<=0 && keluar[posisi_lift]<=0) { lift_bergerak = 1;
				cout<<endl<<"LANTAI "<<posisi_lift<<" ^^^"<<endl<<endl;
				return 0;

			}
			else {

				//Jika ada yang ingin naik atau keluar
				lift_bergerak = 0;
				cout<<endl<<"LANTAI "<<posisi_lift<<" ^^^"<<endl<<endl;
				return 1;
			}
		}

	}
	return -15;
}

int gerak_turun(int turun[], int keluar[], int antrian_naik = 0, int tujuan = 0) {

	// Kembali ke atas saat di lantai terbawah
	if(posisi_lift<=1) {
		arah_gerak=1;
		// Kembalikan 4 agar lift balik arah
		return 4;
	}
	// Apabila posisi lift diatas 1 lantai maka turunkan
	else
	{

		posisi_lift-=1;

		//Apabila tidak ada yang turun di bawah
		if(antrian_naik!=0) {

			// Pengecekan ulang apakah di bawah ada orang yang akan turun
			if(turun[posisi_lift]>0 || keluar[posisi_lift]>0) {
				lift_bergerak = 0;
				cout<<endl<<"LANTAI "<<posisi_lift<<" vvv"<<endl<<endl;
				//Apabila ada, maka kembalikan 2
				return 2;
			}
			// Apabila ada yang ingin naik, maka berhenti, kemudian naik lagi
			else if(tujuan==posisi_lift) {
				lift_bergerak = 0;
				cout<<endl<<"LANTAI "<<posisi_lift<<" ^^^"<<endl<<endl;
				arah_gerak = 1;
				return 1;
			}
			//Lift terus bergerak
			else {
				lift_bergerak = 1;
				cout<<endl<<"LANTAI "<<posisi_lift<<" vvv"<<endl<<endl;
				// Saat lift sudah turun, maka kembalikan 0
				return 0;
			}

		}
			//Jika di bawah ada yang ingin turun
		else {
			//Jika ada yang mau turun atau kelaur, maka bergenti
			if(turun[posisi_lift]<=0 && keluar[posisi_lift]<=0) {
				lift_bergerak = 1;
				cout<<endl<<"LANTAI "<<posisi_lift<<" vvv"<<endl<<endl;
				return 0;
			}
			//Jika tidak maka tetap berjalan
			else {

				lift_bergerak = 0;
				cout<<endl<<"LANTAI "<<posisi_lift<<" vvv"<<endl<<endl;
				return 1;
			}
		}
	}

	// Kembalian apabila ada hal di luar prediksi
	return -15;
}
int cek_tombol(int * naik, int * turun) {

	//Deklarasi variabel yang akan digunakan untuk cek tombol
	int tertekan=0;
	int arah_tekan=0;
	int penumpang_masuk=0;
	//Program input nomot lantai yang tombolnya tertekan
	cout<<"Masukkan lantai yang tombolnya tertekan (Tidak ada=0, Keluar program=-999)"<<" : ";
	cin>>tertekan;
	//Jika input -999, maka akan keluar program
    //Jika input 0, maka akan diperintahkan untuk menginput ulang
	if (tertekan==-999 || tertekan == 0) return tertekan;
	//Jika input lebih dari 0, maka akan diproses ke langkah selanjutnya, yaitu arah lift
	else if(tertekan>0 && tertekan <= banyak_lantai) {
		//Input untuk arah lift, naik/turun
		cout<<"Arahnya kemana? (TURUN = 0, NAIK = 1)"<<" : ";
		cin>>arah_tekan;

		//Jika inputnya 0 atau 1, masuk ke proses selanjutnya
		if(arah_tekan==1 || arah_tekan==0) {
			//Input untuk jumlah orang yang masuk
			cout<<"Berapa orang?"<<" : ";
			cin>>penumpang_masuk;

			// Jika input orang yang masuk itu lebih besar atau sama dengan 0, akan diproses ke langkah selanjutnya
			if(penumpang_masuk>=0) {
				//Saat input 1 arahnya ke atas
				if(arah_tekan!=1) {
					// Jika berada pada lantai 1 dan menginput turun
					if(tertekan==1 && tertekan!=0) cout<<"Maaf, anda sudah berada di lantai terbawah"<<endl;
					else
					// Masukkan input ke dalam antrian turun
					turun[tertekan]+=penumpang_masuk;
				}
				else {


					//Jika sudah berada di lantai paling atas, akan ada peringatan
					if(tertekan==banyak_lantai && tertekan !=-999) cout<<"Maaf, anda sudah berada di lantai teratas"<<endl;
					else
					// Input ke antrian naik
					naik[tertekan]+=penumpang_masuk;
				}
			}
			// Jika input tidak sesuai perintah
			else cout<<"LANTAI TIDAK DITEMUKAN"<<endl;
		}
		 // Jika input tidak sesuai perintah
		else cout<<"BACA PERINTAHNYA!"<<endl;
		return 1;
	}
	// Jika input tidak sesuai perintah
	else cout<<"TIDAK ADA LANTAI "<<tertekan<<endl;
	return 1;
}
int penentuan_arah(int naikTurun, int * naik, int * turun, int * keluar, int temp_check = 0) {
	//Pembuatan variabel sementara untuk tujuan lift
	int temp_tujuan=0;
	temp_naik=0;
	temp_turun=0;
	tujuan=0;
	// Jika Naik
	if(naikTurun != 1) {
		// saat temp_check=2 maka tidak ditemukan, kembalikan -1
		if(temp_check>=2) return -1;

		// cek apakah ada yang turun di bawah posisi sekarang
		int i=posisi_lift-1;
		while(i>=1){
			//jika ada, simpan di variabel
			if(turun[i]>0 || keluar[i]>0) {
				temp_tujuan = i;
				break;
			} i--;
		}
		// jika temp_tujuan bukan nol, maka ada yang ingin turun
		if(temp_tujuan != 0)
			return 1;
		//agar turun

		 //cek di bawah ada yang ingin naik atau tidak
		else {

			int i=1;
			while(i<=posisi_lift) {
              	// jika ada masukkan ke temp_tujuan
				if(naik[i]>0) {
					temp_tujuan=i;
					break;
				} i++;
			}

			//saat temp_tujuan nilainya bukan 0 berarti ada yang akan naik dari posisi di bawah posisi sekarang
			if(temp_tujuan!=0) {
				//Jika posisi sekarang mau turun, masukkan 4 ke fungsi
				if(temp_tujuan==posisi_lift)
					return 4;
					// jika tidak masukkan nilai untuk naik

				else {

					temp_naik=1;
					tujuan=temp_tujuan;

					return 1;
				}
			}
			// pengecekan agar tidak terjadi infinite loop
			else {
				int hsl=penentuan_arah(1, naik, turun, keluar, temp_check+1);
				// jika -1, maka tetap tidak ada, inputkan -1 ke fungsi
				if(hsl==-1)
					return hsl;
				 //Jika tidak input 1 kemudian keluatkan sesuai hasil
				else
				{
					arah_gerak=1;
					return hsl;
				}
			}
		}
	}
	else {


		//Jika pengecekan lebih dari 2, gerak_lift=-1 untuk menginformasikan tidak ada
		if(temp_check>=2) return -1;

		// Pengecekan dari lantai paling atas, apakah ada orang yang akan masuk
		int i=posisi_lift+1;
		while(i<=banyak_lantai){
			//Apabila ada, maka simpan ke variabe tujuan sementara
			if(naik[i]>0 || keluar[i]>0) {
				temp_tujuan = i;
				break;
			}i++;
		}
		// Jika variabel tujuan sementara tidak nol, masukkan 1 ke fungsi untuk menginformasikan lift agar naik
		if(temp_tujuan != 0)
			return 1;
		// Pengecekan untuk orang yang akan turun dari lantai atas
		else {
			int i = banyak_lantai;
			while (i>=posisi_lift) {
            // Jika ditemukan, maka masukkan ke variabel tujuan sementara
                if (turun[i]>0){
                    temp_tujuan=i;
                    break;
                }
               i--;
			}


			// Jika temp_tujuan bukan nol, maka ada orang yang akan turun
			if(temp_tujuan!=0) {
				// Jika orang turun dari posisi sekarang
				if(temp_tujuan==posisi_lift)
					// Masukkan 4 ke fungsi agar ada input orang yang akan turun
					//Jika tidak, masukkan 1 agar naik.
					return 4;
				else {
					temp_turun=1;
					tujuan=temp_tujuan;
					return 1;
				}
			}
			//Agar tidak terjadi infinite loop, apabila -1, maka arah turun tidak ada
			else {
				int hsl=penentuan_arah(0, naik, turun, keluar, temp_check+1);
				if(hsl==-1)
					return hsl;
					//balik arah lift apabila tidak ada
				else
				{
					arah_gerak=0;
					return hsl;
				}
			}
		}
	}
	// //kembalian tak terduga
	return -24;
}

void banyak_naik(int * naik, int * keluar) {

	// Variabel jumlah orang di dalam lift
	int orang_sementara=muatan+naik[posisi_lift];
	// Variabel sementara untuk tujuan keluar
	int temp_keluar;
	// Cek kapasitas lift
	if(orang_sementara<=orang_max) {
		int i=0;
		while(i<naik[posisi_lift]){
			//Input lantai yang dituju
			cout<<"Tujuan lantai orang ke-"<<i+1<< " : ";
			cin>>temp_keluar;
			// Cek apakah tujuan sama
			if(temp_keluar==posisi_lift){
				//Tidak terjadi apa-apa
			}
			// Cek apakah lantai benar
			else if(temp_keluar>=1 && temp_keluar<=banyak_lantai) {
				// Menambahkan ke antrean keluar
				keluar[temp_keluar]++;
				// Menambahkan jumlah orang di lift
				muatan++;
			}
			// Jika input sembarangan
			else cout<<"TIDAK ADA LANTAI "<<temp_keluar<<endl;
			i++;
		}
	}
	// Jika kapasitas lift terlewati
	else cout<<"Maaf, beban maksimal lift telah terlampaui"<<endl;
	// Mengosongkan antrian turun
	naik[posisi_lift] = 0;
}
void banyak_turun(int * turun, int * keluar) {
	// Variabel jumlah orang di dalam lift
	int orang_sementara=muatan+turun[posisi_lift];
	// Variabel sementara untuk tujuan keluar
	int temp_keluar;
	// Cek kapasitas lift
	if(orang_sementara<=orang_max) {
        int i=0;
		while(i<turun[posisi_lift]){
			//Input lantai yang dituju
			cout<<"Tujuan lantai orang ke- " << i+1 <<" : ";
			cin>>temp_keluar;
			// Cek apakah tujuan sama
			if(temp_keluar==posisi_lift){
				//Tidak terjadi apa-apa
			}
			// Cek apakah lantai benar
			else if(temp_keluar>=1 && temp_keluar<=banyak_lantai) {
				// Menambahkan ke antrean keluar
				keluar[temp_keluar]++;
				// Menambahkan jumlah orang di lift
				muatan++;
			}
			// Jika input sembarangan
			else cout<<"TIDAK ADA LANTAI "<<temp_keluar<<endl;
            i++;
		}
	}
	// Jika kapasitas lift terlewati
	else cout<<"Maaf, beban maksimal lift telah terlampaui"<<endl;
	// Mengosongkan antrian turun
	turun[posisi_lift] = 0;
}

void bongkar_muat(int * naik, int * turun, int * keluar) {


	// Mengurangi penumpang lift yang keluar pada lantai sekarang
	muatan -= keluar[posisi_lift];
	// Mengosongkan antrean pada lantai sekarang
	keluar[posisi_lift] = 0;
	// Jika arah turun
	if(arah_gerak!=1){

		// Masukkan orang yang mengantri turun
		banyak_turun(turun,keluar);
		}
	//Jika arah naik
	else{
            // Masukkan orang yang mengantri naik
		banyak_naik(naik,keluar);
		}

}
