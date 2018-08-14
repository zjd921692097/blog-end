package com.blog.service.impl;

import com.blog.bean.Article;
import com.blog.bean.ArticleType;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.dao.ArticleMapper;
import com.blog.dao.ArticleTypeMapper;
import com.blog.param.GetArticleParam;
import com.blog.param.WriteParam;
import com.blog.service.ArticleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Resource
    ArticleTypeMapper articleTypeMapper;


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

    @Override
    public ListResultEx<ArticleType> getArticleType() {
        List<ArticleType> articleTypes=articleTypeMapper.getArticleType();
        ListResultEx resultEx=new ListResultEx();
        resultEx.setDataList(articleTypes);
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx wirteArticle(WriteParam param) {
        ResultEx resultEx=new ResultEx();
        param.setCreatedTime(new Date());
        if(param.getTitle()==null || param.getTitle()==""){
            return resultEx.makeFailedResult("标题不能为空");
        }
        param.setStatus(1);
        int result=articleMapper.write(param);
        if(result==0){
            return resultEx.makeFailedResult("增添失败");
        }
        return resultEx.makeSuccessResult();
    }
}
