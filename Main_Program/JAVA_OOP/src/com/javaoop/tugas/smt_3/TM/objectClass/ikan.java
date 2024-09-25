package com.javaoop.tugas.smt_3.TM.objectClass;
class iwak{
  String warna;
  String jenis;
  String bentukMata;
  String bentukEkor;
  String habitat;
  String kelamin;
  
  
  iwak(String warna, String jenis, String mata, String ekor, String habitat, String kelamin){
    this.warna = warna;
    this.jenis = jenis;
    this.bentukMata = mata;
    this.bentukEkor = ekor;
    this.habitat = habitat;
    this.kelamin = kelamin;
  }

  void display(){
    System.out.println("warna : "+this.warna);
    System.out.println("jenis : "+this.jenis);
    System.out.println("bentuk mata : "+this.bentukMata);
    System.out.println("bentuk ekor : "+this.bentukEkor);
    System.out.println("habitat : "+this.habitat);
    System.out.println("kelamin : "+this.kelamin);
  }
  
  String getJenis(){
    return this.jenis;
  }

  void setJenis(String jenis){
    this.jenis = jenis;
  }
  
  String getWarna(){
    return this.warna;
  }

  void setWarna(String warna){
      this.warna = warna;
  }
  
  String getMata(){
    return this.bentukMata;
  }

  void setMata(String mata){
      this.bentukMata = mata;
  }
  
  String getEkor(){
    return this.bentukEkor;
  }

  void setEkor(String ekor){
      this.bentukEkor = ekor;
  }
  
  String getHabitat(){
    return this.habitat;
  }

  void setHabitat(String habitat){
      this.habitat = habitat;
  }
  
  String getKelamin(){
    return this.kelamin;
  }

  void setKelamin(String kelamin){
      this.kelamin = kelamin;
  }
}


public class ikan {
  public static void main(String [] args){
    iwak lele1 = new iwak("hitam","lele","bulat","pendek","air tawar","jantan");
    
    System.out.println("warna : "+lele1.getWarna());
    System.out.println("jenis : "+lele1.getJenis());
    System.out.println("bentuk mata : "+lele1.getMata());
    System.out.println("bentuk ekor : "+lele1.getEkor());
    System.out.println("habitat : "+lele1.getHabitat());
    System.out.println("kelamin : "+lele1.getKelamin());

    System.out.println("================");
    lele1.setWarna("kuning");
    lele1.setJenis("piranha");
    lele1.setMata("lonjong");
    lele1.setEkor("pipih");
    lele1.setHabitat("air tawar");
    lele1.setKelamin("betina");

    lele1.display();
      }
}