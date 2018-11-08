package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.AccountViewModel;
import com.netcracker.fapi.service.AccountDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountDataController {

    @Autowired
    private  AccountDataService accountDataService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccountViewModel>> getAllAccounts() {
        List<AccountViewModel> accountViewModels = accountDataService.getAll();
        return ResponseEntity.ok().body(accountViewModels);
    }

    @RequestMapping(value = "/login/{login}",method = RequestMethod.GET)
    public ResponseEntity<AccountViewModel> getAccountByLogin(@PathVariable String login) {
        return ResponseEntity.ok(accountDataService.getAccountByLogin(login));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountViewModel> createAccount(@RequestBody AccountViewModel account ) {
        if (account != null) {
            return ResponseEntity.ok(accountDataService.createAccount(account));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable String id) {
        accountDataService.deleteAccount(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}
