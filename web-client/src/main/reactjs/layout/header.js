'use strict';

import React, { Component } from 'react';
import './css/header.css';

import NavigationBar from './navigation';

class Header extends Component{

    render() {
        return(
            <header className="App-header">
                <h1 className="App-title">Welcome to Micro Service Me Up!</h1>
                <br/>
                <br/>
                <NavigationBar/>
            </header>
        );
    }

}

export default Header;