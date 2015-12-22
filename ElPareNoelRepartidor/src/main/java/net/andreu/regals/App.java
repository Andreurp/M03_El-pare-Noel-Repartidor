package net.andreu.regals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * El pare Noel Repartidor
 *
 */
public class App {
	private String arxiu = "src/main/resources/llista2.txt";
	private ArrayList<String> regals = new ArrayList<String>();
	private List<String> stock;

	public static void main(String[] args) {
		App a = new App();
		a.inici();
	}

	public void inici() {
		llegirFitxer();
		procesaFitxer();
		triaNens();
	}
	public void triaNens() {
		String[] nen;
		String[] desitjos;
		for(int i=0; i<regals.size(); i++){
			nen=regals.get(i).split(":");
			desitjos=nen[1].split(",");
			if(comparaRegals(desitjos)== true){
				System.out.println(nen[0]);
			}
		}
	}
	public boolean comparaRegals(String[] desitjos) {
		boolean hiSon=true; 
		for(int i=0; i<desitjos.length; i++){
			if(!stock.contains(desitjos[i].trim())){
				hiSon=false;
			}
		}
		return hiSon;
	}
	public void procesaFitxer() {
		String s=regals.get(regals.size()-1);
		stock = Arrays.asList(s.split(","));
		//System.out.println(stock);
		regals.remove(regals.size()-1);
		
	}
	public void llegirFitxer() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(arxiu));
			String linia;
			while ((linia = br.readLine()) != null) {
				regals.add(linia);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
