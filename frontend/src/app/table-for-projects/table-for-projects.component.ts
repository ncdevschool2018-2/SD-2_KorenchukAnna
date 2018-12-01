import {OnInit, OnDestroy, Component} from "@angular/core";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {Project} from "../models/project";
import {ProjectService} from "../service/project.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'table-for-projects',
  templateUrl: './table-for-projects.component.html'
})
export class ProjectTableComponent implements OnInit,OnDestroy {

  projects: Project[];
  currentPage = 1;
  page: number;
  size = 3;
  countOfProjects = 0;


  private subscriptions: Subscription[] = [];

  constructor(private projectService: ProjectService,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router) {
    this.subscriptions.push(this.projectService.getAllProjects(0,0).subscribe(pr => {
      this.countOfProjects = pr.length;
    }));
  }

  ngOnInit() {
    this.loadTableWithProjects(1);
  }

  pageChanged(event: any): void {
    this.page = event.page;
    this.loadTableWithProjects(this.page);
  }

  private loadTableWithProjects(page: number): void {
    this.subscriptions.push(this.projectService.getAllProjects(page-1,this.size).subscribe(pr => {
      this.projects = pr;
    }));
  }

  openProjectDescription(projectCode : string){
    this.loadingService.show();
    this.router.navigate(['/projects/description',projectCode]);
    this.loadingService.hide();
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
