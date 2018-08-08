package com.blog.param;

import java.io.Serializable;

public class GetArticleParam  implements Serializable {
    private Integer typeId;
    private Integer status=1;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
