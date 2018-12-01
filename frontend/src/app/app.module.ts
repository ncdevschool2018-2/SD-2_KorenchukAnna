import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { AccountComponent } from './account/account.component';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {MenuComponent} from "./menu/menu.component";

import {AlertModule, ButtonsModule} from 'ngx-bootstrap';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

import { RouterModule, Routes } from '@angular/router';

import {AuthorizationFormView} from "./view/authorization/authorization-form.view";
import {CommentsComponent} from "./comments/comments.component";

import { TableForTaskComponent } from './table-for-tasks/table-for-task.component';
import {TaskDescriptionComponent} from "./task-description/task-description.component";
import {TableForTasksView} from "./view/tasks/table/table-for-tasks.view";
import {TaskDescriptionView} from "./view/tasks/description/task-description.view";

import {TableForProjectsView} from "./view/projects/table/table-for-projects.view";
import {ProjectTableComponent} from "./table-for-projects/table-for-projects.component";
import {ProjectDescriptionComponent} from "./project-description/project-description.component";
import {ProjectDescriptionView} from "./view/projects/description/project-description.view";


import { PaginationModule } from 'ngx-bootstrap/pagination';


const routes: Routes = [
  {path:'',component: AuthorizationFormView},
  {path:'tasks',component:  TableForTasksView },
  {path:'tasks/description/:taskCode',component:  TaskDescriptionView},
  {path:'projects',component: TableForProjectsView },
  {path:'projects/description/:projectCode',component:  ProjectDescriptionView},
]


@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    MenuComponent,
    CommentsComponent,
    AuthorizationFormView,

    TableForTaskComponent,
    TaskDescriptionComponent,
    TableForTasksView ,
    TaskDescriptionView,

    ProjectTableComponent,
    ProjectDescriptionComponent,
    TableForProjectsView,
    ProjectDescriptionView

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ButtonsModule.forRoot(),
    ModalModule.forRoot(),
    AlertModule.forRoot(),
    RouterModule.forRoot(routes,{ enableTracing: true }),
    BsDatepickerModule.forRoot(),
    PaginationModule.forRoot()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
