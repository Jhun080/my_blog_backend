package com.cmx.entity;

/**
 * 分类标签表
 */
public class Classification {
    private int classification_id;//标签id
    private String classification_name;//标签名

    @Override
    public String toString() {
        return "Classification{" +
                "classification_id=" + classification_id +
                ", classification_name='" + classification_name + '\'' +
                '}';
    }

    public int getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(int classification_id) {
        this.classification_id = classification_id;
    }

    public String getClassification_name() {
        return classification_name;
    }

    public void setClassification_name(String classification_name) {
        this.classification_name = classification_name;
    }

    public Classification() {
    }
}
