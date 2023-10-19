package team.cook.community.controller;

import org.springframework.web.bind.annotation.*;
import team.cook.community.dto.request.AccountDtoRequest;
import team.cook.community.dto.response.AccountDtoResponse;
import team.cook.community.service.AccountService;

@RequestMapping("account")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping
    public AccountDtoResponse createAccount(@RequestBody AccountDtoRequest accountDtoRequest) {
        return accountService.addAccount(accountDtoRequest);
    }


    @GetMapping("{id}")
    public AccountDtoResponse getAccount(@PathVariable final Long id) {
        return accountService.findAccountById(id);
    }


    @PatchMapping("{id}")
    public AccountDtoResponse updateAccount(@PathVariable final Long id, @RequestBody AccountDtoRequest accountDtoRequest) {
        return accountService.modifyAccount(id, accountDtoRequest);
    }


    @DeleteMapping("{id}")
    public void deleteAccount(@PathVariable final Long id) {
        accountService.removeAccountById(id);
    }

}
