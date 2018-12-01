import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {Task} from "../models/task";
import {TaskService} from "../service/task.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {StatusService} from "../service/status.service";


@Component({
  selector: 'taskdescription',
  templateUrl: './task-description.component.html',
  styleUrls: ['./task-description.component.css']
})
export class TaskDescriptionComponent implements OnInit, OnDestroy{

  private sub: Subscription[] ;

  task: Task = new Task();
  statusValue;
  modalRef: BsModalRef;
  priorityImg: string = "C:/Users/Anna/Desktop/SD-2_KorenchukAnna/frontend/src/app/resources/blocker.png" ;

  constructor(private activatedRouter: ActivatedRoute,
              private taskService: TaskService,
              private modalService: BsModalService,
              private statusService: StatusService ){
    this.sub = [];
  }

  ngOnInit() {
    this.sub.push(this.activatedRouter.params.subscribe(param => {
      this.task.taskCode = param['taskCode'];
      this.sub.push(this.taskService.getTaskByTaskCode(this.task.taskCode).subscribe(task => {
        this.task = task;
        this.statusValue = this.task.status.status;
        //this.priorityImg += this.task.priority.priority + ".png";
      }));
    }));
  }

  public openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  changeStatus(template: TemplateRef<any>):void{
    if(this.statusValue != this.task.status.status){
      this.openModal(template)
    }
  }

  public updateStatus():void{
    this.sub.push(this.statusService.getAllStatus().subscribe(st => {
      for (let i of st) {
        if(i.status == this.statusValue)
          this.task.status = i;
      }
      this.sub.push(this.taskService.updateTask(this.task).subscribe(()=> {

      }));
    }));

    this.closeModal();

  }

  ngOnDestroy() {
    this.sub.forEach(subscription => subscription.unsubscribe());
  }


}
