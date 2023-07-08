import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TweetsListComponent } from './tweets-list/tweets-list.component';
import { TweetFormComponent } from './tweet-form/tweet-form.component';

const routes: Routes = [
  { path: 'tweets', component: TweetsListComponent },
  { path: 'addtweet', component: TweetFormComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
