package com.cmx.entity;

/**
 * 记录文章与标签之间的关联
 */
public class Category {
    private int category_id;//自增id
    private int article_id;//文章id
    private Classification classification;//标签内容

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", article_id=" + article_id +
                ", classification=" + classification +
                '}';
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Category() {
    }
}
