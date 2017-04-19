package com.lewandowska.julia.entity;

public class TransactionEntity {

    private final Long id;
    private final String type;
    private final Integer price;
    private final Integer commission;
    private final String currency;
    private final Boolean isPaid;

    public TransactionEntity(final Long id, final String type, final Integer price, final Integer commission,
                             final String currency, final Boolean isPaid) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.commission = commission;
        this.currency = currency;
        this.isPaid = isPaid;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() { return type; }

    public Integer getPrice() {
        return price;
    }

    public Integer getCommission() {
        return commission;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionEntity)) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        if (getPrice() != null ? !getPrice().equals(that.getPrice()) : that.getPrice() != null) return false;
        if (getCommission() != null ? !getCommission().equals(that.getCommission()) : that.getCommission() != null)
            return false;
        if (getCurrency() != null ? !getCurrency().equals(that.getCurrency()) : that.getCurrency() != null)
            return false;
        return isPaid != null ? isPaid.equals(that.isPaid) : that.isPaid == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCommission() != null ? getCommission().hashCode() : 0);
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (isPaid != null ? isPaid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                 id +
                " " + type  +
                " " + price +
                " " + commission +
                " " + currency  +
                " " + isPaid ;
    }
}