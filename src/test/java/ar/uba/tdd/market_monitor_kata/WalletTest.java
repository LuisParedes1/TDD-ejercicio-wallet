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
    public void walletIsNotEmpty(){
        var wallet = new Wallet();
        wallet.add("BTC",1);
        assertFalse(wallet.isEmpty());
    }
}
