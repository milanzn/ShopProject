package cubes.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cubes.main.dao.LocationDAO;
import cubes.main.dao.MessageDAO;
import cubes.main.dao.ProductDAO;
import cubes.main.dao.SliderDAO;
import cubes.main.dao.StaticPageDAO;
import cubes.main.dao.StickerDAO;
import cubes.main.entity.Category;
import cubes.main.entity.Message;
import cubes.main.entity.Product;
import cubes.main.entity.Slider;
import cubes.main.entity.Sticker;
import cubes.main.service.CategoryService;

@Controller
public class FrontController {
	
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SliderDAO sliderDAO;
	@Autowired
	private StaticPageDAO staticPageDAO;
	@Autowired
	private LocationDAO locationDAO;
	@Autowired
	private StickerDAO stickerDAO;
	
	//------------------------- HOMEPAGE -------------------------
	
	@RequestMapping(value = {"/homepage", "", "/"})
	public String getHomePage(Model model) {
		
		List<Product>list = productDAO.getProductListForMainPage();
		List<Category>categories = categoryService.getCategoryListForMainPage();
		List<Slider>sliders = sliderDAO.getSliderList();
		
		model.addAttribute("products", list);
		model.addAttribute("categories", categories);
		model.addAttribute("sliders", sliders);
		model.addAttribute("locations", locationDAO.getLocationList());
		return "homepage";
	}
	
	//------------------------- CONTACT -------------------------
	@RequestMapping(value = "/contact-form")
	public String getContactPage(Model model) {
		
		model.addAttribute("message", new Message());
		model.addAttribute("locations", locationDAO.getLocationList());
		return "contact-form";
	}
	
	@RequestMapping(value = "/contact-save")
	public String getContactSavePage(@ModelAttribute Message message) {
		
		messageDAO.saveMessage(message);
		return "redirect: contact-form";
	}
	
	//------------------------- SHOP LIST -------------------------
	
	@RequestMapping(value = "/shop-list")
	public String getProductList(@RequestParam(required = false) Integer category,
			@RequestParam(required = false) Integer price, 
			@RequestParam(required = false, value ="sticker") Integer[] stickersArray,
			Model model) {
	
		List<Product> products = productDAO.getProductList(category, price, stickersArray);
		List<Category> categories = categoryService.getCategoryList();
		List<Sticker> stickers = stickerDAO.getStickerList();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		model.addAttribute("stickers", stickers);
		
		if( category!=null) {
		model.addAttribute("categorySelected", category);
		}
		if( price!=null) {
		model.addAttribute("priceSelected", price);
		}
		if(stickersArray!= null) {
			model.addAttribute("stickerSelected", Arrays.asList(stickersArray));		
		}
		
		model.addAttribute("locations", locationDAO.getLocationList());

		
		return ("shop-list");
	
	}
	
	
	@RequestMapping(value = "/shop-detail/{title}/{id}")
	public String getShopDetailPage(@PathVariable int id,@PathVariable String title, Model model) {
		
		Product p = productDAO.getProductById(id);
		List<Product> productsFromCategory = productDAO.getProductListByCategoryId(p.getCategory().getId());

		model.addAttribute("product", p);
		model.addAttribute("products", productsFromCategory);
		model.addAttribute("locations", locationDAO.getLocationList());
		
		return "shop-detail";
	}
	
	
	@RequestMapping(value = "/shop-search")
	public String getShopSearchPage(@RequestParam String text, Model model){
		
		
		List<Product> products = productDAO.getProductList(text);
		model.addAttribute("products", products);
		model.addAttribute("locations", locationDAO.getLocationList());
		return "shop-search";
	}
	
	
	@RequestMapping(value = "/shop-search-test")
	public ModelAndView getSearchPageTest(@RequestParam String text) {
		List<Product> list = productDAO.getProductList(text);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("shop-search");
		mv.addObject("products", list);
		return mv;
	}
	
	@RequestMapping(value = "/shop-search-text")
	@ResponseBody
	public String getShopSearchPageText(@RequestParam String text) {
		List<Product> list = productDAO.getProductList(text);
		
		// return text;
		
		return list.toString();
	}
	
		
	//------------------------- ABOUT US -------------------------
	
	
	@RequestMapping(value = "/about-us")
	public String getAboutUsPage(Model model){
		model.addAttribute("content", staticPageDAO.getAboutUsPage());
		model.addAttribute("locations", locationDAO.getLocationList());
		
		return "about-us";
		
	}
	
	//------------------------- LOCATION -------------------------
	
	@RequestMapping(value = "/location")
	public String getLocationPage(Model model){
		model.addAttribute("locations", locationDAO.getLocationList());
		
		return "location";
	}
	


}
