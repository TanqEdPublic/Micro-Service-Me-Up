'use strict';

import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import Navigation from './applicaton-router';
import Footer from './footer';

class Layout extends Component{

    render(){
        {/* Header Row */}
        return(

            <div className="container-fluid base-layout">

                <Navigation/>

                <Footer/>

            </div>
        );
    }
}

export default Layout;