import { StudentDetailComponent } from './student-detail/student-detail.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';


const routes: Routes = [
  { path: '', redirectTo: 'student', pathMatch: 'full' },
  { path: 'students', component: StudentListComponent },
  { path: 'add', component: CreateStudentComponent },
  { path: 'details/:id', component: StudentDetailComponent },
  {path:'update/:id', component: UpdateStudentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
