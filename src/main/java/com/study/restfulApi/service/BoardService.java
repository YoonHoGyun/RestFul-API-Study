package com.study.restfulApi.service;

import com.study.restfulApi.bean.BoardBean;
import com.study.restfulApi.dao.BoardDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardDAO boardDAO;

    public void atclSave(BoardBean bean){
        log.info(String.format("title [%s] content [%s] ", bean.getTitle(), bean.getContent()));
        boardDAO.atclSave(bean);
    }

    public List<BoardBean> atclList(){
        return boardDAO.atclList();
    }

    public BoardBean atclInfo(String brdId){
        return boardDAO.atclInfo(brdId);
    }

    public void updateBoard(String brdId, String title, String content) {
        BoardBean board = boardDAO.atclInfo(brdId);

        if(board==null){
            throw new RuntimeException("게시글을 찾을 수 없습니다. brdId: " + brdId);
        }

        board.setTitle(title);
        board.setContent(content);

        boardDAO.atclUpdate(board);
    }

    public void partialUpdateBoard(String brdId, Map<String, Object> updates) {
        BoardBean board = boardDAO.atclInfo(brdId);
        if (board == null) {
            throw new RuntimeException("게시글을 찾을 수 없습니다.");
        }

        String title = updates.containsKey("title") ? (String) updates.get("title") : null;
        String content = updates.containsKey("content") ? (String) updates.get("content") : null;

        boardDAO.partialUpdate(brdId, title, content);
    }

    public void atclDelete(String brdId){
        BoardBean board = boardDAO.atclInfo(brdId);
        if (board == null) {
            throw new RuntimeException("게시글을 찾을 수 없습니다.");
        }

        boardDAO.atclDelete(brdId);
    }

    public void atclReset(){
        boardDAO.atclReset();
        boardDAO.seQuenceReset();
    }
}
