import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Priority} from "../models/priority";

@Injectable({
  providedIn: 'root'
})

export class PriorityService {


  constructor(private http: HttpClient) {
  }

  getAllPriorities(): Observable<Priority[]> {
    return this.http.get<Priority[]>('/api/priority/');
  }


  getPriorityById(id: string): Observable<Priority> {
    return this.http.get<Priority>('/api/priority/' + id);
  }

}
