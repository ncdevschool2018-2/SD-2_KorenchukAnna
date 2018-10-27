package com.netcracker.fapi.controller;

import com.netcracker.fapi.model.AccountViewModel;
import com.netcracker.fapi.service.AccountDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class AccountDataController {


        private  AccountDataService accountDataService;

        @RequestMapping
        public ResponseEntity<List<AccountViewModel>> getAllAccounts() {
            return ResponseEntity.ok(accountDataService.getAll());
        }

        @RequestMapping(value = "/{login}",method = RequestMethod.GET)
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
