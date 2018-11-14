import {Component, OnInit} from "@angular/core";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {Project} from "../models/project";
import {ProjectService} from "../service/project.service";



@Component({
  selector: 'table-for-projects',
  templateUrl: './table-for-projects.component.html'
})
export class ProjectsComponent implements OnInit {

  projects: Project[];

  private subscriptions: Subscription[] = [];

  constructor(private projectService: ProjectService,
              private router: Router) { }

  ngOnInit() {
    this.loadTableWithProjects();
  }

  private loadTableWithProjects(): void {
    this.subscriptions.push(this.projectService.getAllProjects().subscribe(pr => {
      this.projects = pr;
    }));
  }



  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
