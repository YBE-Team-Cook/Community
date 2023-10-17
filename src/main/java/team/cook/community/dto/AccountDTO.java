package team.cook.community.dto;

import team.cook.community.domain.Account;

import java.time.LocalDateTime;

public record AccountDTO(
        Long id,
        String email,
        String name,
        String password,
        LocalDateTime modifiedAt,
        LocalDateTime createdAt) {


    public static AccountDTO of(Long id, String email, String name, String password, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        return new AccountDTO(id, email, name, password,createdAt,modifiedAt);
    }

    public static AccountDTO fromEntity(Account entity) {
        return new AccountDTO(
                entity.getId(),
                entity.getEmail(),
                entity.getName(),
                entity.getPassword(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }

    public Account toEntity(Account entity) {
        return Account.of(
                id,
                email,
                name,
                password
        );
    }



}
