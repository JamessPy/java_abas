package abas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class productEntry {
	public static void main(String[] args) {
		
		Product[] entry = new Product[15];
		
		entry[0] = new Product(1000,2000,12,100.51);
		entry[1] = new Product(1000,2001,31,200);
		entry[2] = new Product(1000,2002,22,150.86);
		entry[3] = new Product(1000,2003,41,250);
		entry[4] = new Product(1000,2004,55,244);
		
		entry[5] = new Product(1001,2001,88,44.531);
		entry[6] = new Product(1001,2002,121,88.11);
		entry[7] = new Product(1001,2004,74,211);
		entry[8] = new Product(1001,2002,14,88.11);
		
		entry[9] = new Product(1002,2003,2,12.1);
		entry[10] = new Product(1002,2004,3,22.3);
		entry[11] = new Product(1002,2003,8,12.1);
		entry[12] = new Product(1002,2002,16,94);
		entry[13] = new Product(1002,2005,9,44.1);
		entry[14] = new Product(1002,2006,19,90);
		
		// ----------------Tablo------------------------
		displayTable(entry);
		
		// ----------------------Toplam Tutar--------------------
		sum(entry);
		
		// ---------------Ortalama Fiyat---------------------
		generalAverage(entry);

		// ----------------------- MAL BAZLI ORTALAMA ----------------------
		specificAverage(entry);

		// -------------------- Mal Bazli Adet ---------------------------
		specificCount(entry);
 
		
	}
	public static void displayTable(Product[] entry) {
		System.out.println("------------------------ Tablo ------------------------------");
		for (int i = 0; i < entry.length; i++) {
			System.out.print("Sipariş: " +entry[i].getSiparis()+" Mal Numarası: "+entry[i].getMal_no()+" Miktar: "+entry[i].getMiktar()+" Birim Fiyat: "+ entry[i].getBirim_fiyat()+"\n");
		}
	}
	
	public static void sum(Product[] entry) {
		System.out.println("---------------------- Toplam Tutar ------------------------");
		double total = 0;
		
		// Listenin içindeki tüm elemanların sırasıyla birim fiyatıyla miktarını çarparak total değişkeninde toplama.
		for(int i=0; i < entry.length;i++) {
			total += entry[i].getBirim_fiyat() * entry[i].getMiktar();
					}
		System.out.println(total);
	}
	public static void generalAverage(Product[] entry) {
		System.out.println("-------------------------- Ortalama Fiyat ---------------------------------------");
		
		// 3 siparişinde ortalamasını bastırmak için 3 sipariş içinde gerekli değişkenleri tanımlanması.
		double sum_price1 = 0;
		double sum_price2 = 0;
		double sum_price3 = 0;
		
		double total_product1 = 0;
		double total_product2 = 0;
		double total_product3 = 0;
		
		double average1 = 0;
		double average2 = 0;
		double average3 = 0;
		double average4 = 0;
		
		for (int i = 0; i < entry.length; i++) {
			
			// Sipariş no 1000 olanları ele alıp bunun ortalamasını bulma
			if(entry[i].getSiparis() == 1000) {
				sum_price1 += entry[i].getBirim_fiyat() * entry[i].getMiktar();
				total_product1 += entry[i].getMiktar();
			}
			// Sipariş no 1001 olanları ele alıp bunun ortalamasını bulma
			else if(entry[i].getSiparis() == 1001) {
				sum_price2 += entry[i].getBirim_fiyat() * entry[i].getMiktar();
				total_product2 += entry[i].getMiktar();
			}
			// Sipariş no 1002 olanları ele alıp bunun ortalamasını bulma
			else {
				sum_price3 += entry[i].getBirim_fiyat() * entry[i].getMiktar();
				total_product3 += entry[i].getMiktar();
			}
			
		}
		// 3 Sipariş için ortalama hesaplama ayrıca genel ortalamayıda içeriyor.
		average1 = sum_price1/total_product1;
		average2 = sum_price2/total_product2;
		average3 = sum_price3/total_product3;
		average4 = (sum_price3 + sum_price2 + sum_price1) / (total_product1+total_product2+total_product3);
		
		System.out.println("Ortalama fiyat sipariş no 1000 için: " + average1);
		System.out.println("Ortalama fiyat sipariş no 1001 için: " + average2);
		System.out.println("Ortalama fiyat sipariş no 1002 için: " + average3);
		System.out.println("Üç siparişin genel ortalaması: " + average4);
		
	}
	
	public static void specificAverage(Product[] entry) {
		System.out.println(" ----------------------- MAL BAZLI ORTALAMA --------------------------------");
		
		// Stream yardımıyla ürünleri mal numarasına göre gruplama ve yeni map oluşturma
		Map<Integer, List<Product>> groupped =
				Stream.of(entry).collect(Collectors.groupingBy(w -> w.getMal_no()));
		
		// Gruplanmış olan map içerisinde ki değerlere ulaşmak için for
		for (Map.Entry<Integer, List<Product>> element : groupped.entrySet()) {
			Integer key = element.getKey();
			List<Product> val = element.getValue();
			
			double totals= 0;
			double	sum_price = 0;
			// Mapin içinde ki liste elemanlarına ulaşıp ortalama hesaplayıp bastırma.
            for (Product product : val) {
            	totals += product.getMiktar();
            	sum_price += product.getBirim_fiyat() * product.getMiktar();
            }
        	System.out.println("mal no: " + key+ " ortalama fiyatı: "+ (sum_price)/totals);

			
		}
	}
	public static void specificCount(Product[] entry) {
		System.out.println("------------------------- Mal Bazli Adet --------------------------------");

		
		// Mal no sipariş no ve bunların sayısını tutabilmek için map oluşturuldu
        Map<Integer, Map<Integer, Integer>> malMap = new HashMap<>();

        
       for (Product product : entry) {
    	   // Mal_no ya göre bir giriş bakar yoksa yeni oluşturur
           malMap.putIfAbsent(product.getMal_no(), new HashMap<>());
           Map<Integer, Integer> siparisMap = malMap.get(product.getMal_no());
           //Siparişno ya göre ekleme yapılır yoksa yeni oluşturup miktarı ekler
           siparisMap.put(product.getSiparis(), siparisMap.getOrDefault(product.getSiparis(), 0) + product.getMiktar());
       }

       // For döngüsü içinde keyi yani mal no yu alıp daha sonrasında ise diger map içerisinde ki değerleri ekrana bastırma.
       for (Map.Entry<Integer, Map<Integer, Integer>> malEntry : malMap.entrySet()) {
           int malNo = malEntry.getKey();
           Map<Integer, Integer> val = malEntry.getValue();
           System.out.println("Mal No: " + malNo);

           for (Map.Entry<Integer, Integer> siparisEntry : val.entrySet()) {
               int siparisNo = siparisEntry.getKey();
               int toplamMiktar = siparisEntry.getValue();
               System.out.println("  Sipariş No: " + siparisNo + ", Toplam Miktar: " + toplamMiktar);
           }
       }
		
		
		
        /*Map<Integer, Map<Integer, Integer>> orderMap = new HashMap<>();

        for (Product product : entry) {
            orderMap.putIfAbsent(product.getSiparis(), new HashMap<>());
            Map<Integer, Integer> malMap = orderMap.get(product.getSiparis());
            malMap.put(product.getMal_no(), malMap.getOrDefault(product.getMal_no(), 0) + product.getMiktar());
        }

        for (Map.Entry<Integer, Map<Integer, Integer>> orderEntry : orderMap.entrySet()) {
            int siparisNo = orderEntry.getKey();
            System.out.println("Sipariş No: " + siparisNo);

            for (Map.Entry<Integer, Integer> malEntry : orderEntry.getValue().entrySet()) {
                int malNo = malEntry.getKey();
                int toplamMiktar = malEntry.getValue();
                System.out.println("  Mal No: " + malNo + ", Toplam Miktar: " + toplamMiktar);
            }
        }*/
	}
	

}
