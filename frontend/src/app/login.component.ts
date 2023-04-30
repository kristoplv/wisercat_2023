import {Component, OnInit} from "@angular/core"
import { Input } from "./Login";
import { NgForm } from "@angular/forms";
import { PetsService } from './pets.service';
import { HttpErrorResponse } from "@angular/common/http";
import {Router} from '@angular/router';

@Component({
    selector: 'app-root',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

    title= "Login page";
    public input: Input;
    private gotUser: Input;
    public isLoggedIn:boolean=false;

    constructor(private PetsService:PetsService, private router: Router){}

    ngOnInit(): void {
        if(sessionStorage.getItem("id")){
            this.router.navigate(["/Pets"]);
        }
    }

    public save(login:NgForm):void{
        console.log(login.value.password);
        
        this.PetsService.getUser(login.value.username, login.value.password).subscribe(
            (response: Input)=>{
                console.log(response);
                this.gotUser = response;
                sessionStorage.setItem("id", (this.gotUser.id).toString());
                sessionStorage.setItem("username", "'"+this.gotUser.username);
                this.isLoggedIn=true;
                this.router.navigate(["/Pets"]);
            },(error:HttpErrorResponse)=>{alert("Login credentials are wrong. Please check your username and password!");}
        )
    }
}