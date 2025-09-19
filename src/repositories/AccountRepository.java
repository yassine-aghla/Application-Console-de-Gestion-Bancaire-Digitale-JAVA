package repositories;

import models.Account;
import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    void save(Account account);
    List<Account> findByOwnerId(UUID ownerId);
    Account findById(String accountId);
    void update(Account account);
}

