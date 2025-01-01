package model;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    private long id;

    private String name;
    private String passkey;

    public String getPasskey() {
        return passkey;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

}
