package team.cook.community.dto.response;

import team.cook.community.domain.Account;

import java.time.LocalDateTime;

public record AccountDtoResponse(
            Long id,
            String email,
            String name,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt) {

     public static AccountDtoResponse of(Long id, String email, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
         return new AccountDtoResponse(id, email, name, createdAt, modifiedAt);
     }

     public static AccountDtoResponse fromEntity(Account entity) {
         return new AccountDtoResponse(
                 entity.getId(),
                 entity.getEmail(),
                 entity.getName(),
                 entity.getCreatedAt(),
                 entity.getModifiedAt()
         );
     }
}

