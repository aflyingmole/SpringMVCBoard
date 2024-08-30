package com.jhta.controller;

import com.jhta.service.BoardService;
import com.jhta.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController {
    @Autowired
    private BoardService service;

    @GetMapping("/board/detail")
    public String detail(int num, Model model) {
        service.detail(num);
        model.addAttribute("vo", service.detail(num));
        model.addAttribute("prev", service.prev(num));
        model.addAttribute("next", service.next(num));
        return "board/detail";

    }

}
