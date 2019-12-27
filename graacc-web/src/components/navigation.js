import React from "react";
import { Route, Link, BrowserRouter as Router } from "react-router-dom";

import Home from "./home";
import Donation from "./donation";
import SearchLawsuit from "./searchLawsuit";

const Navigation = () => {
  return (
    <Router>
      <div>
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <Link class="nav-link" to="/">
              Home
            </Link>
          </li>
          <li class="nav-item">
            <Link class="nav-link" to="/doar">
              Doações
            </Link>
          </li>
          <li class="nav-item">
            <Link class="nav-link" to="/consultar-processos">
              Consultar Processos
            </Link>
          </li>
        </ul>
        <Route exact path="/" component={Home} />
        <Route path="/doar" component={Donation} />
        <Route path="/consultar-processos" component={SearchLawsuit} />
      </div>
    </Router>
  );
};

export default Navigation;
