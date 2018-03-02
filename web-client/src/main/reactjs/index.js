// ReactJS application entry point
// All start up components can be loaded here, i.e., bootstrap, css, etc.
'use strict';
import React from 'react';
import ReactDOM from 'react-dom';
import Application from './components/applicaton-router';

import 'jquery/dist/jquery.min.js';
import 'tether/dist/js/tether.min.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';

ReactDOM.render(<Application/>, document.getElementById('root'));