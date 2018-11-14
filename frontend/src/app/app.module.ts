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

import { AlertModule } from 'ngx-bootstrap';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

import { RouterModule, Routes } from '@angular/router';
import { TasktableComponent } from './tasktable/tasktable.component';
import {TaskdescriptionComponent} from "./taskdescription/taskdescription.component";
import {CommentsComponent} from "./comments/comments.component";

import {Globals} from './global';
import {TasksView} from "./view/tasks/tasks.view";
import {DescriptionView} from "./view/description/description.view";
import {AuthorizationFormView} from "./view/authorization/authorization-form.view";
import {ProjectsView} from "./view/projects/projects.view";
import {ProjectsComponent} from "./table-for-projects/table-for-projects.component";


const routes: Routes = [
  {path:'',component: AuthorizationFormView},
  {path:'tasks',component: TasksView},
  {path:'description/:taskCode',component:  DescriptionView},
  {path:'projects',component: ProjectsView }
]


@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    MenuComponent,
    TasktableComponent,
    TaskdescriptionComponent,
    CommentsComponent,
    AuthorizationFormView,
    TasksView,
    DescriptionView,
    ProjectsComponent,
    ProjectsView
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    AlertModule.forRoot(),
    RouterModule.forRoot(routes,{ enableTracing: true }),
    BsDatepickerModule.forRoot()
  ],
  providers: [Globals],
  bootstrap: [AppComponent]
})
export class AppModule { }
