package repositories;

import models.Account;
import java.util.*;

public class InMemoryAccountRepository implements AccountRepository {
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public void save(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    @Override
    public List<Account> findByOwnerId(UUID ownerId) {
        List<Account> userAccounts = new ArrayList<>();
        for (Account account : accounts.values()) {
            if (account.getOwnerId().equals(ownerId)) {
                userAccounts.add(account);
            }
        }
        return userAccounts;
    }

    @Override
    public Account findById(String accountId) {
        return accounts.get(accountId);
    }

    @Override
    public void update(Account account) {
        accounts.put(account.getAccountId(), account);
    }
}
