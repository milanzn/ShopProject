package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Slider;

public interface SliderDAO {
	
	public List<Slider> getSliderList();
	public void saveSlider(Slider s);
	public Slider getSliderByID(int id);
	public void deleteSliderByID(int id);


}
