'use strict';

import React, { Component } from 'react';

import Header from './common/header';
import Footer from './common/footer';

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