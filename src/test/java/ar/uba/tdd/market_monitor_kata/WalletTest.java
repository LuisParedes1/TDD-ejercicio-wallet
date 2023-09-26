package ar.uba.tdd.market_monitor_kata;


import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Test;

import java.beans.BeanProperty;
import java.util.Objects;

import static org.junit.gen5.api.Assertions.*;

public class WalletTest {
    @Test
    void createNonNullWallet(){
        assertNotNull(new Wallet());
    }

    @Test
    void walletStartsOutEmpty(){
        var wallet = new Wallet();
        assertTrue(wallet.isEmpty());
    }

    @Test
    void walletIsNotEmptyAfterAddingPositiveAmount(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
    }

    @Test
    void addingNegativeAmountToWalletThrowsException(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
        assertThrows(InvalidAmountException.class,  () -> {
            wallet.add("BTC",-1);
        });
    }

    @Test
    void addingZeroAmountToWalletThrowsException(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
        assertThrows(InvalidAmountException.class,  () -> {
            wallet.add("BTC",0);
        });
    }

    @Test
    void walletHasInitialAmountZero(){
        var wallet = new Wallet();
        assertEquals(0, wallet.getAmount("BTC"));
    }

    @Test
    void addingAnAmountToACoinInTheWalletLeavesThatAmountInTheWallet(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertEquals(1, wallet.getAmount("BTC"));
    }



    // Para cualquier par de monedas arbitraria probar
    @Property
    void addingAmountToDifferentCoinsLeavesDifferentAmountsInTheWallet(
        @ForAll String firstCoin,
        @ForAll String secondCoin
    ){
        Assume.that(!Objects.equals(firstCoin, secondCoin));

        var wallet = new Wallet();
        wallet.add("BTC",1);
        wallet.add("ETH",2);

        assertEquals(1, wallet.getAmount("BTC"));
        assertEquals(2, wallet.getAmount("ETH"));
    }


    @Property
    void addingToSameCoinLeavesAddedAmountsInTheWallet(
            @ForAll String coin,
            @ForAll @Positive int firstAmount,
            @ForAll @Positive int secondAmount
    ){
        var wallet = new Wallet();
        wallet.add(coin,firstAmount);
        wallet.add(coin,secondAmount);
        assertEquals(firstAmount + secondAmount, wallet.getAmount(coin));
    }


    @Test
    void removingFromEmptyWalletThrowsException(){
        var wallet = new Wallet();
        assertThrows(InvalidAmountException.class, () -> {
            wallet.remove("BTC",1);
        });
    }

    @Property
    void addingAndThenRemovingCurrencyFromWalletMaintainsAmount(
            @ForAll String coin,
            @ForAll @Positive int amount
    ){
        var wallet = new Wallet();
        wallet.add(coin,amount);
        wallet.remove(coin,amount);

        assertEquals(0, wallet.getAmount(coin));
    }

}
