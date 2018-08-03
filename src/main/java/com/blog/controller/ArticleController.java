package com.blog.controller;

import com.blog.bean.Article;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.param.GetArticleParam;
import com.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping(value = "/article", name = "文章相关")
public class ArticleController {
    @Resource
    ArticleService articleService;


    @RequestMapping(value = "/getArticleByType" ,method = RequestMethod.POST)
    @ResponseBody
    public ListResultEx<Article> getArticleByType(GetArticleParam param){
        return articleService.getArticleByType(param).makeSuccessResult();
    }
}
