package com.lewandowska.julia.entity;

public class SummaryTransactionsEntity extends TransactionEntity {

    private final Integer toChargeValue;
    private final Integer settlementValue;

    public SummaryTransactionsEntity(final Long id, final String type, final Integer price, final Integer commission, final String currency, final Boolean isPaid, final Integer toChargeValue, final Integer settlementValue) {
        super(id, type, price, commission, currency, isPaid);
        this.toChargeValue = toChargeValue;
        this.settlementValue = settlementValue;
    }

    public Integer getToChargeValue() {
        return toChargeValue;
    }

    public Integer getSettlementValue() {
        return settlementValue;
    }

    @Override
    public String toString() {
        return super.getCurrency() + " " + super.getType() + " " + super.getPrice()
                + " " + super.getCommission() + " " + toChargeValue + " " + settlementValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SummaryTransactionsEntity)) return false;
        if (!super.equals(o)) return false;

        SummaryTransactionsEntity that = (SummaryTransactionsEntity) o;

        if (!getToChargeValue().equals(that.getToChargeValue())) return false;
        return getSettlementValue().equals(that.getSettlementValue());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getToChargeValue().hashCode();
        result = 31 * result + getSettlementValue().hashCode();
        return result;
    }
}