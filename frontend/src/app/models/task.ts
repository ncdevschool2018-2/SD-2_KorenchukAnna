import {Priority} from "./priority";
import {Status} from "./status";
import {User} from "./user";

export class Task{

  id: number;
  taskName: string;
  taskCode: string;
  description: string;
  priority: Priority;
  status: Status;
  reporter: User;
  assignee: User;
  projectCode: string;
  created: string;
  updated: string;
  dueDate: string;
  estimation: number;

}
