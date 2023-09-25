package ar.uba.tdd.market_monitor_kata;

import java.util.Vector;

public class Wallet {

    Vector<String> coins = new Vector<String>();

    int amount = 0;
    boolean isEmpty = true;

    public boolean isEmpty() {
        return this.amount == 0;
    }

    public void add(String currency, int amount) {
        if(amount <= 0){
            throw new InvalidAmountException();
        }else{
            this.amount = amount;
        }
    }

    public int getAmount(String currency) {
        return this.amount;
    }
}
