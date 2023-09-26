package ar.uba.tdd.market_monitor_kata;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.gen5.api.Assertions.*;

public class MercadoTest {

    @Test
    void createNonNullMarket(){
        assertNotNull(new Market());
    }

    @Property
    void getCurrencyValueFromMarket(@ForAll String coin){
        var market = new Market();
        assertNotNull(market.getValue(coin));
    }

    @Property
    void getMaxValueOfCurrencyValueSinceStartedRecording(@ForAll String coin){
        var market = new Market();
        assertNotNull(market.getMax(coin));
    }

    @Property
    void getMinValueOfCurrencyValueSinceStartedRecording(@ForAll String coin){
        var market = new Market();
        assertNotNull(market.getMin(coin));
    }

    @Property
    void updateCurrencyValueFromMarket(@ForAll String coin){
        var market = new Market();
        market.updateCurrency(coin);
        assertNotEquals(0, market.getValue(coin));
    }
}
