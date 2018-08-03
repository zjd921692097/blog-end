package com.blog.dao;

import com.blog.bean.Article;
import com.blog.param.GetArticleParam;

import java.util.List;

public interface ArticleMapper {
    List<Article> getArticleByType(GetArticleParam param);
}
