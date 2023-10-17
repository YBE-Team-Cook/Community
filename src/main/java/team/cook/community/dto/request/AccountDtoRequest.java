package team.cook.community.dto.request;

import team.cook.community.domain.Account;

public record AccountDtoRequest(
            String email,
            String name,
            String password) {

     public static AccountDtoRequest of(String email, String name, String password) {
         return new AccountDtoRequest(email, name, password);
     }

     public static AccountDtoRequest fromEntity(Account entity) {
         return new AccountDtoRequest(
                 entity.getEmail(),
                 entity.getName(),
                 entity.getPassword()
         );
     }

     public Account toEntity(){
         return Account.of(null, this.email, this.name, this.password);
     }
}
