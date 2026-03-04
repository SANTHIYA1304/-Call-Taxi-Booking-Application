package com.taxi.main;
import com.taxi.service.TaxiService;
public class Main {
	  public static void main(String[] args) {

	        TaxiService service = new TaxiService(4);

	        service.bookTaxi(1, 'B', 'A', 9);
	        service.bookTaxi(2, 'A', 'D', 9);
	        service.bookTaxi(3, 'B', 'C', 12);

	        System.out.println("\n----- Taxi Details -----");
	        service.displayTaxiDetails();
}}
