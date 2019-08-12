package com.demo.price.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceExample() {
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

        public Criteria andPriceIdIsNull() {
            addCriterion("price_id is null");
            return (Criteria) this;
        }

        public Criteria andPriceIdIsNotNull() {
            addCriterion("price_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriceIdEqualTo(Long value) {
            addCriterion("price_id =", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdNotEqualTo(Long value) {
            addCriterion("price_id <>", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdGreaterThan(Long value) {
            addCriterion("price_id >", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("price_id >=", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdLessThan(Long value) {
            addCriterion("price_id <", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdLessThanOrEqualTo(Long value) {
            addCriterion("price_id <=", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdIn(List<Long> values) {
            addCriterion("price_id in", values, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdNotIn(List<Long> values) {
            addCriterion("price_id not in", values, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdBetween(Long value1, Long value2) {
            addCriterion("price_id between", value1, value2, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdNotBetween(Long value1, Long value2) {
            addCriterion("price_id not between", value1, value2, "priceId");
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

        public Criteria andBuyCurrentPriceIsNull() {
            addCriterion("buy_current_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceIsNotNull() {
            addCriterion("buy_current_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceEqualTo(Float value) {
            addCriterion("buy_current_price =", value, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceNotEqualTo(Float value) {
            addCriterion("buy_current_price <>", value, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceGreaterThan(Float value) {
            addCriterion("buy_current_price >", value, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("buy_current_price >=", value, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceLessThan(Float value) {
            addCriterion("buy_current_price <", value, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceLessThanOrEqualTo(Float value) {
            addCriterion("buy_current_price <=", value, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceIn(List<Float> values) {
            addCriterion("buy_current_price in", values, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceNotIn(List<Float> values) {
            addCriterion("buy_current_price not in", values, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceBetween(Float value1, Float value2) {
            addCriterion("buy_current_price between", value1, value2, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyCurrentPriceNotBetween(Float value1, Float value2) {
            addCriterion("buy_current_price not between", value1, value2, "buyCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceIsNull() {
            addCriterion("sell_current_price is null");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceIsNotNull() {
            addCriterion("sell_current_price is not null");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceEqualTo(Float value) {
            addCriterion("sell_current_price =", value, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceNotEqualTo(Float value) {
            addCriterion("sell_current_price <>", value, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceGreaterThan(Float value) {
            addCriterion("sell_current_price >", value, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("sell_current_price >=", value, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceLessThan(Float value) {
            addCriterion("sell_current_price <", value, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceLessThanOrEqualTo(Float value) {
            addCriterion("sell_current_price <=", value, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceIn(List<Float> values) {
            addCriterion("sell_current_price in", values, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceNotIn(List<Float> values) {
            addCriterion("sell_current_price not in", values, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceBetween(Float value1, Float value2) {
            addCriterion("sell_current_price between", value1, value2, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andSellCurrentPriceNotBetween(Float value1, Float value2) {
            addCriterion("sell_current_price not between", value1, value2, "sellCurrentPrice");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateIsNull() {
            addCriterion("price_current_date is null");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateIsNotNull() {
            addCriterion("price_current_date is not null");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateEqualTo(Date value) {
            addCriterion("price_current_date =", value, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateNotEqualTo(Date value) {
            addCriterion("price_current_date <>", value, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateGreaterThan(Date value) {
            addCriterion("price_current_date >", value, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("price_current_date >=", value, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateLessThan(Date value) {
            addCriterion("price_current_date <", value, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateLessThanOrEqualTo(Date value) {
            addCriterion("price_current_date <=", value, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateIn(List<Date> values) {
            addCriterion("price_current_date in", values, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateNotIn(List<Date> values) {
            addCriterion("price_current_date not in", values, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateBetween(Date value1, Date value2) {
            addCriterion("price_current_date between", value1, value2, "priceCurrentDate");
            return (Criteria) this;
        }

        public Criteria andPriceCurrentDateNotBetween(Date value1, Date value2) {
            addCriterion("price_current_date not between", value1, value2, "priceCurrentDate");
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