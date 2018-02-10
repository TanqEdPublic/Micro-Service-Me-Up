// ReactJS application entry point
// All start up components can be loaded here, i.e., bootstrap, css, etc.
'use strict';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './app';
import 'bootstrap/dist/css/bootstrap.css';

ReactDOM.render(<App />, document.getElementById('root'));