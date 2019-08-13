package com.demo.orders.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("qty is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("qty is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyIsNull() {
            addCriterion("remain_qty is null");
            return (Criteria) this;
        }

        public Criteria andRemainQtyIsNotNull() {
            addCriterion("remain_qty is not null");
            return (Criteria) this;
        }

        public Criteria andRemainQtyEqualTo(Integer value) {
            addCriterion("remain_qty =", value, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyNotEqualTo(Integer value) {
            addCriterion("remain_qty <>", value, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyGreaterThan(Integer value) {
            addCriterion("remain_qty >", value, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_qty >=", value, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyLessThan(Integer value) {
            addCriterion("remain_qty <", value, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyLessThanOrEqualTo(Integer value) {
            addCriterion("remain_qty <=", value, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyIn(List<Integer> values) {
            addCriterion("remain_qty in", values, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyNotIn(List<Integer> values) {
            addCriterion("remain_qty not in", values, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyBetween(Integer value1, Integer value2) {
            addCriterion("remain_qty between", value1, value2, "remainQty");
            return (Criteria) this;
        }

        public Criteria andRemainQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_qty not between", value1, value2, "remainQty");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(Float value) {
            addCriterion("market_price =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(Float value) {
            addCriterion("market_price <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(Float value) {
            addCriterion("market_price >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("market_price >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(Float value) {
            addCriterion("market_price <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(Float value) {
            addCriterion("market_price <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<Float> values) {
            addCriterion("market_price in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<Float> values) {
            addCriterion("market_price not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(Float value1, Float value2) {
            addCriterion("market_price between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(Float value1, Float value2) {
            addCriterion("market_price not between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceIsNull() {
            addCriterion("limit_price is null");
            return (Criteria) this;
        }

        public Criteria andLimitPriceIsNotNull() {
            addCriterion("limit_price is not null");
            return (Criteria) this;
        }

        public Criteria andLimitPriceEqualTo(Float value) {
            addCriterion("limit_price =", value, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceNotEqualTo(Float value) {
            addCriterion("limit_price <>", value, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceGreaterThan(Float value) {
            addCriterion("limit_price >", value, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("limit_price >=", value, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceLessThan(Float value) {
            addCriterion("limit_price <", value, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceLessThanOrEqualTo(Float value) {
            addCriterion("limit_price <=", value, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceIn(List<Float> values) {
            addCriterion("limit_price in", values, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceNotIn(List<Float> values) {
            addCriterion("limit_price not in", values, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceBetween(Float value1, Float value2) {
            addCriterion("limit_price between", value1, value2, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andLimitPriceNotBetween(Float value1, Float value2) {
            addCriterion("limit_price not between", value1, value2, "limitPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceIsNull() {
            addCriterion("trigger_price is null");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceIsNotNull() {
            addCriterion("trigger_price is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceEqualTo(Float value) {
            addCriterion("trigger_price =", value, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceNotEqualTo(Float value) {
            addCriterion("trigger_price <>", value, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceGreaterThan(Float value) {
            addCriterion("trigger_price >", value, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("trigger_price >=", value, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceLessThan(Float value) {
            addCriterion("trigger_price <", value, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceLessThanOrEqualTo(Float value) {
            addCriterion("trigger_price <=", value, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceIn(List<Float> values) {
            addCriterion("trigger_price in", values, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceNotIn(List<Float> values) {
            addCriterion("trigger_price not in", values, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceBetween(Float value1, Float value2) {
            addCriterion("trigger_price between", value1, value2, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andTriggerPriceNotBetween(Float value1, Float value2) {
            addCriterion("trigger_price not between", value1, value2, "triggerPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceIsNull() {
            addCriterion("stop_price is null");
            return (Criteria) this;
        }

        public Criteria andStopPriceIsNotNull() {
            addCriterion("stop_price is not null");
            return (Criteria) this;
        }

        public Criteria andStopPriceEqualTo(Float value) {
            addCriterion("stop_price =", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceNotEqualTo(Float value) {
            addCriterion("stop_price <>", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceGreaterThan(Float value) {
            addCriterion("stop_price >", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("stop_price >=", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceLessThan(Float value) {
            addCriterion("stop_price <", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceLessThanOrEqualTo(Float value) {
            addCriterion("stop_price <=", value, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceIn(List<Float> values) {
            addCriterion("stop_price in", values, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceNotIn(List<Float> values) {
            addCriterion("stop_price not in", values, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceBetween(Float value1, Float value2) {
            addCriterion("stop_price between", value1, value2, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andStopPriceNotBetween(Float value1, Float value2) {
            addCriterion("stop_price not between", value1, value2, "stopPrice");
            return (Criteria) this;
        }

        public Criteria andFullOrKillIsNull() {
            addCriterion("full_or_kill is null");
            return (Criteria) this;
        }

        public Criteria andFullOrKillIsNotNull() {
            addCriterion("full_or_kill is not null");
            return (Criteria) this;
        }

        public Criteria andFullOrKillEqualTo(Integer value) {
            addCriterion("full_or_kill =", value, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillNotEqualTo(Integer value) {
            addCriterion("full_or_kill <>", value, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillGreaterThan(Integer value) {
            addCriterion("full_or_kill >", value, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillGreaterThanOrEqualTo(Integer value) {
            addCriterion("full_or_kill >=", value, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillLessThan(Integer value) {
            addCriterion("full_or_kill <", value, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillLessThanOrEqualTo(Integer value) {
            addCriterion("full_or_kill <=", value, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillIn(List<Integer> values) {
            addCriterion("full_or_kill in", values, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillNotIn(List<Integer> values) {
            addCriterion("full_or_kill not in", values, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillBetween(Integer value1, Integer value2) {
            addCriterion("full_or_kill between", value1, value2, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andFullOrKillNotBetween(Integer value1, Integer value2) {
            addCriterion("full_or_kill not between", value1, value2, "fullOrKill");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andGtdDateIsNull() {
            addCriterion("gtd_date is null");
            return (Criteria) this;
        }

        public Criteria andGtdDateIsNotNull() {
            addCriterion("gtd_date is not null");
            return (Criteria) this;
        }

        public Criteria andGtdDateEqualTo(Date value) {
            addCriterion("gtd_date =", value, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateNotEqualTo(Date value) {
            addCriterion("gtd_date <>", value, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateGreaterThan(Date value) {
            addCriterion("gtd_date >", value, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateGreaterThanOrEqualTo(Date value) {
            addCriterion("gtd_date >=", value, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateLessThan(Date value) {
            addCriterion("gtd_date <", value, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateLessThanOrEqualTo(Date value) {
            addCriterion("gtd_date <=", value, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateIn(List<Date> values) {
            addCriterion("gtd_date in", values, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateNotIn(List<Date> values) {
            addCriterion("gtd_date not in", values, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateBetween(Date value1, Date value2) {
            addCriterion("gtd_date between", value1, value2, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andGtdDateNotBetween(Date value1, Date value2) {
            addCriterion("gtd_date not between", value1, value2, "gtdDate");
            return (Criteria) this;
        }

        public Criteria andMinuteIsNull() {
            addCriterion("minute is null");
            return (Criteria) this;
        }

        public Criteria andMinuteIsNotNull() {
            addCriterion("minute is not null");
            return (Criteria) this;
        }

        public Criteria andMinuteEqualTo(Integer value) {
            addCriterion("minute =", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteNotEqualTo(Integer value) {
            addCriterion("minute <>", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteGreaterThan(Integer value) {
            addCriterion("minute >", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteGreaterThanOrEqualTo(Integer value) {
            addCriterion("minute >=", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteLessThan(Integer value) {
            addCriterion("minute <", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteLessThanOrEqualTo(Integer value) {
            addCriterion("minute <=", value, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteIn(List<Integer> values) {
            addCriterion("minute in", values, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteNotIn(List<Integer> values) {
            addCriterion("minute not in", values, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteBetween(Integer value1, Integer value2) {
            addCriterion("minute between", value1, value2, "minute");
            return (Criteria) this;
        }

        public Criteria andMinuteNotBetween(Integer value1, Integer value2) {
            addCriterion("minute not between", value1, value2, "minute");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNull() {
            addCriterion("submit_date is null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIsNotNull() {
            addCriterion("submit_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitDateEqualTo(Date value) {
            addCriterion("submit_date =", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotEqualTo(Date value) {
            addCriterion("submit_date <>", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThan(Date value) {
            addCriterion("submit_date >", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_date >=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThan(Date value) {
            addCriterion("submit_date <", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateLessThanOrEqualTo(Date value) {
            addCriterion("submit_date <=", value, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateIn(List<Date> values) {
            addCriterion("submit_date in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotIn(List<Date> values) {
            addCriterion("submit_date not in", values, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateBetween(Date value1, Date value2) {
            addCriterion("submit_date between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andSubmitDateNotBetween(Date value1, Date value2) {
            addCriterion("submit_date not between", value1, value2, "submitDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSendOutDateIsNull() {
            addCriterion("send_out_date is null");
            return (Criteria) this;
        }

        public Criteria andSendOutDateIsNotNull() {
            addCriterion("send_out_date is not null");
            return (Criteria) this;
        }

        public Criteria andSendOutDateEqualTo(Date value) {
            addCriterion("send_out_date =", value, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateNotEqualTo(Date value) {
            addCriterion("send_out_date <>", value, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateGreaterThan(Date value) {
            addCriterion("send_out_date >", value, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateGreaterThanOrEqualTo(Date value) {
            addCriterion("send_out_date >=", value, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateLessThan(Date value) {
            addCriterion("send_out_date <", value, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateLessThanOrEqualTo(Date value) {
            addCriterion("send_out_date <=", value, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateIn(List<Date> values) {
            addCriterion("send_out_date in", values, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateNotIn(List<Date> values) {
            addCriterion("send_out_date not in", values, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateBetween(Date value1, Date value2) {
            addCriterion("send_out_date between", value1, value2, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andSendOutDateNotBetween(Date value1, Date value2) {
            addCriterion("send_out_date not between", value1, value2, "sendOutDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateIsNull() {
            addCriterion("final_date is null");
            return (Criteria) this;
        }

        public Criteria andFinalDateIsNotNull() {
            addCriterion("final_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinalDateEqualTo(Date value) {
            addCriterion("final_date =", value, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateNotEqualTo(Date value) {
            addCriterion("final_date <>", value, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateGreaterThan(Date value) {
            addCriterion("final_date >", value, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("final_date >=", value, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateLessThan(Date value) {
            addCriterion("final_date <", value, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateLessThanOrEqualTo(Date value) {
            addCriterion("final_date <=", value, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateIn(List<Date> values) {
            addCriterion("final_date in", values, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateNotIn(List<Date> values) {
            addCriterion("final_date not in", values, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateBetween(Date value1, Date value2) {
            addCriterion("final_date between", value1, value2, "finalDate");
            return (Criteria) this;
        }

        public Criteria andFinalDateNotBetween(Date value1, Date value2) {
            addCriterion("final_date not between", value1, value2, "finalDate");
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