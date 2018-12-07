package com.springboot.entity.silverwaimai;

import java.util.Date;

/**
box_waimai
 */
public class Waimai {
    /**
     */
    private Long id;

    /**
     */
    private String orderNum;

    /**
     */
    private Integer orderSeq;

    /**
     */
    private Integer orderType;

    /**
     */
    private Integer orderStatus;

    /**
     */
    private String buyerId;

    /**
     */
    private Integer shopperId;

    /**
     */
    private Integer shopId;

    /**
     */
    private String shopName;

    /**
     */
    private Long machineId;

    /**
     */
    private Long outerSupportId;

    /**
     */
    private Double originalPrice;

    /**
     * 订单已支付金额
     */
    private Double totalFee;

    /**
     */
    private Double totalPrice;

    /**
     */
    private Integer payStatus;

    /**
     */
    private Integer payModel;

    /**
     */
    private Double totalPay;

    /**
     */
    private Double thirdPromotionFee;

    /**
     */
    private Double payplatformPromotionFee;

    /**
     */
    private String tableUid;

    /**
     */
    private String tableNum;

    /**
     */
    private String tradeNo;

    /**
     */
    private Integer buyerRerfundTimeout;

    /**
     */
    private String delivererName;

    /**
     */
    private String delivererPhone;

    /**
     */
    private Double deliveryPay;

    /**
     */
    private String endDeliveryTime;

    /**
     */
    private Integer endSeconds;

    /**
     */
    private String buyerMobile;

    /**
     */
    private String buyNick;

    /**
     */
    private String buyerPhone;

    /**
     */
    private String address;

    /**
     */
    private String invoiceTitle;

    /**
     */
    private Integer isHexiao;

    /**
     */
    private String identifyingCode;

    /**
     */
    private Integer isOut;

    /**
     */
    private Integer isPrint;

    /**
     */
    private String note;

    /**
     */
    private String payAccount;

    /**
     */
    private Integer peopleNumber;

    /**
     */
    private String promotionDesc;

    /**
     */
    private String promotionName;

    /**
     */
    private Double promotionPrice;

    /**
     */
    private Integer promotionType;

    /**
     */
    private Double refundFee;

    /**
     */
    private String refundNo;

    /**
     */
    private Date refundTime;

    /**
     */
    private Integer sellerCouponFee;

    /**
     */
    private Integer sellerRerfundTimeout;

    /**
     */
    private String shopContactPhone;

    /**
     */
    private String shopLogo;

    /**
     */
    private String startDeliveryTime;

    /**
     */
    private Date timeOutStamp;

    /**
     */
    private String cancleReason;

    /**
     */
    private String refuseMessage;

    /**
     */
    private String shopperName;

    /**
     */
    private Integer isPromotion;

    /**
     */
    private String shopAddress;

    /**
     */
    private Integer isChainStore;

    /**
     */
    private Integer isAlipayOrder;

    /**
     */
    private Integer isDelete;

    /**
     */
    private Integer hexiaoType;

    /**
     */
    private Double otherPrice;

    /**
     */
    private Integer isCheckout;

    /**
     * 不打折金额
     */
    private Double actualAmount;

    /**
     * 是否是第三方扫码进入
     */
    private Integer source;

    /**
     */
    private String uid;

    /**
     */
    private Integer isOtherPay;

    /**
     */
    private String koubeiShopid;

    /**
     * 是否开具了发票，0表示未开，1表示已开
     */
    private Integer isOpenInvoice;

    /**
     * 是否抹零
     */
    private Integer isRid;

    /**
     * 免除金额
     */
    private Double ridPrice;

    /**
     */
    private String reachTime;

    /**
     */
    private String consignTime;

    /**
     * 第三方系统订单编号
     */
    private String outOrderNum;

    /**
     */
    private Date createTime;

    /**
     */
    private Date updateTime;

    /**
     */
    private Date payTime;

