package com.demo.SellOrderBook.pojo;

import java.util.ArrayList;
import java.util.List;

public class SellOrderBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellOrderBookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSobIdIsNull() {
            addCriterion("sob_id is null");
            return (Criteria) this;
        }

        public Criteria andSobIdIsNotNull() {
            addCriterion("sob_id is not null");
            return (Criteria) this;
        }

        public Criteria andSobIdEqualTo(Long value) {
            addCriterion("sob_id =", value, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdNotEqualTo(Long value) {
            addCriterion("sob_id <>", value, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdGreaterThan(Long value) {
            addCriterion("sob_id >", value, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sob_id >=", value, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdLessThan(Long value) {
            addCriterion("sob_id <", value, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdLessThanOrEqualTo(Long value) {
            addCriterion("sob_id <=", value, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdIn(List<Long> values) {
            addCriterion("sob_id in", values, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdNotIn(List<Long> values) {
            addCriterion("sob_id not in", values, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdBetween(Long value1, Long value2) {
            addCriterion("sob_id between", value1, value2, "sobId");
            return (Criteria) this;
        }

        public Criteria andSobIdNotBetween(Long value1, Long value2) {
            addCriterion("sob_id not between", value1, value2, "sobId");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNull() {
            addCriterion("stock_id is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("stock_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(Long value) {
            addCriterion("stock_id =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(Long value) {
            addCriterion("stock_id <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(Long value) {
            addCriterion("stock_id >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            addCriterion("stock_id >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(Long value) {
            addCriterion("stock_id <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(Long value) {
            addCriterion("stock_id <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<Long> values) {
            addCriterion("stock_id in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<Long> values) {
            addCriterion("stock_id not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(Long value1, Long value2) {
            addCriterion("stock_id between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(Long value1, Long value2) {
            addCriterion("stock_id not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andAskSizeIsNull() {
            addCriterion("ask_size is null");
            return (Criteria) this;
        }

        public Criteria andAskSizeIsNotNull() {
            addCriterion("ask_size is not null");
            return (Criteria) this;
        }

        public Criteria andAskSizeEqualTo(Integer value) {
            addCriterion("ask_size =", value, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeNotEqualTo(Integer value) {
            addCriterion("ask_size <>", value, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeGreaterThan(Integer value) {
            addCriterion("ask_size >", value, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ask_size >=", value, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeLessThan(Integer value) {
            addCriterion("ask_size <", value, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeLessThanOrEqualTo(Integer value) {
            addCriterion("ask_size <=", value, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeIn(List<Integer> values) {
            addCriterion("ask_size in", values, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeNotIn(List<Integer> values) {
            addCriterion("ask_size not in", values, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeBetween(Integer value1, Integer value2) {
            addCriterion("ask_size between", value1, value2, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("ask_size not between", value1, value2, "askSize");
            return (Criteria) this;
        }

        public Criteria andAskPriceIsNull() {
            addCriterion("ask_price is null");
            return (Criteria) this;
        }

        public Criteria andAskPriceIsNotNull() {
            addCriterion("ask_price is not null");
            return (Criteria) this;
        }

        public Criteria andAskPriceEqualTo(Float value) {
            addCriterion("ask_price =", value, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceNotEqualTo(Float value) {
            addCriterion("ask_price <>", value, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceGreaterThan(Float value) {
            addCriterion("ask_price >", value, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("ask_price >=", value, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceLessThan(Float value) {
            addCriterion("ask_price <", value, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceLessThanOrEqualTo(Float value) {
            addCriterion("ask_price <=", value, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceIn(List<Float> values) {
            addCriterion("ask_price in", values, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceNotIn(List<Float> values) {
            addCriterion("ask_price not in", values, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceBetween(Float value1, Float value2) {
            addCriterion("ask_price between", value1, value2, "askPrice");
            return (Criteria) this;
        }

        public Criteria andAskPriceNotBetween(Float value1, Float value2) {
            addCriterion("ask_price not between", value1, value2, "askPrice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}