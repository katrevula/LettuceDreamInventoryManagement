import React from "react";

import "./App.css";
import NavagationBar from "./components/NavagationBar";
import { Col, Container, Row } from "react-bootstrap";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AddBay from "./components/AddBay";
import BayList from "./components/BayList";
import ReactNotification from "react-notifications-component";

function App() {
  const marginTop = {};
  return (
    <Router>
      <NavagationBar />

      <Container>
        <ReactNotification />
        <Row>
          <Col lg={12}>
            <Switch>
              <Route path="/list" exact component={BayList} />
              <Route path="/add" exact component={AddBay} />
            </Switch>
          </Col>
        </Row>
      </Container>
    </Router>
  );
}

export default App;
