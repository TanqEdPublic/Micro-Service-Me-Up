'use strict';

import React, { Component } from 'react';
import './css/header.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import NavigationBar from './navigation';

class Header extends Component{

    render() {
        return(
            <header className="App-header border-bottom">
                <h1 className="App-title text-justify text-center">Welcome to Micro Service Me Up!</h1>
                {/*<NavigationBar/>*/}
            </header>
        );
    }

}

export default Header;