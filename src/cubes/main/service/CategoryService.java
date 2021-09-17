package cubes.main.service;

import java.util.List;
import cubes.main.entity.Category;

public interface CategoryService {
	

	public List<Category> getCategoryList();
	public void saveCategory(Category category);
	public Category getCategoryByID(Integer id);
	public void deleteCategoryByID(int id);
	public List<Category> getCategoryListForMainPage();


}
