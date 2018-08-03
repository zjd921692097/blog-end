package com.blog.service.impl;

import com.blog.bean.Article;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.dao.ArticleMapper;
import com.blog.param.GetArticleParam;
import com.blog.service.ArticleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Override
    public ListResultEx<Article> getArticleByType(GetArticleParam param) {
        ListResultEx resultEx=new ListResultEx();

        resultEx.setDataList(articleMapper.getArticleByType(param));
        for(Object a: resultEx.getDataList()){
            Article article=(Article)a;
            System.out.print(article.getCreatedTime());
        }

        return resultEx;
    }
}
