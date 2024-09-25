package com.javaoop.tugas.smt_3.TM.PecahanNumber;

public class pecahan {
  private int pembilang;
  private int penyebut;
  
  public pecahan(int pembilang, int penyebut){
    this.pembilang = pembilang;
    this.penyebut = penyebut;
  }
  
  public int getPembilang(){
    return this.pembilang;
  }
  
  public int getPenyebut(){
    return this.penyebut;
  }
  //=============================== PERKALIAN ========================================
  public double dikalikan1(pecahan x){
    return ((double)this.pembilang * x.pembilang) / ((double)this.penyebut*x.penyebut);
    // podo ae tibak e
    // return ((double)this.pembilang * x.getPembilang()) / ((double)this.penyebut*x.getPenyebut());
    // a/b * c/d = ac/bd
  }
  
  public pecahan dikalikan2(pecahan x){
    return new pecahan(this.pembilang*x.getPembilang(), this.penyebut*x.getPenyebut());
    // a*c , b*d = ac,bd
  }
  
  //================================ PENJUMLAHAN ========================================
  public double penjumlahan1(pecahan x){
    return (((double)this.pembilang*x.getPenyebut())+(double)this.penyebut*x.getPembilang()) / ((double)this.penyebut*x.getPenyebut());
    // pemjumlahan p/q + r/s = ps+qr/qs
  }

  public pecahan penjumlahan2(pecahan x){
    return new pecahan((this.pembilang*x.getPenyebut())+this.penyebut*x.getPembilang(),this.penyebut*x.getPenyebut());
  } 

  //=============================== PENGURANGAN =========================================
  public double pengurangan1(pecahan x){
    return (((double)this.pembilang*x.getPenyebut())-(double)this.penyebut*x.getPembilang()) / ((double)this.penyebut*x.getPenyebut());
    // pengurangan p/q - r/s = ps-qr/qs
  }
  
  public pecahan pengurangan2(pecahan x){
    return new pecahan((this.pembilang*x.getPenyebut())-this.penyebut*x.getPembilang(),this.penyebut*x.getPenyebut());
  } 
  
  //=============================== PEMBAGIAN =========================================
  public double pembagian1(pecahan x){
    return ((double)this.pembilang * x.getPenyebut()) / ((double)this.penyebut*x.getPembilang());
    // pembagian a/b : c/d = ad/bc
  }

  public pecahan pembagian2(pecahan x){
    return new pecahan(this.pembilang*x.getPenyebut(), this.penyebut*x.getPembilang());
  }

  public void cetakLayar(){
    System.out.println(this.pembilang+"/"+this.penyebut);
  }

  public void sederhana(){
    int x = this.pembilang;
    int y = this.penyebut;
    //===================
    int indeks=0;
    if (x>y){
      indeks +=y;
    } else if (x<=y){
      indeks += x;
    }
    while (indeks>=2){
      if((x%indeks==0)&&(y%indeks==0)){
        x /= indeks;
        y /= indeks;
        break;
      } else {
        indeks-=1;
      }
    }
    System.out.println(this.pembilang+"/"+this.penyebut+"\t-----> "+x+"/"+y);
    // System.out.println(x+"/"+y);
  }
}
