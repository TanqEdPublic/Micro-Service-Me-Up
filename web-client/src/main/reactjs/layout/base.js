'use strict';

import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import Header from './header';
import Body from './body';
import Footer from './footer';

class Layout extends Component{

    render(){
        {/* Header Row */}
        return(

            <div className="container-fluid base-layout">
                <div className="row">
                    <div className="col-sm">
                        <Header/>
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                        <Body/>
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                        <Footer/>
                    </div>
                </div>

            </div>
        );
    }
}

export default Layout;