package team.cook.community.service;

import team.cook.community.dto.request.AccountDtoRequest;
import team.cook.community.dto.response.AccountDtoResponse;

public interface AccountService {
    AccountDtoResponse addAccount(AccountDtoRequest of);

    AccountDtoResponse findAccountById(Long id);

    AccountDtoResponse modifyAccount(AccountDtoRequest of);

    AccountDtoResponse removeAccountById(Long id);
}
