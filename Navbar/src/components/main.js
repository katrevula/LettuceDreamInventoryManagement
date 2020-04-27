import React from 'react';
import { Switch, Route } from 'react-router-dom';

import LandingPage from './landingpage';
import Scanspage from './scanspage';
import Contact from './contact';
import Projects from './reports';
import Generatebarcode from './generatebarcode';


const Main = () => (
  <Switch>
    <Route exact path="/" component={LandingPage} />
    <Route path="/scanspage" component={Scanspage} />
    <Route path="/contact" component={Contact} />
    <Route path="/reports" component={Projects} />
    <Route path="/generatebarcode" component={Generatebarcode} />
  </Switch>
)

export default Main;
