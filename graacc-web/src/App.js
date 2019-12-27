import React from "react";
import { createStore, combineReducers, applyMiddleware } from "redux";
import { Provider } from "react-redux";
import ReduxThunk from "redux-thunk";
import "./App.css";

import donationReducer from "./store/reducers/donation";
import lawsuitReducer from "./store/reducers/lawsuit";
import emailReducer from "./store/reducers/email";

import Navigation from './components/navigation';

const rootReducer = combineReducers({
  donation: donationReducer,
  lawsuit: lawsuitReducer,
  email: emailReducer
});

const store = createStore(rootReducer, applyMiddleware(ReduxThunk));

function App() {
  return (
    <Provider store={store}>
      <Navigation />
      
    </Provider>
  );
}

export default App;
