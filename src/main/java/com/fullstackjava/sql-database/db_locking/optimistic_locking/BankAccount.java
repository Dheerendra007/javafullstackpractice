import java.math.BigDecimal;

import com.fullstackjava.db_locking.optimistic_locking;

@Entity
public class BankAccount {
  
     @Id
     private Long id;

     private BigDecimal balance;
    
}