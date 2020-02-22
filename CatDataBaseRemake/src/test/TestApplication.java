package test;

import data.FelineInterface;
import persistence.FelineRepository;

public class TestApplication {

	public static void main(String[] args) throws CloneNotSupportedException {

		// FelineInterface cat = new Cat(1, "Murzik", "Brittish", 2018);
		//
		// FelineInterface cloned = cat.clone();
		//
		// System.out.println(cat);
		// System.out.println(cloned);

		FelineRepository fr = new FelineRepository();

		fr.generate();

		FelineInterface original = fr.findById(2);
//		original.setYear(1900);
//		original.setId(1000);
//		fr.save(original);
		
		fr.delete(original);
		
		
		
		System.out.println(fr.findAll());
		
	}

}
