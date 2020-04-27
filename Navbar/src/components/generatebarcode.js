/* Import statements*/
import React, { Component } from 'react';
import { Grid, Cell } from 'react-mdl';
import Education from './education';
import Experience from './experience';
import Skills from './skills';

 /* Create a class that extends the home page*/
class Generatebarcode extends Component {
  render() {
    return(
      <div>
        <Grid> 
          <Cell col={4}>
            <div style={{textAlign: 'center'}}>
              <img
                src="https://www.shareicon.net/download/2015/09/18/103157_man_512x512.png"
                alt="avatar"
                style={{height: '200px'}}
                 />
            </div>

         
          </Cell>
          <Cell className="resume-right-col" col={8}>
          


           
             
                <hr style={{borderTop: '3px solid #e22947'}} />

              

           


          </Cell>
        </Grid>
      </div>
    )
  }
}

export default Generatebarcode;
