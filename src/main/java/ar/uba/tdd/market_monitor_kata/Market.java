package ar.uba.tdd.market_monitor_kata;

public class Market {

    int currency = 0;
    int max_value = 0;
    int min_value = 0;

    public int getValue(String currency){
        return this.currency;
    }

    public void updateCurrency(String coin) {
        this.currency = 1;
    }

    public int getMax(String coin) {
        return this.max_value;
    }

    public int getMin(String coin){
        return this.min_value;
    }
}
