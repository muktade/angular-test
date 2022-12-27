import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ApiService} from "../../service/api.service";
import {Router} from "@angular/router";
import {Employee} from "../../service/Employee";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  employee?: Employee;
  constructor(private api: ApiService, private router: Router, private fb : FormBuilder) {
    this.registrationForm;
  }

  registrationForm:FormGroup = this.fb.group({
    firstName : [''],
    lastName : [''],
    email : [''],
    password : ['']
  });

  ngOnInit(): void{}

  signUp(){
    const formValue = this.registrationForm.value;
    this.employee = formValue;
    console.log(this.employee);

    this.api.postRequest('save', this.employee).subscribe(response =>{
      console.log(response+"ami assi");
      this.registrationForm.reset();
      alert("Employee register successful");
      this.router.navigateByUrl('/login');
    },error => {
      console.log(error);
      alert("Sorry somethings went wrong!!!")
    });
  }

}
