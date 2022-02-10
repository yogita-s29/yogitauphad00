import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Observable } from "rxjs";


@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  
  'id': number;
  'student': Student;
  

  constructor(private route: ActivatedRoute,private router: Router,
    private studentService: StudentService) { }

  ngOnInit() {
    this.student = new Student();

    this.id = this.route.snapshot.params['id'];
    
    this.studentService.getStudent(this.id)
      .subscribe((data: any) => {
        console.log(data)
        this.student = data;
      }, (error: any) => console.log(error));
  }
  updateStudent() {
    this.studentService.updateStudent(this.id, this.student)
    .subscribe(
      (        data: any) => {
        console.log(data);
        
    
        this.student = new Student();
        this.gotolist();
      }, (error: any) => console.log(error));
  }

  onSubmit() {
    this.updateStudent();    
  }

  gotolist(){
    this.router.navigate(['/students']);
  }
}