import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-add-student',
  standalone: true,
  imports: [FormsModule,RouterModule],
  templateUrl: './add-student.component.html',
  styleUrl: './add-student.component.css'
})

export class AddStudentComponent {

  public studentDetails = {
    firstName: null,
    lastName: null,
    age: null,
    address: null,
    dob: null,
    nic: null,
    email: null,
    phone: null,
    gender: null,
  }

  image: File | null = null;
  showToast=false;

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.image = file;
    } else {
      console.error("No file selected.");
    }
  }

  async addStudent() {
    const std = JSON.stringify(this.studentDetails);
    const formData = new FormData();

    const studentBlob = new Blob([std], { type: 'application/json' });

    formData.append('student', studentBlob);

    if (this.image) {
      formData.append('file', this.image);
    } else {
      alert('Please select an image file.');
      return;
    }

    try {
      const res = await fetch('http://localhost:8080/upload', {
        method: 'POST',
        body: formData
      });

      if (!res.ok) {
        const errorMsg = await res.text();
        throw new Error(`Error ${res.status}: ${errorMsg}`);
      }

      alert('File Uploaded Successfully!');

    } catch (error) {
      console.error('Error during file upload:', error);
      alert(`Error: ${error}`);
    }
  }
}
