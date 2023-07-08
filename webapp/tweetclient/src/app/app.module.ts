import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TweetsListComponent } from './tweets-list/tweets-list.component';
import { TweetFormComponent } from './tweet-form/tweet-form.component';
import { TweetServiceService } from './tweet-service.service';

@NgModule({
  declarations: [
    AppComponent,
    TweetsListComponent,
    TweetFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [TweetServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }