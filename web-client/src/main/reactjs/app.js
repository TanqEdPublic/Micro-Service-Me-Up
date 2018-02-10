'use strict';

import React, { Component } from 'react';

import Header from './layout/header';
import Footer from './layout/footer';

import './main.css';


class App extends Component {

    render() {
        return (
            <div className="App">
                <Header/>
                <Footer/>
            </div>
        );
    } // end of render()
}

export default App;