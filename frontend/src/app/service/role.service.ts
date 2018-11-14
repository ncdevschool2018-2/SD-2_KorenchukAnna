import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../models/role";

@Injectable({
  providedIn: 'root'
})

export class RoleService {


  constructor(private http: HttpClient) {
  }

  getAllRolies(): Observable<Role[]> {
    return this.http.get<Role[]>('/api/role');
  }


  getRoleById(id: string): Observable<Role> {
    return this.http.get<Role>('/api/role' + id);
  }

}
