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
}
