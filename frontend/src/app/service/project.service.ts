import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../models/project";

@Injectable({
  providedIn: 'root'
})

export class ProjectService {


  constructor(private http: HttpClient) {
  }

  addProject(project: Project): Observable<Project> {
    return this.http.post<Project>('/api/projects/', project);
  }

  getAllProjects(page: number, size: number): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects?'+'page='+page+'&&'+'size='+size);
  }


  getProjectsByAuthorId(id: string): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects/authorId/' + id);
  }

  getProjectsByProjectCode(code: string): Observable<Project> {
    return this.http.get<Project>('/api/projects/projectCode/' + code);
  }

  deleteProject(id: number): Observable<void> {
    return this.http.delete<void>('/api/projects/' + id);
  }

  updateProject(project: Project): Observable<void> {
    return this.http.put<void>('/api/projects/', project);
  }

}
