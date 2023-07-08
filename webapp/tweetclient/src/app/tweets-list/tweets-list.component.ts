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

      this.tweets.sort((t1, t2)=>{

        let t1DateTime = this.parseDate(t1.dateTime);
        let t2DateTime = this.parseDate(t2.dateTime);

        if (t1DateTime < t2DateTime){
        
          return 1
        
        } else if (t1DateTime > t2DateTime){
          
          return -1;
        
        } else {

          let t1Author = t1.author.toUpperCase();
          let t2Author = t2.author.toUpperCase();
          return (t1Author < t2Author) ? -1 : (t1Author > t2Author) ? 1 : 0;  
        
        }
      });
      
    });
  }

  parseDate(dateTime:string) : number {
    //04:22 GMT - 15/03/2023

    //remove the '-' 04:22 GMT 
    let time = dateTime.substring(0, dateTime.indexOf("-")-1);

    //American date format for Date.parse() //MM/DD/YYYY 15/03/2023 -> 03/15/2023 March 15 2023
    let day = dateTime.substring(dateTime.indexOf("/")-2, dateTime.indexOf("/"));
    let month = dateTime.substring(dateTime.indexOf("/")+1, dateTime.indexOf("/")+3);
    let year = dateTime.substring(dateTime.indexOf("/")+4);
    let dateTimeToParse = time + month + "/" + day + "/" + year;

    return Date.parse(dateTimeToParse);
  }
}
