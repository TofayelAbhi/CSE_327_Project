import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepositTest {

    private Deposit deposit;

    @BeforeEach
    public void setUp() {
        deposit = new Deposit("");
    }

    @Test
    public void testDepositButtonActionPerformed() {
        // Test deposit action when amount is empty
        deposit.getTextField().setText("");
        deposit.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Deposit"));
        assertFalse(deposit.isVisible());

        // Test deposit action when amount is not empty
        deposit.getTextField().setText("100");
        deposit.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Deposit"));
        assertFalse(deposit.isVisible());
    }

    @Test
    public void testBackButtonActionPerformed() {
        // Test back button action
        deposit.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Back"));
        assertFalse(deposit.isVisible());
    }
}
