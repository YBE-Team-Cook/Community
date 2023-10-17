package team.cook.community.service.impl;

import org.springframework.stereotype.Service;
import team.cook.community.dto.request.AccountDtoRequest;
import team.cook.community.dto.response.AccountDtoResponse;
import team.cook.community.repository.AccountRepository;
import team.cook.community.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDtoResponse addAccount(AccountDtoRequest of) {
        return null;
    }

    @Override
    public AccountDtoResponse findAccountById(Long id) {
        return null;
    }

    @Override
    public AccountDtoResponse modifyAccount(AccountDtoRequest of) {
        return null;
    }

    @Override
    public AccountDtoResponse removeAccountById(Long id) {
        return null;
    }
}
