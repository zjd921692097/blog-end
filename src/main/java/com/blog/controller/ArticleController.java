package com.blog.controller;

import com.blog.bean.Article;
import com.blog.bean.ArticleType;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.param.GetArticleParam;
import com.blog.param.WriteParam;
import com.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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


    @RequestMapping(value = "/wirteArticle" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultEx wirteArticle(WriteParam param, HttpServletRequest request){
        if(request.getSession().getAttribute("USER")==null || request.getSession().getAttribute("USER")==""){
            return new ResultEx().makeFailedResult("please login");
        }
        return articleService.wirteArticle(param);
    }

}
