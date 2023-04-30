import { Injectable } from "@angular/core";
import {HttpClient} from "@angular/common/http";
import { Observable } from "rxjs";
import { Pets } from "./Pets";
import {Types } from "./Types";
import { Origins } from "./Origins";
import { environment } from "src/environments/environment";
import { Input } from "./Login";

@Injectable({
    providedIn: "root"
})
export class PetsService{
    private apiServerURL = environment.apiURL;
    constructor(private http:HttpClient){}

    public getPets():Observable<Pets[]>{
        return this.http.get<Pets[]>(`${this.apiServerURL}/pets/all`);
    }

    public getPetsById(id:number):Observable<Pets[]>{
        return this.http.get<Pets[]>(`${this.apiServerURL}/pets/find/${id}`);
    }

    public addPets(pets:Pets):Observable<Pets>{
        return this.http.post<Pets>(`${this.apiServerURL}/pets/add`, pets);
    }

    public updatePets(pets:Pets):Observable<Pets>{
        return this.http.put<Pets>(`${this.apiServerURL}/pets/update`, pets);
    }

    public deletePets(id:number):Observable<void>{
        return this.http.delete<void>(`${this.apiServerURL}/pets/delete/${id}`);
    }
    public getTypes():Observable<Types[]>{
        return this.http.get<Types[]>(`${this.apiServerURL}/types/all`);
    }

    public getOrigins():Observable<Origins[]>{
        return this.http.get<Origins[]>(`${this.apiServerURL}/Origin/all`);
    }

    public getUser(username:string, password:string):Observable<Input>{
        return this.http.get<Input>(`${this.apiServerURL}/Account/findone/${username}&${password}`);
    }

    
}