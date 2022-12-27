import { Component } from '@angular/core';
import {Employee} from "../../service/Employee";
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  employee?:Employee;

  constructor(private api: ApiService, private router: Router, private fb:FormBuilder) {
    this.loginForm.value;
  }

  loginForm:FormGroup = this.fb.group({
    email : [''],
    password: ['']
  });

  login(){
    const formValue = this.loginForm.value;
    this.employee = formValue;
    console.log(this.employee);
    this.api.postRequest('login', this.employee).subscribe((res)=>{
      alert("login success");
      // localStorage.setItem('email', this.employee?.email);
      this.router.navigate(['/dashboard']);
    });
  }

}
