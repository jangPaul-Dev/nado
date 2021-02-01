package nado.dao;
import java.util.List;

import nado.vo.MeetCard;

public interface MeetCardDao {
	
	public List<MeetCard> selectList() throws Exception;
	public int insert(MeetCard meetcard) throws Exception;
	public List<MeetCard> selectMyPage() throws Exception;
}