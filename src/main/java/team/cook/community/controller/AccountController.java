package team.cook.community.controller;

import org.springframework.web.bind.annotation.*;
import team.cook.community.dto.request.AccountDtoRequest;
import team.cook.community.dto.response.AccountDtoResponse;
import team.cook.community.service.AccountService;

@RequestMapping("account")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }


    @PostMapping
    public AccountDtoResponse createAccount(@RequestBody AccountDtoRequest accountDtoRequest) {
        return accountService.addAccount(AccountDtoRequest.of("new email01", "new name01", "new password01"));
    }


    @GetMapping("{id}")
    public AccountDtoResponse getAccount(@PathVariable final Long id) {
        return accountService.findAccountById(id);
    }


    @PatchMapping()
    public AccountDtoResponse updateAccount(@RequestBody AccountDtoRequest accountDtoRequest){
        return accountService.modifyAccount(AccountDtoRequest.of("new email07", "new name07", "new password07"));
    }


    @DeleteMapping("{id}")
    public AccountDtoResponse deleteAccount(@PathVariable final Long id){
        return accountService.removeAccountById(id);
    }

}
