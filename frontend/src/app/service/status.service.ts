import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Status} from "../models/status";

@Injectable({
  providedIn: 'root'
})

export class StatusService {


  constructor(private http: HttpClient) {
  }

  getAllStatus(): Observable<Status[]> {
    return this.http.get<Status[]>('/api/status/');
  }


  getStatusById(id: string): Observable<Status> {
    return this.http.get<Status>('/api/status/' + id);
  }

}
