package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main_Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc  = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Product> list = new ArrayList<>();
        
		System.out.print("Enter the number of product: ");
		int n = sc.nextInt();
	
		for(int i=1; i <= n ; i++) {
			System.out.println("Product #"+ i+" data:");
			System.out.print("Common, Used or Imported ( c / u / i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String prod_Name = sc.nextLine();
			System.out.print("Price: ");
			double prod_Price = sc.nextDouble();
			  if(ch == 'c') {
				  list.add(new Product(prod_Name,prod_Price));
			   	  }
			  else if (ch =='u') {
				  System.out.print("Manufacture Date(DD/MM/YYYY)");
				  Date manufacture_Date = sdf.parse(sc.next());
				  list.add(new UsedProduct(prod_Name,prod_Price,manufacture_Date));
			  }
			  else {
				  System.out.print("Customs fee: ");
				  double customs_Fee = sc.nextDouble();
				  list.add(new ImportedProduct(prod_Name,prod_Price,customs_Fee));
			  }
		}
		System.out.println("Price Tags:");
		for(Product prod: list ) {
			System.out.println(prod.priceTag());
			
		}
		
		
		sc.close();
	}

}
