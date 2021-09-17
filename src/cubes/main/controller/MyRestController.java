package cubes.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cubes.main.dao.ProductDAO;
import cubes.main.dao.StickerDAO;
import cubes.main.entity.Category;
import cubes.main.entity.Product;
import cubes.main.entity.Sticker;
import cubes.main.rest.MessageResponse;
import cubes.main.rest.NullCategoryException;
import cubes.main.rest.request_body.ProductFilter;
import cubes.main.rest.response.BasicProductResponse;
import cubes.main.rest.response.SettingResponse;
import cubes.main.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class MyRestController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private StickerDAO stickerDAO;
	@Autowired
	private ProductDAO productDAO;
	
	
	// ---------------------- CATEGORY ----------------------------------------
	
	@GetMapping(value = "/categories")
	public List<Category> getCategories(){
		List<Category> list = categoryService.getCategoryList();
		
		return list;
		
		
	}
	@GetMapping(value = "/categories/{id}")
	public Category getCategoryByID(@PathVariable int id){
		Category c = categoryService.getCategoryByID(id);
		if (c == null) {
			throw new NullCategoryException("Kategorija sa id: " + id + " ne postoji u bazi!");
			
		}
		return c;		
	}
	
	@PostMapping(value = "/categories")
	public MessageResponse createCategory(@RequestBody Category category) {
		category.setId(0);
		categoryService.saveCategory(category);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je sacuvana Kategorija : " + category, System.currentTimeMillis());
	}
	
	@PutMapping(value = "/categories")
	public MessageResponse updateCategory(@RequestBody Category category) {
		categoryService.saveCategory(category);
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izmenjena Kategorija : " + category, System.currentTimeMillis());
	}
	
	@DeleteMapping(value = "/categories/{id}")
	public MessageResponse deleteCategory(@PathVariable int id) {
		
		Category category = categoryService.getCategoryByID(id);
		categoryService.deleteCategoryByID(id);
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izbrisana Kategorija : " + category, System.currentTimeMillis());
	}
	
	// ---------------------- STICKER ----------------------------------------
	
	@GetMapping(value = "/stickers")
	public List<Sticker> getStickers(){
		List<Sticker> list = stickerDAO.getStickerList();
		
		return list;
	
	}
	

	@GetMapping(value = "/stickers/{id}")
	public Sticker getStickerByID(@PathVariable int id){
	
		Sticker s = stickerDAO.getStickerByID(id);
		if (s == null) {
			throw new NullCategoryException("Sticker sa id: " + id + " ne postoji u bazi!");
		
			}
		return s;		
}
	
	
	@PostMapping(value = "/stickers")
	public MessageResponse createSticker(@RequestBody Sticker sticker) {
		
		sticker.setId(0);
		stickerDAO.saveSticker(sticker);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je sacuvana Kategorija : " + sticker, System.currentTimeMillis());
	}	
	
	@PutMapping(value = "/stickers")
	public MessageResponse updateSticker(@RequestBody Sticker sticker) {
		stickerDAO.saveSticker(sticker);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izmenjena Kategorija : " + sticker, System.currentTimeMillis());
	}	
	
	
	@DeleteMapping(value = "/stickers/{id}")
	public MessageResponse deleteSticker(@PathVariable int id) {
		
		Sticker sticker = stickerDAO.getStickerByID(id);
		stickerDAO.deleteStickerByID(id);

		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izbrisana Kategorija : " + sticker, System.currentTimeMillis());
	}
	
	
	// ---------------------------------- SETTINGS --------------------------------------------
	
	@GetMapping(value = "/settings")
	public SettingResponse getSettings() {
		
		SettingResponse settings = new SettingResponse();
		
		settings.setCategories(categoryService.getCategoryList());
		settings.setStickers(stickerDAO.getStickerList());
		return settings;
		
	}
	
	// ---------------------------------- PRODUCTS --------------------------------------------
	
	@GetMapping(value = "/products")
	public List<Product> getProducts(){
		List<Product> products = productDAO.getProductListWithStickers();
		return products;
	}
	
	@GetMapping(value = "/basicproducts")
	public List<BasicProductResponse> getBasicProducts(){
		
		List<BasicProductResponse> list = new ArrayList<>();
		List<Product> products = productDAO.getProductListWithStickers();
		 for(Product p: products) {
			 
			 list.add(new BasicProductResponse(p));
		 }
		 return list;
		
	}
	
	@PostMapping("/products")
	public MessageResponse saveProduct(@RequestBody Product product) {
		product.setId(0);
		productDAO.saveProduct(product);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je sacuvan product: " + product, System.currentTimeMillis());
	}
	
	@PutMapping("/products")
	public MessageResponse updateProduct(@RequestBody Product product) {
		
		productDAO.saveProduct(product);
		
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izmenili product: " + product, System.currentTimeMillis());
	}
	
	@DeleteMapping("/products/{id}")
	public MessageResponse deleteProduct(@PathVariable int id) {
		Product p = productDAO.getProductById(id);
		productDAO.deleteProduct(id);
		return new MessageResponse(HttpStatus.OK.value(), "Uspesno je izbrisali product: " + p, System.currentTimeMillis());
	}
	
	@GetMapping(value = "fileter-products")
	public List<Product> getProductListFilter(@RequestBody ProductFilter filter){
		
		List<Product> list = productDAO.getProductList(filter.getCategory(), filter.getPrice(), filter.getStickers());
		return list;
	}
}
