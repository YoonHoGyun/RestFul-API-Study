package com.study.restfulApi.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBean {
    private int brdId;
    private String title;
    private String content;
    private String regDate;
}
