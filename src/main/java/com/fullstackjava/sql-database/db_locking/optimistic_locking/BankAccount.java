import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
  
     @Id
     private Long id;

     private BigDecimal balance;
    
}