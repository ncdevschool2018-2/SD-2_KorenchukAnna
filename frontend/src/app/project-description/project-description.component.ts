import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Project} from "../models/project";
import {ProjectService} from "../service/project.service";
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";


@Component({
  selector: 'project-description',
  templateUrl: './project-description.component.html',
  styleUrls: ['./project-description.component.css']
})
export class ProjectDescriptionComponent implements OnInit,OnDestroy {

  private sub : Subscription[] ;
  modalRef: BsModalRef;

  project: Project ;

  constructor(private activatedRouter: ActivatedRoute,
              private projectService: ProjectService,
              private modalService: BsModalService,
              private router: Router,
              private loadingService: Ng4LoadingSpinnerService) {
    this.sub = [];
  }

  ngOnInit() {
    this.sub.push( this.activatedRouter.params.subscribe(param => {
      this.project = new Project();
      this.project.code = param['projectCode'];
      this.sub.push(this.projectService.getProjectsByProjectCode(this.project.code).subscribe(p => {
        this.project = p;
        this.description = this.project.summary;
      }));
    }));
  }

  public openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(): void {
    this.modalRef.hide();
  }



  public delete(id: number): void{
    this.loadingService.show();
    this.sub.push(this.projectService.deleteProject(id).subscribe(() => {
      this.loadingService.hide();
      this.router.navigate(['/projects']);
    }));
    this.closeModal();
  }



  description: string;

  public updateProject(){
    this.loadingService.show();
    this.project.summary = this.description;
    this.sub.push(this.projectService.updateProject(this.project).subscribe(() => {
      this.loadingService.hide();
    }));
    this.closeModal();
  }


  ngOnDestroy() {
    this.sub.forEach(subscription => subscription.unsubscribe());
  }
}