    /**
     * 收货地址经度
     */
    private String receiverLng;

    /**
     * 收货地址纬度
     */
    private String receiverLat;

    /**
     * 1：商家已接单2：订单取消 3：骑手已接单 4：骑手已取货 5：送达 6：订单已过期 7：订单异常
     */
    private Integer deliveryStatus;

    /**
     * 收货人性别（0：女士，1：先生）
     */
    private Integer receiverSex;

    /**
     * 配送方式，0：商家自己配，1：蜂鸟配送，2：达达配送，默认0
     */
    private Integer takeOutMethod;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 备餐状态
     */
    private Integer prepMealStatus;

    /**
     * 取餐柜编号
     */
    private String containerNum;

    /**
     * 口碑预点单外部取餐号
     */
    private String outTakeNo;

    /**
     * 锁状态 0：未锁定 1：已锁定
     */
    private Integer lockStatus;

    /**
     * 创建时间
     */
    private Date lockTime;

    /**
     */
    private Integer posVersion;

    /**
     * 记录支付订单号（与 box_order_pay_detail表支付单号字段对应）
     */
    private String payOrderNum;

    /**
     * 支付类型编码（对应系统级支付方式及商家子订单支付方式pay_code字段）
     */
    private String payCode;

    /**
     * 接单超时时间
     */
    private Date receiptTimeout;

    /**
     * 留桌时间或备餐截
     * 止时间
     */
    private Date reserveTime;

    /**
     * 用户实付违约金额
     */
    private Double buyerDefaultRealAmount;

    /**
     */
    private String thirdSystemOrderNum;

    /**
     * 创建记录时间
     */
    private Date insertTime;

    /**
     * 取餐码
     */
    private String takeMealCode;

    /**
     * 员工号
     */
    private String jobNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public Integer getShopperId() {
        return shopperId;
    }

