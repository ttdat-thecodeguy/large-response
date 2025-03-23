package com.ttdat.LargeResponse.dto;

public class Rule {
    private String column;
    private Integer index;

    public Rule() {
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Rule(String column, Integer index) {
        this.column = column;
        this.index = index;
    }
}
