import React, { Component } from 'react';
import { Tabs, Tab, Grid, Cell, Card, CardTitle, CardText, CardActions, Button, CardMenu, IconButton } from 'react-mdl';


class Projects extends Component {
  constructor(props) {
    super(props);
    this.state = { activeTab: 0 };
  }

  toggleCategories() {

    if(this.state.activeTab === 0){
      return(
       
    } else if(this.state.activeTab === 1) {
      return (
        <div><h1>This is Order Reports</h1></div>
      )
    } else if(this.state.activeTab === 2) {
      return (
        <div><h1>View all bar codes</h1></div>
      )
    } else if(this.state.activeTab === 3) {
      return (
        <div><h1>List view by date</h1></div>
      )
    }

  }



  render() {
    return(
      <div>
        <Tabs activeTab={this.state.activeTab} onChange={(tabId) => this.setState({ activeTab: tabId })} ripple>
          <Tab>Production Reports</Tab>
          <Tab>Order Reports</Tab>
          <Tab>View all Barcodes</Tab>
          <Tab>List view by date</Tab>
        </Tabs>


          <Grid>
            <Cell col={12}>
              <div className="content">{this.toggleCategories()}</div>
            </Cell>
          </Grid>


      </div>
    )
  }
}

export default Projects;
