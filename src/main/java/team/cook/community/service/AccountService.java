package team.cook.community.service;

import team.cook.community.dto.request.AccountDtoRequest;
import team.cook.community.dto.response.AccountDtoResponse;

public interface AccountService {
    AccountDtoResponse addAccount(AccountDtoRequest accountDtoRequest);

    AccountDtoResponse findAccountById(Long id);

    AccountDtoResponse modifyAccount(Long id, AccountDtoRequest accountDtoRequest);

    boolean removeAccountById(Long id);
}
