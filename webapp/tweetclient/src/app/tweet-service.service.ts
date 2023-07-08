import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Tweet } from './tweet';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TweetServiceService {

  private tweetsUrl: string;

  constructor(private http: HttpClient) {
    this.tweetsUrl = 'http://localhost:8080/api/v1/tweets';
  }

  public findAll(): Observable<Tweet[]> {
    return this.http.get<Tweet[]>(this.tweetsUrl);
  }

  public save(tweets: Tweet[]) {
    return this.http.post<Tweet[]>(this.tweetsUrl, tweets);
  }
}
