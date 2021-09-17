package cubes.main.dao;

import java.util.List;
import cubes.main.entity.Sticker;

public interface StickerDAO {
	
	public List<Sticker> getStickerList();
	public void saveSticker(Sticker s);
	public Sticker getStickerByID(int id);
	public void deleteStickerByID(int id);

}
