package ar.uba.tdd.market_monitor_kata;

public class Wallet {

    boolean isEmpty = true;

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public void add(String currency, int amount) {
        this.isEmpty = false;
    }
}
