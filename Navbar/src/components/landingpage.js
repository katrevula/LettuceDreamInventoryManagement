/* Import statements*/
import React, { Component } from 'react';
import { Grid, Cell } from 'react-mdl';

/* Create a class that extends components*/
class Landing extends Component {
  render() {
    /* Inserting the image and name at the middle*/
    return(
      <div style={{width: '100%', margin: 'auto'}}>
        <Grid className="landing-grid">
          <Cell col={12}>
            <img
              src="https://www.shareicon.net/download/2015/09/18/103157_man_512x512.png"
              alt="Lettuce Dream Image"
              className="avatar-img"
              />

            <div className="banner-text">
            <h1>Lettuce Dream Inventory</h1>

            <hr/>

            /* Link of social media*/
            
        <div className="social-links">

        
        

          {/* Youtube */}
          <a href="http://google.com" rel="noopener noreferrer" target="_blank">
            <i className="fa fa-youtube-square" aria-hidden="true" />
          </a>

        </div>
            </div>
          </Cell>
        </Grid>
      </div>
    )
  }
}

export default Landing;
