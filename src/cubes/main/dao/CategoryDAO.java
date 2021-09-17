package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Category;

public interface CategoryDAO {
	
	public List<Category> getCategoryList();
	public void saveCategory(Category category);
	public Category getCategoryByID(Integer id);
	public void deleteCategoryByID(int id);
	public List<Category> getCategoryListForMainPage();
	

}
