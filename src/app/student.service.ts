import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';


@Injectable({
  providedIn: 'root'
})
export class StudentService {
 
 
  private baseUrl = 'http://localhost:8047/api/v1';


  constructor(private http: HttpClient) { }
 

  getStudent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getById/${id}`);
  }

  createStudent(student: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/student/add`, student, { responseType: 'text' });
  }

  updateStudent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }


  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/student/delete/${id}`);
  }

  getStudentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/student/all`);
  }
}