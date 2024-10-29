import { Routes } from '@angular/router';
import { TableComponent } from './pages/table/table.component';
import { AddStudentComponent } from './pages/add-student/add-student.component';

export const routes: Routes = [
    {
        path:"",
        component:TableComponent
    },
    {
        path:"add-student",
        component:AddStudentComponent
    }
];
