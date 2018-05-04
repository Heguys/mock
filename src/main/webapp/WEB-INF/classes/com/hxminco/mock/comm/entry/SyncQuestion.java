package com.hxminco.mock.comm.entry;

public class SyncQuestion {
    private String id;

    private String tqid;

    private String description;

    private String paperId;

    private Integer paperOrder;

    private Integer questionTypeCode;

    private Integer difficultyLevelCode;

    private Double score;

    private Integer sort;

    private Integer type;

    private String XX;

    public SyncQuestion(String id, String tqid, String description, String paperId, Integer paperOrder, Integer questionTypeCode, Integer difficultyLevelCode, Double score, Integer sort, Integer type, String XX) {
        this.id = id;
        this.tqid = tqid;
        this.description = description;
        this.paperId = paperId;
        this.paperOrder = paperOrder;
        this.questionTypeCode = questionTypeCode;
        this.difficultyLevelCode = difficultyLevelCode;
        this.score = score;
        this.sort = sort;
        this.type = type;
        this.XX = XX;
    }

    public SyncQuestion() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTqid() {
        return tqid;
    }

    public void setTqid(String tqid) {
        this.tqid = tqid == null ? null : tqid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public Integer getPaperOrder() {
        return paperOrder;
    }

    public void setPaperOrder(Integer paperOrder) {
        this.paperOrder = paperOrder;
    }

    public Integer getQuestionTypeCode() {
        return questionTypeCode;
    }

    public void setQuestionTypeCode(Integer questionTypeCode) {
        this.questionTypeCode = questionTypeCode;
    }

    public Integer getDifficultyLevelCode() {
        return difficultyLevelCode;
    }

    public void setDifficultyLevelCode(Integer difficultyLevelCode) {
        this.difficultyLevelCode = difficultyLevelCode;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getXX() {
        return XX;
    }

    public void setXX(String XX) {
        this.XX = XX == null ? null : XX.trim();
    }
}