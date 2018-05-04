package com.hxminco.mock.comm.entry;

public class UnionpayZmData {
    private String uid;

    private String tradeCode;

    private String acqInsCode;

    private String sendInsCode;

    private String traceNo;

    private String txnTime;

    private String payCardNo;

    private String txnAmt;

    private String merCatCode;

    private String termType;

    private String queryId;

    private String oldPayType;

    private String orderId;

    private String payCardType;

    private String origTraceNo;

    private String origTxnTime;

    private String merchantHandlingFee;

    private String settlementAmount;

    private String payType;

    private String groupMerId;

    private String txnType;

    private String txnSubType;

    private String bizType;

    private String accType;

    private String billType;

    private String billNo;

    private String interactMode;

    private String origQryId;

    private String merId;

    private String status;

    private Long createTime;

    public UnionpayZmData(String uid, String tradeCode, String acqInsCode, String sendInsCode, String traceNo, String txnTime, String payCardNo, String txnAmt, String merCatCode, String termType, String queryId, String oldPayType, String orderId, String payCardType, String origTraceNo, String origTxnTime, String merchantHandlingFee, String settlementAmount, String payType, String groupMerId, String txnType, String txnSubType, String bizType, String accType, String billType, String billNo, String interactMode, String origQryId, String merId, String status, Long createTime) {
        this.uid = uid;
        this.tradeCode = tradeCode;
        this.acqInsCode = acqInsCode;
        this.sendInsCode = sendInsCode;
        this.traceNo = traceNo;
        this.txnTime = txnTime;
        this.payCardNo = payCardNo;
        this.txnAmt = txnAmt;
        this.merCatCode = merCatCode;
        this.termType = termType;
        this.queryId = queryId;
        this.oldPayType = oldPayType;
        this.orderId = orderId;
        this.payCardType = payCardType;
        this.origTraceNo = origTraceNo;
        this.origTxnTime = origTxnTime;
        this.merchantHandlingFee = merchantHandlingFee;
        this.settlementAmount = settlementAmount;
        this.payType = payType;
        this.groupMerId = groupMerId;
        this.txnType = txnType;
        this.txnSubType = txnSubType;
        this.bizType = bizType;
        this.accType = accType;
        this.billType = billType;
        this.billNo = billNo;
        this.interactMode = interactMode;
        this.origQryId = origQryId;
        this.merId = merId;
        this.status = status;
        this.createTime = createTime;
    }

    public UnionpayZmData() {
        super();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode == null ? null : tradeCode.trim();
    }

    public String getAcqInsCode() {
        return acqInsCode;
    }

    public void setAcqInsCode(String acqInsCode) {
        this.acqInsCode = acqInsCode == null ? null : acqInsCode.trim();
    }

    public String getSendInsCode() {
        return sendInsCode;
    }

    public void setSendInsCode(String sendInsCode) {
        this.sendInsCode = sendInsCode == null ? null : sendInsCode.trim();
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo == null ? null : traceNo.trim();
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime == null ? null : txnTime.trim();
    }

    public String getPayCardNo() {
        return payCardNo;
    }

    public void setPayCardNo(String payCardNo) {
        this.payCardNo = payCardNo == null ? null : payCardNo.trim();
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt == null ? null : txnAmt.trim();
    }

    public String getMerCatCode() {
        return merCatCode;
    }

    public void setMerCatCode(String merCatCode) {
        this.merCatCode = merCatCode == null ? null : merCatCode.trim();
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType == null ? null : termType.trim();
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId == null ? null : queryId.trim();
    }

    public String getOldPayType() {
        return oldPayType;
    }

    public void setOldPayType(String oldPayType) {
        this.oldPayType = oldPayType == null ? null : oldPayType.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getPayCardType() {
        return payCardType;
    }

    public void setPayCardType(String payCardType) {
        this.payCardType = payCardType == null ? null : payCardType.trim();
    }

    public String getOrigTraceNo() {
        return origTraceNo;
    }

    public void setOrigTraceNo(String origTraceNo) {
        this.origTraceNo = origTraceNo == null ? null : origTraceNo.trim();
    }

    public String getOrigTxnTime() {
        return origTxnTime;
    }

    public void setOrigTxnTime(String origTxnTime) {
        this.origTxnTime = origTxnTime == null ? null : origTxnTime.trim();
    }

    public String getMerchantHandlingFee() {
        return merchantHandlingFee;
    }

    public void setMerchantHandlingFee(String merchantHandlingFee) {
        this.merchantHandlingFee = merchantHandlingFee == null ? null : merchantHandlingFee.trim();
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount == null ? null : settlementAmount.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getGroupMerId() {
        return groupMerId;
    }

    public void setGroupMerId(String groupMerId) {
        this.groupMerId = groupMerId == null ? null : groupMerId.trim();
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType == null ? null : txnType.trim();
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType == null ? null : txnSubType.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType == null ? null : accType.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getInteractMode() {
        return interactMode;
    }

    public void setInteractMode(String interactMode) {
        this.interactMode = interactMode == null ? null : interactMode.trim();
    }

    public String getOrigQryId() {
        return origQryId;
    }

    public void setOrigQryId(String origQryId) {
        this.origQryId = origQryId == null ? null : origQryId.trim();
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId == null ? null : merId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}