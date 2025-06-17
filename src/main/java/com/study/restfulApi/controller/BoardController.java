package com.study.restfulApi.controller;

import com.study.restfulApi.bean.BoardBean;
import com.study.restfulApi.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String home() {
        return "redirect:/board/brdList";
    }

    /**
     * 게시판 목록 화면 이동
     * @return
     */
    @GetMapping("/board/brdList")
    public String brdList(Model model){
        List<BoardBean> atclList = boardService.atclList();
        model.addAttribute("atclList",atclList);
        return "board/brdList";
    }

    /**
     * 게시판 작성화면 이동
     * @return
     */
    @GetMapping("/board/brdWrite")
    public String brdWrite(Model model, String mode, String brdId){
        model.addAttribute("mode", mode);
        if(!"write".equals(mode)){
            BoardBean atclInfo = boardService.atclInfo(brdId);
            model.addAttribute("atclInfo", atclInfo);
        }
        return "board/brdWrite";
    }

    /**
     * 게시글 조회화면 이동
     * @return
     */
    @GetMapping("/board/brdView")
    public String brdView(Model model, String brdId){
        log.info("brdId :  "+brdId);
        BoardBean atclInfo = boardService.atclInfo(brdId);
        model.addAttribute("atclInfo", atclInfo);
        return "board/brdView";
    }

    /**
     * 게시글 등록
     * @param bean
     * @return
     */
    @PostMapping("/atclSave")
    public String atclSave(BoardBean bean, String mode){
        boardService.atclSave(bean, mode);
        return "redirect:/board/brdList";
    }
}
