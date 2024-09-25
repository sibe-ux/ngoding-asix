from abc import ABC, abstractmethod 

class MobilMewah(ABC):  
    @abstractmethod 
    def harga(self):   
        pass  

class Tesla(MobilMewah):   
    def harga(self):   
        print("Harga mobil ini 2 Milliar Rupiah")   
class Lexus(MobilMewah):   
    def harga(self):   
        print("Harga mobil ini 3 Milliar Rupiah")  
class Ferrari(MobilMewah):   
    def harga(self):   
        print("Harga mobil ini 10 Milliar Rupiah")  

tesla_obj = Tesla()
tesla_obj.harga()

ferrari_obj = Ferrari()
ferrari_obj.harga()

#output
# Harga mobil ini 2 Milliar Rupiah
# Harga mobil ini 10 Milliar Rupiah