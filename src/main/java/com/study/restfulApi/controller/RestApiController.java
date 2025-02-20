package com.study.restfulApi.controller;

import com.study.restfulApi.bean.BoardBean;
import com.study.restfulApi.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class RestApiController {

    @Autowired
    private BoardService boardService;

    // 게시글 등록
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BoardBean bean){
        log.info(String.format("Save API > title [%s] content [%s] ", bean.getTitle(), bean.getContent()));

        try {
            boardService.atclSave(bean);

            Map<String, Object> response = Map.of(
                    "title", bean.getTitle(),
                    "content", bean.getContent(),
                    "message", "글 등록이 완료되었습니다."
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // 게시글 수정 (전체 수정 - 제목과 내용 모두 변경)
    @PutMapping("/update/{brdId}")
    public ResponseEntity<?> update(@PathVariable String brdId, @RequestBody BoardBean bean) {
        log.info(String.format("Update API > brdId [%s] title [%s] content [%s] ", brdId, bean.getTitle(), bean.getContent()));

        try {
            boardService.updateBoard(brdId, bean.getTitle(), bean.getContent());

            return ResponseEntity.ok(Map.of(
                    "brdId", brdId,
                    "title", bean.getTitle(),
                    "content", bean.getContent(),
                    "message", "게시글이 수정되었습니다."
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // 게시글 부분 수정 (제목 또는 내용 수정)
    @PatchMapping("/update/{brdId}")
    public ResponseEntity<?> partialUpdate(@PathVariable String brdId, @RequestBody Map<String, Object> updates) {
        log.info(String.format("Patch API > brdId [%s] updates [%s]", brdId, updates.toString()));

        try {
            boardService.partialUpdateBoard(brdId, updates);

            return ResponseEntity.ok(Map.of(
                    "id", brdId,
                    "updateInfo", updates.toString(),
                    "message", "게시글이 부분 수정되었습니다."
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
