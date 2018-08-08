package com.blog.controller;

import com.blog.bean.Article;
import com.blog.bean.ArticleType;
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
        if(param.getTypeId()!=null){
            if(param.getTypeId()==1){
                param.setTypeId(null);
            }
        }

        return articleService.getArticleByType(param).makeSuccessResult();
    }

    @RequestMapping(value = "/getArticleType" ,method = RequestMethod.POST)
    @ResponseBody
    public ListResultEx<ArticleType> getArticleType(){
        return articleService.getArticleType();
    }
}
