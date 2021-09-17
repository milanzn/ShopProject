package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Message;

public interface MessageDAO {
	
	public List<Message> getAllMesages();
	public void saveMessage(Message message);
	public long getUnreadMessagesCount();
	public Message getMesageById(int id);

}
