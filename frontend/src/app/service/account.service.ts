import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../models/account";

@Injectable({
  providedIn: 'root'
})

export class AccountService {


  constructor(private http: HttpClient) {
  }

  getAccount(login: string): Observable<Account> {
    return this.http.get<Account>('/api/account/login/' + login);
  }

  addAccount(account: Account): Observable<Account> {
    return this.http.post<Account>('/api/account/', account);
  }


}
