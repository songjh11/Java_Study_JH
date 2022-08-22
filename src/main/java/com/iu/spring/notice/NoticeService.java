package com.iu.spring.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeListDAO noticeListDAO;
	
	//목록
	public List<NoticeDTO> getList()throws Exception{
		return noticeListDAO.getList();
	}
	

	//추가
	public int addNotice(NoticeDTO noticeDTO) throws Exception{
		return noticeListDAO.addNotice(noticeDTO);
		
		
	}
	

	//수정
	public int updateNotice(NoticeDTO noticeDTO) throws Exception{
		return noticeListDAO.updateNotice(noticeDTO);
	}
	


	//삭제
	public int deleteNotice (NoticeDTO noticeDTO) throws Exception{
		return noticeListDAO.deleteNotice(noticeDTO);
	}
	

	//조회수증가
	public int updateHit (NoticeDTO noticeDTO) throws Exception{
		return noticeListDAO.updateHit(noticeDTO);
	}
	

	//글 한개 조회
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return noticeListDAO.getDetail(noticeDTO);
	}
	

}
