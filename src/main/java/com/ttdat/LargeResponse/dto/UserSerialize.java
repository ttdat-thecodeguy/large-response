package com.ttdat.LargeResponse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserSerialize {
    @JsonProperty("rule") private List<String> rules;
    @JsonProperty("data") private List<List<String>> datas;

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public List<List<String>> getDatas() {
        return datas;
    }

    public void setDatas(List<List<String>> datas) {
        this.datas = datas;
    }

    public UserSerialize() {}
}
