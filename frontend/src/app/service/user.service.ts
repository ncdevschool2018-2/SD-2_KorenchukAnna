import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})

export class UserService {


  constructor(private http: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/' );
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>('/api/users/id/'+id);
  }

  getUserByAccountId(id: number): Observable<User> {
    return this.http.get<User>('/api/users/accountId/'+ id);
  }

  addUser(account: User): Observable<User> {
    return this.http.post<User>('/api/users/', account);
  }


}
