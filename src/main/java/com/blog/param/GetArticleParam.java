package com.blog.param;

import java.io.Serializable;

public class GetArticleParam  implements Serializable {
    private Integer typeId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
