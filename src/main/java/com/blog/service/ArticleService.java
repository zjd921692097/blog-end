package com.blog.service;

import com.blog.bean.Article;
import com.blog.bean.ArticleType;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.param.GetArticleParam;
import com.blog.param.WriteParam;

public interface ArticleService {
    ListResultEx<Article> getArticleByType(GetArticleParam param);
    ListResultEx<ArticleType> getArticleType();
    ResultEx wirteArticle(WriteParam param);
}
