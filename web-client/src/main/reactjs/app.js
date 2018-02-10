'use strict';

import React, { Component } from 'react';

import Layout from './layout/layout';

import './main.css';


class App extends Component {

    render() {
        return (
            <div className="App">
                <Layout/>
            </div>
        );
    } // end of render()
}

export default App;