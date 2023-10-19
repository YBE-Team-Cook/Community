package team.cook.community.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.cook.community.domain.Account;
import team.cook.community.dto.request.AccountDtoRequest;
import team.cook.community.dto.response.AccountDtoResponse;
import team.cook.community.repository.AccountRepository;
import team.cook.community.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDtoResponse addAccount(AccountDtoRequest accountDtoRequest) {
        Account account = Account.of(null, accountDtoRequest.email(), accountDtoRequest.name(), accountDtoRequest.password());
        Account savedAccount = accountRepository.save(account);

        return AccountDtoResponse.fromEntity(savedAccount); // ToDo: ModifiedAt에 무슨 값이 담기는지 확인.
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDtoResponse findAccountById(Long id) {
        return null;
    }

    @Override
    public AccountDtoResponse modifyAccount(AccountDtoRequest of) {
        return null;
    }

    @Override
    public boolean removeAccountById(Long id) {
        // ToDo: 삭제시 반환 어떻게 할지

        try {
            accountRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
