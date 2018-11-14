import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from '../models/Task';
import {Account} from "../models/account";

@Injectable({
  providedIn: 'root'
})

export class TaskService {


  constructor(private http: HttpClient) {
  }

  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>('/api/task');
  }

  getCountOfTasksByProjectCode(projectCode: string): Observable<number> {
    return this.http.get<number>('/api/task/projectCode/' + projectCode);
  }


  getTaskByTaskCode(taskCode: string): Observable<Task> {
    return this.http.get<Task>('/api/task/' + taskCode);
  }

  addTask(task: Task): Observable<Task> {
    return this.http.post<Task>('/api/task/', task);
  }

}
