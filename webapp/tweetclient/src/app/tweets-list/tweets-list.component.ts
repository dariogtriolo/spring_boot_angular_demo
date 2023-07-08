import { Component, OnInit } from '@angular/core';
import { Tweet } from '../tweet';
import { TweetServiceService } from '../tweet-service.service';

@Component({
  selector: 'app-tweets-list',
  templateUrl: './tweets-list.component.html',
  styleUrls: ['./tweets-list.component.css']
})
export class TweetsListComponent implements OnInit {

  tweets: Tweet[] = [];

  constructor(private tweetService: TweetServiceService) {
  }

  ngOnInit() {
    this.tweetService.findAll().subscribe(data => {
      this.tweets = data;
    });
  }
}
