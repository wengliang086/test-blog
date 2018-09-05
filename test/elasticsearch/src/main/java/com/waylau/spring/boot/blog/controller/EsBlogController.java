package com.waylau.spring.boot.blog.controller;

import com.waylau.spring.boot.blog.domain.es.EsBlog;
import com.waylau.spring.boot.blog.repository.es.EsBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EsBlogController {

    @Resource
    private EsBlogRepository esBlogRepository;

    @RequestMapping("hello")
    public String sayHello() {
        return "ES Project Say: " + "Hello World!";
    }

    @RequestMapping("es")
    public String search() {
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1", "11", "111"));
        esBlogRepository.save(new EsBlog("2", "22", "222"));
        esBlogRepository.save(new EsBlog("3", "33", "333"));

        Pageable pageable = PageRequest.of(0, 10);
        Page<EsBlog> blogs = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining("1", "", "", pageable);
        System.out.println(blogs.getTotalElements());

        return "ok";
    }
}
