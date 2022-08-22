package com.iu.spring.notice;

import java.util.List;


public interface NoticeDAO {
	
	public List<NoticeDTO> getList()throws Exception;
	
	public int addNotice(NoticeDTO noticeDTO) throws Exception;
	
	public int updateNotice(NoticeDTO noticeDTO) throws Exception;

	public int deleteNotice (NoticeDTO noticeDTO) throws Exception;
	
	public int updateHit (NoticeDTO noticeDTO) throws Exception;
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception;
}
