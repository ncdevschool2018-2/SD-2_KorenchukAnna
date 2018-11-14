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

  getAllProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects/');
  }


  getProjectsByAuthorId(id: string): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects/' + id);
  }

}
