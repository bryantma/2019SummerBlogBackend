package com.shimh.entity;

import com.shimh.common.entity.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "me_article_body")
public class ArticleBody extends BaseEntity<Long> {

    private static final long serialVersionUID = -7611409995977927628L;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "text")
    private String content;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "text")
    private String contentHtml;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}
