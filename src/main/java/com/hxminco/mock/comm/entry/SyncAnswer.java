package com.hxminco.mock.comm.entry;

public class SyncAnswer {
    private String id;

    private String description;

    private String questionId;

    private String isValid;

    public SyncAnswer(String id, String description, String questionId, String isValid) {
        this.id = id;
        this.description = description;
        this.questionId = questionId;
        this.isValid = isValid;
    }

    public SyncAnswer() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }
}