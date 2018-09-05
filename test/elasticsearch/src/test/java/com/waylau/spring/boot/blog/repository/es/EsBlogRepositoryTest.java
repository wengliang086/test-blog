package com.waylau.spring.boot.blog.repository.es;

import com.waylau.spring.boot.blog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Resource
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("1", "11", "111"));
        esBlogRepository.save(new EsBlog("2", "22", "222"));
        esBlogRepository.save(new EsBlog("3", "33", "333"));
    }

    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<EsBlog> blogs = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining("1", "", "", pageable);
        System.out.println(blogs.getTotalElements());
    }
}