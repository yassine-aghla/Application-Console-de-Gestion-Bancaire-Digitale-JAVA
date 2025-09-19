package Services;

import models.Account;
import models.User;
import repositories.AccountRepository;
import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(User user) {
        Account account = new Account(user.getId());
        accountRepository.save(account);
        return account;
    }

    public List<Account> getUserAccounts(User user) {
        return accountRepository.findByOwnerId(user.getId());
    }

    public boolean closeAccount(User user, String accountId) {
        Account account = accountRepository.findById(accountId);
        if (account != null && account.getOwnerId().equals(user.getId())) {
            boolean result = account.closeAccount();
            if (result) {
                accountRepository.update(account);
            }
            return result;
        }
        return false;
    }
}

