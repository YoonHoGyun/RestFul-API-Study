package com.study.restfulApi.batchJob;

import com.study.restfulApi.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Slf4j
@EnableScheduling
public class BoardJob {

    @Autowired
    private BoardService boardService;

    @Async
    @Scheduled(cron = "0 */5 * * * *")
    public void resetBoard(){
        log.info("============== 게시글 초기화 시작 ==============");
        try{
            boardService.atclReset();
        }catch(Exception e){
            log.error("게시글 초기화 중 오류 발생: {}", e.getMessage(), e);
        }
        log.info("============== 게시글 초기화 완료 ==============");
    }
}
