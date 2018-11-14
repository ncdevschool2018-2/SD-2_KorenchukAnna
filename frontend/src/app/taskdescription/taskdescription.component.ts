import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {Task} from "../models/Task";
import {TaskService} from "../service/task.service";


@Component({
  selector: 'taskdescription',
  templateUrl: './taskdescription.component.html',
  styleUrls: ['./taskdescription.component.css']
})
export class TaskdescriptionComponent implements OnInit{

  private sub: any;

  task: Task = new Task();

  constructor(private activatedRouter: ActivatedRoute,
              private taskService: TaskService){}

  ngOnInit() {
    this.sub = this.activatedRouter.params.subscribe(param => {
      this.task.taskCode = param['taskCode'];
      console.log(this.task.taskCode);
      this.sub = this.taskService.getTaskByTaskCode(this.task.taskCode).subscribe(task => {
        this.task = task;
        console.log(this.task);
      });
    });

    this.sub =this.taskService.getTaskByTaskCode(this.task.taskCode).subscribe(task => {
      this.task = task;
      console.log(this.task);
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }


}
