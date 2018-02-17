// ReactJS application entry point
// All start up components can be loaded here, i.e., bootstrap, css, etc.
'use strict';
import React from 'react';
import ReactDOM from 'react-dom';
import Layout from './layout/base';
import 'jquery/dist/jquery.min.js';
import 'tether/dist/js/tether.min.js';

ReactDOM.render(<Layout />, document.getElementById('root'));