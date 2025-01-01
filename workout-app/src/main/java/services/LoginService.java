package services;

import exceptions.LoginDoesNotExistException;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;

@Service
public class LoginService {
    private final AccountRepository accountRepository;

    @Autowired
    public LoginService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public ResponseEntity<Account> login(String user, String passkey){
        Account account = accountRepository.findAccountByNameAndPasskey(user,passkey);
        if(account == null) throw new LoginDoesNotExistException();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(account);
    }
}
