package com.study.restfulApi.dao;

import com.study.restfulApi.bean.BoardBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {

    void atclSave(BoardBean bean);
    List<BoardBean> atclList();
    BoardBean atclInfo(String brdId);
    void atclUpdate(BoardBean bean);
    void partialUpdate(@Param("brdId") String brdId, @Param("title") String title, @Param("content") String content);
}
