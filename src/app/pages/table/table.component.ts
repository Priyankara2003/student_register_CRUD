import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [NgFor,RouterModule],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent implements OnInit{

  constructor(private sanitizer: DomSanitizer) { }
  imgRecourse: any;

  ngOnInit(): void {
    this.loadStudents();
  }
  public studentDetails = [];

  async loadStudents() {
    await fetch('http://localhost:8080/get-all')
      .then((res) => res.json())
      .then((data) => {
        this.studentDetails = data;
      });
  }

  public student = {
    firstName: null,
    lastName: null,
    age: null,
    address: null,
    dob: null,
    nic: null,
    email: null,
    phone: null,
    gender: null,
    imageData: null
  };

  async getStudent(id:any){
    await fetch(`http://localhost:8080/get-student?id=${id}`)
    .then(res => res.json())
    .then(data => {
      this.student = data;
      this.imgRecourse = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + this.student.imageData);
    })
  }
}
