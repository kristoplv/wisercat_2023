import { PetsService } from '../pets.service';
import { Component, OnInit } from '@angular/core';
import { Pets } from "../Pets";
import { Types } from '../Types';
import { Origins } from '../Origins';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginComponent } from '../login.component';

@Component({
  selector: 'app-root',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit{
  title = 'Pet_management';
  public pets: Pets[];
  public editPet: Pets;
  public deletePet: Pets;
  public types: Types[];
  public origins: Origins[];
  public selectedOrigin:any;
  public selectedType:any;
  public ownerID:any;
  public ownerName:string;
  constructor(private petsService: PetsService, private router:Router){}

  ngOnInit(): void {
      this.getTypes();
      this.getOrigins();
      if(sessionStorage.getItem("id")){
        this.ownerName = sessionStorage.getItem("username")
        this.ownerID = sessionStorage.getItem("id");
        this.getPetsById(parseInt(this.ownerID));
      } else{
        this.router.navigate([""]);
      }
      if(this.pets==null){
      }
    }
  

// Sorting logic for id, name, code, type, color, origin
  public sortByID(){
    this.pets.sort((a,b)=>a.id - b.id);
  }

  public logOut():void{
    console.log("logout pressed");
    sessionStorage.removeItem("id");
    sessionStorage.removeItem("username");
    this.router.navigate([""]);
}
  sortByName() {
    this.pets.sort((a, b) => a.name.localeCompare(b.name));
  }
  sortByCode() {
    this.pets.sort((a, b) => a.code.localeCompare(b.code));
  }
  sortByType() {
    this.pets.sort((a, b) => a.type-b.type);
  }
  sortByColor() {
    this.pets.sort((a, b) => a.color.localeCompare(b.color));
  }
  sortByOrigin() {
    this.pets.sort((a, b) => a.origin.localeCompare(b.origin));
  }

// Selection for origin
  public onSelected(event:any):void{
    this.selectedOrigin = event.target.value;
    console.log(this.selectedOrigin);
  }

  // Selection for type
  public onSelectedType(event:any):void{
    this.selectedType = event.target.value;
    console.log(this.selectedType);
  }


  // Getting pet type dropdown bar options
  public getTypes():void{
    this.petsService.getTypes().subscribe(
      (response:Types[])=>{this.types = response;},
      (error:HttpErrorResponse)=>{alert(error.message);}
    )
  }
  // Getting pet origin dropdown bar options
  public getOrigins():void{
    this.petsService.getOrigins().subscribe(
      (response:Origins[])=>{this.origins = response;},
      (error:HttpErrorResponse)=>{alert(error.message);})
  }
// Get pets
  public getPetsById(id:number):void{
    try{

      this.petsService.getPetsById(id).subscribe(
        (response:Pets[])=>{
          this.pets = response;
          console.log(response);
        },
        (error:HttpErrorResponse)=>{alert(error.message);}
        );
      }catch {
        alert("Add a pet :)");
      }
  }
  public getPets():void{
    this.petsService.getPets().subscribe(
      (response:Pets[])=>{
        this.pets = response;
        console.log(response);
      },
      (error:HttpErrorResponse)=>{alert(error.message);}
    );
  }

  // Pet add
  public onAddPet(addForm: NgForm):void{
    addForm.value.type = this.selectedType;
    addForm.value.origin = this.selectedOrigin;
    addForm.value.owner = parseInt(this.ownerID);
    console.log(addForm.value);
    document.getElementById("add_pet_form").click();
    if(addForm.value.name ===""){
      alert("please add a name :)");
    }else if(addForm.value.type <0 || addForm.value.type >10 || addForm.value.type===null){
      alert("please specify animal :)");
    }else if(addForm.value.color ===""){
      alert("please add a color :)");
    } else if(addForm.value.origin ===""){
      alert("please add pet origin :)");
    }else {

      this.petsService.addPets(addForm.value).subscribe(
        (response: Pets)=>{
          console.log(response);
          this.getPetsById(this.ownerID);
        },
        (error: HttpErrorResponse)=>{alert(error.message);}
        );
      }
    }

  // Pet delete
  public onDeletePet(petId :number):void{
    this.petsService.deletePets(petId).subscribe(
      (response: void)=>{
        console.log(response);
        this.getPetsById(this.ownerID);
      },
      (error: HttpErrorResponse)=>{alert(error.message);}
    )
  }


  // Handles pre-selected pet origin and types
  public OriginAndType(pet:Pets):void{
    this.selectedOrigin = pet.origin;
    this.selectedType = pet.type;
  };

  // Edit pet
  public onUpdatePet(pets: Pets):void{
    pets.owner = parseInt(this.ownerID);
    pets.origin = this.selectedOrigin;
    pets.type = this.selectedType;
    console.log(pets);
    if(pets.name ===""){ //FE form validation *TO BE MADE BETTER*
      alert("please add a name :)");
    }else if(pets.type <0 || pets.type >10 || pets.type===null){
      alert("please specify animal :)");
    }else if(pets.color ===""){
      alert("please add a color :)");
    } else if(pets.origin ===""){
      alert("please add pet origin :)");
    }
     else {

      this.petsService.updatePets(pets).subscribe(
        (response: Pets)=>{
          console.log(response);
          this.getPetsById(this.ownerID);
        },
        (error: HttpErrorResponse)=>{alert(error.message);}
        );
      }
  }


  // Handles add, edit and delete pet modals
  public onOpenModal(pet: Pets, mode: string): void {
    const mainContainer = document.getElementById("mainCont")
    const btn = document.createElement("button");
    btn.type = "button";
    btn.style.display = "none";
    btn.setAttribute("data-toggle", "modal");
    if(mode=== "add"){
      btn.setAttribute("data-target", "#addPets");
      this.selectedOrigin = "Estonia";
      this.selectedType = 1;
    }
    if(mode=== "edit"){
      this.editPet = pet
      btn.setAttribute("data-target", "#editPets");
    }
    if(mode=== "delete"){
      this.deletePet = pet;
      btn.setAttribute("data-target", "#deletePets");
    }
    mainContainer?.appendChild(btn);
    btn.click();

  }
}
