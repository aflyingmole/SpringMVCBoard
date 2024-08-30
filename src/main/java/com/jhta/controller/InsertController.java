package com.jhta.controller;

import com.jhta.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import test.vo.BoardVo;

@Controller
public class InsertController {
    @Autowired
    private BoardService service;

    @GetMapping("/board/insert")
    public String insertForm() {
        return "board/insert";
    }

    @PostMapping("/board/insert")
    public ModelAndView insert(BoardVo vo) {
        System.out.println("vo :" + vo);
        String code = "success";
        try {
            service.insert(vo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            code = "fail";
        }

        // 생성자 파라미터는 "board/result" 뷰이름이 된다.
        ModelAndView mv = new ModelAndView("board/result");
        mv.addObject("code", code);
        return mv;
    }
}
