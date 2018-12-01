import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from '../models/task';

@Injectable({
  providedIn: 'root'
})

export class TaskService {


  constructor(private http: HttpClient) {
  }

  getAllTasks(page: number, size: number): Observable<Task[]> {
    return this.http.get<Task[]>('/api/task?'+'page='+page+'&&'+'size='+size);
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

  updateTask(task: Task): Observable<void> {
    return this.http.put<void>('/api/task/', task);
  }

}
