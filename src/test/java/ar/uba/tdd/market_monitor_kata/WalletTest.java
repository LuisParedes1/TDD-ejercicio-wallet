package ar.uba.tdd.market_monitor_kata;


import org.junit.Test;
import static org.junit.Assert.*;

public class WalletTest {
    @Test
    public void createNonNullWallet(){
        assertNotNull(null, new Wallet());
    }

    @Test
    public void walletStartsOutEmpty(){
        var wallet = new Wallet();
        assertTrue(wallet.isEmpty());
    }

    @Test
    public void walletIsNotEmptyAfterAddingPositiveAmount(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
    }

    @Test
    public void addingNegativeAmountToWalletThrowsException(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
        assertThrows(InvalidAmountException.class,  () -> {
            wallet.add("BTC",-1);
        });
    }

    @Test
    public void addingZeroAmountToWalletThrowsException(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
        assertThrows(InvalidAmountException.class,  () -> {
            wallet.add("BTC",0);
        });
    }

    @Test
    public void walletHasInitialAmountZero(){
        var wallet = new Wallet();
        assertEquals(0, wallet.getAmount("BTC"));
    }

    @Test
    public void addingAnAmountToACoinInTheWalletLeavesThatAmountInTheWallet(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertEquals(1, wallet.getAmount("BTC"));
    }
}
