package ar.uba.tdd.market_monitor_kata;

import java.util.HashMap;
import java.util.Vector;

public class Wallet {

    HashMap<String,Integer> amount = new HashMap<String,Integer>();
    boolean isEmpty = true;

    public boolean isEmpty() {
        return this.amount.isEmpty();
    }

    public void add(String currency, int amount) {
        if(amount <= 0){
            throw new InvalidAmountException();
        }else{
            this.amount.put(currency, amount + this.getAmount(currency));
        }
    }

    public int getAmount(String currency) {
        return this.amount.getOrDefault(currency,0);
    }

    public void remove(String currency, int amount) {
        if (amount <= 0  || this.isEmpty()){
            throw new InvalidAmountException();
        }

        this.amount.put(currency, this.getAmount(currency) - amount);
    }
}