    public void setShopperId(Integer shopperId) {
        this.shopperId = shopperId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public Long getOuterSupportId() {
        return outerSupportId;
    }

    public void setOuterSupportId(Long outerSupportId) {
        this.outerSupportId = outerSupportId;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayModel() {
        return payModel;
    }

    public void setPayModel(Integer payModel) {
        this.payModel = payModel;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public Double getThirdPromotionFee() {
        return thirdPromotionFee;
    }

    public void setThirdPromotionFee(Double thirdPromotionFee) {
        this.thirdPromotionFee = thirdPromotionFee;
    }

    public Double getPayplatformPromotionFee() {
        return payplatformPromotionFee;
    }

    public void setPayplatformPromotionFee(Double payplatformPromotionFee) {
        this.payplatformPromotionFee = payplatformPromotionFee;
    }

    public String getTableUid() {
        return tableUid;
    }

    public void setTableUid(String tableUid) {
        this.tableUid = tableUid == null ? null : tableUid.trim();
    }

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum == null ? null : tableNum.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getBuyerRerfundTimeout() {
        return buyerRerfundTimeout;
    }

    public void setBuyerRerfundTimeout(Integer buyerRerfundTimeout) {
        this.buyerRerfundTimeout = buyerRerfundTimeout;
    }

    public String getDelivererName() {
        return delivererName;
    }

    public void setDelivererName(String delivererName) {
        this.delivererName = delivererName == null ? null : delivererName.trim();
    }

    public String getDelivererPhone() {
        return delivererPhone;
    }

    public void setDelivererPhone(String delivererPhone) {
        this.delivererPhone = delivererPhone == null ? null : delivererPhone.trim();
    }

    public Double getDeliveryPay() {
        return deliveryPay;
    }

    public void setDeliveryPay(Double deliveryPay) {
        this.deliveryPay = deliveryPay;
    }

    public String getEndDeliveryTime() {
        return endDeliveryTime;
    }

    public void setEndDeliveryTime(String endDeliveryTime) {
        this.endDeliveryTime = endDeliveryTime == null ? null : endDeliveryTime.trim();
    }

    public Integer getEndSeconds() {
        return endSeconds;
    }

    public void setEndSeconds(Integer endSeconds) {
        this.endSeconds = endSeconds;
    }

    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile == null ? null : buyerMobile.trim();
    }

    public String getBuyNick() {
        return buyNick;
    }

    public void setBuyNick(String buyNick) {
        this.buyNick = buyNick == null ? null : buyNick.trim();
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone == null ? null : buyerPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public Integer getIsHexiao() {
        return isHexiao;
    }

    public void setIsHexiao(Integer isHexiao) {
        this.isHexiao = isHexiao;
    }

    public String getIdentifyingCode() {
        return identifyingCode;
    }

    public void setIdentifyingCode(String identifyingCode) {
        this.identifyingCode = identifyingCode == null ? null : identifyingCode.trim();
    }

    public Integer getIsOut() {
        return isOut;
    }

    public void setIsOut(Integer isOut) {
        this.isOut = isOut;
    }

    public Integer getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Integer isPrint) {
        this.isPrint = isPrint;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc == null ? null : promotionDesc.trim();
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName == null ? null : promotionName.trim();
    }

    public Double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Double getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Double refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo == null ? null : refundNo.trim();
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getSellerCouponFee() {
        return sellerCouponFee;
    }

    public void setSellerCouponFee(Integer sellerCouponFee) {
        this.sellerCouponFee = sellerCouponFee;
    }

    public Integer getSellerRerfundTimeout() {
        return sellerRerfundTimeout;
    }

    public void setSellerRerfundTimeout(Integer sellerRerfundTimeout) {
        this.sellerRerfundTimeout = sellerRerfundTimeout;
    }

    public String getShopContactPhone() {
        return shopContactPhone;
    }

    public void setShopContactPhone(String shopContactPhone) {
        this.shopContactPhone = shopContactPhone == null ? null : shopContactPhone.trim();
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo == null ? null : shopLogo.trim();
    }

    public String getStartDeliveryTime() {
        return startDeliveryTime;
    }

    public void setStartDeliveryTime(String startDeliveryTime) {
        this.startDeliveryTime = startDeliveryTime == null ? null : startDeliveryTime.trim();
    }

    public Date getTimeOutStamp() {
        return timeOutStamp;
    }

    public void setTimeOutStamp(Date timeOutStamp) {
        this.timeOutStamp = timeOutStamp;
    }

    public String getCancleReason() {
        return cancleReason;
    }

    public void setCancleReason(String cancleReason) {
        this.cancleReason = cancleReason == null ? null : cancleReason.trim();
    }

    public String getRefuseMessage() {
        return refuseMessage;
    }

    public void setRefuseMessage(String refuseMessage) {
        this.refuseMessage = refuseMessage == null ? null : refuseMessage.trim();
    }

    public String getShopperName() {
        return shopperName;
    }

    public void setShopperName(String shopperName) {
        this.shopperName = shopperName == null ? null : shopperName.trim();
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    public Integer getIsChainStore() {
        return isChainStore;
    }

    public void setIsChainStore(Integer isChainStore) {
        this.isChainStore = isChainStore;
    }

    public Integer getIsAlipayOrder() {
        return isAlipayOrder;
    }

    public void setIsAlipayOrder(Integer isAlipayOrder) {
        this.isAlipayOrder = isAlipayOrder;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getHexiaoType() {
        return hexiaoType;
    }

    public void setHexiaoType(Integer hexiaoType) {
        this.hexiaoType = hexiaoType;
    }

    public Double getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(Double otherPrice) {
        this.otherPrice = otherPrice;
    }

    public Integer getIsCheckout() {
        return isCheckout;
    }

    public void setIsCheckout(Integer isCheckout) {
        this.isCheckout = isCheckout;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getIsOtherPay() {
        return isOtherPay;
    }

    public void setIsOtherPay(Integer isOtherPay) {
        this.isOtherPay = isOtherPay;
    }

    public String getKoubeiShopid() {
        return koubeiShopid;
    }

    public void setKoubeiShopid(String koubeiShopid) {
        this.koubeiShopid = koubeiShopid == null ? null : koubeiShopid.trim();
    }

    public Integer getIsOpenInvoice() {
        return isOpenInvoice;
    }

    public void setIsOpenInvoice(Integer isOpenInvoice) {
        this.isOpenInvoice = isOpenInvoice;
    }

    public Integer getIsRid() {
        return isRid;
    }

    public void setIsRid(Integer isRid) {
        this.isRid = isRid;
    }

    public Double getRidPrice() {
        return ridPrice;
    }

    public void setRidPrice(Double ridPrice) {
        this.ridPrice = ridPrice;
    }

    public String getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime == null ? null : reachTime.trim();
    }

    public String getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(String consignTime) {
        this.consignTime = consignTime == null ? null : consignTime.trim();
    }

    public String getOutOrderNum() {
        return outOrderNum;
    }

    public void setOutOrderNum(String outOrderNum) {
        this.outOrderNum = outOrderNum == null ? null : outOrderNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getReceiverLng() {
        return receiverLng;
    }

    public void setReceiverLng(String receiverLng) {
        this.receiverLng = receiverLng == null ? null : receiverLng.trim();
    }

    public String getReceiverLat() {
        return receiverLat;
    }

    public void setReceiverLat(String receiverLat) {
        this.receiverLat = receiverLat == null ? null : receiverLat.trim();
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getReceiverSex() {
        return receiverSex;
    }

    public void setReceiverSex(Integer receiverSex) {
        this.receiverSex = receiverSex;
    }

    public Integer getTakeOutMethod() {
        return takeOutMethod;
    }

    public void setTakeOutMethod(Integer takeOutMethod) {
        this.takeOutMethod = takeOutMethod;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public Integer getPrepMealStatus() {
        return prepMealStatus;
    }

    public void setPrepMealStatus(Integer prepMealStatus) {
        this.prepMealStatus = prepMealStatus;
    }

    public String getContainerNum() {
        return containerNum;
    }

    public void setContainerNum(String containerNum) {
        this.containerNum = containerNum == null ? null : containerNum.trim();
    }

    public String getOutTakeNo() {
        return outTakeNo;
    }

    public void setOutTakeNo(String outTakeNo) {
        this.outTakeNo = outTakeNo == null ? null : outTakeNo.trim();
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Integer getPosVersion() {
        return posVersion;
    }

    public void setPosVersion(Integer posVersion) {
        this.posVersion = posVersion;
    }

    public String getPayOrderNum() {
        return payOrderNum;
    }

    public void setPayOrderNum(String payOrderNum) {
        this.payOrderNum = payOrderNum == null ? null : payOrderNum.trim();
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public Date getReceiptTimeout() {
        return receiptTimeout;
    }

    public void setReceiptTimeout(Date receiptTimeout) {
        this.receiptTimeout = receiptTimeout;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Double getBuyerDefaultRealAmount() {
        return buyerDefaultRealAmount;
    }

    public void setBuyerDefaultRealAmount(Double buyerDefaultRealAmount) {
        this.buyerDefaultRealAmount = buyerDefaultRealAmount;
    }

    public String getThirdSystemOrderNum() {
        return thirdSystemOrderNum;
    }

    public void setThirdSystemOrderNum(String thirdSystemOrderNum) {
        this.thirdSystemOrderNum = thirdSystemOrderNum == null ? null : thirdSystemOrderNum.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getTakeMealCode() {
        return takeMealCode;
    }

    public void setTakeMealCode(String takeMealCode) {
        this.takeMealCode = takeMealCode == null ? null : takeMealCode.trim();
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum == null ? null : jobNum.trim();
    }
}