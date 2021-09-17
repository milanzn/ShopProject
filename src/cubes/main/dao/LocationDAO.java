package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Location;

public interface LocationDAO {
	
	public List<Location> getLocationList();
	public void saveLocation(Location location);
	public Location getLocationByID(int id);
	public void deleteLocationByID(int id);

}
