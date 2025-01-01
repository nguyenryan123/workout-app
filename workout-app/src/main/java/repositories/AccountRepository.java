package repositories;

import model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    @Modifying
    @Query("INSERT INTO account (name,passkey) VALUES (:name,:passkey)")
    void insertAccount(String name, String passkey);

    @Query("SELECT * FROM account WHERE name = :name AND passkey = :passkey")
    Account findAccountByNameAndPasskey(String name, String passkey);

    @Query("SELECT * FROM account WHERE name = :name")
    Account findByUser(String name);

    @Query("SELECT * FROM account WHERE passkey = :passkey")
    Account findByPasskey(String passkey);
}
