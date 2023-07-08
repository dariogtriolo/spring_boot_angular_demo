import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tweet } from '../tweet';
import { TweetServiceService } from '../tweet-service.service';

@Component({
  selector: 'app-tweet-form',
  templateUrl: './tweet-form.component.html',
  styleUrls: ['./tweet-form.component.css']
})
export class TweetFormComponent {

  tweets: Tweet[] = [];
  newTweet: Tweet;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private tweetsService: TweetServiceService) {
          this.newTweet = new Tweet();
  }

  onSubmit() {
    this.newTweet.dateTime = Math.floor(new Date().getTime() / 1000).toString();
    this.tweets.push(this.newTweet);
    this.tweetsService.save(this.tweets).subscribe(result => this.gotoTweetsList());
  }

  gotoTweetsList() {
    this.router.navigate(['/tweets']);
  }

}