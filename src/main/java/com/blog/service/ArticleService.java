package com.blog.service;

import com.blog.bean.Article;
import com.blog.bean.ArticleType;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.param.GetArticleParam;

public interface ArticleService {
    ListResultEx<Article> getArticleByType(GetArticleParam param);
    ListResultEx<ArticleType> getArticleType();
}
