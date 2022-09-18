package com.capstone.shopforhome.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.shopforhome.entity.Product;


/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This class is responsible for iterating the csv file.
 */

public class CSVHelper {
	
	public static String TYPE = "text/csv";
	  static String[] HEADERs = { "productName", "productCategory", "productDescription", "productStock","productPrice","productImage" };
	  public static boolean hasCSVFormat(MultipartFile file) {
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	  public static List<Product> csvToTutorials(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	      List<Product> tutorials = new ArrayList<Product>();
	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      for (CSVRecord csvRecord : csvRecords) {
	        Product tutorial = new Product(
//	              Long.parseLong(csvRecord.get("pid")),
	              csvRecord.get("productName"),
	              csvRecord.get("productCategory"),
	              csvRecord.get("productDescription"),
	              Long.parseLong(csvRecord.get("productStock")),
	              Double.parseDouble(csvRecord.get("productPrice")),
	              csvRecord.get("productImage")
	            );
	        tutorials.add(tutorial);
	      }
	      return tutorials;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }

}
