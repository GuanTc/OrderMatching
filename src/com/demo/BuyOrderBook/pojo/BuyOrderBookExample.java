package com.demo.BuyOrderBook.pojo;

import java.util.ArrayList;
import java.util.List;

public class BuyOrderBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuyOrderBookExample() {
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

        public Criteria andBobIdIsNull() {
            addCriterion("bob_id is null");
            return (Criteria) this;
        }

        public Criteria andBobIdIsNotNull() {
            addCriterion("bob_id is not null");
            return (Criteria) this;
        }

        public Criteria andBobIdEqualTo(Long value) {
            addCriterion("bob_id =", value, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdNotEqualTo(Long value) {
            addCriterion("bob_id <>", value, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdGreaterThan(Long value) {
            addCriterion("bob_id >", value, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bob_id >=", value, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdLessThan(Long value) {
            addCriterion("bob_id <", value, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdLessThanOrEqualTo(Long value) {
            addCriterion("bob_id <=", value, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdIn(List<Long> values) {
            addCriterion("bob_id in", values, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdNotIn(List<Long> values) {
            addCriterion("bob_id not in", values, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdBetween(Long value1, Long value2) {
            addCriterion("bob_id between", value1, value2, "bobId");
            return (Criteria) this;
        }

        public Criteria andBobIdNotBetween(Long value1, Long value2) {
            addCriterion("bob_id not between", value1, value2, "bobId");
            return (Criteria) this;
        }

        public Criteria andBuySizeIsNull() {
            addCriterion("buy_size is null");
            return (Criteria) this;
        }

        public Criteria andBuySizeIsNotNull() {
            addCriterion("buy_size is not null");
            return (Criteria) this;
        }

        public Criteria andBuySizeEqualTo(Integer value) {
            addCriterion("buy_size =", value, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeNotEqualTo(Integer value) {
            addCriterion("buy_size <>", value, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeGreaterThan(Integer value) {
            addCriterion("buy_size >", value, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_size >=", value, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeLessThan(Integer value) {
            addCriterion("buy_size <", value, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeLessThanOrEqualTo(Integer value) {
            addCriterion("buy_size <=", value, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeIn(List<Integer> values) {
            addCriterion("buy_size in", values, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeNotIn(List<Integer> values) {
            addCriterion("buy_size not in", values, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeBetween(Integer value1, Integer value2) {
            addCriterion("buy_size between", value1, value2, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuySizeNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_size not between", value1, value2, "buySize");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("buy_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(Float value) {
            addCriterion("buy_price =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(Float value) {
            addCriterion("buy_price <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(Float value) {
            addCriterion("buy_price >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("buy_price >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(Float value) {
            addCriterion("buy_price <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(Float value) {
            addCriterion("buy_price <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<Float> values) {
            addCriterion("buy_price in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<Float> values) {
            addCriterion("buy_price not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(Float value1, Float value2) {
            addCriterion("buy_price between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(Float value1, Float value2) {
            addCriterion("buy_price not between", value1, value2, "buyPrice");
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