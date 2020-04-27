/* Import Statements*/
import React, { Component } from 'react';
import './App.css';
import { Layout, Header, Navigation, Drawer, Content } from 'react-mdl';
import Main from './components/main';
import { Link } from 'react-router-dom';

/* Screen Display*/

class App extends Component {
  render() {
    return (

      /* Content Display on Nav-Bar and path navigation from Nav-Bar to specified pages*/


      <div className="demo-big-content">
    <Layout>
        <Header className="header-color" title={<Link style={{textDecoration: 'none', color: 'white'}} to="/">Lettuce Dream</Link>} scroll>
            <Navigation>
                <Link to="/generatebarcode">Generate Barcode</Link>
                <Link to="/scanspage">Scan</Link>
                <Link to="/projects">Reports</Link>
                <Link to="/contact">Add details</Link>
                <Link to="/delete">Delete</Link>
            </Navigation>
        </Header>  
        <Drawer title={<Link style={{textDecoration: 'none', color: 'black'}} to="/">Lettuce Dream</Link>}>
            <Navigation>
              <Link to="/generatebarcode">Generate Barcode</Link>
              <Link to="/scanspage">Scans</Link>
              <Link to="/projects">Reports</Link>
              <Link to="/contact">Add details</Link>
              <Link to="/delete">Delete</Link>
            </Navigation>
        </Drawer>
        <Content>
            <div className="page-content" />
            <Main/>
        </Content>
    </Layout>
</div>

    );
  }
}

export default App;
