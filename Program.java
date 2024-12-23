package aplicattion;

import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported(c/u/i)? ");
			char cui = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			Double price = sc.nextDouble();
			if (cui == 'c') {
				Product pro = new Product(name, price);
				list.add(pro);
			} else if(cui == 'u'){
				System.out.print("Manufacturedate (DD/MM/YYYY): ");
				LocalDate manuFactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product pro = new UsedProduct(name, price, manuFactureDate);
				list.add(pro);
			} else if (cui == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product pro = new ImportedProduct(name, price, customsFee);
				list.add(pro);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product pro : list) {
			System.out.println(pro);
		}
		sc.close();
	}

}
