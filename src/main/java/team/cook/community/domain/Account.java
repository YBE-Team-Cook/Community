package team.cook.community.domain;

import jakarta.persistence.*;
import lombok.Getter;
import team.cook.community.dto.request.AccountDtoRequest;

import java.util.Objects;

@Getter
@Entity
public class Account extends AuditingField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 255)
    private String password;

    protected Account() {
    }

    private Account(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public static Account of(Long id, String email, String name, String password) {
        return new Account(id, email, name, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account that)) return false;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void updateAccount(AccountDtoRequest accountDtoRequest) {
        if (accountDtoRequest.email() != null) {
            this.email = accountDtoRequest.email();
        }
        if (accountDtoRequest.name() != null) {
            this.name = accountDtoRequest.name();
        }
        if (accountDtoRequest.password() != null) {
            this.password = accountDtoRequest.password();
        }

    }
}
