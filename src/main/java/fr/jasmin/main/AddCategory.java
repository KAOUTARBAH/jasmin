package fr.jasmin.main;

import fr.jasmin.model.dao.interfaces.ICategoryDao;
import fr.jasmin.utils.DataTest;
import fr.jasmin.entity.Category;
import fr.jasmin.entity.Item;
import fr.jasmin.model.dao.impl.CategoryDao;

public class AddCategory {
	
	public static void main(String[] args) {
		System.out.println("***********************début de test**********************");
		ICategoryDao CategoryDao = new CategoryDao();
		
		
		try {
			
		
//			Item item = new Item(DataTest.article(), DataTest.city());
//			item.setDiscount(2);
//			
			Category category = new Category(DataTest.categoryName(), 5, true, null);
			
//			item.setCategory(category);
//			category.getItems().add(item);			
			//System.out.println(item);			
			
			
			
			Item item = null;
			for (int index = 0 ; index < 4; index++) {
				item = new Item(DataTest.article(), DataTest.city());
				item.setDiscount(2);
				
				item.setCategory(category);
				category.getItems().add(item);			
				System.out.println(item);						
			}
		
			
			
			CategoryDao.addCategory(category);
			System.out.println(category);
			category.getItems().forEach(i -> System.out.println("  -> " + i));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
