import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule }   from '@angular/router';

import { AppComponent } from './app.component';
import {GamesComponent} from "./games/games.component";
import { GameComponent } from './game/game.component';
import { KingdomComponent } from './kingdom/kingdom.component';
import { TileComponent } from './tile/tile.component';
import { AlertModule } from 'ng2-bootstrap';
import { DraftComponent } from './draft/draft.component';
import { DraftDominoComponent } from './draft-domino/draft-domino.component';
import { NewGamesComponent } from './new-games/new-games.component';

@NgModule({
  declarations: [
    AppComponent,
    GamesComponent,
    GameComponent,
    KingdomComponent,
    TileComponent,
    DraftComponent,
    DraftDominoComponent,
    NewGamesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,

    RouterModule.forRoot([
      {
        path: 'games/:uuid',
        component: GameComponent
      },
      {
        path: 'games',
        component: GamesComponent
      },
      {
        path: 'new-games',
        component: NewGamesComponent
      },
      {
        path: '',
        redirectTo: 'games',
        pathMatch: 'full'
      }

    ], { useHash: true }),

    AlertModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
