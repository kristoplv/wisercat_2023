import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { PetComponent } from './pets/pet.component';
import { LoginComponent } from './login.component';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { PagenotfoundComponent } from './notfound/pagenotfound.component';
const appRoute: Routes = [
  {path:"", component:LoginComponent},
  {path:"login", component:LoginComponent},
  {path:"Pets", component:PetComponent},
  { path: '**', component: PagenotfoundComponent }
]

@NgModule({
  
  declarations: [
    AppComponent,
    PetComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoute),
    HttpClientModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
