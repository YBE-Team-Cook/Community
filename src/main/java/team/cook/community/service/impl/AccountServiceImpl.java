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
        Account account = accountRepository.getReferenceById(id);
        return AccountDtoResponse.fromEntity(account);
    }

    @Override
    public AccountDtoResponse modifyAccount(Long id, AccountDtoRequest request) {

        Account account = accountRepository.getReferenceById(id);

        // TODO 이건 아닌듯 -> 도메인에서 처리할 수 있음(더티체킹 활용)

//        String newEmail = account.getEmail();
//        String newName = account.getName();
//        String newPassword = account.getPassword();
//        if(request.email() != null) { newEmail = request.email(); }
//        if(request.name() != null) { newName = request.name(); }
//        if(request.password() != null) { newPassword = request.password(); }
//        Account newAccount = Account.of(account.getId(), newEmail, newName, newPassword);
//        Account modifyAccount = accountRepository.save(newAccount);

//        Account.builder()
//                .email(request.email())
//                ...


        // Account 안에 update() -> 더티체킹
        account.updateAccount(request);

        return AccountDtoResponse.fromEntity(account);
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
