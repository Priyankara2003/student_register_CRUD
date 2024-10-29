import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { AddStudentComponent } from './pages/add-student/add-student.component';
import { TableComponent } from "./pages/table/table.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AddStudentComponent, TableComponent,RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'student_register_CRUD';
}
