package services;

import exceptions.InvalidPasswordException;
import exceptions.LoginDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repositories.AccountRepository;

@Service
public class SignupService {
    private final AccountRepository accountRepository;

    public SignupService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void signup(String user, String passkey){
        Account account = accountRepository.findByUser(user);
        if(account != null) throw new UserAlreadyExistsException();
        if(passkey.contains(" ") || passkey.isEmpty()) throw new InvalidPasswordException();

        accountRepository.insertAccount(user,passkey);
    }
}
